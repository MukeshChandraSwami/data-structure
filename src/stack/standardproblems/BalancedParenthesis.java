package stack.standardproblems;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {

        String input = /*"[()]{}{[()()]()}"*/ "[(])";
        System.out.print("Expression : " + input);

        boolean balanced = checkParenthesisOrder(input);

        System.out.print("\n\nBalanced : " + balanced);
    }

    public static boolean checkParenthesisOrder(String input) {

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(') {
                stack.push(String.valueOf(ch));
                continue;
            }

            switch (ch) {
                case ']':
                    if(!stack.pop().equalsIgnoreCase("["))
                        return false;
                    break;
                case '}':
                    if(!stack.pop().equalsIgnoreCase("{"))
                        return false;
                    break;
                case ')':
                    if(!stack.pop().equalsIgnoreCase("("))
                        return false;
                    break;
            }
        }

        return true;
    }
}
