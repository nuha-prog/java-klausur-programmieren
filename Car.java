package aufgabe4;

/**
 * Aufgabe 4: Klassen und Objekte.
 */
public class Car {
    private final String marke;
    private final int baujahr;
    private int kmStand;

    public Car(String marke, int baujahr, int kmStand) {
        if (marke == null || marke.isBlank()) {
            throw new IllegalArgumentException("Die Marke darf nicht leer sein.");
        }
        if (baujahr < 1886) {
            throw new IllegalArgumentException("Ungültiges Baujahr: " + baujahr);
        }
        if (kmStand < 0) {
            throw new IllegalArgumentException("Der km-Stand darf nicht negativ sein.");
        }
        this.marke = marke;
        this.baujahr = baujahr;
        this.kmStand = kmStand;
    }

    /** Erhöht den km-Stand um die gefahrenen Kilometer. */
    public void drive(int km) {
        if (km < 0) {
            throw new IllegalArgumentException("Die gefahrenen Kilometer dürfen nicht negativ sein.");
        }
        kmStand += km;
    }

    public String getMarke() {
        return marke;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public int getKmStand() {
        return kmStand;
    }

    @Override
    public String toString() {
        return "Marke: " + marke + ", Baujahr: " + baujahr + ", km-Stand: " + kmStand + " km";
    }
}
