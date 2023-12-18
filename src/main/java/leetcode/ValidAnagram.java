package leetcode;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charStats = new int[26];
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        for (char ch: schars) {
            charStats[ch - 'a']++;
        }
        for (char ch : tchars) {
            charStats[ch - 'a']--;
            if (charStats[ch - 'a'] < 0) return false;
        }
        return true;
    }
}
