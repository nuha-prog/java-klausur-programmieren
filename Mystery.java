/**
 * Aufgabe 6: Die Unlösbare.
 *
 * Annahme: Jede Zahl steht für die Position eines Buchstabens im Alphabet
 * (1 = A, 2 = B, ..., 26 = Z). Die Zahlen sind durch "-" getrennt.
 * Ein Teil, der keine gültige Zahl von 1 bis 26 ist (z. B. "?"),
 * ist nicht entschlüsselbar und wird als "?" im Ergebnis markiert.
 */
public class Mystery {

    public static void main(String[] args) {
        String code = decode("9-1-2-?");
        System.out.println(code);
    }

    public static String decode(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        StringBuilder wort = new StringBuilder();
        for (String teil : input.split("-")) {
            wort.append(teilZuBuchstabe(teil.trim()));
        }
        return wort.toString();
    }

    /** Wandelt eine Zahl 1-26 in einen Buchstaben um, alles andere in '?'. */
    private static char teilZuBuchstabe(String teil) {
        try {
            int zahl = Integer.parseInt(teil);
            if (zahl >= 1 && zahl <= 26) {
                return (char) ('A' + zahl - 1);
            }
        } catch (NumberFormatException e) {
            // kein gültiger Zahlenwert, z. B. "?"
        }
        return '?';
    }
}
