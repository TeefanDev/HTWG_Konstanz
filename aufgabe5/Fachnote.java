// Fachnote.java
package aufgabe5;
/**
 * Klasse für Fachnoten.
 * @author Stefan Ptacek
 * @version 10.01.2022
 */
public final class Fachnote {
    /** Der Name des Fachs. */
    public final String fach;
    /** Die Note. */
    public final Note note;

    /**
     * Konstruktor für die Klasse Fachnote.
     * @param fach ist der Name des Fachs.
     * @param note ist die Note.
     * @throws IllegalArgumentException
     */
    public Fachnote(String fach, Note note) throws IllegalArgumentException {
        if (fach == null || note == null || fach.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.fach = fach;
        this.note = note;
    }
}
