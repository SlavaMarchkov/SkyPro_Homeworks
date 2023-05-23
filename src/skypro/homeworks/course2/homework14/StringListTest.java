package skypro.homeworks.course2.homework14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import skypro.homeworks.course2.homework14.exceptions.ElementNotFoundException;
import skypro.homeworks.course2.homework14.exceptions.IndexOverBoundsException;
import skypro.homeworks.course2.homework14.exceptions.LimitReachedException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    private final StringList out = new StringListImpl();

    public static Stream<Arguments> indexOfParams() {
        return Stream.of(
                Arguments.of("Item1", 0),
                Arguments.of("Item2", 1),
                Arguments.of("Item3", 2),
                Arguments.of("Item4", 3)
        );
    }

    public static Stream<Arguments> lastIndexOfParams() {
        return Stream.of(
                Arguments.of("Item1", 3),
                Arguments.of("Item2", 2),
                Arguments.of("Item3", 1),
                Arguments.of("Item4", 0)
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
        assertThrows(IndexOverBoundsException.class, () -> out.add(10, newElement));
    }

    @Test
    @DisplayName("Должен выбросить исключение при превышении размера")
    void addItemsOverLimitTest() {
        out.add("Item5");
        assertThrows(LimitReachedException.class, () -> out.add("Item Over Limit"));
    }

    @Test
    @DisplayName("Должен выбросить исключение при превышении размера при добавлении элемента по индексу")
    void addItemByIndexOverLimitTest() {
        out.add("Item5");
        assertThrows(LimitReachedException.class, () -> out.add(2, "Item Over Limit"));
    }

    @Test
    @DisplayName("Должен заменить значение элемента по индексу")
    void setTest() {
        String expected = out.set(2, "New Item");
        assertEquals(expected, out.get(2));
    }

    @Test
    @DisplayName("Должен выбросить исключение при замене элемента по неверному индексу")
    void setWrongIndexTest() {
        assertThrows(IndexOverBoundsException.class, () -> out.set(12, "New Item"));
    }

    @Test
    @DisplayName("Должен удалить элемент по индексу")
    void removeItemByIndexTest() {
        int beforeRemove = out.size();
        out.remove(2);
        assertEquals(out.size(), beforeRemove - 1);
    }

    @Test
    @DisplayName("Должен удалить элемент по значению")
    void removeItemByValueTest() {
        int beforeRemove = out.size();
        out.remove("Item3");
        assertEquals(out.size(), beforeRemove - 1);
    }

    @Test
    @DisplayName("Должен выбросить исключение при удалении элемента по неверному индексу")
    void removeItemByWrongIndexTest() {
        assertThrows(ElementNotFoundException.class, () -> out.remove(10));
    }

    @Test
    @DisplayName("Должен выбросить исключение при удалении элемента по неверному значению")
    void removeItemByWrongValueTest() {
        assertThrows(ElementNotFoundException.class, () -> out.remove("Item10"));
    }

    @Test
    @DisplayName("Должен подтвердить, что элемент есть в массиве")
    void containsTest() {
        assertTrue(out.contains("Item1"));
    }

    @Test
    @DisplayName("Должен подтвердить, что элемента нет в массиве")
    void doesNotContainElementTest() {
        assertFalse(out.contains("Item10"));
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента")
    @MethodSource("indexOfParams")
    void indexOfTest(String search, int index) {
        assertEquals(out.indexOf(search), index);
    }

    @ParameterizedTest
    @DisplayName("Должен показать индекс элемента с конца")
    @MethodSource("lastIndexOfParams")
    void lastIndexOfTest(String search, int index) {
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
        assertThrows(IndexOverBoundsException.class, () -> out.get(10));
    }

    @Test
    @DisplayName("Должен посчитать количество элементов")
    void sizeTest() {
        assertEquals(out.size(), 4);
    }

    @Test
    @DisplayName("Должен подтвердить, что массив пустой")
    void isEmptyTest() {
        out.clear();
        assertTrue(out.isEmpty());
    }

    @Test
    @DisplayName("Должен очистить массив")
    void clearTest() {
        out.clear();
        assertEquals(out.size(), 0);
    }

}