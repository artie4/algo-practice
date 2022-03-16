package leetcode.algo_1_path;

public class ReverseString {

    public static void main(String[] args) {
        char[] chars1 = "abbapap".toCharArray();
        reverseString(chars1);
        System.out.println(new String(chars1));
        char[] chars2 = "Bbapap".toCharArray();
        reverseString(chars2);
        System.out.println(new String(chars2));
        char[] chars3 = "POI".toCharArray();
        reverseString(chars3);
        System.out.println(new String(chars3));
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
