package math;

public class Factorial {
    public static void main(String[] args) {
        long fact11_20 = 1;
        long fact10 = 1;
        for (int i = 11; i < 21; i++) {
            fact11_20 *= i;
            System.out.println(fact11_20);
        }
        for (int i = 1; i < 11; i++) {
            fact10 *= i;

        }
        System.out.println(fact11_20);
        System.out.println(fact10);
        System.out.println(fact11_20/fact10);
    }
}
