package skypro.homeworks.course2.homework15;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void main(final String[] args) {
        int[] randomIntArray = new int[100_000];
        fill(randomIntArray);

        int[] bubbleArr = Arrays.copyOf(randomIntArray, randomIntArray.length);
        System.out.println("Сортировка пузырьком: " + checkBubbleSort(bubbleArr));

        int[] selectionArr = Arrays.copyOf(randomIntArray, randomIntArray.length);
        System.out.println("Сортировка выборкой: " + checkSelectionSort(selectionArr));

        int[] insertionArr = Arrays.copyOf(randomIntArray, randomIntArray.length);
        System.out.println("Сортировка вставкой: " + checkInsertionSort(insertionArr));
    }

    private static long checkBubbleSort(final int[] arr) {
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        return System.currentTimeMillis() - start;
    }

    private static long checkSelectionSort(final int[] arr) {
        long start = System.currentTimeMillis();
        selectionSort(arr);
        return System.currentTimeMillis() - start;
    }

    private static long checkInsertionSort(final int[] arr) {
        long start = System.currentTimeMillis();
        insertionSort(arr);
        return System.currentTimeMillis() - start;
    }

    private static void fill(final int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 100000);
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void insertionSort(final int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

}
