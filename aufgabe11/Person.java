package aufgabe11;

import java.time.LocalDate;
import java.util.*;

public class Person {
    private String vorname;
    private String nachname;
    private LocalDate gebdatum;

    public Person(String vorname, String nachname, LocalDate gebdatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.gebdatum = gebdatum;
    }

    public String getVorname() {
        return vorname;
    }
    public String getNachname() {
        return nachname;
    }
    public LocalDate getGebdatum() {
        return gebdatum;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    @SuppressWarnings("unused")
    public void setGebdatum(LocalDate gebdatum) {
        this.gebdatum = gebdatum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Vorname='" + vorname + '\'' +
                ", Nachname='" + nachname + '\'' +
                ", Geburtsdatum='" + gebdatum + '\'' +
                '}';
    }

    @FunctionalInterface
    interface Predicate {
        boolean test(int x);
    }
    public static boolean allOver18(List<Person> list, Predicate predicate) {
        for (Person p : list) {
            if (!predicate.test(p.getGebdatum().getYear())) {
                return false;
            }
        }
        return true;
    }
    // Hauptprogramm
    public static void main(String[] args) {
        List<Person> persList = new ArrayList<>();
        persList.add(new Person("Michael","Maier", LocalDate.of(2003,1,2)));
        persList.add(new Person("Alina","Schmidt", LocalDate.of(2007,8,29)));
        persList.add(new Person("Max","Mustermann   ", LocalDate.of(2005,2,3)));
        persList.add(new Person("Anna","Schmidt", LocalDate.of(1972,6,18)));
        persList.add(new Person("Anton","Beier", LocalDate.of(1998,9,21)));
        persList.add(new Person("Laura","Müller", LocalDate.of(2000,3,14)));
        persList.add(new Person("Michael","Wendler", LocalDate.of(1980,4,15)));
        persList.add(new Person("Alisa","Maier", LocalDate.of(1995,12,12)));

        // a)
        Predicate over18 = x -> LocalDate.now().getYear() - x >= 18;
        if (allOver18(persList, over18)) {
            System.out.println("Alle Personen sind volljährig!\n");
        } else {
            System.out.println("Es sind nicht alle Personen volljährig!\n");
        }
        // b)
        Comparator<Person> cmp = Comparator.comparing(p->p.getGebdatum().getYear());
        persList.sort(cmp);
        persList.forEach(System.out::println); // Test
        System.out.println();
        // c)
        persList.sort(cmp.reversed());
        persList.forEach(System.out::println); // Test
        System.out.println();
        // d)
        persList.stream()
                .sorted(cmp)
                .forEach(x -> System.out.println(x.getGebdatum()));
        System.out.println();
        // e)
        persList.stream()
                .sorted(cmp)
                .filter(x -> x.getVorname().startsWith("A"))
                .limit(3)
                .forEach(System.out::println);
    }
}


