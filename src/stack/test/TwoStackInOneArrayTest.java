package stack.test;

import stack.TwoStackInOneArray;

import java.util.Random;

public class TwoStackInOneArrayTest {

    public static void main(String[] args) {

        TwoStackInOneArray stack = new TwoStackInOneArray(10);

        System.out.print("Is Empty : " +  stack.isEmpty());
        System.out.print("\nIs Full : " +  stack.isFull());

        System.out.print("\n\nInserting data in stack1: ");
        new Random().ints(1,50).limit(0)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    stack.push1(data);
                });

        System.out.print("\n\nInserting data in stack2: ");
        new Random().ints(1,50).limit(1)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    stack.push2(data);
                });

        System.out.print("\n\nTraverse stack1 : ");
        stack.traverse1();

        System.out.print("\n\nTraverse stack2 : ");
        stack.traverse2();

        System.out.print("\n\nIs Empty : " +  stack.isEmpty());
        System.out.print("\nIs Full : " +  stack.isFull());

        System.out.print("\n\nPop1 : " +  stack.pop1());
        System.out.print("\nPop2 : " +  stack.pop2());

        System.out.print("\n\nTraverse stack1 : ");
        stack.traverse1();

        System.out.print("\n\nTraverse stack2 : ");
        stack.traverse2();

        System.out.print("\n\nIs Empty : " +  stack.isEmpty());
        System.out.print("\nIs Full : " +  stack.isFull());

    }
}
