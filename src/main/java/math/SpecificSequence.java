package math;

public class SpecificSequence {
    public static void main(String[] args) {
        assert(sequence(new int[] {1,1,2,1,1,1,2,1,0,1,1,2,1,0}) == 2);
        assert(sequence(new int[] {1,1,2,1,1,1,2,1,0}) == 1);
    }

    public static int sequence(int [] numbers) {
        int result = 0;
        boolean possibleSeq = false;
        int prevprev = numbers[0];
        int prev = numbers[1];
        for (int i = 2; i < numbers.length; i++) {
            if (possibleSeq && prev == 1 && numbers[i] == 0) {
                result++;
            } else if (prevprev == 1 && prev == 1 && numbers[i] == 2) {
                possibleSeq = true;
            } else if (prevprev == 1 && prev == 2 && numbers[i] == 1) {
                possibleSeq = true;
            } else {
                possibleSeq = false;
            }
            prevprev = prev;
            prev = numbers[i];
        }
        return result;
    }
}

