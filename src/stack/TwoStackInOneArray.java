package stack;

public class TwoStackInOneArray {

    private int top1;
    private int top2;
    private int capacity;
    private int []arr;

    public TwoStackInOneArray(int capacity) {
        this.arr = new int[capacity];
        this.top1 = -1;
        this.top2 = capacity;
        this.capacity = capacity;
    }

    public boolean isFull() {
        return this.top1 == this.top2 - 1;
    }

    public boolean isEmpty() {
        return this.isEmpty1() && this.isEmpty2();
    }

    private boolean isEmpty1() {
        return this.top1 == -1;
    }

    private boolean isEmpty2() {
        return this.top2 == this.capacity;
    }

    public void push1(int data) {
        if(this.isFull()) {
            System.out.print("Stack is full");
            return;
        }

        this.top1 += 1;
        this.arr[this.top1] = data;
    }

    public void push2(int data) {
        if(this.isFull()) {
            System.out.print("Stack is fulle");
            return;
        }
        this.top2 -= 1;
        this.arr[this.top2] = data;
    }

    public int pop1() {
        if(this.isEmpty1()) {
            System.out.print("Stack is empty");
            return -1;
        }

        int data = this.arr[this.top1];
        this.top1 -= 1;
        return data;
    }

    public int pop2() {
        if(this.isEmpty2()) {
            System.out.print("Stack is empty");
            return -1;
        }

        int data = this.arr[this.top2];
        this.top2 += 1;
        return data;
    }

    public void traverse1() {

        if(this.isEmpty()) {
            System.out.print("The stack is empty");
            return;
        }
        for(int i = this.top1; i >= 0; i--) {
            System.out.print("\t" + this.arr[i] + "\t|");
        }
    }

    public void traverse2() {

        if(this.isEmpty()) {
            System.out.print("The stack is empty");
            return;
        }
        for(int i = this.top2; i < this.capacity; i++) {
            System.out.print("\t" + this.arr[i] + "\t|");
        }
    }
}
