package utils;

import stack.conversion.ExpressionType;

public class DSUtils {

    public static int precedence(char op) {
        int precedence = -1;
        switch(op) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            case '^':
                precedence = 3;
                break;
        }
        return precedence;
    }

    public static boolean checkIfOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static ExpressionType checkExpressionType(String expression) {
        ExpressionType type = null;
        if(checkIfOperator(expression.charAt(0))) {
            type = ExpressionType.PREFIX;
        } else if(checkIfOperator(expression.charAt(expression.length() - 1))) {
            type = ExpressionType.POSTFIX;
        } else {
            type = ExpressionType.INFIX;
        }
        return type;
    }

    public static int performOperation(int first, int second, char operator) {
        int result = 0;
        switch (operator){
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
        }
        return result;
    }
}
