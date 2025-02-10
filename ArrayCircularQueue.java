/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArrayCircularQ;

public class ArrayCircularQueue {
    private int[] queue;   // Array to store queue elements
    private int front;     // Points to the front of the queue
    private int rear;      // Points to the rear of the queue
    private int size;      // Maximum capacity of the queue
    private int count;     // Number of elements in the queue

    // Constructor to initialize the queue
    public ArrayCircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == size;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Add an element to the queue
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return;
        }
        rear = (rear + 1) % size; // Circular increment
        queue[rear] = element;
        count++;
        System.out.println("Enqueued: " + element);
    }

    // Remove and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return -1 to indicate an error
        }
        int element = queue[front];
        front = (front + 1) % size; // Circular increment
        count--;
        System.out.println("Dequeued: " + element);
        return element;
    }

    // Peek the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Return -1 to indicate an error
        }
        return queue[front];
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % size] + " ");
        }
        System.out.println();
    }

    // Main method to test the ArrayCircularQueue
    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

        queue.dequeue();
        queue.dequeue();

        queue.display();

        queue.enqueue(60);
        queue.enqueue(70);

        queue.display();
        System.out.println("Front element: " + queue.peek());
    }
}

