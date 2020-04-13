package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

public class MoveLastElementAtFirst {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(50,100).limit(3)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtEnd(data);
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        moveLastAtFirst(list);

        System.out.print("\n\nAfter swapping :- ");
        list.traverse();
    }

    public static void moveLastAtFirst(SinglyLinkedList list) {

        Node head = list.getHead();

        Node current = list.getHead();
        Node previous = null;

        while(current != null && current.getNext() != null) {
            previous = current;
            current = previous.getNext();
        }
        if(current != null && previous != null) {
            current.setNext(head);
            previous.setNext(null);
            list.setHead(current);
        }
    }
}
