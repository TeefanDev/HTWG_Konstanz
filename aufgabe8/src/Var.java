// Var.java

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 14.05.2022
 */
public class Var implements Expression {

    private final String varname;

    public Var(String s) {
        varname = s;
    }

    @Override
    public double eval(Map<String, Double> m) {
        return m.get(varname);
    }

    @Override
    public Set<String> getVars() {
        Set<String> vars = new TreeSet<>();
        vars.add(varname);
        return vars;
    }

    @Override
    public String toString() {
        return varname;
    }
}
