package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Check if list is palindromeViaStack or not
 * We can check it in following ways :
 * 1. By using stack
 * 2. By reversing the list.
 */
public class Palindrome {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(3)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        System.out.print("\n\npalindromeViaStack (Stack): " + palindromeViaStack(list));

        System.out.print("\n\npalindromeViaStack (Reversal): " + palindromeViaReversal(list));
    }

    public static boolean palindromeViaStack(SinglyLinkedList list) {

        Stack<Integer> stack = new Stack<>();
        Node currentElement = list.getHead();
        while(currentElement != null){
            stack.push(currentElement.getData());
            currentElement = currentElement.getNext();
        }

        currentElement = list.getHead();
        while(currentElement != null){
            if(currentElement.getData() != stack.pop().intValue()) {
                return false;
            }
            currentElement = currentElement.getNext();
        }
        return true;
    }

    public static boolean palindromeViaReversal(SinglyLinkedList list) {

        // Reversing the list
        SinglyLinkedList reversedList = Reverse.reverse(list.getHead(), new SinglyLinkedList());

        Node currentElementOriginalList = list.getHead();
        Node currentElementReversedList = reversedList.getHead();
        while(currentElementOriginalList != null) {

            if(currentElementOriginalList.getData() != currentElementReversedList.getData()) {
                return false;
            }
            currentElementOriginalList = currentElementOriginalList.getNext();
            currentElementReversedList = currentElementReversedList.getNext();

        }
        return true;
    }


}
