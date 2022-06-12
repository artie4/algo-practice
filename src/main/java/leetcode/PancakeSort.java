package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PancakeSort {

    public List<Integer> pancakeSort(int[] arr) {
        if (arr == null || arr.length < 2) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();

        for (int x = arr.length; x > 0; --x) {
            int i = 0;
            // searching max
            while (arr[i] != x) { i++; }
            // move max to beginning
            flip(arr, i + 1);
            result.add(i + 1);
            // move max to ending
            flip(arr, x);
            result.add(x);
        }
        return result;
    }

    private void flip(int[] arr, int k) {
        for (int i = 0; i < k/2; i++) {
            int temp = arr[i];
            int swapIndex = k - i - 1;
            arr[i] = arr[swapIndex];
            arr[swapIndex] = temp;
        }
    }

    private void printArray(String msg, int[] arr) {
        System.out.println(msg + " " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        PancakeSort inst = new PancakeSort();
        assert(inst.pancakeSort(new int[] {4,3,2,1}).equals(List.of(1, 4, 3, 3, 2, 2, 1, 1)));
    }
}
