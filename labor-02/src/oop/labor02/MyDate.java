package oop.labor02;

public class MyDate {
    private int day = 23;
    private int month = 2;
    private int year = 2026;

    public MyDate(int y, int m, int d) {
        if (DateUtil.isValidDate(y, m, d)) {
            year = y;
            month = m;
            day = d;
        }else {
            throw new IllegalArgumentException("Invalid date parameters");
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return String.format("%04d.%02d.%02d", year, month, day);
    }
}
