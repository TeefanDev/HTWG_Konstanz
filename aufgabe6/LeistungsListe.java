// LeistungsListe.java
package aufgabe6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LeistungsListe kapselt eine Liste von Leistungen.
 * @author Stefan Ptacek
 * @version 17.01.2022
 */
public final class LeistungsListe implements Iterable<Leistung> {
    private Element head = null; // leere Liste

    /**
     * Fügt eine Zahl am Listenanfang ein.
     * @param n die einzuf&uuml;gende Zahl
     * @return die Liste
     */
    public LeistungsListe insert(Leistung n) {
        this.head = new Element(this.head, n);
        return this;
    }

    /**
     * Element speichert eine einzelne Zahl als Teil einer Liste.
     * Beipiel f&uuml;r eine statisch eingebettete Klasse.
     */
    private static final class Element {
        private final Element next;
        private final Leistung n;

        private Element(Element e, Leistung n) {
            this.next = e;
            this.n = n;
        }
    }

    /**
     * Implementation für Iterator<Leistung>.
     * @return einen Iterator<Leistung>.
     */
    @Override
    public Iterator<Leistung> iterator() {
        // Beispiel für eine anonyme lokale Klasse
        return new Iterator<Leistung>() {
            private Element current = LeistungsListe.this.head;

            /**
             * Prüft, ob die Liste ein weiteres Element besitzt.
             * @return true, wenn es ein weiteres Element gibt, sonst false.
             */
            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            /**
             * Gibt das nächste Element der Liste zurück.
             * @return ein Objekt der Klasse Leistung.
             */
            @Override
            public Leistung next() {
                if (this.current == null) {
                    throw new NoSuchElementException();
                }

                Element e = this.current;
                this.current = this.current.next;
                return e.n;
            }

            /**
             * Entfernt ein Element der Liste.
             * @throw UnsupportedOperationExeption weil es veraltet ist.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

