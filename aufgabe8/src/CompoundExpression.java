// CompoundExpressionjava

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 14052022
 */
public abstract class CompoundExpression implements Expression {

    protected Expression e1;
    protected Expression e2;

    public CompoundExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public Set<String> getVars() {
       Set<String> vars = new TreeSet<>();
       vars.addAll(this.e1.getVars());
       vars.addAll(this.e2.getVars());
       return vars;
    }
}
