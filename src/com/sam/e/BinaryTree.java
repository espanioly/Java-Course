package com.sam.e;
import java.util.LinkedList;
import java.util.Queue;

// Made with DeepSeek-R1

class BinaryTree {
    private TreeNode root;

    BinaryTree() {
        this.root = null;
    }

    // Insert a new node
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // toString method to represent the tree as a list in level-order
    @Override
    public String toString() {
        if (root == null) {
            return "root = []"; // Empty tree
        }

        StringBuilder sb = new StringBuilder("root = [");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Remove the node from the queue
            sb.append(current.data); // Append its data

            // Add the left child to the queue if it exists
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add the right child to the queue if it exists
            if (current.right != null) {
                queue.add(current.right);
            }

            // Add a comma if there are more nodes
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}

