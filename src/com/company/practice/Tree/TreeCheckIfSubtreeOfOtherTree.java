package com.company.practice.Tree;

public class TreeCheckIfSubtreeOfOtherTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);

        System.out.println("Check if Subtree : " + checkSubtree(tree.root1, tree.root2));
    }

    public static boolean areIdentical(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1==null || n2==null) {
            return false;
        }
        return n1.data == n2.data && areIdentical(n1.left, n2.left) && areIdentical(n1.right, n2.right);
    }
    public static boolean checkSubtree(Node T, Node S) {
        if (S==null) {
            return true;
        }
        if (T==null){
            return false;
        }
        if (areIdentical(T, S)) {
            return true;
        }
        return checkSubtree(T.left, S) || checkSubtree(T.right, S);
    }
    static class BinaryTree{
        Node root1, root2;
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
