// Constant.java

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 14.05.2022
 */
public class Constant implements Expression {

    private double constant;

    public Constant(double value) {
        this.constant = value;
    }

    @Override
    public double eval(Map<String, Double> m) {
        return this.constant;
    }

    @Override
    public Set<String> getVars() {
        return new TreeSet<>();
    }

    @Override
    public String toString() {
        return String.valueOf(constant);
    }
}
