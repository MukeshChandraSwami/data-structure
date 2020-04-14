package queue;

import stack.Stack;

public class QueueUsingStack {

    private Stack stack1 = null;
    private Stack stack2 = null;
    private int size;
    private int capacity;

    public QueueUsingStack(int capacity) {
        this.capacity = capacity;
        stack1 = new Stack(capacity);
        stack2 = new Stack(capacity);
    }

    /**
     * @param data
     * Insert data in queue
     */
    public void enQueue(int data) {

        if(this.isFull()) {
            System.out.print("Queue is full");
            return;
        }
        stack1.push(data);
    }

    /**
     * @return
     * Get data from queue
     */
    public int deQueue() {

        if(this.isEmpty()) {

            System.out.print("Queue is empty");
            return -1;
        }

        // Push data in stack2 if it is empty.
        if(this.stack2.isEmpty()) {
            while(!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }

        return this.stack2.pop();
    }

    /**
     * @return
     * Size of the queue
     */
    public int size() {
        return this.stack1.size() + this.stack2.size();
    }

    /**
     * @return
     * Check if queue is empty or not
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * @return
     * Check if queue is full or not
     */
    public boolean isFull() {
        return this.stack1.size() + this.stack2.size() == capacity;
    }

    /**
     * @return
     * Get the capacity of queue
     */
    public int capacity() {
        return this.capacity;
    }

    /**
     * Traverse list
     */
    public void traverse() {

        while(!this.stack1.isEmpty()){
            this.stack2.push(this.stack1.pop());
        }

        if(!this.stack2.isEmpty())
            this.stack2.traverse();
    }
}
