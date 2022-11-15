// Faecher.java
package aufgabe6;

/**
 * Faecher prüft die eingegeben Fächer.
 * @author Stefan Ptacek
 * @version 17.01.2022
 */
public final class Faecher {
    /** Array von Strings mit den Fächern aus AIN1. */
    private static final String[] FAECHER = {
        "Mathematik 1",
        "Digitaltechnik",
        "Programmiertechnik 1",
        "Softwaremodellierung"
    };

    /**
     * Privater Konstruktor.
     */
    private Faecher() { }

    /**
     * Prüft, ob ein Fachname in dem Array der zulässigen Fächer enthalten ist.
     * @param fachname ist der zu prüfende Name.
     * @return true, wenn der Name zulässig ist, sonst false.
     */
    public static boolean istZulaessig(String fachname) {
        for (String element : FAECHER) {
            if (fachname.equals(element)) {
                return true;
            }
        }
        return false;
    }
}
