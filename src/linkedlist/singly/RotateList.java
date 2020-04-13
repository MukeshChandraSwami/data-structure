package linkedlist.singly;

import java.util.stream.IntStream;

public class RotateList {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Inserting Data At Beginning:- ");
        IntStream.range(1,50).limit(10)
                .forEach(data -> {
                    System.out.print("\nInserting :- " + data);
                    list.insertAtBeginning(data);
                });

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        int rotationFactor = 3;
        rotateByHeplOfSize(list,3);

        System.out.print("\n\nAfter Rotation :- ");
        list.traverse();
    }

    public static void rotateByHeplOfSize(SinglyLinkedList list, int rotationFactor) {

        if(rotationFactor > list.size()) {
            return;
        }
    }
}
