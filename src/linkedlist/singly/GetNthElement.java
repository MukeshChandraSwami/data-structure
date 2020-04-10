package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * Search for Nth element of the list if exists
 * We can find Nth element in following 2 ways :
 * 1. Linear Traversal
 * 2. Recursive Traversal
 */
public class GetNthElement {

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

        int index = 1;
        System.out.print("\n\nGetting " + index + "th element (Linear):- " + getNthElement(list, index));
        System.out.print("\n\nGetting " + index + "th element ( Recursively : 1 ):- " + getNthElement(list.getHead(), index, 1));
        System.out.print("\n\nGetting " + index + "th element ( Recursively : 2 ):- " + getNthElement(list.getHead(), index));
    }

    /**
     *
     * @param list
     * @param index
     * @return
     *
     * Getting Nth element via linear traversal
     * Will return -1 if index is out of the bounds of List.
     */
    public static int getNthElement(SinglyLinkedList list, int index) {

        int i = 1;
        Node currentElement = list.getHead();
        while(index > 0 && currentElement != null) {
            if(index == i) {
                return currentElement.getData();
            }
            currentElement = currentElement.getNext();
            i++;
        }
        return -1;
    }

    /**
     * @param currentElement
     * @param index
     * @param counter
     * @return
     *
     * Recursive way 1
     */
    public static int getNthElement(Node currentElement, int index, int counter) {

        // Check end of the list and index number at least 1.
        if(index < 1 || currentElement == null)
            return -1;

        if(index == counter)
            // If counter is equals to index then return data.
            return currentElement.getData();
        else {
            // Increase the counter by 1
            counter++;
            // Set element by  next element
            currentElement = currentElement.getNext();
        }

        // Continue searching until list is completed
        return getNthElement(currentElement,index,counter);
    }

    /**
     * @param currentElement
     * @param index
     * @return
     *
     * Recursive way 2
     */
    public static int getNthElement(Node currentElement, int index) {

        // Check end of the list and index number at least 1.
        if(index < 1 || currentElement == null)
            return -1;

        int count = 1;

        if(index == count)
            return currentElement.getData();

        return getNthElement(currentElement.getNext(),--index);
    }
}
