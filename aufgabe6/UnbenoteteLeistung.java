// UnbenoteteLeistung.java
package aufgabe6;

/**
 * UnbenoteteLeistung speichert eine Unbenotete Leistung.
 * @author Stefan Ptacek
 * @version 17.01.2022
 */
public final class UnbenoteteLeistung extends Leistung {
    /** Speichert, ob die Note bestanden hat, oder nicht. */
    private final boolean bestanden;

    /**
     * Konstruktor.
     * @param fachname
     * @param bestanden
     */
    public UnbenoteteLeistung(String fachname, boolean bestanden) {
        super(fachname);
        this.bestanden = bestanden;
    }

    /**
     * Überschreibt die Methode Leistung.istBestanden().
     * @return true, wenn die Note bestanden hat, sonst false.
     */
    @Override
    public boolean istBestanden() {
        return this.bestanden;
    }

    /**
     * Überschreibt die Methode Leistung.istBenotet().
     * @return immer false.
     */
    @Override
    public boolean istBenotet() {
        return false;
    }
}
