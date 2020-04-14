package stack;

import dto.StackDto;

public class StackO1 {

    private StackDto[]stack;
    private int top = -1;

    /**
     * @param capacity
     * Initialization of the stack
     */
    public StackO1(int capacity) {
        this.stack = new StackDto[capacity];
    }


    /**
     * @param data
     * Push a element in stack
     */
    public void push(int data) {
        int min = 0;
        int max = 0;
        if(this.top == this.stack.length - 1) {
            System.out.print("\tStack is full.");
            return;
        }
        if(this.isEmpty()) {
            min = data;
            max = data;
        } else {
            StackDto peek = this.peek();
            min = peek.getMin() <= data ? peek.getMin() : data;
            max = peek.getMax() >= data ? peek.getMax() : data;
        }

        this.top += 1;
        this.stack[this.top] = new StackDto(min,max,data);
    }

    /**
     * @return
     * Pop data from stack
     */
    public StackDto pop() {
        if(this.isEmpty()) {
            System.out.print("Stack is empty");
            return null;
        }
        StackDto data = this.stack[this.top];
        this.top -= 1;
        return data;
    }

    /**
     * @return
     * Similar to pop operation but difference is that top element will not be deleted.
     */
    public StackDto peek() {
        if(this.isEmpty()) {
            System.out.print("Stack is empty");
            return null;
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
     * Checks if stack is full or not
     */
    public boolean isFull() {
        return  this.top == this.stack.length - 1;
    }

    /**
     * @return
     * Return size of the stack.
     */
    public int size() {
        return this.top + 1;
    }

    /**
     * @return
     * Returns the capacity of the stack
     */
    public int capacity() {
        return this.stack.length;
    }

    /**
     * Traverse the stack
     */
    public void traverse() {
        if(this.isEmpty()) {
            System.out.print("The stack is empty");
            return;
        }
        for(int i = this.top; i >= 0; i--) {
            System.out.print("\t" + this.stack[i].getData() + "\t|");
        }
    }

    /**
     * @return
     * Return the minimum element of the stack
     */
    public int getMin() {
        if(this.isEmpty()) {
            System.out.print(" Stack is empty");
            return -1;
        }
        return this.peek().getMin();
    }

    /**
     * @return
     * Returns the max element of the stack
     */
    public int getMax() {
        if(this.isEmpty()) {
            System.out.print(" Stack is empty");
            return -1;
        }
        return this.peek().getMax();
    }

    /*public void reverse() {

        if(this.isEmpty())
            return;

        StackDto data = this.pop();

        reverse();

        // Insert data at bottom.
        insertAtBottom(data);
    }

    private void insertAtBottom(StackDto data) {

        if(this.isEmpty()) {
            this.push(data);
            return;
        }

        StackDto d = this.pop();
        insertAtBottom(data);
        this.push(d);

    }*/
}
