package oop.labor06.parcialis_minta;

import oop.labor06.parcialis_minta.felveteli.Diak;
import oop.labor06.parcialis_minta.felveteli.Informatika;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Informatika infoSzak = new Informatika();

        infoSzak.ujBeiratkozo(new Diak("Mezei", "Mária", 7.56, 8.78));
        infoSzak.ujBeiratkozo(new Diak("Asztalos", "Imre", 8.45, 7.25));

        infoSzak.listazOsszes();
        System.out.println("***************************");

        try (Scanner scanner = new Scanner(new File("felveteli_beiratkozas.csv"))) {
            while (scanner.hasNext()) {
                String vnev = scanner.next();
                String knev = scanner.next();
                double erettsegi = scanner.nextDouble();
                double matematika = scanner.nextDouble();
                infoSzak.ujBeiratkozo(new Diak(vnev, knev, erettsegi, matematika));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        infoSzak.listazAtlag(8.0);
        System.out.println("***************************");

        System.out.println("Felvételizők száma: " + infoSzak.felvetelizokSzama() + ", átlag: " + infoSzak.felvetelizokAtlaga());
    }
}
