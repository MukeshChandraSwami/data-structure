package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.Random;

public class RemoveDuplicatesFromUnSortedList {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        new Random().ints(0,10).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                    if(data % 2 == 0) {
                        list.insertAtBeginning(data);
                    }
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        System.out.print("\n\nAfter removing duplicates :-");
        removeDuplicates(list);
        list.traverse();
    }

    /**
     * @param list
     *
     * Removing duplicate elements via iteration.
     * Steps :
     * 1. There will be 2 parts of it.
     * 2. Pick first element and find its duplicate in the list and remove.
     * 3. Now this element do not have its duplicates.
     * 4. These non-duplicate elements will be in left.
     * 5  Repeat step 2 to 4 until all duplicates are removed.
     */
    public static void removeDuplicates(SinglyLinkedList list) {

        Node currentElement = list.getHead();

        // This is first element.
        while(currentElement != null) {

            Node next = currentElement.getNext();
            Node previous = currentElement;
            while(next != null) {
                if(currentElement.getData() == next.getData()) {
                    previous.setNext(next.getNext());
                } else {
                    previous = previous.getNext();
                }
                next = next.getNext();
            }

            // Updating the first element via its next element, who do not have more duplicates.
            currentElement = currentElement.getNext();
        }
    }
}
