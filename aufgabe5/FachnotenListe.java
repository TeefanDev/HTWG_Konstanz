// FachnotenListe.java
package aufgabe5;

import java.util.NoSuchElementException;

/**
 * FachnotenListe verwaltet Fachnoten als Liste.
 * Übernommen aus dem Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author Stefan Ptacek
 * @version 22.12.2021
 */
public final class FachnotenListe {

    private Element head = null; // leere Liste

    /**
     * F&uuml;gt eine Fachnote am Listenanfang ein.
     * Der heimliche Paramter this verweist auf das Objekt des Aufrufs.
     * @param n die einzuf&uuml;gende Fachnote
     * @return die Liste
     */
    public FachnotenListe insert(/* final FachnotenListe this, */ Fachnote n) {
        this.head = new Element(this.head, n);
        return this;
    }

    /**
     * Element speichert eine einzelne Fachnote als Teil einer Liste.
     * Beipiel f&uuml;r eine statisch eingebettete Klasse.
     */
    private static final class Element {
        private final Element next;
        private final Fachnote n;

        private Element(/* final Element this, */ Element e, Fachnote n) {
            this.next = e;
            this.n = n;
        }
    }

    /**
     * Iterator speichert den aktuellen Zustand einer Listeniteration.
     * Beipiel f&uuml;r eine innere Klasse.
     */
    public final class Iterator {
        // private FachnotenListe FachnotenListe.this;
        private Element current = FachnotenListe.this.head;

        /**
         * pr&uuml;t, ob das Listenende erreicht ist.
         * Der heimliche Paramter this verweist auf das Objekt des Aufrufs.
         * @return false, wenn das Listenende erreicht ist, sonst true.
         */
        public boolean hasNext(/* final Iterator this */) {
            return this.current != null;
        }

        /**
         * liefert die aktuelle Fachnote und iteriert zum n&auml;chsten Jahr.
         * Aufruf am Listenende liefert NoSuchElementException.
         * Der heimliche Paramter this verweist auf das Objekt des Aufrufs.
         * @return die aktuelle Fachnote
         */
        public Fachnote next(/* final Iterator this */) {
            if (this.current == null) {
                throw new NoSuchElementException();
            }

            Element e = this.current;
            this.current = this.current.next;
            return e.n;
        }
    }
}
