package com.company.practice.Tree;

import java.util.HashMap;
import java.util.Map;

public class TreeMaxSumWithNoAdjacent {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(1);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(5);
        System.out.println("Max Sum : " + maxSum(tree.root));
    }

    static Map<Node, Integer> map = new HashMap<>();
    public static int maxSum(Node root) {
        if (root == null) {
            return 0;
        }
        if(map.containsKey(root)){
            map.get(root);
        }

        int inc = root.data;
        if (root.left != null){
            inc += maxSum(root.left.left) + maxSum(root.left.right);
        }
        if (root.right != null) {
            inc += maxSum(root.right.left) + maxSum(root.right.right);
        }

        int exc = maxSum(root.left) + maxSum(root.right);

        map.put(root, Math.max(inc, exc));
        return Math.max(inc, exc);
    }
    static class BinaryTree{
        Node root;
    }
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
}
