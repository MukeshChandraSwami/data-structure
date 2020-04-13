package stack;

import java.util.Stack;

public class ReverseIndividualWord {

    public static void main(String[] args) {

        String s = "Hello Mukesh Chandra Swami";
        System.out.print("Input : " + s);

        s = reverseIndividuals(s);

        System.out.print("\n\nOutput : " + s);
    }

    private static String reverseIndividuals(String s) {

        Stack<Character> stack = new Stack<>();
        String output = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stack.push(ch);
            if(ch == ' ') {
                while(!stack.isEmpty())
                    output += stack.pop();
            }
        }
        output += ' ';
        while(!stack.isEmpty())
            output += stack.pop();

        return output;
    }
}
