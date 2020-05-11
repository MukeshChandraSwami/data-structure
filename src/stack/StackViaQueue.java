package stack;

import queue.CircularQueue;

public class StackViaQueue {

    private CircularQueue queue;

    public StackViaQueue(int capacity) {
        this.queue = new CircularQueue(capacity);
    }

    public void push(int data) {

        if(this.isFull()) {
            System.out.print("Stack is full");
            return;
        }
        if(this.isEmpty()) {
            this.queue.enqueue(data);
        } else {
            this.queue.reverse();
            this.queue.enqueue(data);
            this.queue.reverse();
        }
    }

    public int pop() {

        if(this.isEmpty()) {
            System.out.print("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return this.queue.dequeue();
    }

    public boolean isFull() {
        return this.queue.isFull();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public int size() {
        return this.queue.getSize();
    }

    public void traverse() {
        if(this.isEmpty()) {
            System.out.print("Stack is empty");
            return;
        }

        this.queue.travers();
    }
}
