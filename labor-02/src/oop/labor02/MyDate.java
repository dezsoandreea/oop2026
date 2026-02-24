package oop.labor02;

public class MyDate {
    private int day = 23;
    private int month = 2;
    private int year = 2026;

    // Constructor
    public Date(int y, int m, int d) {
        if (DateUtil.isValidDate(y, m, d)) {
            year = y;
            month = m;
            day = d;
        }
    }

    public void printDate(){
        System.out.println(year + "/" + month + "/" + day);
    }
}
