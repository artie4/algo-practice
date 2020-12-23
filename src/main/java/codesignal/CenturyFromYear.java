package codesignal;

public class CenturyFromYear {

    public static void main(String[] args) {
        System.out.println(centuryFromYear(1));
        System.out.println(centuryFromYear(100));
        System.out.println(centuryFromYear(101));
        System.out.println(centuryFromYear(199));
        System.out.println(centuryFromYear(2000));
    }

    // 1 ≤ year ≤ 2005
    static int centuryFromYear(int year) {
        int century = year / 100 + 1;
        if (year % 100 == 0) --century;
        return century;
    }
}
