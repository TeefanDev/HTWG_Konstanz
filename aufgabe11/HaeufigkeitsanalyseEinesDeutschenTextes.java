package aufgabe11;

/* Wortweises Einlesen eines deutschen Textes von einer Datei.
 * Ermittlung der Haefigkeiten der Woerter und Ausgabe der  
 * 100 haeufigsten Woerter.
 *
 * Oliver Bittel; 10.03.2019
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;

public class HaeufigkeitsanalyseEinesDeutschenTextes {
	
	public static void main(String[] args) throws IOException {
		Map<String,Integer> haeufigkeit = ermittleHaufigekeiten("Kafka_Der_Prozess.txt");
		printTop100(haeufigkeit);
	}
	
	public static Map<String,Integer> ermittleHaufigekeiten(String fileName) throws IOException {
		
		LineNumberReader in = new LineNumberReader(new FileReader(fileName));
		String line;
		
		Map<String,Integer> haeufigkeit = new TreeMap<>(); 	// enthaelt zu jedem Wort seine Haefigkeit
				
		while ((line = in.readLine()) != null) {
			String[] wf = line.split("[^a-z^A-ZßäöüÄÖÜ]+");
			for (String w: wf) {
				if (w.length() == 0 || w.length() == 1) 
					continue;
				// System.out.println(w);
				// Ihr Code:
				if (!haeufigkeit.containsKey(w)) {
					haeufigkeit.put(w, 1);
				} else {
					int z = haeufigkeit.get(w);
					haeufigkeit.put(w, ++z);
				}
			}
		}

		return haeufigkeit;
	}
	
	public static void printTop100(Map<String,Integer> h) {
		// Ihr Code:
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(h.entrySet());
		entries.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(100)
				.forEach(System.out::println);
	}
}