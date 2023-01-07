import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {

    private LocalDate dato;

    private Forestilling forestilling;

    public ArrayList<Kunde> kunder = new ArrayList<>();

    public ArrayList<Plads> pladser = new ArrayList<>();

    private Kunde kunde;

    public Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde) {
        this.dato = dato;
        this.forestilling = forestilling;
        this.setKunde(kunde);
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void addKunde(Kunde kunde) {
        if (!kunder.contains(kunde)) {
            kunder.add(kunde);
            kunde.setBestilling(this);
        }
    }

    public void removeKunde(Kunde kunde) {
        if(kunder.contains(kunde)) {
            kunder.remove(kunde);
            kunde.setBestilling(null);
            }
        }


    public void setKunde(Kunde kunde) {
        if(this.kunde != kunde) {
            Kunde oldKunde = this.kunde;
            if(oldKunde != null)
                oldKunde.removeBestilling(this);
        }
        this.kunde = kunde;
        if(kunde != null) {
            kunde.addBestilling(this);
        }
    }

    public ArrayList<Plads> getPladser(){
        return new ArrayList<>(pladser);
    }

    public void addPlads(Plads plads) {
        if(!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }

    public int samletPris() {
        int samletPris = 0;
        for(Plads plads : pladser) {
            samletPris += plads.getPris();
            System.out.println("hej");
        }
        return samletPris;
    }

}
