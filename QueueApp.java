/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package boundedQueue;

public class QueueApp {

    public static void main(String[] args) {
        BoundedArrayQueue theQueue = new BoundedArrayQueue(5); // Create a queue with max size 5

        // Enqueue elements
        theQueue.enqueue(10);
        theQueue.enqueue(20);
        theQueue.enqueue(30);
        theQueue.enqueue(40);
        theQueue.enqueue(50);

        // Display the queue
        theQueue.display();

        // Peek the front element
        System.out.println("Front element is: " + theQueue.peek());

        // Dequeue elements
        System.out.println("Dequeued: " + theQueue.dequeue());

        // Display the queue after dequeue operations
        theQueue.display();
    }
}

