package stack.test;

import stack.Stack;
import stack.StackO1;

import java.util.Random;

public class TestStackO1 {

    public static void main(String[] args) {
        StackO1 stack = new StackO1(10);

        System.out.print("Stack is empty : " + stack.isEmpty());
        System.out.print("\nStack is full : " + stack.isFull());
        System.out.print("\nStack size : " + stack.size());
        System.out.print("\nStack capacity : " + stack.capacity());
        System.out.print("\nMin : " + stack.getMin());
        System.out.print("\nMax : " + stack.getMax());

        System.out.print("\n\nInserting data in stack");
        new Random().ints(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    stack.push(data);
                });

        System.out.print("\n\nTraversing Stack : ");
        stack.traverse();

        System.out.print("\n\nStack is empty : " + stack.isEmpty());
        System.out.print("\nStack is full : " + stack.isFull());
        System.out.print("\nStack size : " + stack.size());
        System.out.print("\nStack capacity : " + stack.capacity());
        System.out.print("\nMin : " + stack.getMin());
        System.out.print("\nMax : " + stack.getMax());

        System.out.print("\n\nPop : " + stack.pop().getData());
        System.out.print("\nPop : " + stack.pop().getData());

        System.out.print("\n\nStack is empty : " + stack.isEmpty());
        System.out.print("\nStack is full : " + stack.isFull());
        System.out.print("\nStack size : " + stack.size());
        System.out.print("\nStack capacity : " + stack.capacity());
        System.out.print("\nMin : " + stack.getMin());
        System.out.print("\nMax : " + stack.getMax());

        System.out.print("\n\nTraversing Stack : ");
        stack.traverse();
    }
}
