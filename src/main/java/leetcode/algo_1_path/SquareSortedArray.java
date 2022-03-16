package leetcode.algo_1_path;

import java.util.Arrays;
import java.util.Collections;

public class SquareSortedArray {

    public static void main(String[] args) {
        int[] arr = {-8, -6, 1, 1, 4, 6};
        int[] result = square(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static int[] square(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        int i = end;

        while (start <= end) {
            int startSq = nums[start] * nums[start];
            int endSq = nums[end] * nums[end];
            if (endSq >= startSq) {
                result[i--] = endSq;
                end--;
            } else {
                result[i--] = startSq;
                start++;
            }
        }
        return result;
    }
}
