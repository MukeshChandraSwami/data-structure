package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

public class MergeTwoSortedListInReverseOrder {

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(1,20).limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list1.insertAtEnd(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(1,20).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list2.insertAtEnd(data);

                    if(data % 2 == 0)
                        list2.insertAtEnd(data);
                });

        System.out.print("\n\nTraversing List1 :- ");
        list1.traverse();

        System.out.print("\n\nTraversing List2 :- ");
        list2.traverse();


        SinglyLinkedList mergedSortedList = merge(list1, list2);

        System.out.print("\n\nMerged List :- ");
        mergedSortedList.traverse();
    }

    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {

        SinglyLinkedList list = new SinglyLinkedList();

        Node ls1 = list1.getHead();
        Node ls2 = list2.getHead();

        while(ls1 != null || ls2 != null) {

            if((ls1 != null && ls2 != null && ls1.getData() <= ls2.getData()) || (ls1 != null && ls2 == null)) {
                list.insertAtEnd(ls1.getData());
                ls1 = ls1.getNext();
            } else {
                list.insertAtEnd(ls2.getData());
                ls2 = ls2.getNext();
            }
        }

        return list;
    }
}
