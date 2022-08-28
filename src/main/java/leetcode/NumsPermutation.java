package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumsPermutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> sequence, List<List<Integer>> container) {
        if (nums.length < 1) {
            container.add(new ArrayList<>(sequence));
            sequence.clear();
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int[] remain = copyExcept(nums, i);
            List<Integer> newSeq = new ArrayList<>(sequence);
            newSeq.add(curr);
            helper(remain, newSeq, container);
        }
    }

    private int[] copyExcept(int[] ints, int exclude) {
        int[] result = new int[ints.length - 1];
        for (int i = 0; i < ints.length; i++) {
            if (i < exclude) {
                result[i] = ints[i];
            } else if (i > exclude) result [i - 1] = ints[i];
        }
        return result;
    }

    private void printList(List<List<Integer>> listList) {
        for(List<Integer> list: listList) {
            String mutation = list.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(mutation);
        }
    }

    public static void main(String[] args) {
        NumsPermutation numsPermutation = new NumsPermutation();
        List<List<Integer>> permutations = numsPermutation.permute(new int[]{1, 2, 3});
        numsPermutation.printList(permutations);
    }
}
