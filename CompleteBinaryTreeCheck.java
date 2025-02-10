/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompleteBinaryTree;

/**
 *
 * @author Shasha
 */
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    // Function to check if a binary tree is complete
    public boolean isComplete(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean foundNull = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                foundNull = true;
            } else {
                if (foundNull) return false; // If we found a null before, tree is not complete
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }
}

public class CompleteBinaryTreeCheck {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Creating a complete binary tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);

        // Checking if the tree is complete
        System.out.println("Is the tree complete? " + tree.isComplete(tree.root));
    }
}
