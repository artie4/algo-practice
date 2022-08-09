package leetcode;

public class TrappingRainWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int count = 0;

        while(left < right) {
            if (leftMax <= rightMax) {
                left++;
                int hleft = height[left];
                if (leftMax < hleft) {
                    leftMax = hleft;
                }
                count += leftMax - hleft;
            } else {
                right--;
                int hright = height[right];
                if (rightMax < hright) {
                    rightMax = hright;
                }
                count += rightMax - hright;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        assert(trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) == 6);
        assert(trappingRainWater.trap(new int[]{0,1,2,3,0,0,1,5,2,1,2,1}) == 9);
    }
}
