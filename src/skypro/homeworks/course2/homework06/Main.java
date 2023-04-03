package skypro.homeworks.course2.homework06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        // напечатать только нечетные числа в консоль
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 13, 26, 31, 1_000, 1_003));
        for (int num : nums) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private static void task2() {
        // напечатать только четные числа без повторений в порядке возрастания
        List<Integer> nums = new ArrayList<>(List.of(48, 16, 16, 24, 1, 0, 1, 8, 2, 3, 5, 5, 6, 7, 2, 10, 4, 4, 8, 64, 32, 9));
        List<Integer> evenNums = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                evenNums.add(num);
            }
        }

        Collections.sort(evenNums);

        for (int i = 0; i < evenNums.size() - 1; i++) {
            if (evenNums.get(i).equals(evenNums.get(i + 1))) {
                evenNums.remove(evenNums.get(i + 1));
            }
            System.out.print(evenNums.get(i) + " ");
        }
        System.out.print(evenNums.get(evenNums.size() - 1));

        System.out.println();
    }
}
