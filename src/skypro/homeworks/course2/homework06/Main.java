package skypro.homeworks.course2.homework06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        // напечатать только нечетные числа в консоль
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 13, 26, 31, 1_000, 1_003));
        for (int num : nums) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
    }
}
