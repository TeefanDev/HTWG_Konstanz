// IntVar.java

package aufgabe1.bonus;

import java.util.Scanner;

//import einstieg.Einstieg;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Stefan
 * @version 19.10.2021
 */
public final class ShortVar {
    private ShortVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * MIN: minimale int Variable.
     */
    public static final short MIN = -0x8000;
    /**
     * MAX: maximale int Variable.
     */
    public static final short MAX = 0x7FFF;

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        short max = 0;
        short min = 0;
        System.out.println("Zwei ganze Zahlen zwischen "
            + MIN + " und " + MAX + " eingeben:");
        min = EINGABE.nextShort();
        max = EINGABE.nextShort();
        System.out.println(min + ", Otalzahl: " + Integer.toOctalString(min)
            + ", Hexadezimalzahl: " + Integer.toHexString(min));
        System.out.println(max + ", Otalzahl: " + Integer.toOctalString(max)
            + ", Hex-zahl: " + Integer.toHexString(max));
        System.out.println(min + " + " + max + " ist " + (min + max));
        System.out.println(min + " - " + max + " ist " + (min - max));
        System.out.println(min + " * " + max + " ist " + (min * max));
        System.out.println(min + " / " + max + " ist " + (min / max));
        System.out.println(min + " % " + max + " ist " + (min % max));
        System.out.println(min + " == " + max + " ist " + (min == max));
        System.out.println(min + " != " + max + " ist " + (min != max));
        System.out.println(min + " < " + max + " ist " + (min < max));
        System.out.println(min + " <= " + max + " ist " + (min <= max));
        System.out.println(min + " > " + max + " ist " + (min > max));
        System.out.println(min + " >= " + max + " ist " + (min >= max));
    }
}

