package stack.conversion;

import java.util.Stack;

/**
 * This class is responsible to convert a Prefix expression into Postfix expression. Alog :
 * Step 1 : Scan the expression from right to left.
 * Step 2 : If input == operand     -> Push into stack
 * Step 3 : If input == operator    -> Pop two elements from stack A,B.
 * Step 4 : Now do : A + B + operator and push back to stack
 * Step 5 : Repeat until complete expression is done.
 */
public class PrefixToPostfix {

    public static void main(String[] args) {
        String prefixExp = Expressions.PREFIX1;
        System.out.print("Prefix : " + prefixExp);

        String postfixExp = convertToPostfix(prefixExp);

        System.out.print("\n\nPostfix : " + postfixExp);
    }

    public static String convertToPostfix(String prefixExp) {

        Stack<String> stack = new Stack<>();
        for(int i = prefixExp.length() - 1; i >= 0; i--) {
            char ch = prefixExp.charAt(i);
            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                stack.push(String.valueOf(ch));
            } else {
                String a = stack.pop();
                String b = stack.pop();
                String c = a + b + ch;
                stack.push(c);
            }
        }
        return stack.pop();
    }
}
