package skypro.homeworks.course2.homework14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import skypro.homeworks.course2.homework14.exceptions.InvalidIndexException;
import skypro.homeworks.course2.homework14.exceptions.StorageIsFullException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    private final StringList out = new StringListImpl(5);

    public static Stream<Arguments> indexOfParams() {
        return Stream.of(
                Arguments.of("Item1", 0),
                Arguments.of("Item2", 1),
                Arguments.of("Item3", 2),
                Arguments.of("Item4", 3),
                Arguments.of("Item5", 4)
        );
    }

    public static Stream<Arguments> negativeIndexOfParams() {
        return Stream.of(
                Arguments.of("Item not exist", -1),
                Arguments.of("Item5", -1),
                Arguments.of("Item6", -1),
                Arguments.of("Item7", -1)
        );
    }

    public static Stream<Arguments> positiveContainsParams() {
        return Stream.of(
                Arguments.of("Item1"),
                Arguments.of("Item2"),
                Arguments.of("Item3")
        );
    }

    public static Stream<Arguments> negativeContainsParams() {
        return Stream.of(
                Arguments.of("Item5"),
                Arguments.of("Item6"),
                Arguments.of("Item7")
        );
    }

    @BeforeEach
    void setUp() {
        out.add("Item1");
        out.add("Item2");
        out.add("Item3");
        out.add("Item4");
    }

    @AfterEach
    void tearDown() {
        out.clear();
    }

    @Test
    @DisplayName("Должен добавить элемент")
    void addItemTest() {
        int beforeAdd = out.size();
        String newElement = "Item5";
        out.add(newElement);
        assertEquals(out.size(), beforeAdd + 1);
    }

    @Test
    @DisplayName("Должен добавить элемент по индексу")
    void addItemByIndexTest() {
        int beforeAdd = out.size();
        String newElement = "Item5";
        out.add(4, newElement);
        assertEquals(out.size(), beforeAdd + 1);
    }

    @Test
    @DisplayName("Должен выбросить исключение при добавлении элемента по неверному индексу")
    void addItemByWrongIndexTest() {
        String newElement = "Item5";
        assertThrows(InvalidIndexException.class, () -> out.add(10, newElement));
    }

    @Test
    @DisplayName("Должен выбросить исключение при превышении размера")
    void addItemsOverLimitTest() {
        out.add("Item5");
        assertThrows(StorageIsFullException.class, () -> out.add("Item Over Limit"));
    }

    @Test
    @DisplayName("Должен выбросить исключение при превышении размера при добавлении элемента по индексу")
    void addItemByIndexOverLimitTest() {
        out.add("Item5");
        assertThrows(StorageIsFullException.class, () -> out.add(2, "Item Over Limit"));
    }

    @Test
    @DisplayName("Должен заменить значение элемента по индексу")
    void setTest() {
        int size = out.size();
        String expected = out.set(2, "New Item");
        assertEquals(expected, out.get(2));
        assertEquals(size, out.size());
    }

    @Test
    @DisplayName("Должен выбросить исключение при замене элемента по неверному индексу")
    void setWrongIndexTest() {
        assertThrows(InvalidIndexException.class, () -> out.set(12, "New Item"));
    }

    @Test
    @DisplayName("Должен удалить элемент по индексу")
    void removeItemByIndexTest() {
        int beforeRemove = out.size();
        assertEquals("Item1", out.remove(0));
        assertEquals(out.size(), beforeRemove - 1);
    }

    @Test
    @DisplayName("Должен удалить элемент по значению")
    void removeItemByValueTest() {
        int beforeRemove = out.size();
        assertEquals("Item3", out.remove("Item3"));
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
        assertThrows(InvalidIndexException.class, () -> out.remove("Item10"));
    }

    @ParameterizedTest
    @DisplayName("Должен подтвердить, что элемент есть в массиве")
    @MethodSource("positiveContainsParams")
    void containsTest(String str) {
        assertTrue(out.contains(str));
    }

    @ParameterizedTest
    @DisplayName("Должен подтвердить, что элемента нет в массиве")
    @MethodSource("negativeContainsParams")
    void doesNotContainElementTest(String str) {
        assertFalse(out.contains(str));
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента")
    @MethodSource("indexOfParams")
    void indexOfTest(String search, int index) {
        out.add("Item5");
        assertEquals(out.indexOf(search), index);
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента")
    @MethodSource("negativeIndexOfParams")
    void negativeIndexOfTest(String search, int index) {
        assertEquals(out.indexOf(search), index);
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента с конца")
    @MethodSource("indexOfParams")
    void lastIndexOfTest(String search, int index) {
        out.add("Item5");
        assertEquals(out.lastIndexOf(search), index);
    }

    @Test
    @DisplayName("Должен показать индекс элемента с конца при неверном значении")
    void lastIndexOfWrongValueTest() {
        assertEquals(out.lastIndexOf("Item100"), -1);
    }

    @Test
    @DisplayName("Должен получить элемент по индексу")
    void getTest() {
        assertEquals(out.get(0), "Item1");
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
        StringList test = new StringListImpl(5);
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
        StringList test = new StringListImpl(5);
        test.add("Item1");
        test.add("Item2");
        test.add("Item3");
        test.add("Item4");
        assertTrue(out.equals(test));
    }

    @Test
    @DisplayName("Должен выбросить исключение при сравнении с пустым массивом")
    void equalsNullNegativeTest() {
        StringList test = new StringListImpl(5);
        assertThrows(NullPointerException.class, () -> test.equals(null));
    }

    @Test
    void toArrayTest(){
        String[] test = {"Item1", "Item2", "Item3", "Item4"};
        assertArrayEquals(test, out.toArray());
    }

}