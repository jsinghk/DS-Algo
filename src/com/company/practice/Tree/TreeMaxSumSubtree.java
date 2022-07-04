package com.company.practice.Tree;

import java.util.HashMap;
import java.util.Map;

public class TreeMaxSumSubtree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(-7);
        tree.root.right.right = new Node(2);
        maxSum(tree.root);
        System.out.println("Max Sum : " + maxVal);
    }

    static int maxVal = 0;
    public static int maxSum(Node root) {
        if (root == null){
            return 0;
        }
        int sum = maxSum(root.left) + maxSum(root.right) + root.data;
        maxVal = Math.max(maxVal, sum);
        return sum;
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
