package queue;

public class CircularQueue {

    private int capacity;
    private int size;
    private int front;
    private int rear;
    private int [] queue;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data) {

        if(this.isFull()) {
            System.out.print("Queue is full.");
            return;
        }

        if(this.rear == -1 && this.front == -1) {
            this.rear = this.front = 0;
        } else {
            this.rear = (this.rear + 1) % this.capacity;
        }

        this.size += 1;
        this.queue[this.rear] = data;
    }

    public int dequeue() {

        if(this.isEmpty()) {
            System.out.print("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int data = this.queue[this.front];
        this.size -= 1;
        if(this.front == this.rear)
            this.front = this.rear = -1;
        else
            this.front = (this.front + 1) % this.capacity;
        return data;
    }

    public boolean isFull() {

        return (this.rear + 1) % this.capacity == this.front;
    }

    public boolean isEmpty() {

        return front == -1 && this.rear == -1;
    }

    public int getSize() {
        return this.size;
    }

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

    public int getFront() {

        if(this.isEmpty()) {
            System.out.print("Queue is empty");
            return Integer.MIN_VALUE;
        }

        return this.queue[this.front];
    }

    public int getRear() {

        if(this.isEmpty()) {
            System.out.print("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return this.queue[this.rear];
    }

}
