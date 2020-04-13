package linkedlist.singly.sort;

import linkedlist.singly.SinglyLinkedList;

import java.util.Random;

public class SelectionSort {

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

        sort(list);

        System.out.print("\n\nSorted List :- ");
        list.traverse();
    }

    public static void sort(SinglyLinkedList list) {

        // TODO : Pending sorting.
    }
}
