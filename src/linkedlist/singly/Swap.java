package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * This class will swapByData 2 elements of List.
 * There may be following use cases :
 * 1. Find x and y
 * 2. May be one of them not exists.
 * 3. May be x and y is same element.
 * 4. There may be only one element in the List.
 */
public class Swap {

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

        swap(list,2,510);
        System.out.print("\n\nAfter swapping :- ");
        list.traverse();

    }

    private static void swap(SinglyLinkedList list, int x, int y) {

        Node currentElement = list.getHead();
        Node nodeX = null;
        Node nodeY = null;

        while(currentElement != null) {
            if(currentElement.getData() == x) {
                nodeX = currentElement;
            }

            if(currentElement.getData() == y) {
                nodeY = currentElement;
            }
            currentElement = currentElement.getNext();
        }

        if(nodeX == null || nodeY == null) {
            System.out.print("\n\nElement(s) are not exists in list. So swapping can not be completed.");
            return;
        }

        int temp = nodeX.getData();
        nodeX.setData(nodeY.getData());
        nodeY.setData(temp);
    }
}
