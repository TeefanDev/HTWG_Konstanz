// Notenstatistik.java
package aufgabe3;

import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException; 
import java.util.NoSuchElementException;
/**
 * @author Stefan Ptacek
 * @version 16.11.2021
 */
public final class Notenstatistik {
    private Notenstatistik() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");
        int anzahlNoten = 0;
        double bestandenSumme = 0;
        int bestandenAnz = 0;
        int durchgefallenAnz = 0;
        double besteNote = 5.0;
        double schlechtesteNote = 0;
        double noten = 0.0;
        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            //Double toDouble = Double.valueOf(note);
            //---------------------------------------------- Eingabe pruefen
            try {
                if (note.matches("\\d*\\.\\d") || note.matches("\\d*\\,\\d")) {
                    String ausgabeNote = note;
                    note = note.replace(',','.');
                    //System.out.println("Note: " + note);
                    noten = Double.parseDouble(note);
                    //System.out.println("Noten: " + noten);
                    double nachkommatest = noten % 1;
                    nachkommatest = Math.round(10.0 * nachkommatest) / 10.0;
                    int vorkommatest = (int)noten;
                    //System.out.println("Nachkommatest: " + nachkommatest);
                    //System.out.println("Note: " + note);
                    if (vorkommatest < 1 || vorkommatest > 5) {
                        throw new Exception("Note " + ausgabeNote + " wird wegen Vorkommastelle " + vorkommatest + " ignoriert!");
                    }
                    if (nachkommatest != 0.0 && nachkommatest != 0.3 && nachkommatest != 0.7 && vorkommatest < 6 || noten == 4.3 || noten == 4.7 || noten == 5.3 || noten == 5.7) {
                        throw new Exception("Note " + ausgabeNote + " wird wegen Nachkommastelle " + (int)(nachkommatest*10) + " ignoriert!");
                    }
                } else {
                    throw new Exception("Note " + note + " wird wegen Formatfehler ignoriert!");
                }
                switch (note) {
                case "1,0":
                case "1.0":
                    noten = 1.0;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "1,3":
                case "1.3":
                    noten = 1.3;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "1,7":
                case "1.7":
                    noten = 1.7;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "2,0":
                case "2.0":
                    noten = 2.0;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "2,3":
                case "2.3":
                    noten = 2.3;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "2,7":
                case "2.7":
                    noten = 2.7;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "3,0":
                case "3.0":
                    noten = 3.0;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "3,3":
                case "3.3":
                    noten = 3.3;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "3,7":
                case "3.7":
                    noten = 3.7;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "4,0":
                case "4.0":
                    noten = 4.0;
                    bestandenSumme += noten;
                    bestandenAnz = bestandenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                case "5,0":
                case "5.0":
                    noten = 5.0;
                    durchgefallenAnz = durchgefallenAnz + 1;
                    anzahlNoten = anzahlNoten + 1;
                    break;
                default:
                    //System.out.println("WHY?");
                    break;
                }
            //------------------------------------------------ Note erfassen
                if (noten < besteNote && noten >= 1.0) {
                    besteNote = noten;
                }
                if (noten > schlechtesteNote) {
                    schlechtesteNote = noten;
                }
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
        } // while
        //------------------------------------------ Notenstatistik ausgeben
        double durchschnitt = (((bestandenSumme / bestandenAnz) * 100) / 100);
        double durchfallquote = 0.0;
        if (durchgefallenAnz > 0) {
            durchfallquote = ((100 / (double)anzahlNoten) * (double)durchgefallenAnz);
        }
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