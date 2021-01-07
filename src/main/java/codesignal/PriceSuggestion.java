package codesignal;

import java.util.Arrays;

public class PriceSuggestion {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(priceSuggestion(new int[]{1,2})));
    }

    static int[] priceSuggestion(int[] contractData) {
        if (contractData == null || contractData.length < 2) return new int[]{};
        boolean isEven = contractData.length % 2 == 0;
        int halfSize = isEven ? contractData.length / 2 : contractData.length / 2 + 1;
        int[] firstHalf = new int[halfSize];
        int[] secondHalf = new int[halfSize];
        Arrays.sort(contractData);
        int k = 0;
        int l = 0;
        for (int i = 0; i < contractData.length; i++) {
            if (i < halfSize - 1) {
                firstHalf[k++] = contractData[i];
            } else if (i == halfSize - 1) {
                if (!isEven) {
                    secondHalf[l++] = contractData[i];
                }
                firstHalf[k++] = contractData[i];
            } else {
                secondHalf[l++] = contractData[i];
            }
        }
        int lowMedian = firstHalf.length % 2 == 0 ? firstHalf.length / 2 - 1 : firstHalf.length / 2;
        return new int[]{firstHalf[lowMedian], secondHalf[secondHalf.length / 2]};
    }

}
