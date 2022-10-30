package leetcode;

public class NonDecreasingRotatedArray {

    public static boolean check(int[] nums) {
        if (nums.length < 2) return true;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                int shift = nums.length - i;
                flip(nums, 0, nums.length - 1);
                flip(nums, 0, shift - 1);
                flip(nums, shift, nums.length - 1);
                for (int j = 1; j < nums.length; ++j) {
                    if (nums[j] < nums[j - 1]) return false;
                }
                return true;
            }
        }
        return true;
    }

    private static void flip(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
//        assert(check(new int[] {3,4,5,1,2}));
        assert (!check(new int[] {2, 1, 3, 4}));
    }
}
