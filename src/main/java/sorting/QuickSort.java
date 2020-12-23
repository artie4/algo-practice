package sorting;

import java.util.Arrays;

public class QuickSort {

    static int iterations = 0;

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 8, 2, 9, 4, 5, 1};
        System.out.println("Was " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Become " + Arrays.toString(arr));
    }

    static void quickSort(int[] array, int start, int end) {
        if (array == null || array.length == 0) return;
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        int bearing = array[mid];

        int left = start;
        int right = end;

        while (left <= right) {
            System.out.println("while (left <= right) " + ++iterations);
            while (array[left] < bearing) {
                left++;
            }
            while (array[right] > bearing) {
                right--;
            }

            if (left <= right) {
                // swap
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        if (start < right) {
            quickSort(array, start, right);
        }
        if (end > left) {
            quickSort(array, left, end);
        }
    }
}
