package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * This class is like an search engine.
 * It can search an element in List in 2 ways :-
 * 1. Linear Search
 * 2. Recursive Search
 */
public class SearchElement {

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

        System.out.print("\n\nIs available (Iterative): " + search(list, 5000));

        System.out.print("\n\nIs available (Recursive): " + search(list.getHead(), 5));
    }

    /**
     * @param list
     * @param item
     * @return
     *
     * Linear search in singly linked list.
     */
    public static boolean search(SinglyLinkedList list, int item) {

        Node currentElement =  list.getHead();
        while(currentElement != null) {
            if(currentElement.getData() == item) {
                return true;
            }
            currentElement = currentElement.getNext();
        }
        return false;
    }

    /**
     * @param head
     * @param item
     * @return
     *
     * Searching an item recursively
     */
    public static boolean search(Node head, int item) {

        if(head == null)
            return false;

        if(head.getData() == item)
            return true;

        return search(head.getNext(),item);
    }
}
