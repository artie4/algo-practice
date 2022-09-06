package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> smallerToGreater = new HashMap<>();

        for (int num: nums2) {
            while (!stack.empty() && num > stack.peek()) {
                smallerToGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = smallerToGreater.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        assert (Arrays.equals(nextGreaterElement(new int[]{2, 4}, new int[]{3, 2, 1, 4}), new int[]{4, -1}));
        assert (Arrays.equals(nextGreaterElement(new int[]{3, 1}, new int[]{3, 2, 4, 1}), new int[]{4, -1}));
        assert (Arrays.equals(nextGreaterElement(new int[]{3, 1}, new int[]{3, 2, 4, 1}), new int[]{4, -1}));
    }
}
