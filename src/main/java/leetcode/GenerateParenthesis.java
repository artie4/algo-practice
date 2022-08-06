
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int closed = 0;
        String sequence = "";
        List<String> sequences = new ArrayList<>();
        helper(open, closed, sequence, n, sequences);
        return sequences;
    }

    private void helper(int open, int close, String sequence, int n, List<String> sequences) {
        if (sequence.length() == 2*n) {
            sequences.add(sequence);
            return;
        }
        if (open < n) {
            helper(open + 1, close, sequence + "(", n, sequences);
        }
        if (open > close) {
            helper(open, close + 1, sequence + ")", n, sequences);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        var result = generateParenthesis.generateParenthesis(3);
        var expected = List.of("((()))","(()())","(())()","()(())","()()()");
        assert(result.equals(expected));
    }
}
