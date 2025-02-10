/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundedStack;

public class BoundedStack<T> {
    private T[] stack;
    private int capacity;
    private int top;

    // Constructor
    public BoundedStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
        this.top = -1; // Stack is empty
    }

    // Push an element onto the stack
    public void push(T element) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. Cannot push element.");
        }
        stack[++top] = element;
    }

    // Pop an element from the stack
    public T pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop element.");
        }
        T element = stack[top];
        stack[top--] = null; // Clear the slot and decrement top
        return element;
    }

    // Peek the top element without removing it
    public T peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get the current size of the stack
    public int size() {
        return top + 1;
    }

    // Get the capacity of the stack
    public int getCapacity() {
        return capacity;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        BoundedStack<Integer> stack = new BoundedStack<>(5);

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println("Top element: " + stack.peek()); // 30
            System.out.println("Popped element: " + stack.pop()); // 30
            System.out.println("Current size: " + stack.size()); // 2

            stack.push(40);
            stack.push(50);
            stack.push(60);
            System.out.println("Is stack full? " + stack.isFull()); // true

            while (!stack.isEmpty()) {
                System.out.println("Popped: " + stack.pop());
            }

            System.out.println("Is stack empty? " + stack.isEmpty()); // true
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
