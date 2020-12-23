package codesignal;

public class AdjacentElementsProduct {

    public static void main(String[] args) {
        System.out.println(adjacentElementsProduct(new int[] {0, -3, 5, 1, -6}));
        System.out.println(adjacentElementsProduct(new int[] {0, -3, 5}));
    }

    // 2 ≤ inputArray.length ≤ 10
    static int adjacentElementsProduct(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        if (inputArray.length == 2) {
            return inputArray[0] * inputArray[1];
        }
        for (int i = 1; i < inputArray.length - 1; i++) {
            if (inputArray[i - 1] * inputArray[i] > max) {
                max = inputArray[i - 1] * inputArray[i];
            }
            if (inputArray[i + 1] * inputArray[i] > max) {
                max = inputArray[i + 1] * inputArray[i];
            }
        }
        return max;
    }
}
