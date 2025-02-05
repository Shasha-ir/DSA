/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList;

/**
 *
 * @author Shasha
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add nodes
        list.append(10);
        list.append(20);
        list.append(30);

        // Display the list
        System.out.println("Initial list:");
        System.out.println(list);

        // Insert at the beginning
        list.insertBeginning(5);
        System.out.println("After inserting 5 at the beginning:");
        System.out.println(list);

        // Insert after a specific value
        list.insertAfter(15, 10);
        System.out.println("After inserting 15 after 10:");
        System.out.println(list);

        // Insert before a specific value
        list.insertBefore(18, 20);
        System.out.println("After inserting 18 before 20:");
        System.out.println(list);

        // Find the last node
        Node last = list.findLast();
        System.out.println("Last node is: " + (last != null ? last.data : "null"));

        // Delete the first node
        list.deleteFirst();
        System.out.println("After deleting the first node:");
        System.out.println(list);

        // Delete the last node
        list.deleteLast();
        System.out.println("After deleting the last node:");
        System.out.println(list);

        // Remove a specific node
        list.delete(18);
        System.out.println("After deleting 18:");
        System.out.println(list);
    }
}
