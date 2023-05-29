package skypro.homeworks.course2.homework15;

import skypro.homeworks.course2.homework15.exceptions.ElementNotFoundException;
import skypro.homeworks.course2.homework15.exceptions.InvalidIndexException;
import skypro.homeworks.course2.homework15.exceptions.NullItemException;
import skypro.homeworks.course2.homework15.exceptions.StorageIsFullException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private int size;
    private final Integer[] storage;

    public IntegerListImpl() {
        this(5);
    }

    public IntegerListImpl(int initSize) {
        storage = new Integer[initSize];
    }

    @Override
    public Integer add(final Integer item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(final int index, final Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        // сдвиг элементов массива вправо
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(final int index, final Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(final Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException("Элемент " + item + " не найден");
        }
        return remove(index);
    }

    @Override
    public Integer remove(final int index) {
        validateIndex(index);
        Integer item = storage[index];
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(final Integer item) {
        Integer[] storageCopy = toArray();
        insertionSorting(storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public int indexOf(final Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(final Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(final int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(final IntegerList otherList) {
        if (otherList == null) {
            throw new NullItemException("Item is null");
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(storage[i], otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException("Item is null");
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException("Storage is full");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException("Invalid index");
        }
    }

    private void insertionSorting(Integer[] arr) {
        int in, out;
        for (out = 1; out < arr.length; out++) {
            Integer temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2; // (min + max) / 2

            if (arr[mid].compareTo(item) == 0) {
                return true;
            } else if (arr[mid].compareTo(item) < 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }
}
