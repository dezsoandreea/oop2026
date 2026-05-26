package oop.labor13.lab13_2;

public class Person {
    private String name;
    protected int birthYear;
    protected int deathYear;

    public Person(String name) {
        this.name = name;
    }

    public boolean hasFullData() {
        return ((birthYear != 0) && (deathYear != 0));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }
}
