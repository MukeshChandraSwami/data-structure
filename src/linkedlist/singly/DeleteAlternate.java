package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * This class will delete alternate from the list.
 */
public class DeleteAlternate {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(50,100).limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtEnd(data);
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        delete(list);

        System.out.print("\n\nTraversing List After Deletion :- ");
        list.traverse();
    }

    public static void delete(SinglyLinkedList list) {

        Node pointer1 = list.getHead();
        Node pointer2 = list.getHead();

        while(pointer1 != null && pointer2 != null) {
            if(pointer2.getNext() != null) {
                pointer2 = pointer2.getNext().getNext();
            } else {
                break;
            }
            pointer1.setNext(pointer2);
            pointer1 = pointer2;
        }
    }
}
