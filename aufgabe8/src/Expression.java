// Expression.java

import java.util.Map;
import java.util.Set;

/**
 * Aufgabe 8 Bäume
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 14.05.2022
 */
public interface Expression {

    double eval(Map<String,Double> m);
    Set<String> getVars();
    @Override
    String toString();
}
