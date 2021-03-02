package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(integerToRoman(2090));
    }

    /**
     * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral.
     */

    public static String integerToRoman(int value) {
        Map<Integer, String> romanNumbs = new HashMap<>();
        romanNumbs.put(1000, "M");
        romanNumbs.put(500, "D");
        romanNumbs.put(100, "C");
        romanNumbs.put(50, "L");
        romanNumbs.put(10, "X");
        romanNumbs.put(5, "V");
        romanNumbs.put(1, "I");

        int[] decPlaces = {1000, 100, 10, 1};

        StringBuilder sb = new StringBuilder();
        for (int j = 0, dec_placesLength = decPlaces.length; j < dec_placesLength; j++) {
            int dp = decPlaces[j];
            int curDigit = value / dp;
            value = value % dp;
            String firstToken = "";
            String secondToken = "";
            int count = 0;
            switch (curDigit) {
                case 1: { secondToken = romanNumbs.get(dp); count = 1; break;}
                case 2: { secondToken = romanNumbs.get(dp); count = 2; break;}
                case 3: { secondToken = romanNumbs.get(dp); count = 3; break;}
                case 4: { firstToken = romanNumbs.get(dp); secondToken = romanNumbs.get(dp * 5); count = 1; break;}
                case 5: { firstToken = romanNumbs.get(dp * 5); break;}
                case 6: { firstToken = romanNumbs.get(dp * 5); secondToken = romanNumbs.get(dp); count = 1; break;}
                case 7: { firstToken = romanNumbs.get(dp * 5); secondToken = romanNumbs.get(dp); count = 2; break;}
                case 8: { firstToken = romanNumbs.get(dp * 5); secondToken = romanNumbs.get(dp); count = 3; break;}
                case 9: { firstToken = romanNumbs.get(dp); secondToken = romanNumbs.get(dp * 10); count = 1; break;}
                default: continue;
            }
            sb.append(firstToken);
            sb.append(secondToken.repeat(count));
        }
        return sb.toString();
    }
}
