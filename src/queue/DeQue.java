package queue;

/**
 * This class is responsible to create a double ended queue. We will do following operations.
 *
 * 1. Insert at front.
 * 2. Insert at end.
 * 3. Delete from front.
 * 4. Delete from end.
 * 5. Traverse.
 * 6. isFull.
 * 7. isEmpty.
 * 8. size.
 */
public class DeQue {

    private int front;
    private int rear;
    private int capacity;
    private int size;
    private int queue[];

    public DeQue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = -1;
        this.size = 0;
    }

    /**
     * @param data
     * Insert data at the front of the queue.
     */
    public void insertAtFront(int data) {
        if(this.isFull()) {
            System.out.print("Queue is full");
            return;
        }

        if(this.front == -1 && this.rear == -1) {
            this.front = this.rear = 0;
        } else if(this.front == 0) {
            this.front = this.capacity - 1;
        } else {
            this.front -= 1;
        }
        this.queue[this.front] = data;
        this.size += 1;
    }

    /**
     * @param data
     * Insert data at the end of the queue.
     */
    public void insertAtEnd(int data) {
        if(this.isFull()) {
            System.out.print("Queue is full");
            return;
        }

        if(this.front == -1 && this.rear == -1) {
            this.front = this.rear = 0;
        } else{
            this.rear = (this.rear + 1) % this.capacity;
        }
        this.queue[this.rear] = data;
        this.size += 1;
    }

    /**
     * @return
     * Delete and return last element of the queue.
     */
    public int deleteFromFront() {
        if(this.isEmpty()) {
            System.out.print("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int data = this.queue[this.front];

        if(this.front == this.rear) {
            this.front = this.rear = -1;
        } else {
            this.front = (this.front + 1) % this.capacity;
        }

        this.size -= 1;
        return data;
    }

    /**
     * @return
     * Delete and return last element of the queue.
     */
    public int deleteFromEnd() {
        if(this.isEmpty()) {
            System.out.print("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int data = this.queue[this.rear];

        if(this.front == this.rear) {
            this.front = this.rear = -1;
        } else if(this.rear == 0) {
            this.rear = this.capacity - 1;
        } else {
            this.rear -= 1;
        }

        this.size -= 1;
        return data;
    }

    /**
     * @return
     * Return size of the queue.
     */
    public int size() {
        return this.size;
    }

    /**
     * @return
     * Return true if full.
     */
    public boolean isFull() {
        return (this.rear + 1) % this.capacity == this.front;
    }

    /**
     * @return
     * Returns true if empty.
     */
    public boolean isEmpty() {
        return this.rear == -1 && this.front == -1;
    }

    /**
     * Traverse queue and print all the elements.
     */
    public void travers() {

        if(this.isEmpty()) {
            System.out.print("Queue is empty.");
            return;
        }
        int i = this.front;
        while(i != this.rear) {
            System.out.print("\t" + this.queue[i] + "\t|");
            i = (i + 1) % this.capacity;
        }
        System.out.print("\t" + this.queue[i] + "\t|");
    }
}
