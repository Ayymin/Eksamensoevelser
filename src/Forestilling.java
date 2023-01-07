import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {

    private String navn;

    private LocalDate startDato;

    private LocalDate slutDato;

    private final ArrayList<Bestilling> bestillings = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillings);
    }

    public Bestilling createBestilling(LocalDate dato, Kunde kunde ) {
        Bestilling bestilling = new Bestilling(dato,this, kunde);
        bestillings.add(bestilling);
        return bestilling;
    }

    public void removeBestilling(Bestilling bestilling) {
        if(bestillings.contains(bestilling)) {
            bestillings.remove(bestilling);
        }
    }

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antalBestiltePåDag = 0;
        for (Bestilling bestilling : bestillings) {
            if (bestilling.getDato().equals(dato)) ;
            antalBestiltePåDag += bestilling.getPladser().size();
        }
    return antalBestiltePåDag;
    }

    public LocalDate successDato() {
        LocalDate successDato = null;
        int max = 0;
        for (LocalDate dato = startDato; !dato.isAfter(slutDato); dato = dato.plusDays(1)) {
            if (antalBestiltePladserPåDag(dato) > max) {
                max = antalBestiltePladserPåDag(dato);
                successDato = dato;
            }
        }
        return successDato;
    }
}

