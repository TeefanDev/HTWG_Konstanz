package aufgabe6;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Julian Klimek
 * @since 02.05.2022
 */

public abstract class ZusammengesetzteTätigkeit implements Tätigkeit {
    protected List<Tätigkeit> meineTätigkeiten = new LinkedList<>();

    private double total_time = 0.0;
    private int count = 0;

    @Override
    public double getTime() {
        for (Tätigkeit t : meineTätigkeiten) {
            total_time  += t.getTime();
        }
        return total_time;
    }

    @Override
    public int getAnzahl() {
        for (Tätigkeit t : meineTätigkeiten) {
            count += t.getAnzahl();
        }
        return count;
    }

    @Override
    public void add(Tätigkeit tk) {
        meineTätigkeiten.add(tk);
    }

    @Override
    public void remove(Tätigkeit tk) {
        meineTätigkeiten.remove(tk);
    }
}
