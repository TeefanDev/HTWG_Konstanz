// Histogramm.java
package aufgabe2;

import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author Stefan Ptacek
 * @version 02.11.2021
 */
public final class Histogramm {
    private Histogramm() { }
    private static final Scanner EINGABE = new Scanner(System.in);
    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        int[] zaehler = new int[] {0, 0, 0, 0, 0, 0};
        final int six = 6;
        //---------------------------------------------------- Zahlen einlesen
        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D/Strg-Z):");

        while (EINGABE.hasNextInt()) {
            int number = EINGABE.nextInt();
            if (number < 1 || number > six) {
                System.out.println("Falsche eingabe wird ignoriert: " + number);
            } else {
                ++zaehler[number - 1];
            }
        }
        //------------------------------------------------ Histogramm ausgeben
        System.out.println("Histogramm:");
        int count = 0;
        for (int i = 0; i < zaehler.length; ++i) {
            count = 0;
            for (int j = 0; j < zaehler[i]; j++) {
                count++;
                if(count < 5) {
                    System.out.print(i + 1);
                }
                else {
                    System.out.print("$");
                    count = 0;
                }
            }
            System.out.println(" (" + zaehler[i] + ")");
        }
    }
}

