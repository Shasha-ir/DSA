/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package boundedQueue;

import java.util.NoSuchElementException;

public class BoundedArrayQueue {

    private int maxSize; // size of the queue array
    private int[] array;
    private int front; // front of the queue
    private int rear; // rear of the queue
    private int nItems; // number of items in the queue

    public BoundedArrayQueue(int s) {
        maxSize = s; // set array size
        array = new int[maxSize];
        front = 0; // index of the front element
        rear = -1; // index before the first element
        nItems = 0; // no items in the queue initially
    }

    // Enqueue operation
    public void enqueue(int j) {
        if (isFull()) {
        	throw new IllegalStateException("Stack is full.");
        } else {
            rear++; // Move rear forward
            array[rear] = j; // Insert the element
            nItems++; // Increment the item count
        }
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty."); // Return a sentinel value to indicate an error
        } else {
            int temp = array[front]; // Get the front element
            front++; // Move front forward
            nItems--; // Decrease item count
            return temp;
        }
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty"); // Return a sentinel value
        } else {
            return array[front]; // Return the front element
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear == maxSize - 1);
    }

    // Display the contents of the queue
    public void display() {
            System.out.print("Queue elements (front to rear): [");
            for (int i = front; i <= rear; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("]");
        }
    }

