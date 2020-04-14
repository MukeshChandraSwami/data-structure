package stack.test;

import queue.QueueUsingStack;
import stack.Stack;

import java.util.Random;

public class QueueUsingStackTest {

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack(9);

        System.out.print("Queue is empty : " + queue.isEmpty());
        System.out.print("\nQueue is full : " + queue.isFull());
        System.out.print("\nQueue size : " + queue.size());
        System.out.print("\nQueue capacity : " + queue.capacity());

        System.out.print("\n\nInserting data in Queue");
        new Random().ints(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    queue.enQueue(data);
                });

        System.out.print("\n\nTraversing Queue : ");
        queue.traverse();

        System.out.print("\n\nQueue is empty : " + queue.isEmpty());
        System.out.print("\nQueue is full : " + queue.isFull());
        System.out.print("\nQueue size : " + queue.size());
        System.out.print("\nQueue capacity : " + queue.capacity());

        System.out.print("\n\nDequeue : " + queue.deQueue());
        System.out.print("\nDequeue : " + queue.deQueue());

        System.out.print("\n\nQueue is empty : " + queue.isEmpty());
        System.out.print("\nQueue is full : " + queue.isFull());
        System.out.print("\nQueue size : " + queue.size());
        System.out.print("\nQueue capacity : " + queue.capacity());

        System.out.print("\n\nTraversing Queue : ");
        queue.traverse();
    }
}
