package skypro.homeworks.course2.homework01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Задание 5.
        int value = 33;
        changeValue(value);
        System.out.println(value); // 33

        // Задание 6.
        Integer value2 = 33;
        changeValue(value2);
        System.out.println(value2); // 33

        // Задание 7.
        Integer[] value3 = new Integer[]{3, 4};
        System.out.println(Arrays.toString(value3)); // [3, 4]
        changeValue(value3);
        System.out.println(Arrays.toString(value3)); // [3, 4]

        // Задание 8.
        Integer[] value4 = new Integer[]{3, 4};
        System.out.println(Arrays.toString(value4)); // [3, 4]
        changeValue4(value4);
        System.out.println(Arrays.toString(value4)); // [99, 4]

        // Задание 9.
        Person person = new Person("Lyapis", "Trubetskoy");
        person.changePerson(person);
        System.out.println("person = " + person);

        // Задание 10.
        Person person2 = new Person("Lyapis", "Trubetskoy");
        person2.changePerson2(person2);
        System.out.println("person2 = " + person2);

    }

    private static void changeValue4(Integer[] value) {
        value[0] = 99;
        System.out.println("value4 = " + Arrays.toString(value)); // value4 = [99, 4]
    }

    private static void changeValue(Integer[] value) {
        value = new Integer[]{1, 2};
        System.out.println("value = " + Arrays.toString(value)); // value = [1, 2]
    }

    private static void changeValue(Integer value) {
        value = 22;
    }

    private static void changeValue(int value) {
        value = 22;
    }
}
