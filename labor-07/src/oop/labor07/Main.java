package oop.labor07;

public class Main {
    public static void main(String[] args) {
        JarmuPark park = new JarmuPark("jarmuvek.txt");

        System.out.println("--- Jarmuvek listaja ---");
        park.listaz();

        System.out.println("\nAutok szama: " + park.autokSzama());
        System.out.println("Motorok szama: " + park.motorokSzama());

        System.out.println("\nKolcsonzes...");
        park.kolcsonzes("ABC123");
        System.out.println("ki van kolcsonozve az ABC123 rendszamu jarmu");
        park.kolcsonzes("XYZ111");
        System.out.println("ki van kolcsonozve az XYZ111 rendszamu jarmu");
        park.kolcsonzes("VWX567");
        System.out.println("ki van kolcsonozve a VWX567 rendszamu jarmu");

        System.out.println("\nVisszavitel...");
        park.visszavitel("vWX567");
        System.out.println("vissza van vive a VWX567 rendszamu jarmu");

        park.printToFile();
        System.out.println("\nAutok elmentve az autok.txt fajlba.");
        System.out.println("Nem kolcsonzott motorok elmentve a motorok.txt fajlban");

        if(park.torol("VWX567")) {
            System.out.println("\nSikerult torolni a VWX567 rendszamu jarmuvet");
        }
        else{
            System.out.println("\nNem sikerult torolni a VWX567 rendszamu jarmuvet");
        }
    }
}
