package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        final String fizz = "Fizz";
        final String buzz = "Buzz";
        for(int i = 1; i <= n; i++) {
            boolean divBy3 = i % 3 == 0;
            boolean divBy5 = i % 5 == 0;

            String current = "";

            if (divBy3) {
                current += fizz;
            }

            if (divBy5) {
                current += buzz;
            }

            if (current.equals("")) {
                current = i + "";
            }
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
