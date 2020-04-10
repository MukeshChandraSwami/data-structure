package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * This class will find middle element of the List.
 * There are 2 ways of it.
 * 1. By calculating size of the list.
 * 2. By maintaining 2 pointers.
 */
public class MiddleElement {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(3)
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

        System.out.print("\n\nGetting middle element from SinglyLinkedList : " + getMiddleElement(list));
        System.out.print("\n\nGetting middle element from SinglyLinkedList (By two pointers) : " + getMiddleElementByTwoPointer(list));
    }

    /**
     * @param list
     * @return
     *
     * Calculate mid element and return it by traversing it.
     */
    public static int getMiddleElement(SinglyLinkedList list) {
        int index = list.size() % 2 == 0 ? list.size() / 2 :list.size() / 2 + 1;
        return GetNthElement.getNthElement(list,index);
    }

    /**
     * @param list
     * @return
     *
     * Get middle element by maintaining 2 pointers
     */
    public static int getMiddleElementByTwoPointer(SinglyLinkedList list) {
        Node currentElement = list.getHead();
        Node midElement = list.getHead();

        while(currentElement != null && currentElement.getNext() != null) {

            currentElement = currentElement.getNext().getNext();
            midElement = midElement.getNext();
        }
        return midElement.getData();
    }
}
