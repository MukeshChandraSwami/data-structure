package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

public class SwapPairWise {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(2)
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

        swapByData(list);

        System.out.print("\n\nAfter swapping :- ");
        list.traverse();
    }

    public static void swapByData(SinglyLinkedList list) {

        Node current = list.getHead();
        Node next = current.getNext();
        while(current != null && next != null) {

            int temp = current.getData();
            current.setData(next.getData());
            next.setData(temp);

            current = next.getNext();
            next = current != null ? current.getNext() :  null;
        }
    }
}
