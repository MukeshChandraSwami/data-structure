package stack.conversion;

import java.util.Stack;

/**
 * This class is responsible to convert a Postfix expression into Infix. Algo :
 * Step 1 : Travers element left to right
 * Step 2 : If Input == Operand         -> Push in the stack
 * Step 3 : If Input == Operator        -> Pop two operand from stack A,B
 * Step 4 : Now do B + operator + A and push back to stack.
 * Step 5 : Repeat Step 1 to 4 until all the elements of input is traversed.
 */
public class PostfixToInfix {

    public static void main(String[] args) {

        String postFix = Expressions.POSTFIX20;
        System.out.print("Postfix : " + postFix);

        String infix = convertPostfixToInfix(postFix);

        System.out.print("\n\nInfix : " + infix);
    }

    public static String convertPostfixToInfix(String postFix) {

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < postFix.length(); i++) {                     // Step 1 : Traversing elements
            char ch = postFix.charAt(i);

            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {     // Step 2 : Checking if operand then Push in stack
                stack.push(String.valueOf(ch));
            } else {
                String a = stack.pop();                                 // Step 3 : Pop 2 elements : A and B
                String b = stack.pop();

                String c = b + ch + a;                                  // Step 4 : Adding them and pushing back to stack.
                stack.push(c);
            }
        }
        return stack.pop();                                             // Finally stack will contain only 1 element and that is infix expression
    }

}
