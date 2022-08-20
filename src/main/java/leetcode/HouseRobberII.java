package leetcode;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int withFirstHouse = max(nums, 0, nums.length - 2);
        int withLastHouse = max(nums, 1, nums.length - 1);
        return Math.max(withFirstHouse, withLastHouse);
    }

    private int max(int[] nums, int start, int end) {
        int prevprev = 0;
        int prev = 0;

        for (int i = start; i <= end; i++) {
            int temp = prev;
            prev = Math.max(prevprev + nums[i], prev);
            prevprev = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        assert(houseRobberII.rob(new int[] {2,3,2}) == 3);
        assert(houseRobberII.rob(new int[] {1,2,3,2}) == 4);
        assert(houseRobberII.rob(new int[] {8,2,2,3}) == 10);
        assert(houseRobberII.rob(new int[] {2}) == 2);
    }

}
