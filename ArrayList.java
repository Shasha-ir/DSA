/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArrayListLab;

/**
 *
 * @author Shasha
 */
//This file defines a custom implementation of a dynamic array.
import java.util.NoSuchElementException;

//constructor
public class ArrayList {

    private int[] array; // Array to hold the list elements
    private int noOfElements;    // Current size of the list

    // Constructor
    public ArrayList(int capacity) {
        array = new int[capacity];
        noOfElements = 0;
    }

    // Add an element to the end
    public void add(int value) {
        if (noOfElements == array.length) {
            resize(); // Resize if the array is full
        }
        array[noOfElements++] = value;
    }

    // Insert an element at a specific index
    public void insert(int index, int value) {
        if (index < 0 || index > noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (noOfElements == array.length) {
            resize();
        }
        for (int i = noOfElements; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        noOfElements++;
    }

    // Delete an element at a specific index
    public void delete(int index) {
        if (index < 0 || index >= noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < noOfElements - 1; i++) {
            array[i] = array[i + 1];
        }
        noOfElements--;
    }

    // Get an element at a specific index
    public int get(int index) {
        if (index < 0 || index >= noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    // Update an element at a specific index
    public void update(int index, int value) {
        if (index < 0 || index >= noOfElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        array[index] = value;
    }

    // Find an element by its value
    public int find(int value) {
        for (int i = 0; i < noOfElements; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        throw new NoSuchElementException("Value not found."); // Return -1 if not found
    }

    // Display the list
    public void display() {
        System.out.print("[");
        for (int i = 0; i < noOfElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return noOfElements == 0;
    }

    // Get the size of the list
    public int size() {
        return noOfElements;
    }

    // Helper method to resize the array
    private void resize() {
        int[] newArray = new int[array.length * 2]; // Double the capacity
        for (int i = 0; i < noOfElements; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

}
