package queue.test;

import queue.DeQue;

import java.util.Random;

public class DeQueTest {

    public static void main(String[] args) {

        DeQue queue = new DeQue(10);

        System.out.print("Is Empty : " + queue.isEmpty());
        System.out.print("\nIs Full : " + queue.isFull());
        System.out.print("\nSize : " + queue.size());
        System.out.print("\n\nInserting data in queue");
        new Random().ints(1,10)
                .limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting at front : " + data);
                    queue.insertAtFront(data);
                });

        new Random().ints(50,100)
                .limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting at end: " + data);
                    queue.insertAtEnd(data);
                });

        System.out.print("\n\nTraversing : ");
        queue.travers();

        System.out.print("\n\nIs Empty : " + queue.isEmpty());
        System.out.print("\nIs Full : " + queue.isFull());
        System.out.print("\nSize : " + queue.size());

        System.out.print("\n\nDeleting : " + queue.deleteFromFront());
        System.out.print("\nDeleting : " + queue.deleteFromEnd());

        System.out.print("\n\nTraversing : ");
        queue.travers();

        System.out.print("\n\nIs Empty : " + queue.isEmpty());
        System.out.print("\nIs Full : " + queue.isFull());
        System.out.print("\nSize : " + queue.size());
    }
}
