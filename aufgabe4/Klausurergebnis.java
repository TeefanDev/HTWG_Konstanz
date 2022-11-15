// Klausurergebnis.java
package aufgabe4;
//import aufgabe4.schweiz.Noten;
import java.util.Locale;
import java.util.Scanner;

/**
 * Klausurergebnis erstellt eine Notenstatistik.
 * <p>
 * Das Programm liest Noten als Strings ein und bestimmt die beste und
 * die schlechteste Note, den Durchschnitt der Bestandenen sowie
 * die Durchfallquote in Prozent.
 * Das Programm ber&uuml;cksichtigt dabei nur die laut Noten.istZulaessig
 * erlaubten Noten. Andere Noten werden unter Ausgabe einer Warnung ignoriert.
 * Welche Noten besser und schlechter sind, welche als bestanden oder
 * durchgefallen gelten und wie die String-Darstellung der Noten aussieht,
 * wird mit Methoden der Klasse Noten bestimmt.
 * </p>
 * Das Programm gibt als Klausurergebnis folgende Werte aus:
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote</li>
 * </ul>
 *
 * @author Stefan Ptacek
 * @version 30.11.2021
 */
public final class Klausurergebnis {
    private Klausurergebnis() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);
        int anzahlNoten = 0;
        double bestandenSumme = 0.0;
        int bestandenAnz = 0;
        int durchgefallenAnz = 0;
        double besteNote = 5.0;
        double schlechtesteNote = 0;
        double noten = 0.0;
        double durchschnitt = 0.0;

        //Noten Noten = new Noten();
        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");
        while (EINGABE.hasNext()) {
            String note = EINGABE.next();

            //---------------------------------------------- Eingabe pruefen
            try {
                String ausgabeNote = note;
                boolean test = Noten.istZulaessig(note);
                if (!test) {
                    throw new Exception("Unzulaessige Note "
                        + ausgabeNote + " wird ignoriert!");
                } else {
                    if (Noten.istBestanden(Noten.toDouble(note))
                        && Noten.toDouble(note) >= 1.0
                            && Noten.toDouble(note) <= 4.0) {
                        bestandenAnz = bestandenAnz + 1;
                        bestandenSumme = bestandenSumme + Noten.toDouble(note);
                        anzahlNoten = anzahlNoten + 1;
                    }

                    if (Noten.toDouble(note) > 4.0
                        && Noten.toDouble(note) <= 5.0) {
                        durchgefallenAnz = durchgefallenAnz + 1;
                        anzahlNoten = anzahlNoten + 1;
                    }

                    if (Noten.toDouble(note) >= 1.0
                        && Noten.toDouble(note) <= 5.0) {
                        besteNote =
                            Noten.bessere(Noten.toDouble(note), besteNote);
                        schlechtesteNote =
                            Noten.schlechtere(Noten.toDouble(note),
                                schlechtesteNote);
                    } else {
                        throw new Exception("Unzulaessige Note "
                            + ausgabeNote + " wird ignoriert!");
                    }
                }
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
            //------------------------------------------------ Note erfassen
        } // while
        //------------------------------------------ Notenstatistik ausgeben
        durchschnitt = (((bestandenSumme / bestandenAnz) * 100) / 100);
        double durchfallquote = 0.0;
        if (durchgefallenAnz > 0) {
            durchfallquote = ((100 / (double) anzahlNoten)
                * (double) durchgefallenAnz);
        }
        System.out.println("");
        System.out.println("Anzahl beruecksichtigter Noten: " + anzahlNoten);
        System.out.println("Anzahl Bestandene: " + bestandenAnz);
        if (anzahlNoten != 0) {
            System.out.printf("Beste Note: %.1f%n", besteNote);
            System.out.printf("Schlechteste Note: %.1f%n", schlechtesteNote);
            System.out.printf("Durchschnitt Bestandene: %.1f%n", durchschnitt);
            System.out.printf("Durchfallquote: %.1f%s%n", durchfallquote, "%");
        }
    } // main
}
