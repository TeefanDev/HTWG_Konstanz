// IntVar.java

package aufgabe1.bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

//import einstieg.Einstieg;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Stefan
 * @version 19.10.2021
 */
public final class IntBonusVar {
    private IntBonusVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * MIN: minimale int Variable.
     */
    public static final int MIN = 0x80000000;
    /**
     * MAX: maximale int Variable.
     */
    public static final int MAX = 0x7FFFFFFF;

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        BufferedReader buf = new BufferedReader (new InputStreamReader(System.in));
        try {
            String inp = "";
            do {
                handleInput();
                System.out.printf(
                    "%nWenn Sie erneut eine Eingabe tätigen wollen, drücken Sie die 'y'-Taste und bestätigen Sie mit der 'Enter'-Taste."
                );
                inp = buf.readLine();
                inp = inp.trim().toLowerCase();
            } while (inp.equals("y"));

        } catch (CancellationException | NoSuchElementException e) {
            System.out.println("Programm wurde vom User beendet.");
        } catch (IOException e) {
            System.out.println("Programm wurde unerwartet beendet.");
        }
    }
    public static void handleInput() {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        System.out.println(
            "Sie können das Program jederzeit mit 'exit' als Eingabe beenden oder mit 'Strg' + 'D' auf Unix und 'Strg' + 'F' auf Windows!");
        /* Eingabeaufforderung ausgeben */
        System.out.printf("Zwei ganze Zahlen zwischen %s und %s eingeben%n",
            max, min);

        /* zwei ganze Zahlen einlesen */
        long firstInt = getNextNumber();
        long secondInt = getNextNumber();

        evalResult(firstInt, secondInt);
    }
    public static long getNextNumber() {
        String input = "";
        while (!EINGABE.hasNextLong()) {
            input = EINGABE.nextLine().toLowerCase().trim();
            if (input.equals("exit")) {
                throw new CancellationException("Abbruch vom User");
            }
            System.out.println("Bitte geben Sie eine Zahl ein");
        }
        return EINGABE.nextLong();
    }

    public static void evalResult(long firstInt, Long secondInt)
    {
        //int max = 0;
        //int min = 0;
        System.out.println("Zwei ganze Zahlen zwischen "
            + MIN + " und " + MAX + " eingeben:");
        //min = EINGABE.nextInt();
        //max = EINGABE.nextInt();
        boolean isRun = true;
        String input = "";
        while (isRun) {
            input = EINGABE.next();
            input = input.trim().toLowerCase();
            if (input.equals("exit")) {
                throw new CancellationException("Abbruch vom User");
            }
            long result = Long.MAX_VALUE;

            boolean isArithmetischen = false;
            boolean isVergleichsoperator = false;

            switch (input) {
                case "basis":
                    /* die beiden Zahlen dezimal, okatal und hexadezimal ausgeben */
                    String st = "%s ist in Oktal %o und in Hexadezimal %x%n";
                    System.out.printf(st,
                        firstInt, firstInt, firstInt);
                    System.out.printf(st,
                        secondInt, secondInt, secondInt);
                    break;
                case "+":
                    result = firstInt + secondInt;
                    isArithmetischen = true;
                    break;
                case "-":
                    result = firstInt - secondInt;
                    isArithmetischen = true;
                    break;
                case "*":
                    result = firstInt * secondInt;
                    isArithmetischen = true;
                    break;
                case "/":
                    result = firstInt / secondInt;
                    isArithmetischen = true;
                    break;
                case "%":
                    result = firstInt % secondInt;
                    isArithmetischen = true;
                    break;
                /* alle Vergleichsoperatoren ausprobieren */
                case "==":
                    result = firstInt == secondInt ? 1 : 0;
                    isVergleichsoperator = true;
                    break;
                case "!":
                    result = firstInt != secondInt ? 1 : 0;
                    isVergleichsoperator = true;
                    break;
                case ">":
                    result = firstInt > secondInt ? 1 : 0;
                    isVergleichsoperator = true;
                    break;
                case ">=":
                    result = firstInt >= secondInt ? 1 : 0;
                    isVergleichsoperator = true;
                    break;
                case "<":
                    result = firstInt < secondInt ? 1 : 0;
                    isVergleichsoperator = true;
                    break;
                case "<=":
                    result  = firstInt <= secondInt ? 1 : 0;
                    isVergleichsoperator = true;
                    break;
                default:
                    break;
            }
            if (!isArithmetischen && !isVergleichsoperator) {
                System.out.println("Ungültige eingabe!");
            } else if (result > Integer.MAX_VALUE
                || result < Integer.MIN_VALUE) {
                System.out.print(("Das Ergebniss ist zu groß um es als 32Bit-Integer anzeigen zu lassen!"));
            } else {
                System.out.printf("%s %s %s ist ",
                    firstInt, input, secondInt);
                if (isVergleichsoperator){
                    System.out.printf("%b %n", result);
                }
                else {
                    System.out.printf("%s %n", result);
                }
                isRun = false;
            }
        }
    }
}

/**
 * System.out.println(min + ", Otalzahl: " + Integer.toOctalString(min)
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
 */