package stack.test;

import stack.StackViaQueue;

import java.util.Random;

public class StackViaQueueTest {

    public static void main(String[] args) {
        StackViaQueue stack = new StackViaQueue(10);

        System.out.print("Stack is empty : " + stack.isEmpty());
        System.out.print("\nStack size : " + stack.size());

        System.out.print("\n\nInserting data in stack");
        new Random().ints(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    stack.push(data);
                });

        System.out.print("\n\nTraversing Stack : ");
        stack.traverse();

        System.out.print("\n\nStack is empty : " + stack.isEmpty());
        System.out.print("\nStack size : " + stack.size());

        System.out.print("\n\nPop : " + stack.pop());
        System.out.print("\nPop : " + stack.pop());

        System.out.print("\n\nStack is empty : " + stack.isEmpty());
        System.out.print("\nStack size : " + stack.size());

        System.out.print("\n\nTraversing Stack : ");
        stack.traverse();
    }
}
