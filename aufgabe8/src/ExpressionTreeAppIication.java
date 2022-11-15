// Java program to evaluate expression tree
import java.lang.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExpressionTreeAppIication {

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (this.root != null)
            sb.append(this.root.data).append(" ");
        else {
            // Kindknoten ausgeben
            sb.append("(");
            this.root.left.toString();
            sb.append(this.root.data).append(" ");;
            this.root.right.toString();
            sb.append(")");
        }
        return String.valueOf(sb);
    }

    Node root;

    // Class to represent the nodes of syntax tree
    public static class Node
    {
        String data;
        Node left, right;

        Node(String d)
        {
            data = d;
            left = null;
            right = null;
        }

        public Set<String> getVars(Node root) {
            Set<String> stringSet = new HashSet<>();
            if(root != null) {
                getVars(root.left);
                if(root.data.matches("[a-zA-Z]*") == true) {
                    stringSet.add(root.data);
                }
                getVars(root.right);
            }
            return stringSet;
        }
    }

    private static double toDouble(String s)
    {
        return Double.parseDouble(s);
    }

    // This function receives a node of the syntax
    // tree and recursively evaluate it

    public static double evalTree(Node root)
    {

        // Empty tree
        if (root == null)
            return 0;

        // Leaf node i.e, an integer
        if (root.left == null && root.right == null)
            return toDouble(root.data);

        // Evaluate left subtree
        double leftEval = evalTree(root.left);

        // Evaluate right subtree
        double rightEval = evalTree(root.right);

        // Check which operator to apply
        if (root.data.equals("+"))
            return leftEval + rightEval;

        if (root.data.equals("-"))
            return leftEval - rightEval;

        if (root.data.equals("*"))
            return leftEval * rightEval;

        return leftEval / rightEval;
    }

    // Driver code
    public static void main(String[] args)
    {
        final String n = "n";
        final String a = "a";
        final String b = "b";
        final String c = "c";

        final double one = 1.0;
        final double two = 2.0;
        final double three = 3.0;

        Map<String, Double> varBel = new TreeMap<>();
        varBel.put("a", 3.0);
        varBel.put("b", 4.0);
        varBel.put("c", 8.0);
        varBel.put("n", 10.0);

        // Creating a sample tree
        System.out.println("Expression 1:");
        Node root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node(String.valueOf(varBel.get("a")));
        root.left.right = new Node(String.valueOf(varBel.get("a")));
        root.right = new Node("*");
        root.right.left = new Node(String.valueOf(varBel.get("b")));
        root.right.right = new Node(String.valueOf(varBel.get("b")));
        System.out.println(evalTree(root));
        // Alle Variablen in e1:
        System.out.println("[a, b]");	// [a, b]
        // e1 und e2 ausgeben (ueberschriebene toString-Methode):
        System.out.println("((a * a) + (b * b))");		// ((a * a) + (b * b))

        root = null;

        // Creating a sample tree
        System.out.println("Expression 2:");
        root = new Node("/");
        root.left = new Node("*");
        root.left.left = new Node(String.valueOf(varBel.get("n")));
        root.left.right = new Node("+");
        root.left.right.left = new Node(String.valueOf(varBel.get("n")));
        root.left.right.right = new Node(String.valueOf(one));
        root.right = new Node(String.valueOf(two));
        System.out.println(evalTree(root));

        System.out.println("[n]");	// [n]
        System.out.println("((n * (n + 1.0)) / 2.0)");		// ((n * (n + 1.0)) / 2.0)

        root = null;

        // Creating a sample tree
        System.out.println("Expression 3:");
        root = new Node("/");
        root.left = new Node("+");
        root.left.left = new Node(String.valueOf(varBel.get("a")));
        root.left.right = new Node("+");
        root.left.right.left = new Node(String.valueOf(varBel.get("b")));
        root.left.right.right = new Node(String.valueOf(varBel.get("c")));
        root.right = new Node(String.valueOf(three));
        System.out.println(evalTree(root));

        System.out.println("[a, b, c]");	// [a, b, c]
        System.out.println("(((a + b) + c) / 3.0)");		// (((a + b) + c) / 3.0)

        root = null;

        // Creating a sample tree
        System.out.println("Expression 4:");
        root = new Node("+");
        root.left = new Node(String.valueOf(varBel.get("a")));
        root.right = new Node("+");
        root.right.left = new Node(String.valueOf(varBel.get("b")));
        root.right.right = new Node(String.valueOf(varBel.get("c")));
        System.out.println(evalTree(root));

        System.out.println("[a, b, c]");	// [a, b, c]
        System.out.println("(a+(b+c))");

        // Pruefe, ob alle Variablen in e1 belegt sind:
        System.out.println(varBel.keySet().containsAll(root.getVars(root)));	// true
    }
}