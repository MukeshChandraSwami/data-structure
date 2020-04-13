package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.Random;

public class EvenAndOdd {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        new Random().ints(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nList :- ");
        list.traverse();

        //segregateEvenAndOdd(list);
        segregateEvenAndOddByAnotherList(list);

        System.out.print("\n\nSorted List :- ");
        list.traverse();
    }

    /**
     * @param list
     * This will segregate odd numbers followed by even numbers.
     */
    public static void segregateEvenAndOdd(SinglyLinkedList list) {

        /*
        * This one is same as a part of quick sort.
        * 1. Hold start element.
        * 2. Start traversing from beginning and find a even number
        * 3. Swap it with start element.
        * 4. Set start element by its next element and continue until complete list is traversed.
        * */

        Node current = list.getHead();
        // Step 1 : Holding start element
        Node start = current;

        // Step 2 : Starting traversing from beginning.
        while(current != null) {

            // Step 2 : and finding even number
            if(current.getData() % 2 == 0) {
                //Step 3 : Swapping this even number with start
                int temp = current.getData();
                current.setData(start.getData());
                start.setData(temp);

                // Step 4 : Resetting start from its next element.
                start = start.getNext();
            }
            current = current.getNext();
        }
    }

    /**
     * @param list
     * This is simple then last.
     * 1. Create 2 list for odd and even number.
     * 2. Push data in them via traversing main list.
     * 3. Then add even data after even and return as result.
     */
    public static void segregateEvenAndOddByAnotherList(SinglyLinkedList list) {

        SinglyLinkedList odd = new SinglyLinkedList();
        SinglyLinkedList even = new SinglyLinkedList();

        Node currentElement = list.getHead();

        while(currentElement != null) {
            if(currentElement.getData() % 2 == 0)
                even.insertAtBeginning(currentElement.getData());
            else
                odd.insertAtBeginning(currentElement.getData());

            list.deleteFromBeginning();
            currentElement = list.getHead();
        }
        currentElement = odd.getHead();
        while(currentElement != null) {
            list.insertAtBeginning(currentElement.getData());
            odd.deleteFromBeginning();
            currentElement = odd.getHead();
        }

        currentElement = even.getHead();
        while(currentElement != null) {
            list.insertAtBeginning(currentElement.getData());
            even.deleteFromBeginning();
            currentElement = even.getHead();
        }
    }
}
