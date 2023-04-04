package skypro.homeworks.course2.homework06;

import java.util.*;

public class Main {

    private static final List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 13, 26, 31, 1_000, 1_003));
    private static final List<Integer> numsList = new ArrayList<>(List.of(48, 16, 16, 24, 1, 0, 1, 8, 2, 3, 5, 5, 6, 7, 2, 10, 4, 4, 8, 64, 32, 9));
    private static final List<String> words = List.of("cat", "food", "dog", "cat", "eat", "Bob", "Bill", "Bob", "dog");

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    /**
     * печатает только нечетные числа в консоль
     */
    private static void task1() {
        for (int num : nums) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    /**
     * печатает только четные числа без повторений в порядке возрастания
     */
    private static void task2() {
        Collections.sort(numsList);
        int prevNum = Integer.MIN_VALUE;
        for (int num : numsList) {
            if (num % 2 == 0 && num != prevNum) {
                System.out.print(num + " ");
                prevNum = num;
            }
        }

        System.out.println();
    }

    /**
     * выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли
     */
    private static void task3() {
        Set<String> uniqueWords = new HashSet<>(words);

        for (String word : uniqueWords) {
            System.out.print(word + " ");
        }

        System.out.println();
    }

    /**
     * выводит в консоль все количество дублей из списка слов
     */
    private static void task4() {
        List<String> words = List.of("cat", "food", "dog", "cat", "cat", "eat", "Bob", "dog", "cat");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (!wordCountMap.containsKey(word)) {
                wordCountMap.put(word, 0);
            }
            wordCountMap.put(word, wordCountMap.get(word) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getValue() + " ");
            }
        }

        System.out.println();
    }
}
