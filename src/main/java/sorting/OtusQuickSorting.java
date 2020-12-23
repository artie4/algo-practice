package sorting;

import java.util.Arrays;

public class OtusQuickSorting {

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 8};
        System.out.println("Was " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Become " + Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;


        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
