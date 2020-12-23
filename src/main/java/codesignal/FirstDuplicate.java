package codesignal;

public class FirstDuplicate {

    public static void main(String[] args) {
        System.out.println(firstDuplicate(new int[]{1,2,3,4})); // -1
        System.out.println(firstDuplicate(new int[]{2,3,2,1,5,3})); // 2
        System.out.println(firstDuplicate(new int[]{4,2,2,4,1,6})); // 2
        System.out.println(firstDuplicate(new int[]{5,4,3,2,1,1})); // 1
    }

    static int firstDuplicate(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int cur = a[i];
            if (cur < 0) cur = Math.abs(cur);
            if (a[cur-1] < 0) return cur;
            a[cur-1] = -a[cur-1];
        }
        return -1;
    }
}
