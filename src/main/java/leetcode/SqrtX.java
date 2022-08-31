package leetcode;

public class SqrtX {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1;
        int right = x;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid && x / (mid + 1) < (mid + 1)) {
                return mid;
            } else if (x / mid < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        assert(sqrtX.mySqrt(16) == 4);
        assert(sqrtX.mySqrt(2_147_483_647) == 46340);
    }
}
