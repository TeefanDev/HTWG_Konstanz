// BinaryTree.java

import java.util.Stack;

/**
 *
 * @author Julian Klimek & Stefan Ptacek
 * @version 14.05.2022
 */
public class BinaryTree {

    protected Node root;

    // Data structure to store a binary tree node
    static class Node
    {
        char data;
        Node left;
        Node right;
        Node root;

        Node(char data)
        {
            this.data = data;
            this.left = this.right = null;
        }

        Node(char data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Function to construct an expression tree from the given postfix expression
    public static Node construct(String postfix)
    {
        // base case
        if (postfix == null || postfix.length() == 0) {
            return null;
        }

        // create an empty stack to store tree pointers
        Stack<Node> s = new Stack<>();

        // traverse the postfix expression
        for (char c: postfix.toCharArray())
        {
            // if the current token is an operator
            if (isOperator(c))
            {
                // pop two nodes `x` and `y` from the stack
                Node x = s.pop();
                Node y = s.pop();

                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively
                Node node = new Node(c, y, x);

                // push the current node into the stack
                s.add(node);
            }
            // if the current token is an operand, create a new binary tree node
            // whose root is the operand and push it into the stack
            else {
                s.add(new Node(c));
            }
        }

        // a pointer to the root of the expression tree remains on the stack
        return s.peek();
    }

    // Function to check if a given token is an operator
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Print the postfix expression for an expression tree
    public static void postorder(Node root)
    {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }

    // Print the infix expression for an expression tree
    public static void inOrder(Node root)
    {
        if (root == null) {
            return;
        }

        // if the current token is an operator, print open parenthesis
        if (isOperator(root.data)) {
            System.out.print("(");
        }

        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);

        // if the current token is an operator, print close parenthesis
        if (isOperator(root.data)) {
            System.out.print(")");
        }
    }
}
