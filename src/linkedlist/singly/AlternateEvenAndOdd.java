package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.Random;
import java.util.stream.IntStream;

public class AlternateEvenAndOdd {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        new Random().ints(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        boolean startFromEven = false;
        rearrange(list, startFromEven);

        System.out.print("\n\nRearranged List :- ");
        list.traverse();
    }

    public static void rearrange(SinglyLinkedList list, boolean flag) {

        Node head = list.getHead();

        while(head != null) {

            Node node = head;
            while(node != null) {
                boolean swap = false;
                if(flag) {
                    if(node.getData() % 2 == 0) {
                        swap = true;
                        flag = false;
                    }
                } else {
                    if(node.getData() % 2 != 0) {
                        swap = true;
                        flag = true;
                    }
                }

                if(swap) {
                    int temp = head.getData();
                    head.setData(node.getData());
                    node.setData(temp);
                    break;
                }

                node = node.getNext();

                if(node == null)
                    return;
            }
            head = head.getNext();
        }
    }
}
