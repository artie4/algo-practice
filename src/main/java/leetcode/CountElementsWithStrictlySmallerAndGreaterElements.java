package leetcode;

public class CountElementsWithStrictlySmallerAndGreaterElements {

    public static void main(String[] args) {
        assert(countElements(new int[] {0,0,0}) == 0);
        assert(countElements(new int[] {1,2,3}) == 1);
        assert(countElements(new int[] {1}) == 0);
        assert(countElements(new int[] {10,9,9}) == 0);
    }

    public static int countElements(int[] nums) {
        if (nums.length < 3) return 0;
        int min = nums[0];
        int minCount = 0;
        int max = nums[0];
        int maxCount = 0;
        for (int curr : nums) {
            if (min < curr) {
                min = curr;
                minCount = 1;
            }
            if (min == curr) {
                minCount++;
            }

            if (max > curr) {
                maxCount = 1;
                max = curr;
            }
            if (max == curr) {
                maxCount++;
            }
        }
        if (max == min) return 0;
        return nums.length - minCount - maxCount;
    }
}
