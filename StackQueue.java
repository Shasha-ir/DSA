/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StackQueue;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1; // Stack for enqueue operations
    private Stack<Integer> stack2; // Stack for dequeue operations

    // Constructor to initialize the stacks
    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue an element into the queue
    public void enqueue(int value) {
        stack1.push(value);
        System.out.println("Enqueued: " + value);
    }

    // Dequeue an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Error value
        }
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int value = stack2.pop();
        System.out.println("Dequeued: " + value);
        return value;
    }

    // Peek the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Error value
        }
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");

        // To display, combine the two stacks' contents while maintaining FIFO order
        Stack<Integer> temp = new Stack<>();
        while (!stack2.isEmpty()) {
            temp.push(stack2.pop());
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + " ");
        }
        while (!temp.isEmpty()) {
            stack2.push(temp.pop());
        }
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }
        System.out.println();
    }

    // Main method to test the StackQueue
    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        queue.dequeue();

        queue.display();

        System.out.println("Front element: " + queue.peek());
    }
}

