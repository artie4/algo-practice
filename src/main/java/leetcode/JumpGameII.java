package leetcode;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int jumps = 0;
        int currentLength = nums[0];
        int currMaxLength = nums[0];

        for (int i = 1; i < nums.length - 1; ++i) {
            currentLength--;
            currMaxLength--;
            if (nums[i] > currMaxLength) {
                currMaxLength = nums[i];
            }
            if (currentLength == 0) {
                jumps++;
                currentLength = currMaxLength;
                if (currentLength >= nums.length - 1 - i) break;
            }
        }
        return jumps + 1;
    }

    public static void main(String[] args) {

        JumpGameII jumpGameII = new JumpGameII();
        assert (jumpGameII.jump(new int[]{1,2}) == 1);
        assert (jumpGameII.jump(new int[]{2,1}) == 1);
        assert (jumpGameII.jump(new int[]{2,3,1,1,4}) == 2);
        assert (jumpGameII.jump(new int[]{1,1,1,1}) == 3);
    }
}
