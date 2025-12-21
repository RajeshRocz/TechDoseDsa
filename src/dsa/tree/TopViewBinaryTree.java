package dsa.tree;

import java.util.*;

// Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

// Pair class to hold node with horizontal distance
class Pair {
    Node node;
    int hd;  // horizontal distance from root

    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}

public class TopViewBinaryTree {

    public static void printTopView(Node root) {
        if (root == null)
            return;

        // TreeMap to store top view: horizontal distance -> node data
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int hd = current.hd;
            Node node = current.node;

            // Add to map if hd is not present
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            if (node.left != null)
                queue.add(new Pair(node.left, hd - 1));
            if (node.right != null)
                queue.add(new Pair(node.right, hd + 1));
        }

        // Print the top view
        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
    }

    // Sample usage
    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Top view of the binary tree is:");
        printTopView(root);
    }
}

