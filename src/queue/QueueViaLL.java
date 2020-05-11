package queue;

import linkedlist.singly.common.Node;

public class QueueViaLL {

    private int capacity;
    private int size;
    private Node queue;

    public QueueViaLL(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.queue = null;
    }

    public void enqueue(int data) {
        if(this.isFull()) {
            System.out.print("Queue is full");
            return;
        }
        if(this.queue == null) {
            this.queue = new Node(data);
        } else {
            Node node = this.queue;
            while(node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new Node(data));
        }
        size += 1;
    }

    public int dequeue() {

        if(this.isEmpty()) {
            System.out.print("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int data = this.queue.getData();
        this.queue = this.queue.getNext();
        size -= 1;
        return data;
    }

    public void travers() {

        if(this.isEmpty()) {
            System.out.print("Queue is empty.");
            return;
        }

        Node d = this.queue;
        while(d != null) {
            System.out.print("\t" + d.getData() + "\t|");
            d = d.getNext();
        }
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }
}
