package aufgabe6;

/**
 *
 * @author Julian Klimek
 * @since 02.05.2022
 */

public class ParalleleTätigkeit extends ZusammengesetzteTätigkeit {

    private double maxtime;

    @Override
    public double getTime() {
        for (Tätigkeit x : meineTätigkeiten) {
            if (x.getTime() > maxtime) {
                maxtime = x.getTime();
            }
        }
        return maxtime;
    }
}
