package oop.labor07;

public class Auto extends Jarmu{
    private int utasszam;

    public Auto(String rendszam, String marka, int utasszam){
        super(rendszam, marka);
        this.utasszam = utasszam;
    }

    public int getUtasszam() {
        return utasszam;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "rendszam='" + rendszam + '\'' +
                ", marka='" + marka + '\'' +
                ", utasszam=" + utasszam +
                '}';
    }
}
