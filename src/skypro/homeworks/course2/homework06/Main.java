package skypro.homeworks.course2.homework06;

import java.util.*;

public class Main {
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
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 13, 26, 31, 1_000, 1_003));
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
        List<Integer> nums = new ArrayList<>(List.of(48, 16, 16, 24, 1, 0, 1, 8, 2, 3, 5, 5, 6, 7, 2, 10, 4, 4, 8, 64, 32, 9));
        List<Integer> evenNums = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                evenNums.add(num);
            }
        }

        /*
        // Вариант с циклом по ArrayList
        Collections.sort(evenNums);

        for (int i = 0; i < evenNums.size() - 1; i++) {
            if (evenNums.get(i).equals(evenNums.get(i + 1))) {
                evenNums.remove(evenNums.get(i + 1));
            }
            System.out.print(evenNums.get(i) + " ");
        }
        System.out.print(evenNums.get(evenNums.size() - 1));*/

        // Вариант с Set
        Set<Integer> uniqueEvenNums = new HashSet<>(evenNums);

        List<Integer> sortedUniqueEvenNums = new ArrayList<>(uniqueEvenNums);
        Collections.sort(sortedUniqueEvenNums);

        for (Integer num : sortedUniqueEvenNums) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    /**
     * выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли
     */
    private static void task3() {
        List<String> words = List.of("cat", "food", "dog", "cat", "eat", "Bob", "Bill", "Bob", "dog");
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
