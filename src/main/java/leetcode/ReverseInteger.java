package leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int remain = x % 10;
            if (reversed > Integer.MAX_VALUE / 10) return 0;
            if (reversed < Integer.MIN_VALUE / 10) return 0;
            reversed = reversed * 10 + remain;
            x = x / 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        var inst = new ReverseInteger();
        assert(inst.reverse(-123000) == -321);
        assert(inst.reverse(-2147483642) == 0);
        assert(inst.reverse(2147483642) == 0);
        assert(inst.reverse(1463847412) == 2147483641);
    }
}
