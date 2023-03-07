package skypro.homeworks.course1.homework06;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    private static void task1() {
        System.out.println("Задача 1");
        int[] digits = new int[3];
        digits[0] = 1;
        digits[1] = 2;
        digits[2] = 3;

        double[] numbers = {1.57, 7.654, 9.986};

        int[] customArray = new int[]{42, 142, 1142, 2356, 958, 1955, 945, 628};

        System.out.println("Задача 2");

        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
            if (i != digits.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        for (int i = 0; i < customArray.length; i++) {
            System.out.print(customArray[i]);
            if (i != customArray.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        System.out.println("Задача 3");

        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.print(digits[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }

        System.out.println();

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }

        System.out.println();

        for (int i = customArray.length - 1; i >= 0; i--) {
            System.out.print(customArray[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }

        System.out.println();

        System.out.println("Задача 4");

        System.out.println(Arrays.toString(digits));

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 != 0) {
                digits[i] += 1;
            }
        }

        System.out.println(Arrays.toString(digits));
    }

    /**
     * Генерирует массив случайных чисел от 100 000 до 200 000
     *
     * @return arr
     */
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }

        return arr;
    }

    private static void task2() {
        System.out.println("Часть 2. Задача 1");
        // Посчитать сумму всех выплат за месяц
        int[] arr = generateRandomArray();
        int sum = 0;
        for (int element : arr) {
            sum = sum + element;
        }
        String sumFormatted = String.format(Locale.FRANCE, "%,d", sum);
        System.out.println("Сумма трат за месяц составила " + sumFormatted + " рублей");
    }

    private static void task3() {
        System.out.println("Часть 2. Задача 2");
        // Найти минимальную и максимальную трату за день
        int[] arr = generateRandomArray();

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            final int current = arr[i];
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }

        String minFormatted = String.format(Locale.FRANCE, "%,d", min);
        String maxFormatted = String.format(Locale.FRANCE, "%,d", max);
        System.out.println("Минимальная сумма трат за день составила " + minFormatted + " рублей. Максимальная сумма трат за день составила " + maxFormatted + " рублей.");
    }

    private static void task4() {
        System.out.println("Часть 2. Задача 3");
        // Найти среднее значение трат за месяц
        int[] arr = generateRandomArray();

        int sum = 0;
        for (int element : arr) {
            sum = sum + element;
        }

        float avg = (float) sum / arr.length;

        String avgFormatted = String.format(Locale.FRANCE, "%,f", avg);
        System.out.println("Средняя сумма трат за месяц составила " + avgFormatted +" рублей");
    }

    private static void task5() {
        System.out.println("Часть 2. Задача 4");

        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int i = reverseFullName.length - 1; i >= 0; i--) {
            System.out.print(reverseFullName[i]);
        }

        System.out.println();
    }
}
