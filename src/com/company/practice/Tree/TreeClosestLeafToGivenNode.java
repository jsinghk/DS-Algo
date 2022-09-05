package com.company.practice.Tree;

public class TreeClosestLeafToGivenNode {

    public static void main(String[] args) {
        TreeClosestLeafToGivenNode.BinaryTree tree = new TreeClosestLeafToGivenNode.BinaryTree();
        tree.root=new TreeClosestLeafToGivenNode.Node(20);
        tree.root.left=new TreeClosestLeafToGivenNode.Node(8);
        tree.root.right=new TreeClosestLeafToGivenNode.Node(22);
        tree.root.left.left=new TreeClosestLeafToGivenNode.Node(5);
        tree.root.left.right=new TreeClosestLeafToGivenNode.Node(3);
        tree.root.right.left=new TreeClosestLeafToGivenNode.Node(4);
        tree.root.right.right=new TreeClosestLeafToGivenNode.Node(25);
        tree.root.left.right.left=new TreeClosestLeafToGivenNode.Node(10);
        tree.root.left.right.right=new TreeClosestLeafToGivenNode.Node(14);

        closestLeaf(tree.root.left.right.right, 0);
        System.out.println("Closest Leaf : " + leaf);

    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    static int minDepth = Integer.MAX_VALUE;
    static int leaf=0;
    public static void closestLeaf(Node root, int depth) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right==null) {
            if (depth < minDepth) {
                minDepth = depth;
                leaf = root.data;
            }
            return;
        }
        closestLeaf(root.left, depth+1);
        closestLeaf(root.right, depth+1);
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
