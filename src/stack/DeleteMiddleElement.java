package stack;

import java.util.Random;

public class DeleteMiddleElement {

    public static void main(String[] args) {
        Stack stack = new Stack(6);

        System.out.print("\n\nInserting data in stack");
        new Random().ints(1,50).limit(6)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    stack.push(data);
                });

        System.out.print("\n\nTraversing Stack : ");
        stack.traverse();

        deleteMiddle(stack);

        System.out.print("\n\nTraversing after deletion : ");
        stack.traverse();
    }

    public static void deleteMiddle(Stack stack) {

        int elementToDelete = (stack.size() + 1) / 2;
        deleteMiddle(stack, elementToDelete);
    }

    private static void deleteMiddle(Stack stack, int elementToDelete) {
        if(stack.isEmpty() || stack.size() == elementToDelete) {
            stack.pop();
            return;
        }

        int data = stack.pop();

        deleteMiddle(stack,elementToDelete);

        stack.push(data);
    }
}
