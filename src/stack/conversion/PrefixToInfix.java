package stack.conversion;

import java.util.Stack;

/**
 * This class is responsible to covert a Prefix expression into Infix. Algo :
 * Step 1 : Scan the expression from right to left.
 * Step 2 : If input == operand     -> Push into stack
 * Step 3 : If input == operator    -> Take to element from stack A,B.
 * Step 4 : now do : A + operator + B and push back to stack
 * Step 5 : Repeat until expression is scanned completely.
 */
public class PrefixToInfix {

    public static void main(String[] args) {

        String prefixExp = Expressions.PREFIX1;
        System.out.print("Prefix : " + prefixExp);

        String infixExp = convertToInfix(prefixExp);

        System.out.print("\n\nInfix : " + infixExp);
    }

    public static String convertToInfix(String prefixExp) {

        Stack<String> stack = new Stack<>();
        for(int i = prefixExp.length() - 1; i >= 0; i--) {
            char ch = prefixExp.charAt(i);
            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                stack.push(String.valueOf(ch));
            } else {
                String a = stack.pop();
                String b = stack.pop();
                String c = a + ch + b;
                stack.push(c);
            }
        }
        return stack.pop();
    }
}
