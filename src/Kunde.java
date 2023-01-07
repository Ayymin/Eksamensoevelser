import java.util.ArrayList;

public class Kunde {

    private String navn;

    private String mobil;

    public Bestilling bestilling;

    private final ArrayList<Bestilling> bestillings = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public Bestilling getBestilling() {
        return bestilling;
    }

    public void addBestilling(Bestilling bestilling) {
        if(!bestillings.contains(bestilling)) {
            bestillings.add(bestilling);
        }
    }

    public void removeBestilling(Bestilling bestilling) {
        if(bestillings.contains(bestilling)) {
            bestillings.remove(bestilling);
            bestilling.setKunde(null);
        }
    }

    public void setBestilling(Bestilling bestilling) {
        if(this.bestilling != bestilling) {
            Bestilling oldBestilling = this.bestilling;
            if(oldBestilling != null) {
                oldBestilling.removeKunde(this);
            }
            this.bestilling = bestilling;
            if(bestilling != null) {
                bestilling.addKunde(this);
            }
        }
    }
}
