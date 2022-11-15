package aufgabe6;

/**
 *
 * @author Julian Klimek
 * @since 02.05.2022
 */

public class SerielleTätigkeit extends ZusammengesetzteTätigkeit {

    private double time;

    @Override
    public double getTime() {
        for (var x : meineTätigkeiten) {
            time += x.getTime();
        }
        return time;
    }
}
