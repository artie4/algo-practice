package leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int len1 = expandAroundCenter(chars, i, i);
            int len2 = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(char[] chars, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
        assert(instance.longestPalindrome("cabbaba").equals("abba"));
        assert(instance.longestPalindrome("abde").equals("e"));
    }
}


