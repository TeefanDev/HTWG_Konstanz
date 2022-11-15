// Noten.java
package aufgabe4;
//import aufgabe4.schweiz.Noten;
import java.util.Locale;
import java.util.Scanner;
/**
 * @author Stefan Ptacek
 * @version 30.11.2021
 */
public final class Noten {
    /**
     * Standartkonstruktor.
     */
    private Noten() { }
    private static final Scanner EINGABE = new Scanner(System.in);
    /**
     * Beste.
     */
    private static double beste = 0.0;
    /**
     * Schlechteste.
     */
    private static double schlechteste = 0.0;

    /**
     * Prüft, ob der String zulässig ist.
     */
    public static boolean istZulaessig(String note) {
        if (note.matches("\\d\\,\\d") || note.matches("\\d\\.\\d")) {
            note = note.replace(',', '.');
            switch (note) {
            case "1.0":
            case "1.3":
            case "1.7":
            case "2.0":
            case "2.3":
            case "2.7":
            case "3.0":
            case "3.3":
            case "3.7":
            case "4.0":
            case "5.0":
                return true;
            default:
                return false;
            }
        }
        return false;
    }
    /**
     * Wandelt String in double um.
     */
    public static double toDouble(String note) {
        String ausgabeNote = note;
        note = note.replace(',', '.');
        if (istZulaessig(note)) {
            return (Double.parseDouble(note));
        } else {
            throw new IllegalArgumentException("Unzulaessige Note "
                + ausgabeNote + " wird ignoriert!");
        }
    }
    /**
     * Wandelt double in String um.
     */
    public static String toString(double noten) {
        Locale.setDefault(Locale.GERMAN);
        double ausgabeNote = noten;
        noten = Double.parseDouble(String.format(Locale.GERMAN, "%.1f", noten));
        if ((noten < schlechteste && noten > beste)
            || noten == schlechteste || noten == beste) {
            return (Double.toString(noten));
        } else {
            throw new IllegalArgumentException("Unzulaessige Note "
                + ausgabeNote + " wird ignoriert!");
        }
    }
    /**
     * Prüft, ob bestanden wurde.
     */
    public static boolean istBestanden(double noten) {
        return noten <= 4.0;
    }
    /**
     * Evaluiere bessere note.
     */
    public static double bessere(double note1, double note2) {
        return note1 <= note2 ? note1 : note2;
    }
    /**
     * Evaluiere schlechtere Note.
     */
    public static double schlechtere(double note1, double note2) {
        return note1 >= note2 ? note1 : note2;
    }
}