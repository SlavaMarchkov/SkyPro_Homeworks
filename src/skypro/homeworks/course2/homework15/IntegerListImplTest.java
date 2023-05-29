package skypro.homeworks.course2.homework15;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import skypro.homeworks.course2.homework15.exceptions.InvalidIndexException;
import skypro.homeworks.course2.homework15.exceptions.NullItemException;
import skypro.homeworks.course2.homework15.exceptions.StorageIsFullException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private final IntegerListImpl out = new IntegerListImpl(5);

    public static Stream<Arguments> positiveContainsParams() {
        return Stream.of(
                Arguments.of(23),
                Arguments.of(78),
                Arguments.of(4)
        );
    }

    public static Stream<Arguments> negativeContainsParams() {
        return Stream.of(
                Arguments.of(75),
                Arguments.of(103),
                Arguments.of(61)
        );
    }

    public static Stream<Arguments> indexOfParams() {
        return Stream.of(
                Arguments.of(23, 0),
                Arguments.of(78, 1),
                Arguments.of(4, 2),
                Arguments.of(97, 3)
        );
    }

    public static Stream<Arguments> negativeIndexOfParams() {
        return Stream.of(
                Arguments.of(444, -1),
                Arguments.of(555, -1),
                Arguments.of(666, -1),
                Arguments.of(777, -1)
        );
    }

    @BeforeEach
    void setUp() {
        out.add(23);
        out.add(78);
        out.add(4);
        out.add(97);
    }

    @AfterEach
    void tearDown() {
        out.clear();
    }

    @Test
    @DisplayName("Должен добавить элемент")
    void addItemTest() {
        int beforeAdd = out.size();
        Integer newElement = 42;
        assertEquals(42, out.add(newElement));
        assertEquals(out.size(), beforeAdd + 1);
    }

    @Test
    @DisplayName("Должен добавить элемент по индексу")
    void addItemByIndexTest() {
        int beforeAdd = out.size();
        Integer newElement = 42;
        int index = 1;
        assertEquals(42, out.add(index, newElement));
        assertEquals(index, out.indexOf(newElement));
        assertEquals(out.size(), beforeAdd + 1);
    }

    @Test
    @DisplayName("Должен выбросить исключение при добавлении элемента по неверному индексу")
    void addItemByWrongIndexTest() {
        Integer newElement = 42;
        int wrongIndex = 10;
        assertThrows(InvalidIndexException.class, () -> out.add(wrongIndex, newElement));
    }

    @Test
    @DisplayName("Должен выбросить исключение при превышении размера")
    void addItemsOverLimitTest() {
        Integer newElement = 42;
        out.add(newElement);
        assertThrows(StorageIsFullException.class, () -> out.add(43));
    }

    @Test
    @DisplayName("Должен выбросить исключение при превышении размера при добавлении элемента по индексу")
    void addItemByIndexOverLimitTest() {
        Integer newElement = 42;
        out.add(newElement);
        assertThrows(StorageIsFullException.class, () -> out.add(2, 43));
    }

    @Test
    @DisplayName("Должен заменить значение элемента по индексу")
    void setTest() {
        int size = out.size();
        Integer expected = out.set(2, 6987);
        assertEquals(expected, out.get(2));
        assertEquals(size, out.size());
    }

    @Test
    @DisplayName("Должен выбросить исключение при замене элемента по неверному индексу")
    void setWrongIndexTest() {
        assertThrows(InvalidIndexException.class, () -> out.set(10, 6987));
    }

    @Test
    @DisplayName("Должен удалить элемент по индексу")
    void removeItemByIndexTest() {
        int beforeRemove = out.size();
        assertEquals(23, out.remove(0));
        assertEquals(out.size(), beforeRemove - 1);
    }

    @Test
    @DisplayName("Должен удалить элемент по значению")
    @Disabled
    void removeItemByValueTest() {
        int beforeRemove = out.size();
        assertEquals(97, out.remove(97));
        assertEquals(out.size(), beforeRemove - 1);
    }

    @Test
    @DisplayName("Должен выбросить исключение при удалении элемента по неверному индексу")
    void removeItemByWrongIndexTest() {
        assertThrows(InvalidIndexException.class, () -> out.remove(10));
    }

    @Test
    @DisplayName("Должен выбросить исключение при удалении элемента по неверному значению")
    void removeItemByWrongValueTest() {
        assertThrows(InvalidIndexException.class, () -> out.remove(568));
    }

    @ParameterizedTest
    @DisplayName("Должен подтвердить, что элемент есть в массиве")
    @MethodSource("positiveContainsParams")
    void containsTest(Integer item) {
        assertTrue(out.contains(item));
    }

    @ParameterizedTest
    @DisplayName("Должен подтвердить, что элемента нет в массиве")
    @MethodSource("negativeContainsParams")
    void doesNotContainElementTest(Integer item) {
        assertFalse(out.contains(item));
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента")
    @MethodSource("indexOfParams")
    void indexOfTest(Integer search, int index) {
        out.add(5343);
        assertEquals(out.indexOf(search), index);
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента")
    @MethodSource("negativeIndexOfParams")
    void negativeIndexOfTest(Integer search, int index) {
        assertEquals(out.indexOf(search), index);
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента с конца")
    @MethodSource("indexOfParams")
    void lastIndexOfTest(Integer search, int index) {
        out.add(5343);
        assertEquals(out.lastIndexOf(search), index);
    }

    @Test
    @DisplayName("Должен показать индекс элемента с конца при неверном значении")
    void lastIndexOfWrongValueTest() {
        assertEquals(out.lastIndexOf(5343), -1);
    }

    @Test
    @DisplayName("Должен получить элемент по индексу")
    void getTest() {
        assertEquals(out.get(0), 23);
    }

    @Test
    @DisplayName("Должен бросить исключение при получении элемента по неверному индексу")
    void getByWrongIndexTest() {
        assertThrows(InvalidIndexException.class, () -> out.get(10));
    }

    @Test
    @DisplayName("Должен посчитать количество элементов")
    void sizeTest() {
        assertEquals(out.size(), 4);
    }

    @Test
    @DisplayName("Должен подтвердить, что массив пустой")
    void isEmptyTest() {
        IntegerList test = new IntegerListImpl(5);
        assertTrue(test.isEmpty());
    }

    @Test
    @DisplayName("Должен очистить массив")
    void clearTest() {
        out.clear();
        assertEquals(out.size(), 0);
    }

    @Test
    @DisplayName("Должен сравнить массивы")
    void equalsPositiveTest() {
        IntegerList test = new IntegerListImpl(5);
        test.add(23);
        test.add(78);
        test.add(4);
        test.add(97);
        assertTrue(out.equals(test));
    }

    @Test
    @DisplayName("Должен выбросить исключение при сравнении с пустым массивом")
    void equalsNullNegativeTest() {
        IntegerList test = new IntegerListImpl(5);
        assertThrows(NullItemException.class, () -> test.equals(null));
    }

    @Test
    void toArrayTest(){
        Integer[] test = {23, 78, 4, 97};
        assertArrayEquals(test, out.toArray());
    }

}