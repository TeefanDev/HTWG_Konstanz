package aufgabe6;

/**
 *
 * @author Julian Klimek
 * @since 02.05.2022
 */

public interface Tätigkeit {

    double getTime();

    int getAnzahl();

    void add(Tätigkeit tk);

    void remove(Tätigkeit tk);
}
