package leetcode.algo_1_path;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class BinarySearchTask {

    public static void main(String[] args) {
        int[] array = {1, 4, 6, 6, 6, 8, 9, 11};
        int[] array2 = {0, 0};
        int[] array3 = {0, 1};
        int[] array4 = {5, 7};
        int[] array5 = {1, 1, 1, 1, 1};
        int[] array6 = {1, 1, 1};
        assert search(array, 5) == -1;
        assert search(array, 6) == 3;
        assert search(array2, 1) == -1;
        assert search(array3, 2) == -1;
        assert search(array4, 2) == -1;
        assert search(array5, 1) == 2;
        assert search(array6, 2) == -1;
    }

    private static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
