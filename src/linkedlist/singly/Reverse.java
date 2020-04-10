package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * This class will reverse the singly linked list.
 */
public class Reverse {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(3)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(50,100).limit(3)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        System.out.print("\n\nReverse List (No argument):- ");
        list.reverse();

        /*System.out.print("\n\nReverse List (Single argument):- ");
        reverse(list);

        System.out.print("\n\nReverse List (Double argument):- ");
        reverse(list.getHead(), new SinglyLinkedList());*/

        list.traverse();

    }

    /**
     * @param list
     * @return
     *
     * Reversing the list
     */
    public static void reverse(SinglyLinkedList list) {

        if(list.getHead() == null)
            return;

        // Holding head of list in stack frame and then removing it.
        Node head = list.getHead();
        list.deleteFromBeginning();

        // Again reversing.
        reverse(list);

        // Adding back to this list in reverse order.
        list.insertAtEnd(head.getData());
    }

    /**
     * @param head
     * @param list
     * @return
     *
     * Reversing the list. But it will create a new list to get reversed list.
     */
    public static SinglyLinkedList reverse(Node head, SinglyLinkedList list) {
        if(head == null)
            return list;
        reverse(head.getNext(),list);
        list.insertAtEnd(head.getData());
        return list;
    }
}
