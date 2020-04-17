package stack.conversion;

/**
 * This class will convert input infix expression to prefix. Algo :-
 *
 * Step 1 : Reverse the input string
 * Step 2 : Do infix to postfix
 * Step 3 : Again revers the output string.
 * Step 4 : Return as result
 */
public class InfixToPrefix {

    public static void main(String[] args) {

        String infixExp = Expressions.PREFIX20;
        System.out.print("Infix : " + infixExp);

        String prefixExp = convertToPrefix(infixExp);

        System.out.print("\n\nPrefix : " + prefixExp);
    }

    public static String convertToPrefix(String infixExp) {

        infixExp = getReverseExpression(new StringBuffer(infixExp).reverse().toString());                              // Step 1

        String postfix = InfixToPostfix.convertToPostfix(infixExp);             // Step 2

        return new StringBuilder(postfix).reverse().toString();                 // Step 3
    }

    private static String getReverseExpression(String infixExp) {
        String s = "";
        for(int i = 0; i < infixExp.length(); i++) {
            char ch  = infixExp.charAt(i);
            if(ch == '(') {
                ch = ')';
            } else if(ch == ')') {
                ch = '(';
            }
            s += ch;
        }
        return s;
    }
}
