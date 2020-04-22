package queue;

import dto.QueueDto;

/**
 * This class represents Priority Queue.
 * There can be 2 types of it.
 * 1. Insertion operation will be done in O(N) and deletion in O(1)     ->  Prioritization should be done at the time of insertion.
 * 2. Insertion operation will be done in O(1) and deletion in O(N)     ->  Prioritization should be done at the time of deletion.
 *
 * So this class will be priority circular queue representation with Type-1 algo.
 */
public class PriorityCircularQueue {

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private QueueDto[] queue;

    public PriorityCircularQueue(int capacity) {

        this.front = this.rear = 1;
        this.size = 0;
        this.capacity = capacity;
        this.queue = new QueueDto[capacity];
    }

    public void enqueue(int data, int priority) {

        if(this.isFull()) {
            System.out.print("Queue is full");
            return;
        } else if(this.rear == -1 && this.front == -1) {
            this.rear = this.front = 0;
        } else {
            this.rear = (this.rear + 1) % this.capacity;
        }

        QueueDto queueDto = new QueueDto(data, priority);

        int index = -1;
        int i = this.front;
        /*while(priority < this.queue[i].getPriority() && i != this.rear) {
            i = (i + 1) % this.capacity;
        }*/

        // TODO : Insertion is pending. Will complete on sunday.
    }

    public int dequeue() {
        if(this.isEmpty()) {
            System.out.print("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int data = this.queue[this.front].getData();
        if(this.rear == this.front) {
            this.rear = this.front = -1;
        } else {
            this.front = (this.front + 1) % this.capacity;
        }
        return data;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.capacity == this.front;
    }

    public boolean isEmpty() {
        return (this.rear == -1 && this.front == -1) || !this.isFull();
    }

}
