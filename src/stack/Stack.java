package stack;

/**
 * This class represents stack of Integers via Array.
 * Operations :-
 * 1. Push
 * 2. Pop
 * 3. Size
 * 4. Peek
 * 5. isEmpty
 */
public class Stack {

    private int []stack;
    private int top = -1;

    /**
     * @param capacity
     * Initialization of the stack
     */
    public Stack(int capacity) {
        this.stack = new int[capacity];
    }


    /**
     * @param data
     * Push a element in stack
     */
    public void push(int data) {
        if(this.top == this.stack.length - 1) {
            System.out.print("\tStack is full.");
            return;
        }
        this.top += 1;
        this.stack[this.top] = data;
    }

    /**
     * @return
     * Pop data from stack
     */
    public int pop() {
        if(this.isEmpty()) {
            System.out.print("Stack is empty");
            return -1;
        }
        int data = this.stack[this.top];
        this.top -= 1;
        return data;
    }

    /**
     * @return
     * Similar to pop operation but difference is that top element will not be deleted.
     */
    public int peek() {
        if(this.isEmpty()) {
            System.out.print("Stack is empty");
            return -1;
        }
        return this.stack[this.top];
    }

    /**
     * @return
     * Check if stack is empty or not
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * @return
     * Return size of the stack.
     */
    public int size() {
        return this.top + 1;
    }

    public int capacity() {
        return this.stack.length;
    }

    public void traverse() {
        if(this.isEmpty()) {
            System.out.print("The stack is empty");
            return;
        }
        for(int i = this.top; i >= 0; i--) {
            System.out.print("\t" + this.stack[i] + "\t|");
        }
    }

    public void reverse() {

        if(this.isEmpty())
            return;

        int data = this.pop();

        reverse();

        // Insert data at bottom.
        insertAtBottom(data);
    }

    private void insertAtBottom(int data) {

        if(this.isEmpty()) {
            this.push(data);
            return;
        }

        int d = this.pop();
        insertAtBottom(data);
        this.push(d);

    }
}
