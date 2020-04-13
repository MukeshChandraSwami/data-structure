package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Reverse the list in pairs
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 * Output:  3->2->1->6->5->4->8->7->NULL.
 *
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL.
 */
public class ReverseInPairs {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nInserting Data At End:- ");
        IntStream.range(50,100).limit(5)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtEnd(data);
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        int pair = 4;
        reverseInPairs(list,pair);

        System.out.print("\n\nTraversing List after reversal:- ");
        list.traverse();

    }

    public static void reverseInPairs(SinglyLinkedList list, int pair) {

        int counter = 0;
        Node head = list.getHead();
        Stack<Integer> stack = new Stack<>();
        Stack<Stack<Integer>> reversedStackOfStack = new Stack<>();

        while(head != null) {

            if(counter < pair) {
                stack.push(head.getData());
                list.deleteFromBeginning();
                head = list.getHead();
                counter += 1;
            } else {
                counter = 0;
                Stack<Integer> reversedStack = new Stack<>();
                while(!stack.empty()) {
                    reversedStack.push(stack.pop());
                }
                reversedStackOfStack.push(reversedStack);
            }

            if(head == null) {
                Stack<Integer> reversedStack = new Stack<>();
                while(!stack.empty()) {
                    reversedStack.push(stack.pop());
                }
                reversedStackOfStack.push(reversedStack);
            }
        }

        while(!reversedStackOfStack.isEmpty()) {
            Stack<Integer> reversedStack = reversedStackOfStack.pop();
            while(!reversedStack.isEmpty()) {
                list.insertAtBeginning(reversedStack.pop());
            }
        }
    }
}
