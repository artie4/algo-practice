package leetcode.algo_1_path;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 11};
        System.out.println(search(arr, 10));
    }

    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
