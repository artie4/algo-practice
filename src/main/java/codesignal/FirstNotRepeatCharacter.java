package codesignal;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatCharacter {


    public static void main(String[] args) {
        String str1 = "abcabcdabc";
        System.out.println(firstNotRepeatingCharacter(str1));
        String str2 = "abcaabcddabc";
        System.out.println(firstNotRepeatingCharacter(str2));
        String str3 = "iacaabcddaebc";
        System.out.println(firstNotRepeatingCharacter(str3));
        String str4 = "abcdeffea";
        System.out.println(firstNotRepeatingCharacter(str4));
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
}
