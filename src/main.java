import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Forestilling forestilling = new Forestilling("This nigga", LocalDate.now(),LocalDate.now());
        Kunde kunde = new Kunde("Amin","13");
        Bestilling bestilling = new Bestilling(LocalDate.now(),forestilling, kunde);
        Plads plads = new Plads(13,14,32);
        Plads plads1 = new Plads(13,15,32);


    }
}
