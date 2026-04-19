package oop.labor07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class JarmuPark {
    private ArrayList<Jarmu> jarmuvek;

    public JarmuPark(String fajlnev) {
        this.jarmuvek = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fajlnev))) {
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                if(line.startsWith("AUTO")){
                    String rendszam = items[1].trim();
                    String marka = items[2].trim();
                    int utasszam = Integer.parseInt(items[3].trim());
                    ujJarmu(new Auto(rendszam, marka, utasszam));
                }
                else if(line.startsWith("MOTOR")){
                    String rendszam = items[1].trim();
                    String marka = items[2].trim();
                    String tipus = items[3].trim();
                    ujJarmu(new Motorbicikli(rendszam, marka, tipus));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ujJarmu(Jarmu jarmu){
        jarmuvek.add(jarmu);
    }

    public void listaz(){
        for (Jarmu j : jarmuvek){
            System.out.println(j);
        }
    }

    public Jarmu keres(String rendszam){
        for (Jarmu j : jarmuvek) {
            if (j.getRendszam().equalsIgnoreCase(rendszam)){
                return j;
            }
        }
        return null;
    }

    public Jarmu kolcsonzes(String rendszam){
        Jarmu j = keres(rendszam);
        if (j != null && !j.isKolcsonzott()) {
            j.setKolcsonzott(true);
            return j;
        }
        return null;
    }

    public void visszavitel(String rendszam){
        Jarmu j = keres(rendszam);
        if (j != null) {
            j.setKolcsonzott(false);
        }
    }

    public int autokSzama() {
        int db = 0;
        for (Jarmu j : jarmuvek) {
            if (j instanceof Auto){
                db++;
            }
        }
        return db;
    }

    public int motorokSzama() {
        int db = 0;
        for (Jarmu j : jarmuvek) {
            if (j instanceof Motorbicikli){
                db++;
            }
        }
        return db;
    }

    public void printToFile() {
        String filename1 = String.format("auto.txt");
        String filename2 = String.format("motorok.txt");
        try (PrintStream pw = new PrintStream(filename1)) {
            for (Jarmu j : jarmuvek) {
                if (j instanceof Auto) {
                    Auto a = (Auto) j;
                    pw.println(a.getRendszam() + ", " + a.getMarka() + ", " + a.getUtasszam() + ", " + a.isKolcsonzott());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        try (PrintStream pw = new PrintStream(filename2)) {
            for (Jarmu j : jarmuvek) {
                if (j instanceof Motorbicikli) {
                    Motorbicikli m = (Motorbicikli) j;
                    if (m.isKolcsonzott() == false) {
                        pw.println(m.getRendszam() + ", " + m.getMarka() + ", " + m.getTipus());
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public boolean torol(String rendszam) {
        for (int i = 0; i < jarmuvek.size(); i++) {
            if (jarmuvek.get(i).getRendszam().equalsIgnoreCase(rendszam)) {
                jarmuvek.remove(i);
                return true;
            }
        }
        return false;
    }
}
