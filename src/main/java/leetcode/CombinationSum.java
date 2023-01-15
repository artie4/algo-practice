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
}
