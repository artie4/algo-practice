package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSumII {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combo(candidates, 0, new LinkedList<>(), target, result);
        return result;
    }

    private void combo(int[] candidates, int index, LinkedList<Integer> curr, int target, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new LinkedList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            curr.addLast(candidates[i]);
            combo(candidates, i + 1, curr, target - candidates[i], combinations);
            curr.removeLast();
        }
    }

    private static void printResult(List<List<Integer>> result) {
        result.forEach(list ->
                System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(","))));
        System.out.println();
    }


    public static void main(String[] args) {
        CombinationSumII combinationSum = new CombinationSumII();
        var result = combinationSum.combinationSum(new int[]{1, 1, 2, 1, 3, 5}, 8);
        printResult(result);
        var result2 = combinationSum.combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9);
        printResult(result2);
        var result3 = combinationSum.combinationSum(new int[]{4, 1, 1, 1, 2, 3}, 6);
        printResult(result3);
    }
}
