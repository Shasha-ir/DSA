/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList;

/**
 *
 * @author Shasha
 */
public class LinkedList {
    private Node head; // Head of the list

    // Add a new node to the end of the list
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newNode; // Link the new node at the end
        }
    }

    // Insert at the beginning of the list
    public void insertBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert after a specific value
    public void insertAfter(int data, int afterValue) {
        Node current = head;
        while (current != null && current.data != afterValue) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value " + afterValue + " not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Find the last node
    public Node findLast() {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    // Find a specific node
    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null; // Value not found
    }

    // Insert before a specific value
    public void insertBefore(int data, int beforeValue) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == beforeValue) {
            insertBeginning(data); // Special case: insert before head
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != beforeValue) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value " + beforeValue + " not found.");
        } else {
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete the first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) { // Only one node in the list
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) { // Traverse to the second last node
            current = current.next;
        }
        current.next = null; // Remove the last node
    }

    // Remove a node by its value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == data) {
            head = head.next; // Remove the head node if it matches the value
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next; // Traverse until the node before the target node
        }

        if (current.next == null) {
            System.out.println("Element not found."); // Value not in the list
        } else {
            current.next = current.next.next; // Unlink the target node
        }
    }

    // Override toString() to display the linked list
    @Override
    public String toString() {
        if (head == null) {
            return "List is empty.";
        }

        StringBuilder result = new StringBuilder();
        Node current = head;

        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }

        result.append("null");
        return result.toString();
    }
}

