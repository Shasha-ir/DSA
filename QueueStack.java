/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private Queue<Integer> queue1; // Primary queue
    private Queue<Integer> queue2; // Secondary queue for intermediate operations

    // Constructor to initialize the queues
    public QueueStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push an element onto the stack
    public void push(int value) {
        // Add the new element to queue2
        queue2.add(value);

        // Transfer all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the queues: queue2 becomes the primary queue
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        System.out.println("Pushed: " + value);
    }

    // Pop an element from the stack
    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Error value
        }
        int value = queue1.remove();
        System.out.println("Popped: " + value);
        return value;
    }

    // Peek the top element of the stack
    public int peek() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Error value
        }
        return queue1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Display all elements in the stack
    public void display() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements (top to bottom): " + queue1);
    }

    // Main method to test the QueueStack
    public static void main(String[] args) {
        QueueStack stack = new QueueStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        stack.pop();

        stack.display();

        System.out.println("Top element: " + stack.peek());
    }
}

