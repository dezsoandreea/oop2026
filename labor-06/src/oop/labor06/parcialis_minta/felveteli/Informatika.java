package oop.labor06.parcialis_minta.felveteli;

import java.util.ArrayList;

public class Informatika {
    private ArrayList<Diak> felvetelizok;

    public Informatika() {
        this.felvetelizok = new ArrayList<>();
    }

    public void ujBeiratkozo(Diak diak) {
        felvetelizok.add(diak);
    }

    public int felvetelizokSzama() {
        return felvetelizok.size();
    }

    public double felvetelizokAtlaga() {
        if (felvetelizok.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Diak d : felvetelizok) {
            sum += d.atlag();
        }
        return sum / felvetelizok.size();
    }

    public void listazOsszes() {
        for (Diak d : felvetelizok) {
            System.out.println(d.toString());
        }
    }

    public void listazAtlag(double limit) {
        for (Diak d : felvetelizok) {
            if (d.atlag() > limit) {
                System.out.println(d.toString());
            }
        }
    }
}
