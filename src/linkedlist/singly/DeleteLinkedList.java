package linkedlist.singly;


import java.util.stream.IntStream;

/**
 * Delete all items of the list one by one
 * In java it is very easy to do so, thanks to automatic GC.
 * We just need to make head unreachable.
 * Rest of the elements will automatically be garbage collected via GC.
 */
public class DeleteLinkedList {

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

        deleteList(list);
        System.out.print("\n\nTraversing List after deletion:- ");
        list.traverse();
    }

    private static void deleteList(SinglyLinkedList list) {
        list.setHead(null);
    }

}
