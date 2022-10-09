package leetcode;

public class Fibonacci {

    public static int fib(int n) {
        switch (n) {
            case 0: return 0;
            case 1,2: return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }

    public static int fibConstMem(int n) {
        switch (n) {
            case 0: return 0;
            case 1,2: return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }


    public static void main(String[] args) {
        assert(fib(1) == 1);
        assert(fib(5) == 5);
        assert(fib(6) == 8);
        assert(fib(7) == 13);
        assert(fibConstMem(1) == 1);
        assert(fibConstMem(5) == 5);
        assert(fibConstMem(6) == 8);
        assert(fibConstMem(7) == 13);
    }
}
