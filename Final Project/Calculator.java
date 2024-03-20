import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isOperator(String s) {
        ArrayList<String> operators = new ArrayList<>(Arrays.asList("^","*","/","+","-"));
        return operators.contains(s);
    }

    public boolean valid_period(String s) {
        for(int i = s.length()-1; i > 0; i--) {
            if(s.charAt(i) == ' ') { break; }
            if (s.charAt(i) == '.') { return false; }
        }
        return true;
    }

    public boolean isValidExpression(String[] expression) {
        if(expression.length % 2 == 0) {
            return false;
        }
        for(int i = 0; i < expression.length; i++) {
            if(i % 2 == 0) {
                if(!isNumber(expression[i])) {
                    return false;
                }
            } else {
                if(!isOperator(expression[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
