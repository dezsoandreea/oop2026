package oop.labor07;

public class Motorbicikli extends Jarmu{
    private String tipus;

    public Motorbicikli(String rendszam, String marka, String tipus){
        super(rendszam, marka);
        this.tipus = tipus;
    }

    public String getTipus() {
        return tipus;
    }

    @Override
    public String toString() {
        return "Motorbicikli{" +
                "rendszam='" + rendszam + '\'' +
                ", marka='" + marka + '\'' +
                ", tipus='" + tipus + '\'' +
                '}';
    }
}
