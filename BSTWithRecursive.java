/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchTree;

class BSTWithRecursive {

    // Definition of a Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root; // Root of the BST

    // Constructor
    public BSTWithRecursive() {
        root = null;
    }

    // Recursive method to insert a new value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

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

    // Recursive method to search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false; // Value not found
        }
        if (root.data == value) {
            return true; // Value found
        }
        return value < root.data
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }

    // Recursive in-order traversal (sorted order)
    public void inorder() {
        System.out.print("In-order traversal: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Recursive pre-order traversal
    public void preorder() {
        System.out.print("Pre-order traversal: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Recursive post-order traversal
    public void postorder() {
        System.out.print("Post-order traversal: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Recursive method to delete a value from the BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root; // Value not found
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

            // Node with two children: Get the inorder successor
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

    // Main method to test the BSTWithRecursive class
    public static void main(String[] args) {
        BSTWithRecursive bst = new BSTWithRecursive();

        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Traversals
        bst.inorder(); // 20 30 40 50 60 70 80
        bst.preorder(); // 50 30 20 40 70 60 80
        bst.postorder(); // 20 40 30 60 80 70 50

        // Search for values
        System.out.println("Search 40: " + bst.search(40)); // true
        System.out.println("Search 100: " + bst.search(100)); // false

        // Delete an element
        bst.delete(30);
        bst.inorder(); // 20 40 50 60 70 80
    }
}
