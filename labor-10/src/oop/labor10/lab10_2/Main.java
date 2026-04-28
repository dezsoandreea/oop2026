package oop.labor10.lab10_2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyDate> dates = new ArrayList<>();
        dates.add(new MyDate(2026, 1, 1));
        dates.add(new MyDate(2026, 4, 28));
        dates.add(new MyDate(2026, 4, 1));
        dates.add(new MyDate(2026, 2, 28));
        dates.add(new MyDate(2026, 3, 15));

        Collections.sort(dates);
        System.out.println(dates);
    }
}
