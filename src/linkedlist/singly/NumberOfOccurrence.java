package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

public class NumberOfOccurrence {

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
        list.insertAtEnd(1);

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        int element = 1;
        System.out.print("\n\nOccurrence of " + element + " (Linear) : " + findOccurrences(list, element));
        System.out.print("\n\nOccurrence of " + element + " (Linear) : " + findOccurrences(list.getHead(), element, 0));
    }

    public static int findOccurrences(SinglyLinkedList list, int element) {

        int count = 0;

        Node currentElement = list.getHead();
        while(currentElement != null) {
            if(currentElement.getData() == element) {
                count++;
            }
            currentElement = currentElement.getNext();
        }

        return count;
    }

    public static int findOccurrences(Node head, int element, int count) {

        if(head == null)
            return count;

        if(head.getData() == element)
            count += 1;

        return findOccurrences(head.getNext(), element, count);
    }
}
