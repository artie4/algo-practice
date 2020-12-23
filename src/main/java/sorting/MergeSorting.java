package sorting;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class MergeSorting {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 6, 1, 3, 5, 9, 8};
        System.out.println("Was " + Arrays.toString(array));
        mergeSort(array, 0, array.length-1);
        System.out.println("Become " + Arrays.toString(array));
    }

    static void merge(int arr[], int l, int m, int r)
    {
        System.out.println("Start merge " + Arrays.toString(arr));
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1], R = new int[n2];

        // Copy data to temp arrays L[] and R[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays back into arr[l..r]

        // Initial index of first subarray
        int i = 0;

        // Initial index of second subarray
        int j = 0;

        // Initial index of merged subarray
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of
        // L[], if there are any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of
        // R[], if there are any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // l is for left index and r is
// right index of the sub-array
// of arr to be sorted */
    static void mergeSort(int arr[],int l,int r){
        System.out.println("Start mergeSort " + l + " " + r);
        if(l>=r){
            return;//returns recursively
        }
        int m = (l+r-1)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
    }

}
