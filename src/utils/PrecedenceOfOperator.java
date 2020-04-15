package utils;

public class PrecedenceOfOperator {

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
}
