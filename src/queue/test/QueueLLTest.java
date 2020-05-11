package queue.test;

import queue.QueueViaLL;

import java.util.Random;

public class QueueLLTest {

    public static void main(String[] args) {

        QueueViaLL queue = new QueueViaLL(10);

        System.out.print("Is Empty : " + queue.isEmpty());
        System.out.print("\nIs Full : " + queue.isFull());
        System.out.print("\nSize : " + queue.getSize());
        System.out.print("\n\nInserting data in queue");
        new Random().ints(1,10)
                .limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    queue.enqueue(data);
                });

        new Random().ints(50,100)
                .limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting : " + data);
                    queue.enqueue(data);
                });

        System.out.print("\n\nTraversing : ");
        queue.travers();

        System.out.print("\n\nIs Empty : " + queue.isEmpty());
        System.out.print("\nIs Full : " + queue.isFull());
        System.out.print("\nSize : " + queue.getSize());

        System.out.print("\n\nDeleting : " + queue.dequeue());
        System.out.print("\nDeleting : " + queue.dequeue());

        System.out.print("\n\nTraversing : ");
        queue.travers();

        System.out.print("\n\nIs Empty : " + queue.isEmpty());
        System.out.print("\nIs Full : " + queue.isFull());
        System.out.print("\nSize : " + queue.getSize());
    }
}
