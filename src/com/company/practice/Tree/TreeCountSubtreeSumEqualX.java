package com.company.practice.Tree;

public class TreeCountSubtreeSumEqualX {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(-10);
        tree.root.right = new Node(4);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(8);
        tree.root.right.left = new Node(-4);
        tree.root.right.right = new Node(7);
        countSubtreeEqualX(tree.root);
        System.out.println("Count of Subtree : " + count);
    }

    static final int X = 7;
    static int count = 0;
    public static int countSubtreeEqualX(Node root) {
        if (root == null){
            return 0;
        }
        int sum = countSubtreeEqualX(root.left) + countSubtreeEqualX(root.right) + root.data;
        if (sum == X) {
            count++;
        }
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
