// Note.java
package aufgabe5;

/**
 * Klasse für Noten.
 * @author Stefan Ptacek
 * @version 10.01.2022
 */
public final class Note {
    /** Speichert die Note. */
    private final int note;

    /** Speichert ein Notenobjekt mit der besten Note. */
    public static final Note BESTE = Note.valueOf(10);

    /** Speichert ein Notenobjekt mit der besten Note. */
    public static final Note SCHLECHTESTE = Note.valueOf(50);

    /**
     * Standardkonstruktor.
     * @param note ist der Wert der Note.
     */
    private Note(int note) {
        this.note = note;
    }

    /**
     * Eine Fabrikmethode für Noten.
     * @param note ist der Wert der Note als Integer.
     * @return ein neues Notenobjekt.
     * @throws IllegalArgumentException
     */
    public static Note valueOf(int note) throws IllegalArgumentException {
        switch (note) {
        case 10:
        case 13:
        case 17:
        case 20:
        case 23:
        case 27:
        case 30:
        case 33:
        case 37:
        case 40:
        case 50:
            break;
        default:
            throw new IllegalArgumentException("unzulaessige Note " + note);
        }

        return new Note(note);
    }

    /**
     * Eine Fabrikmethode für Noten.
     * @param note ist der Wert der Note als String.
     * @return ein neues Notenobjekt.
     * @throws IllegalArgumentException
     */
    public static Note valueOf(String note) throws IllegalArgumentException {
        switch (note) {
        case "1,0":
        case "1,3":
        case "1,7":
        case "2,0":
        case "2,3":
        case "2,7":
        case "3,0":
        case "3,3":
        case "3,7":
        case "4,0":
        case "5,0":
            break;
        default:
            throw new IllegalArgumentException("unzulaessige Note " + note);
        }

        // String note ins passende Integerformat konvertieren
        int res = Integer.parseInt(
            String.format("%c%c", note.charAt(0), note.charAt(2))
        );

        return new Note(res);
    }

    /**
     * Gibt die im Objekt gespeicherte Note aus.
     * @return die gespeicherte Note.
     */
    public int intValue() {
        return this.note;
    }

    /**
     * Prüft, ob eine Note bestanden hat.
     * @return true, wenn die Note bestanden hat, sonst false.
     */
    public boolean istBestanden() {
        return this.note <= 40;
    }

    /**
     * Konvertiert einen Notenwert im Integerformat zu einem String.
     */
    @Override public String toString() {
        return String.format("%d,%d",  (int) this.note / 10, this.note % 10);
    }

    /**
     * Prüft, ob ein Objekt mit einer Note identisch ist.
     */
    @Override public boolean equals(Object obj) {
        if (obj instanceof Note) {
            Note that = (Note) obj;
            return this.note == that.note;
        }
        return false;
    }

    /**
     * Gibt einen hashcode für die Note aus.
     */
    @Override public int hashCode() {
        return this.note;
    }
}
