package codesignal;

public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome("abcba"));
        System.out.println(checkPalindrome("adbcba"));
        System.out.println(checkPalindrome("a"));
    }
    static boolean checkPalindrome(String inputString) {
        char[] chars = inputString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length  - i - 1]) return false;
        }
        return true;
    }
}
