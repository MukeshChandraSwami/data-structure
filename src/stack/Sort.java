package stack;

import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        System.out.print("\n\nInserting data in stack");
        new Random().ints(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    stack.push(data);
                });

        System.out.print("\n\nTraversing Stack : ");
        stack.traverse();

        /*sort(stack);
        System.out.print("\n\nTraversing After Sorting (Recursion) : ");
        stack.traverse();*/

        Stack tempStack = sortViaTempStack(stack);
        System.out.print("\n\nTraversing After Sorting (Temp Stack) : ");
        tempStack.traverse();
    }

    public static void sort(Stack stack) {

        if(stack.isEmpty())
            return;

        int data = stack.pop();

        sort(stack);

        putAtRightPlace(stack,data);
    }

    private static void putAtRightPlace(Stack stack, int data) {
        if(stack.isEmpty() || stack.peek() <= data) {
            stack.push(data);
            return;
        }
        int d = stack.pop();
        if(d > data) {
            putAtRightPlace(stack,data);
        }
        stack.push(d);
    }

    private static Stack sortViaTempStack(Stack stack) {

        Stack tempStack =  new Stack(stack.capacity());

        while(!stack.isEmpty()) {
            int item = stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > item) {
                stack.push(tempStack.pop());
            }
            tempStack.push(item);
        }
        return tempStack;
    }
}
