package oop.labor02;

public class DateUtil {
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public static boolean isValidDate(int y, int m, int d) {
        if (y <= 0 ) {
            return false;
        }
        if(d < 1 || d > 31) {
            return false;
        }
        if(m < 1 || m > 12) {
            return false;
        }
        if(m == 2) {
            if(isLeapYear(y)) {
                return d <= 29;
            } else {
                return d <= 28;
            }
        }
        if(m == 4 || m == 6 || m == 9 || m == 11) {
            return d <= 30;
        } else {
            return d <= 31;
        }
    }
}
