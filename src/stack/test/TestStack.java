package stack.test;

import stack.Stack;

import java.util.Random;

public class TestStack {

    public static void main(String[] args) {

        Stack stack = new Stack(10);

        System.out.print("Stack is empty : " + stack.isEmpty());
        System.out.print("\nStack size : " + stack.size());
        System.out.print("\nStack capacity : " + stack.capacity());

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
        System.out.print("\nStack capacity : " + stack.capacity());

        System.out.print("\n\nPop : " + stack.pop());
        System.out.print("\nPop : " + stack.pop());

        System.out.print("\n\nStack is empty : " + stack.isEmpty());
        System.out.print("\nStack size : " + stack.size());
        System.out.print("\nStack capacity : " + stack.capacity());

        System.out.print("\n\nTraversing Stack : ");
        stack.traverse();

        System.out.print("\n\nReverse the stack : ");
        stack.reverse();

        System.out.print("\nTraversing Stack : ");
        stack.traverse();
    }
}
