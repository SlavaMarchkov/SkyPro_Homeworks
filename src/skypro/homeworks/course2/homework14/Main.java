package skypro.homeworks.course2.homework14;

import java.util.Arrays;

public class Main {

    public static void main(final String[] args) {
        StringList stringList = new StringListImpl();
        StringList otherList = new StringListImpl();
//        StringList otherList = null;

        stringList.add("Item 1");
        stringList.add("Item 2");
        stringList.add("Item 3");
        stringList.add("Item 4");
//        stringList.add("Item 5");
//        stringList.add("Item 6"); // Limit reached

        otherList.add("Item 1");
        otherList.add("Item 2");
        otherList.add("Item 3");
        otherList.add("Item 4");

        System.out.println(stringList.add(4, "Item 1-1"));

        // замена элемента set
        System.out.println(stringList.set(3, "New Item"));

        // кол-во элементов
        System.out.println("кол-во элементов: " + stringList.size());

        // элемент по индексу
        System.out.println("элемент по индексу 0: " + stringList.get(0));
        System.out.println("элемент по индексу 3: " + stringList.get(3));
//        System.out.println("элемент по индексу 6: " + stringList.get(6));

        // проверка на пустоту
        System.out.println("проверка на пустоту: " + stringList.isEmpty());

        // индекс элемента
        System.out.println("индекс элемента 2: " + stringList.indexOf("Item 2"));
//        System.out.println("индекс элемента 5: " + stringList.indexOf("Item 5"));

        // индекс элемента с конца
        System.out.println("индекс элемента 2 с конца: " + stringList.lastIndexOf("Item 2"));
//        System.out.println("индекс элемента 5 с конца: " + stringList.lastIndexOf("Item 5"));

        // проверка элемента на существование
        System.out.println("проверка наличия элемента 2: " + stringList.contains("Item 2")); // true
        System.out.println("проверка наличия элемента 6: " + stringList.contains("Item 6")); // false

        // удаляет элемент по индексу
        System.out.println(stringList.remove(1));
//        System.out.println(stringList.remove(6)); // not found

        // удаляет элемент по значению
        System.out.println(stringList.remove("New Item"));
//        System.out.println(stringList.remove("Item 6")); // not found

        // сравнение списков
        System.out.println(stringList.equals(otherList));

        // конвертация в массив строк
        System.out.println(Arrays.toString(stringList.toArray()));

        // удаляет все элементы
        stringList.clear();
        System.out.println(stringList.size());

    }

}
