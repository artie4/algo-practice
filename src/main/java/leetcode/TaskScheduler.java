package leetcode;

import java.util.*;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char task : tasks) {
            taskCount.merge(task, 1, (old, upd) -> old + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((v1,v2) -> v2 - v1);
        taskCount.values().forEach(queue::offer);
        Map<Integer, Integer> stepToTaskCount = new HashMap<>();

        int currentStep = 0;
        while (!queue.isEmpty() || !stepToTaskCount.isEmpty()) {
            if (stepToTaskCount.containsKey(currentStep - n - 1)) {
                queue.offer(stepToTaskCount.remove(currentStep - n - 1));
            }
            if (!queue.isEmpty()) {
                int curMax = queue.poll();
                if (curMax > 1) {
                    stepToTaskCount.put(currentStep, curMax - 1);
                }
            }
            currentStep++;
        }
        return currentStep;
    }

    public static void main(String[] args) {
        assert(leastInterval(new char[] {'A', 'B', 'C', 'A'}, 2) == 4);
        assert(leastInterval(new char[] {'A', 'A', 'B', 'B', 'B', 'C', 'C'}, 2) == 7);
        assert(leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C'}, 1) == 8);
    }
}
