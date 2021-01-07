package codesignal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AlmostIncreasingSequence {

    public static void main(String[] args) {
        System.out.println(almostIncreasingSequence(new int[]{1,2,3,4,2}));
    }

    static boolean almostIncreasingSequence(int[] sequence) {
        if (sequence.length < 3) {
            return true;
        }

        int unOrderedCount = 0;
        int prev = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIdx = 0;
        int minIdx = 0;

        // sequence and min, max places checks
        for (int i = 0; i < sequence.length; i++) {
            if (prev > sequence[i]) unOrderedCount++;
            if (unOrderedCount > 1) return false;
            if (max < sequence[i]) { max = sequence[i]; maxIdx = i;}
            if (min > sequence[i]) {min = sequence[i]; minIdx = i;}
            prev = sequence[i];

        }
        if (minIdx - 1 > 0 && maxIdx + 1 < sequence.length - 1) return false;

        // duplicate check
        Set<Integer> set  = new HashSet<>();
        for (int k : sequence) {
            set.add(k);
        }
        return sequence.length - set.size() <= 1;
    }
}
