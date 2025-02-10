/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchTree;

class BinarySearchTree {

    // Definition of a tree node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the tree
    private Node root;

    // Constructor to initialize an empty tree
    public BinarySearchTree() {
        root = null;
    }

    // Insert a value into the tree
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive helper method for insertion
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Search for a value in the tree
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive helper method for searching
    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        return value < root.data
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }

    // Delete a value from the tree
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    // Recursive helper method for deletion
    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal (sorted order)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Recursive helper method for in-order traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("In-order traversal: ");
        bst.inorder();

        // Search for an element
        System.out.println("Search 40: " + bst.search(40)); // true
        System.out.println("Search 90: " + bst.search(90)); // false

        // Delete an element
        bst.delete(30);
        System.out.print("In-order traversal after deletion: ");
        bst.inorder();
    }
}
