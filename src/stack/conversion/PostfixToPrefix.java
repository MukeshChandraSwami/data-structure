package stack.conversion;


import java.util.Stack;

/**
 * This class is responsible to convert Postfix expression into Prefix expression. Algo :
 * Step 1 : Scan the expression left to right
 * Step 2 : If input == operand     -> Push into stack
 * Step 3 : If input == operator    -> Pop two elements from stack A and B
 * Step 4 : Now do : operator + operand2 + operand1 and push back to stack.
 * Step 5 : Repeat until scanning is done.
 */
public class PostfixToPrefix {

    public static void main(String[] args) {
        String postfixExp = Expressions.POSTFIX1;
        System.out.print("Postfix : " + postfixExp);

        String prefixExp = convertToPrefix(postfixExp);

        System.out.print("\n\nPrefix : " + prefixExp);
    }

    public static String convertToPrefix(String postfixExp) {

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < postfixExp.length(); i++) {
            char ch = postfixExp.charAt(i);
            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                stack.push(String.valueOf(ch));
            } else {
                String a = stack.pop();
                String b = stack.pop();
                String c = ch + b + a;
                stack.push(c);
            }
        }
        return stack.pop();
    }
}
