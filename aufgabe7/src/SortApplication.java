// SortApplication.java

import java.util.Random;
import java.util.Arrays;
import java.io.*;

/**
 * Aufgabe 7 Generische Sortiermethoden
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 05.05.2022
 */

public class SortApplication {

    public static void main(String[] args) throws IOException{
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        Integer[] numbers = new Integer[100];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt();
        }
        //HybridSort.quicksort(numbers);
        HybridSort3Median.quicksort(numbers);
        //Arrays.sort(numbers);

        System.out.println();
        System.out.println(Arrays.toString(numbers));
        System.out.println(isSorted(numbers));
        System.out.println("--------------------------------------------------------------------------------");
    }

    private static void test2() {
        Integer[] numbers = new Integer[200];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * numbers.length);
        }

        //HybridSort.quicksort(numbers);
        HybridSort3Median.quicksort(numbers);
        //Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println(isSorted(numbers));
        System.out.println("--------------------------------------------------------------------------------");
    }

    private static void test3() throws FileNotFoundException, IOException {
        System.out.println("Test 3: zu lange ausgabe.");
        LineNumberReader in;
        in = new LineNumberReader(new FileReader("Kafka_Der_Prozess.txt"));
        String line;
        // Text einlesen und Wörter speichern
        while ((line = in.readLine()) != null) {
            String[] words = line.split("[^a-zA-ZßäöüÄÖÜ]+");
            //HybridSort.quicksort(words);
            HybridSort3Median.quicksort(words);
            Arrays.sort(words);
            System.out.println(Arrays.toString(words)); // sehr lange Ausgabe
        }
        in.close();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void test4() {
        int size = 200000;
        Card[] cards = new Card[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            if (rand.nextInt() % 2 == 0) {
                RedCard c = new RedCard();
                cards[i] = c;
            } else {
                BlackCard c = new BlackCard();
                cards[i] = c;
            }
        }
        HybridSort.quicksort(cards);
        // Sortiermethode aufrufen und Laufzeit messen
        long start = System.nanoTime(); // aktuelle Zeit in nsec
        //HybridSort3Median.quicksort(cards);
        Arrays.sort(cards);
        long end = System.nanoTime();

        double elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec
        //System.out.println(Arrays.toString(cards)); // sehr lange Ausgabe
        System.out.println("Benötigte Zeit in msec: " + elapsedTime);
        System.out.println();
    }

    // Methode zum Testen, ob test1() und test2() funktioniert
    private static boolean isSorted(Integer[] a) {
        for (int i = 0; i < a.length-1; i++)
            if (a[i+1] < a[i])
                return false;
        return true;
    }
}
