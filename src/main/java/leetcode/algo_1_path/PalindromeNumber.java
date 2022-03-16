package leetcode.algo_1_path;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(-1));
        System.out.println(isPalindrome(11011));
    }

    public static boolean isPalindrome(int x) {
        var tokens = String.valueOf(x).toCharArray();
        var start = 0;
        var end = tokens.length - 1;

        while (start < end) {
            if (tokens[start++] != tokens[end--]) {
                return false;
            }
        }
        return true;
    }
}
