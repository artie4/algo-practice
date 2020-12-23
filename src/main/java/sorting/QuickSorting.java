package sorting;

import java.util.Arrays;

public class QuickSorting {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 3, 7, 9, 6, 1};
        System.out.println("Was " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("Become " + Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int start, int end) {
        int pivotIdx = end;
        int pivot = array[pivotIdx];
        int left = start;
        int right = end;

        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }

            if (start < right) {
                quickSort(array, start, right);
            }
            if (left < end) {
                quickSort(array, left, end);
            }
        }
    }
}
