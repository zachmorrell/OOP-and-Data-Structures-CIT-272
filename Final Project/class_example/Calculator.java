package class_example;

public class Calculator {
    public boolean isValidOperator(String expr) {
        // Return if the operator is valid.
        return false;
    }
    public boolean isValidExpression(String expr) {
        // Return the valid expression if true or false.
        return false;
    }

    private int priority(String s) {
        if (s.equals("+") || s.equals("-")) {return 0;}
        else if(s.equals("*") || s.equals("/")) { return 1;}
        return 2;
    }

    public double evaluate(String expr) {
        // Build the expression tree, return the root enode
        // Return the value of the root ENode.
        return 0.0;
    }

    // Uses recursion to return the root Enode of an expression.
    private ENode buildExpressionTree(String expr) {
        String[] expr_array = expr.split(" ");
        //shunting yeard

        // Loop through the expression.
        for(int i = 0; i < expr.length(); i++) {
            if(isValidOperator(expr_array[i])) {
                
            }
        }



        return null;
    }
}