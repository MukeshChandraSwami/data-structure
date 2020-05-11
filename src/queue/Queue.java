package queue;

public class Queue {

    private int capacity;
    private int size;
    private int front;
    private int rear;
    private int [] queue;

    public Queue(int capacity) {
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
            this.rear += 1;
        }

        this.queue[this.rear] = data;
        this.size += 1;
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
            this.front += 1;

        return data;
    }

    public boolean isFull() {

        return this.rear == this.capacity - 1;
    }

    public boolean isEmpty() {

        return front == -1 || front > rear;
    }

    public int getSize() {
        return this.size;
    }

    public void travers() {

        if(this.isEmpty()) {
            System.out.print("Queue is empty.");
            return;
        }

        for(int i = front; i <= rear; i++) {
            System.out.print("\t" + this.queue[i] + "\t|");
        }
    }

    public void reverse() {
        if(this.isEmpty())
            return;
        int data = this.dequeue();
        reverse();
        this.enqueue(data);
    }

    public void sort() {

        if(this.isEmpty())
            return;
        int data = this.dequeue();
        sort();

        sort(data);
    }

    private void sort(int data) {
        if(this.isEmpty()) {
            this.enqueue(data);
            return;
        }

        Queue q = new Queue(this.capacity);
        boolean insert = true;
        while(!this.isEmpty()) {
            int d = this.dequeue();
            if(d > data && insert) {
                q.enqueue(data);
                insert = false;
            }
            q.enqueue(d);
        }

        if(insert)
            q.enqueue(data);

        while (!q.isEmpty()){
            this.enqueue(q.dequeue());
        }
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
