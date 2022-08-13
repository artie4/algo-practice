package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        combo(candidates, 0, new LinkedList<>(), target, result);
        return result;
    }

    private void combo(int[] candidates, int index, LinkedList<Integer> curr, int target, List<List<Integer>> combinations) {
        if (target < 0 || index >= candidates.length) {
            return;
        } else if (target == 0) {
            combinations.add(new LinkedList<>(curr));
            return;
        }

        curr.addLast(candidates[index]);
        combo(candidates, index, curr, target - candidates[index], combinations);
        curr.removeLast();
        combo(candidates, index + 1, curr, target, combinations);
    }

    private static void printResult(List<List<Integer>> result) {
        result.forEach(list ->
                System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(","))));
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        var result = combinationSum.combinationSum(new int[] {2,3,5}, 8);
        printResult(result);
        var result2 = combinationSum.combinationSum(new int[] {2,7,6,3,5,1}, 9);
        printResult(result2);
    }
}
