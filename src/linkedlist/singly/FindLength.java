package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * This class will get the length of the linked list in following three ways :
 * 1. I have already written some logic of getting length of the list in SinglyLinkedList class.
 * 2. Via loop.
 * 3. Via recursion.
 */
public class FindLength {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(2)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(50,100).limit(2)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtEnd(data);
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        System.out.print("\n\nGetting length from SinglyLinkedList : " + list.size());

        System.out.print("\n\nGetting length from Iteration : " + getLength(list));

        System.out.print("\n\nGetting length from Recursion : " + getLength(list.getHead(), 0));
    }

    /**
     * @param list
     * @return
     *
     * Getting length from List via iteration.
     */
    public static int getLength(SinglyLinkedList list) {

        int size = 0;
        Node currentElement = list.getHead();
        while(currentElement != null) {
            currentElement = currentElement.getNext();
            size++;
        }

        return size;
    }

    /**
     * @param head
     * @param size
     * @return
     *
     * Getting size of List via recursion
     */
    public static int getLength(Node head, int size) {

        if(head == null)
            return size;
        else
            size++;
        return getLength(head.getNext(),size);
    }

}
