package oop.labor02;

public class DateUtil {
    public static boolean LeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year <= 0 ) {
            return false;
        }
        if(day < 1 || day > 31) {
            return false;
        }
        if(month < 1 || month > 12) {
            return false;
        }
        if(month == 2) {
            if(LeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        if(month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        } else {
            return day <= 31;
        }
    }
}
