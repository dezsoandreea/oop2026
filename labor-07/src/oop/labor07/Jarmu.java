package oop.labor07;

public class Jarmu {
    protected String rendszam;
    protected String marka;
    protected boolean kolcsonzott;

    public Jarmu(String rendszam, String marka) {
        this.rendszam = rendszam;
        this.marka = marka;
    }

    public String getRendszam() {
        return rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public boolean isKolcsonzott() {
        return kolcsonzott;
    }

    public void setKolcsonzott(boolean kolcsonzott) {
        this.kolcsonzott = kolcsonzott;
    }

    @Override
    public String toString() {
        return "Jarmu{" +
                "rendszam='" + rendszam + '\'' +
                ", marka='" + marka + '\'' +
                ", kolcsonzott=" + kolcsonzott +
                '}';
    }
}