package codesignal;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatCharacter {


    public static void main(String[] args) {
//        String str1 = "abcabcdabc";
//        System.out.println(firstNotRepeatingCharacter(str1));
//        String str2 = "abcaabcddabc";
//        System.out.println(firstNotRepeatingCharacter(str2));
//        String str3 = "iacaabcddaebc";
//        System.out.println(firstNotRepeatingCharacter(str3));
//        String str4 = "abcdeffea";
//        System.out.println(firstNotRepeatingCharacter(str4));
//        System.out.println(nonRepeatingNumber(new int[] { 2,4,3,2,6,4,6 }));
        System.out.println(nonRepeatingCharacter("abcdcba"));
    }

    static char firstNotRepeatingCharacter(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();
        for (char aChar : chars) {
            characterIntegerMap.merge(aChar, 1, (oldVal, newVal) -> ++oldVal);
        }
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return '_';
    }

    static int nonRepeatingNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    static char nonRepeatingCharacter(String s) {
        char[] chars = s.toCharArray();
        char result = chars[0];
        for (int i = 1; i < chars.length; i++) {
            result ^= chars[i];
        }
        return result;
    }
}
