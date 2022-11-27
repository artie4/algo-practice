package leetcode;

public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int start = 0;
        int end = num;
        while (start < end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;
            if (square > num) {
                end = mid;
            } else if (square < num) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        assert(isPerfectSquare(1));
        assert(isPerfectSquare(9006001));
        assert(!isPerfectSquare(80));
    }
}
