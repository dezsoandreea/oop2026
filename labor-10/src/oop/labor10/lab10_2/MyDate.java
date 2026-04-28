package oop.labor10.lab10_2;

public class MyDate implements Comparable<MyDate>{
    private int day;
    private int month;
    private int year;

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

    @Override
    public int compareTo(MyDate T) {
        if(this.year != T.year){
            return Integer.compare(this.year, T.year);
        }
        else if(this.month != T.month){
            return Integer.compare(this.month, T.month);
        }
        return Integer.compare(this.day, T.day);
    }
}
