package aufgabe3;

/**
 * Aufgabe 3: Arrays und Schleifen.
 */
public class ArrayUtils {

    /**
     * Gibt das größte Element eines int-Arrays zurück.
     *
     * @param arr das zu durchsuchende Array
     * @return das größte Element
     * @throws IllegalArgumentException wenn das Array null oder leer ist
     *         (der Rückgabetyp int kann keinen "kein Ergebnis"-Wert darstellen)
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Das Array darf nicht null oder leer sein.");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
