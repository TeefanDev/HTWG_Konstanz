package aufgabe6;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    public List<Buch> ausgelieheneBuecher = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Buch> getAusgelieheneBuecher() {
        return ausgelieheneBuecher;
    }

    public boolean leihtAus(Buch b) {
        if (ausgelieheneBuecher.contains(b)) {
            return false;
        }
        if (b.getEntleiher() != null) {
            return false;
        }
        //ausgelieheneBuecher.add(b);
        b.wirdAusgeliehen(this);
        return true;
    }

    public boolean gibtZurueck(Buch b) {
        if (!ausgelieheneBuecher.contains(b)) {
            return false;
        }
        //ausgelieheneBuecher.remove(b);
        b.wirdZurueckGegeben();
        return true;
    }

    public void print() {
        StringBuilder titel = new StringBuilder();
        int count = 0;
        //System.out.println("Einsprung in print");
        //Denn Ausgeliehene Buecher gibt hier höchstens 1 oder keines
        for(Buch x: ausgelieheneBuecher) {
            //System.out.println("Count: " + count);
            //if(x.getEntleiher() != null) {
            //    System.out.println("Count: " + count);
            if(count > 0) {
                titel.append(", " + x.getTitel());
                count++;
            } else {
                titel.append(x.getTitel());
                count++;
            }
            //}
        }
        if(titel.length() == 0) {
            titel.append("keines");
        }
        System.out.println("Person{" + "Name='" + getName() + '\'' +
                           ", Ausgeliehene Buecher=" + titel + '}');
    }
}
