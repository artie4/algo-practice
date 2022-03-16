package leetcode.algo_1_path;

public class FirstBadVersionTask {


    public static void main(String[] args) {

        System.out.println(search(116));
    }

    static int search(int n) {

        int first = 0;
        int last = n;
        int badVersion = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (badVersion == mid || isBadVersion(mid)) {
                last = mid - 1;
                badVersion = mid;
            } else {
                first = mid + 1;
            }
        }

        return badVersion;
    }


    static boolean isBadVersion(int version) {
        return version >= 115;
    }
}
