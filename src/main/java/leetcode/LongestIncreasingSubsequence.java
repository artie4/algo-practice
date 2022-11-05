package leetcode;

public class LongestIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int result = 0;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) start = i;
            if (result < i - start + 1) result = i - start + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        assert (findLengthOfLCIS(new int[] {1,1,1,1,1}) == 1);
        assert (findLengthOfLCIS(new int[] {1,1,2,1,1}) == 2);
        assert (findLengthOfLCIS(new int[] {1,2,3,1,4,5,6,7,1}) == 5);
    }
}
