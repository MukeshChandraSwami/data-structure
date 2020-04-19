package stack.conversion;

import utils.DSUtils;

import java.util.Stack;

/**
 * This class will convert input infix expression to postfix. Algo :-
 *
 * Step 1 : Input == operand -> Add it in expression
 * Step 2 : Input == (       -> Insert in stack
 * Step 3 : Input == )       -> Pop all the operators from the stack and add in expression until opening brace reaches.
 * Step 4 : Input == Operator
 *      4.1 : If stack is empty then push it in stack
 *      4.2 : If lower precedence operator is at top of the stack then push it in stack too.
 *      4.3 : If higher precedence operator is at top then pop the operators until '(', precedence of top operator is high or equal and add in expression. Push this new operator in stack when stack become empty.
 * Step 5 : Repeat 1 to 4 until input expression is completed.
 * Step 6 : If still there are operator in stack then pop them and add in expression.
 */
public class InfixToPostfix {

    public static void main(String[] args) {

        String infixExp = Expressions.INFIX1;
        System.out.print("Infix : " + infixExp);

        String postfixExp = convertToPostfix(infixExp);

        System.out.print("\n\nPostfix : " + postfixExp);
    }

    public static String convertToPostfix(String infixExp) {

        String postfix = "";

        Stack<Character> s = new Stack<>();
        for(int i = 0; i < infixExp.length(); i++) {                        // Scan complete expression.
            char ch = infixExp.charAt(i);
            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {         // Check if it is a valid character.
                postfix += ch;
            } else if(ch == '(') {
                s.push(ch);                                                 // Push if input is (
            } else if(ch == ')') {
                while(!s.isEmpty()) {                                       // Pop all item and add them in expression
                    char poppedItem = s.pop();
                    if(poppedItem == '(')
                        break;
                    postfix += poppedItem;
                }
            } else {
                if(!s.isEmpty()) {
                    if (DSUtils.precedence(s.peek()) >= DSUtils.precedence(ch)) {        // If top operator has higher precedence
                        while (!s.isEmpty() &&
                                s.peek() != '(' &&
                                DSUtils.precedence(s.peek()) >= DSUtils.precedence(ch)) {      // Loop until and add in expression
                            postfix += s.pop();
                        }
                    }
                }
                s.push(ch);                                                 // Finally push current operator in stack.
            }
        }
        while(!s.isEmpty()) {
            postfix += s.pop();
        }
        return postfix;
    }
}
