package skypro.homeworks.course2.homework14;


import skypro.homeworks.course2.homework14.exceptions.ElementNotFoundException;
import skypro.homeworks.course2.homework14.exceptions.IndexOverBoundsException;
import skypro.homeworks.course2.homework14.exceptions.LimitReachedException;
import skypro.homeworks.course2.homework14.exceptions.NullParameterException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private int count;
    private final String[] result;

    public StringListImpl() {
        this(5);
    }

    public StringListImpl(int size) {
        result = new String[size];
    }

    /**
     * Добавляет один элемент.
     *
     * @param item String
     * @return Вернуть добавленный элемент в качестве результата выполнения.
     */
    @Override
    public String add(final String item) {
        if (count < result.length) {
            result[count++] = item;
            return item;
        }
        throw new LimitReachedException("Limit reached");
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
        if (index >= result.length) {
            throw new IndexOverBoundsException("Wrong index");
        }
        if (count < result.length) {
            count++;
            for (int i = count - 1; i > index; i--) {
                result[i] = result[i - 1];
            }
            result[index] = item;
            return item;
        }
        throw new LimitReachedException("Limit reached");
    }

    /**
     * Устанавливает элемент на определенную позицию, затерев существующий.
     * Выбрасывает исключение, если индекс больше фактического количества элементов или выходит за пределы массива.
     *
     * @param index int
     * @param item String
     * @return String
     */
    @Override
    public String set(final int index, final String item) {
        if (index >= result.length) {
            throw new IndexOverBoundsException("Wrong index");
        }
        result[index] = item;
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
        int index = indexOf(item);
        if (index != -1) {
            return remove(index);
        }
        throw new ElementNotFoundException("Element '" + item + "' not found");
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
        String removed;
        if (index < count - 1) {
            removed = result[index];
            for (int i = index; i < count - 1; i++) {
                result[i] = result[i + 1];
            }
            count--;
            return removed;
        }
        throw new ElementNotFoundException("Element with index " + index + " not found");
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
     * Выполняет поиск элемента по его значению.
     * Возвращает индекс элемента или -1 в случае отсутствия.
     *
     * @param item String
     * @return int
     */
    @Override
    public int indexOf(final String item) {
        for (int i = 0; i < count; i++) {
            if (result[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Выполняет поиск элемента с конца.
     * Возвращает индекс элемента или -1 в случае отсутствия.
     *
     * @param item String
     * @return int
     */
    @Override
    public int lastIndexOf(final String item) {
        for (int i = 0; i < count; i++) {
            if (result[i].equals(item)) {
                return count - 1 - i;
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
        if (index > count) {
            throw new IndexOverBoundsException("Wrong index");
        }
        return result[index];
    }

    /**
     * Возвращает фактическое количество элементов.
     *
     * @return int
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Возвращает true, если элементов в списке нет, иначе false.
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Удаляет все элементы из списка.
     */
    @Override
    public void clear() {
        count = 0;
    }

    /**
     * Создаёт новый массив из строк в списке и возвращает его.
     *
     * @return String[]
     */
    @Override
    public String[] toArray() {
        return Arrays.copyOf(result, count);
    }

    /**
     * Сравнивает текущий список с другим.
     * Возвращает true/false или бросает исключение, если передан null.
     *
     * @param o StringList
     * @return boolean
     */
    @Override
    public boolean equals(final StringList o) {
        if (o == null) {
            throw new NullParameterException("Parameter Is Null");
        }

        if (this == o) return true;

        if (getClass() != o.getClass()) return false;

        final StringListImpl that = (StringListImpl) o;

        if (count != that.count) return false;

        return Arrays.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        int result1 = count;
        result1 = 31 * result1 + Arrays.hashCode(result);
        return result1;
    }

}
