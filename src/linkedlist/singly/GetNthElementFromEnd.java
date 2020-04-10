package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.stream.IntStream;

/**
 * This class will find Nth element from end of the list.
 * We can solve this problem in following 2 ways :
 * 1. By calculating length of the list.
 * 2. Via recursion.
 */
public class GetNthElementFromEnd {

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

        int index = 5;
        System.out.print("\n\nGetting " + index + "th element from end (Calculating length):- " + getNthElementFromEnd(list, index));
//        System.out.print("\n\nGetting " + index + "th element ( Recursively : 1 ):- " + getNthElement(list.getHead(), index, 1));
//        System.out.print("\n\nGetting " + index + "th element ( Recursively : 2 ):- " + getNthElement(list.getHead(), index));
    }

    /**
     * @param list
     * @param index
     * @return
     * This method is very much successful if we know the length of the List.
     */
    public static int getNthElementFromEnd(SinglyLinkedList list, int index) {

        index = list.size() - index + 1;
        return GetNthElement.getNthElement(list,index);
    }

    /*public static int getNthElementFromEnd(Node currentElement, int index, int indexFromStart, int counter) {

        int data;
        if(currentElement == null) {
            counter = counter - 1;
            indexFromStart = counter - index + 1;
            return -1;
        }
        data = currentElement.getData();

        getNthElementFromEnd(currentElement.getNext(),index,indexFromStart, counter+1);

        if(indexFromStart == counter) {
            return data;
        }
    }*/
}
