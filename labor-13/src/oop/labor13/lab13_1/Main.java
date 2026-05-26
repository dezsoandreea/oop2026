package oop.labor13.lab13_1;

public class Main {
    public static void main(String[] args) {
        Anagramma a1 = new Anagramma("anagrammabe.txt");

        int pontosanKetto = a1.countGroupsOfSize(2);

        a1.writeResult("anagrammaki.txt", pontosanKetto);

        System.out.println("Pontosan ket szot tartalmazo osztalyok szama: " + pontosanKetto);
    }
}
