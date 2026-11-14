package aufgabe2;

/**
 * Aufgabe 2: Kontrollstrukturen (FizzBuzz).
 */
public class FizzBuzz {

    /**
     * Liefert die Ausgabe für eine einzelne Zahl.
     * Die Prüfung auf 15 (3 und 5) muss vor den Einzelprüfungen stehen.
     */
    static String convert(int zahl) {
        if (zahl % 15 == 0) {
            return "FizzBuzz";
        }
        if (zahl % 3 == 0) {
            return "Fizz";
        }
        if (zahl % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(zahl);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(convert(i));
        }
    }
}
