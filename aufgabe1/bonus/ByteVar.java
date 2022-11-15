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
public final class ByteVar {
    private ByteVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * MIN: minimale int Variable.
     */
    public static final byte MIN = -0x80;
    /**
     * MAX: maximale int Variable.
     */
    public static final byte MAX = 0x7F;

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        byte max = 0;
        byte min = 0;
        System.out.println("Zwei ganze Zahlen zwischen "
            + MIN + " und " + MAX + " eingeben:");
        min = EINGABE.nextByte();
        max = EINGABE.nextByte();
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

