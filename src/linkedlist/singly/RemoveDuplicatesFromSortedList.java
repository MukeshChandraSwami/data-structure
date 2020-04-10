package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtEnd(data);
                    if(data %2 == 0) {
                        list.insertAtEnd(data);
                    }
                    if(data == 3) {
                        list.insertAtEnd(data);
                        list.insertAtEnd(data);
                    }
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        //removeDuplicates(list);
        removeDuplicatesRecursively(list);

        System.out.print("\n\nAfter removing duplicates :- ");
        list.traverse();
    }

    /**
     * @param list
     * Remove all the duplicate element by traversing the list using loops.
     */
    public static void removeDuplicates(SinglyLinkedList list) {

        Node currentElement = list.getHead();
        while(currentElement != null) {

            // Loop until duplicates are there
            Node next = currentElement.getNext();
            while(next != null && next.getData() == currentElement.getData()){
                next = next.getNext();
            }

            // Set pointer part of current element as this non-duplicate element
            currentElement.setNext(next);

            // Update value of current element via this non-duplicate element.
            currentElement = next;
        }
    }

    /**
     * @param list
     * Remove the duplicates via recursively traversal of the list.
     */
    public static void removeDuplicatesRecursively(SinglyLinkedList list) {

        if(list.getHead() == null)
            return;

        // Hold 1 node per stack frame and remove it from list.
        Node currentElement = list.getHead();
        list.deleteFromBeginning();

        // Recursively call this method until this list become empty.
        removeDuplicatesRecursively(list);

        if(list.getHead() == null)
            list.insertAtBeginning(currentElement.getData());

        // Start inserting it at beginning by checking duplicity
        if(list.getHead() != null && list.getHead().getData() != currentElement.getData()) {
            list.insertAtBeginning(currentElement.getData());
        }
    }
}
