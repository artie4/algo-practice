package leetcode;

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (oldvalue, newvalue) -> oldvalue + 1);
        }
       return map.entrySet().stream()
               .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .limit(k)
               .mapToInt(Map.Entry::getKey)
               .toArray();
    }

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{1, 1, 2, 2, 2, 3, 4, 5}, 2);
        System.out.println(Arrays.toString(result));
        int[] result2 = topKFrequent(new int[]{1, 2, 2, 3, 4, 5, 5}, 2);
        System.out.println(Arrays.toString(result2));
    }
}
