// Difference.java

import java.util.Map;

/**
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 14.05.2022
 */
public class Difference extends CompoundExpression {

    public Difference(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public double eval(Map<String, Double> m) {
        return e1.eval(m) - e2.eval(m);
    }

    @Override
    public String toString() {
        return "(" + this.e1 + "-" + this.e2 + ")";
    }
}
