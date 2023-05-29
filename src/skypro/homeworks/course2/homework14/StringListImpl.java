package skypro.homeworks.course2.homework14;


import skypro.homeworks.course2.homework14.exceptions.InvalidIndexException;
import skypro.homeworks.course2.homework14.exceptions.NullItemException;
import skypro.homeworks.course2.homework14.exceptions.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private int size;
    private final String[] storage;

    public StringListImpl() {
        this(5);
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }

    /**
     * Добавляет один элемент.
     *
     * @param item String
     * @return Вернуть добавленный элемент в качестве результата выполнения.
     */
    @Override
    public String add(final String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    /**
     * Добавляет элемент на определенную позицию списка и возвращает его.
     * Если выходит за пределы фактического количества элементов или массива, то выбросить исключение.
     *
     * @param index int
     * @param item  String
     * @return String
     */
    @Override
    public String add(final int index, final String item) {
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

    /**
     * Устанавливает элемент на определенную позицию, затерев существующий.
     * Выбрасывает исключение, если индекс больше фактического количества элементов или выходит за пределы массива.
     *
     * @param index int
     * @param item  String
     * @return String
     */
    @Override
    public String set(final int index, final String item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    /**
     * Удаляет элемент и возвращает его.
     * Бросает исключение, если подобный элемент отсутствует в списке.
     *
     * @param item String
     * @return String
     */
    @Override
    public String remove(final String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    /**
     * Удаляет элемент по индексу и возвращает удаленный элемент.
     * Бросает исключение, если подобный элемент отсутствует в списке.
     *
     * @param index int
     * @return String
     */
    @Override
    public String remove(final int index) {
        validateIndex(index);
        String item = storage[index];
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return item;
    }

    /**
     * Проверяет элемент на существование элемента и возвращает true/false;
     *
     * @param item String
     * @return boolean
     */
    @Override
    public boolean contains(final String item) {
        return indexOf(item) != -1;
    }

    /**
     * Выполняет поиск индекса элемента по его значению.
     * Возвращает индекс элемента или -1 в случае отсутствия.
     *
     * @param item String
     * @return int
     */
    @Override
    public int indexOf(final String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Выполняет поиск индекса элемента с конца.
     * Возвращает индекс элемента или -1 в случае отсутствия.
     *
     * @param item String
     * @return int
     */
    @Override
    public int lastIndexOf(final String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Получает элемент по индексу.
     * Возвращает элемент или исключение, если выходит за рамки фактического количества элементов.
     *
     * @param index int
     * @return String
     */
    @Override
    public String get(final int index) {
        validateIndex(index);
        return storage[index];
    }

    /**
     * Возвращает фактическое количество элементов.
     *
     * @return int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Возвращает true, если элементов в списке нет, иначе false.
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Удаляет все элементы из списка.
     */
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Создаёт новый массив из строк в списке и возвращает его.
     *
     * @return String[]
     */
    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    /**
     * Сравнивает текущий список с другим.
     * Возвращает true/false или бросает исключение, если передан null.
     *
     * @param otherList StringList
     * @return boolean
     */
    @Override
    public boolean equals(final StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    private void validateItem(String item) {
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

}
