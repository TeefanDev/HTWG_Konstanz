// BenoteteLeistung.java
package aufgabe6;

import aufgabe5.Note;

/**
 * BenoteteLeistung speichert eine Benotete Leistung.
 * @author Stefan Ptacek
 * @version 17.01.2022
 */
public final class BenoteteLeistung  extends Leistung {
    /** Speichert die Note. */
    private final Note note;

    /**
     * Konstruktor.
     * @param fachname
     * @param note
     */
    public BenoteteLeistung(String fachname, String note) {
        super(fachname);
        this.note = Note.valueOf(note);
    }

    /**
     * Überschreibt die Methode Leistung.istBestanden().
     * @return true, wenn die Note bestanden ist, sonst false.
     */
    @Override
    public boolean istBestanden() {
        return note.istBestanden();
    }

    /**
     * Überschreibt die Methode Leistung.istBenotet().
     * @return immer true.
     */
    @Override
    public boolean istBenotet() {
        return true;
    }

    /**
     * Gibt die Note in numerischer Schreibweise an.
     * @return den String in numerischer Schreibweise.
     */
    @Override
    public String getNote() {
        return note.toString();
    }

    /**
     * Gibt die Note in Worten aus.
     * @return den String als Note in Worten.
     */
    @Override
    public String getNoteInWorten() {
        switch (note.intValue()) {
        case 10:
        case 13:
            return "sehr gut";
        case 17:
        case 20:
        case 23:
            return "gut";
        case 27:
        case 30:
        case 33:
            return "befriedigend";
        case 37:
        case 40:
            return "ausreichend";
        default:
            return "nicht ausreichend";
        }
    }
}
