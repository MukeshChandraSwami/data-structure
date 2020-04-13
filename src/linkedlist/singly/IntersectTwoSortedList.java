package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.Random;
import java.util.stream.IntStream;

public class IntersectTwoSortedList {

    public static void main(String[] args) {

        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list1.insertAtEnd(data);
                    if(data % 2 == 0)
                        list1.insertAtEnd(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(1,50).limit(5)
                .map(data -> data * 2 - 1)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list2.insertAtEnd(data);
                });

        System.out.print("\n\nTraversing List1 :- ");
        list1.traverse();

        System.out.print("\n\nTraversing List2 :- ");
        list2.traverse();

        SinglyLinkedList list3 = intersection(list1, list2);

        System.out.print("\n\nTraversing after intersection :- ");
        list3.traverse();
    }

    /**
     * @param list1
     * @param list2
     * @return
     *
     * Intersect 2 lists and hold the result in new list.
     */
    public static SinglyLinkedList intersection(SinglyLinkedList list1, SinglyLinkedList list2) {

        SinglyLinkedList intersectedList = new SinglyLinkedList();

        Node ls2Node = list2.getHead();

        // Traverse first / second list and get a element from first list.
        while(ls2Node != null) {

            Node intersectedListHead = intersectedList.getHead();
            // Go through intersected list to check whether it contains this element or not.
            while(intersectedListHead != null) {
                // Check if intersected list contains this node or not.
                // If contains then restart outer loop.
                if(intersectedListHead.getData() == ls2Node.getData()) {
                    ls2Node = ls2Node.getNext();
                    continue;
                }
                intersectedListHead = intersectedListHead.getNext();
            }

            Node ls1Node = list1.getHead();
            // Now loop through second list and check element of first node is exists in second list.
            while(ls1Node != null && ls2Node.getData() >= ls1Node.getData()) {

                // If same element found then add it in intersected list.
                if(ls1Node.getData() == ls2Node.getData()) {
                    intersectedList.insertAtEnd(ls1Node.getData());
                    break;
                }
                ls1Node = ls1Node.getNext();
            }
            ls2Node = ls2Node.getNext();
        }
        return intersectedList;
    }
}
