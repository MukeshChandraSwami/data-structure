package linkedlist.singly;

import linkedlist.singly.common.Node;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * This class represent singly linked list.
 * I am going to use this class in all my practice examples.
 */
public class SinglyLinkedList {

    private AtomicInteger size = new AtomicInteger();
    private Node head;

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

        System.out.print("\n\nInserting Data At Pos 1 :- ");
        list.insertAt(200, 1);

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

//        System.out.print("\n\nDeleting first element :- ");
//        list.deleteFromBeginning();
//
//        System.out.print("\n\nTraversing List :- ");
//        list.traverse();
//
//        System.out.print("\n\nDeleting last element :- ");
//        list.deleteFromEnd();
//

//        System.out.print("\n\nRemoving from index 3 :-");
//        list.deleteByIndex(3);

        System.out.print("\n\nRemoving Key 2 :- ");
        list.deleteByKey(200);

        System.out.print("\n\nTraversing List :- ");
        list.traverse();

        System.out.print("\n\nSize of linked list :- " + list.size());
    }

    /**
     * @param data
     * Adding data at the beginning of the linked list.
     */
    public void insertAtBeginning(int data) {

        Node n = new Node(data);

        if(head == null) {
            head = n;
        } else {
            // Adding the new node at beginning.
            n.setNext(head);

            // Resetting the head of list via this new node.
            head = n;
        }

        // Updating the size of list
        size.incrementAndGet();
    }

    /**
     * @param data
     * Adding data at the end of the linked list.
     */
    public void insertAtEnd(int data) {

        Node n = new Node(data);

        if(head == null) {
            // If head is null then this node is both first and last.
            head = n;
        } else {
            // Starting from head.
            Node currentElement = head;

            // Traverse till end of the list.
            while(currentElement.getNext() != null) {
                currentElement = currentElement.getNext();
            }

            // Add a new element at the end.
            currentElement.setNext(n);
        }

        // Updating the size of list
        size.incrementAndGet();
    }

    /**
     * @param data
     * @param pos
     *
     * Inserting data at a particular position if exists.
     */
    public void insertAt(int data, int pos) {

        if(pos < 1 || (pos > this.size() && this.head != null)) {
            System.out.println("Please verify position where you want to insert data.");
            return;
        }

        Node n = new Node(data);

        int i = 1;
        // Starting from head.
        Node currentElement = this.head;

        if(pos > 1) {
            // Traversing list to fin appropriate position.
            while (i < pos - 1) {
                currentElement = currentElement.getNext();
                i++;
            }
            // Adding reference of next node in newly created node
            n.setNext(currentElement.getNext());
            // Assigning reference of new node to last node.
            currentElement.setNext(n);

            // Updating the size of list
            size.incrementAndGet();

        } else {
            insertAtBeginning(data);
        }
    }

    /**
     * Deleting data from beginning of list
     */
    public void deleteFromBeginning() {

        if(this.head == null) {
            System.out.print("The list is empty");
            return;
        }
        Node next = head.getNext();
        this.head = next;

        // Updating the size of list
        this.size.decrementAndGet();
    }

    /**
     * Deleting data from end of the list
     */
    public void deleteFromEnd() {
        if(this.head == null) {
            System.out.print("The list is empty");
            return;
        }
        if(this.size() == 1) {
            this.head = null;
            return;
        }

        Node current = this.head;

        while(current.getNext().getNext() != null ) {
            current = current.getNext();
        }

        current.setNext(null);

        // Updating the size of list
        this.size.decrementAndGet();
    }

    /**
     * Deleting data from a specific index if exists
     */
    public void deleteByIndex(int index) {

        if(this.head == null) {                         // Handling list is empty use case
            System.out.print("List is empty.");
        } else if(index <= 0 || index > this.size()) {      // If index is not in range of list
            System.out.print("Invalid index");
        } else if(index == 1) {                           // Remove first element.
            deleteFromBeginning();
        } else if(index == this.size()) {                 // Removing last element
            deleteFromEnd();
        } else {
            int i = 1;
            Node currentElement = this.head;
            // Traversing to just last element of index.
            while (i < index - 1) {
                currentElement = currentElement.getNext();
                i++;
            }
            // Resetting indexes
            currentElement.setNext(currentElement.getNext().getNext());

            // Updating the size of list
            this.size.decrementAndGet();
        }
    }

    /**
     * @param key
     * Search for a particular key and delete it.
     */
    public void deleteByKey(int key) {

        if(this.head == null) {                         // Handling list is empty use case
            System.out.print("List is empty.");
            return;
        }

        Node currentElement = this.head;
        Node previouseElement = currentElement;
        while(currentElement != null) {

            if(currentElement != null && currentElement.getData() == key) {
                if(previouseElement == this.head) {
                    this.head = this.head.getNext();
                } else {
                    previouseElement.setNext(currentElement.getNext());
                }
                this.size.decrementAndGet();
                break;
            }

            previouseElement = currentElement;
            currentElement = currentElement.getNext();
        }

        if(currentElement == null) {
            System.out.print("Key is not available");
        }

    }

    /**
     * Traversing all the elements of the list.
     */
    public void traverse() {

        if(this.head == null ) {
            System.out.print("List is empty");
        }
        Node currentNode = this.head;
        while(currentNode != null) {
            System.out.print("\t" + currentNode.getData() + "\t|");
            currentNode = currentNode.getNext();
        }
    }

    /**
     * @return
     * Returns the size of the list.
     */
    public int size() {
        return size.get();
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }

    public void reverse() {
        if(this.getHead() == null)
            return;

        // Holding head of list in stack frame and then removing it.
        Node head = this.getHead();
        this.deleteFromBeginning();

        // Again reversing.
        this.reverse();

        // Adding back to this list in reverse order.
        this.insertAtEnd(head.getData());

    }
}
