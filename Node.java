/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList;

/**
 *
 * @author Shasha
 */
public class Node {
    public int data; // Value of the node
    public Node next; // Reference to the next node

	// Constructor to initialize a node
    public Node(int data) {
        this.data = data;
        this.next = null; // By default, the next reference is null
    }
}

