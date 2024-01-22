package leetcode;

public class LongestSequenceOfOnes {

    static int maxOnes(int[] nums) {
        int result = 0;
        int count = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                zeroCount++;
                if (zeroCount > 1) {
                    result = Math.max(result, count);
                    count = 0;
                    zeroCount = 0;
                }
            }
        }
        result = Math.max(result, count);
        if (result == nums.length) {
            result--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("1,1,1,0,0,1,1,1,0,1 ");
        System.out.println(maxOnes(new int[] {1,1,1,0,0,1,1,1,0,1}));
        System.out.print("1,0 ");
        System.out.println(maxOnes(new int[] {1,0}));
        System.out.print("0,0 ");
        System.out.println(maxOnes(new int[] {0,0}));
        System.out.print("1,1,1 ");
        System.out.println(maxOnes(new int[] {1,1,1}));
        System.out.print("0,1,1,1 ");
        System.out.println(maxOnes(new int[] {0,1,1,1}));
        System.out.print("1,1,1,0,0,1,1,1,0,1 ");
        System.out.println(maxOnes(new int[] {1,1,1,0,0,1,1,1,0,1,1,0,1}));
    }
}
