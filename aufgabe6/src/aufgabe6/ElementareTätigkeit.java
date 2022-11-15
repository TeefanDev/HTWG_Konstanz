package aufgabe6;

/**
 *
 * @author Julian Klimek
 * @since 02.05.2022
 */

public class ElementareTätigkeit implements Tätigkeit {

    @SuppressWarnings("all")
    private final String beschr;
    private final double time;

    public ElementareTätigkeit(String beschr, double time) {
        this.beschr = beschr;
        this.time = time;
    }

    @Override
    public double getTime() {
        return time;
    }
    @Override
    public int getAnzahl() {
        return 1;
    }

    @Override
    public void add(Tätigkeit tk) { }

    @Override
    public void remove(Tätigkeit tk) { }
}
