public class Plads {

    private int række;

    private int nr;

    private int pris;

    public Plads(int række, int nr, int pris) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
    }

    public int getRække() {
        return række;
    }

    public void setRække(int række) {
        this.række = række;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
