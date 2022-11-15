// Notenspiegel.java
package aufgabe5;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Notenspiegel liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Noten
 * in eine verkettete Liste ein und gibt dann einen Notenspiegel aus.
 * @author Stefan Ptacek
 * @version 05.01.2021
 */
public final class Notenspiegel {
    private Notenspiegel() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        FachnotenListe liste = new FachnotenListe(); // leere Liste

        //--------------------------------------------- Notenspiegel einlesen
        System.err.printf(
            "Faecher mit Noten zwischen %d und %d eingeben "
            + "(Ende mit Strg-D):%n",
            Note.BESTE.intValue(), Note.SCHLECHTESTE.intValue());

        while (EINGABE.hasNext()) {
            try {
                //------------------------------------ Fach und Note einlesen
                String fach = EINGABE.next();

                Note note;
                if (EINGABE.hasNextInt()) {
                    note = Note.valueOf(EINGABE.nextInt());
                } else {
                    note = Note.valueOf(EINGABE.next());
                }

                //--------------------- neue Fachnote in Notenliste eintragen
                liste.insert(new Fachnote(fach, note));

            } catch (IllegalArgumentException x) {
                System.err.printf("Eingabefehler: %s%n", x.getMessage());
                continue;
            } catch (NoSuchElementException x) {
                System.err.println("Fach ohne Note ignoriert!");
                break;
            }
        }

        //--------------------------------------------- Notenspiegel ausgeben

        String nameErste = "";
        FachnotenListe.Iterator iter = liste.new Iterator();

        while (iter.hasNext()) {
            String name = iter.next().fach;
            if (name.length() > nameErste.length()) {
                nameErste = name;
            }
        }

        FachnotenListe.Iterator iter2 = liste.new Iterator();

        System.out.println("NOTENSPIEGEL");

        while (iter2.hasNext()) {
            Fachnote element = iter2.next();
            String fach = element.fach;
            Note note = element.note;

            int lange = nameErste.length() - fach.length();
            // Fach Ausgeben
            System.out.printf("%s", fach);
            for (int i = 0; i < lange; i++) {
                System.out.printf(" ");
            }
            System.out.printf("    ");

            // Note Ausgeben
            System.out.printf("%s    ", note.toString());

            // Status check "mit Bestnote bestanden"
            // oder "nicht bestanden" oder "bestanden"
            String status = "";
            if (note.equals(note.BESTE)) {
                status = "mit Bestnote bestanden";
            } else if (note.istBestanden()) {
                status = "bestanden";
            } else {
                status = "nicht bestanden";
            }

            // Bestanden/Nicht Bestanden/bestnote
            System.out.printf("%s%n", status);
        }

    }
}

