package leetcode.data_1_path;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = { 1,3,4,5,6,7,8 };

        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}
