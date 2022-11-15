package aufgabe6;

public class Buch {

    private final String titel;
    private Person entleiher;

    public Buch(String titel) {
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    public Person getEntleiher() {
        return entleiher;
    }

    public boolean wirdAusgeliehen(Person p) {
        if (entleiher != null) {
            return false;
        }
        entleiher = p;
        p.ausgelieheneBuecher.add(this);
        p.leihtAus(this);
        return true;
    }

    public boolean wirdZurueckGegeben() {
        if (entleiher == null) {
            return false;
        }
        getEntleiher().ausgelieheneBuecher.remove(this);
        Person p = entleiher;
        entleiher = null;
        p.gibtZurueck(this);
        return true;
    }

    public void print() {
        if (this.entleiher == null) {
            System.out.println("Buch{" + "Name='" + getTitel() + '\'' +
                               ", Entleiher='not available" + '\'' + '}');
        }
        else {
            System.out.println("Buch{" + "Name='" + getTitel() + '\'' +
                               ", Entleiher='" + entleiher.getName() + '\'' + '}');
        }
    }
}
