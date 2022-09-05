package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

//A binary tree is converted to Sum Tree by replacing its root with sum of children, and leaf children as 0
public class TreeSumTree {
    public static void main(String[] args) {
        Tree binaryTree = new Tree();
        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(12);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(20);
        binaryTree.insert(9);
        binaryTree.insert(13);
        binaryTree.insert(11);
        binaryTree.insert(7);
        //createSumTree(binaryTree.getRootNode());
        binaryTree.traverseLevelOrder();
        System.out.println();
        createGreaterSumTree(binaryTree.getRootNode());
        binaryTree.traverseLevelOrder();
        System.out.println();

        BinaryTree tree=new BinaryTree();
        tree.root=new Node(34);
        tree.root.left=new Node(14);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(6);
        tree.root.right.right=new Node(3);
        tree.root.left.left.left=new Node(1);
        tree.root.left.left.right=new Node(3);
        int res = checkIfSumTree(tree.root);
        boolean check = true;
        if (res == -1) {
            check = false;
        }
        System.out.println("Is given binary tree Sum Tree : " + check);
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static int createSumTree(TreeNode root){
        if (root==null){
            return 0;
        }
        int sum=0, rootSum=0;
        sum = sum+createSumTree(root.getLeftChild());
        sum = sum+createSumTree(root.getRightChild());
        rootSum = rootSum + sum + root.getData();
        root.setData(sum);
        return rootSum;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    //Here sum tree leaf should not have 0 value;
    public static int checkIfSumTree(Node root) {
        if (root == null){
            return 0;
        }
        if (root.isLeaf()) {
            return root.data;
        }
        int lt= checkIfSumTree(root.left);
        int rt= checkIfSumTree(root.right);
        if (lt==-1 || rt==-1 || root.data!=(lt+rt)) {
            return -1;
        }
        return root.data+lt+rt;
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

        boolean isLeaf() {
            return (left==null) && (right==null);
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    //Sum tree with sum of all nodes greater than that node
    static int sum=0;
    public static void createGreaterSumTree(TreeNode root){
        if (root==null){
            return;
        }
        createGreaterSumTree(root.getRightChild());
        sum = sum + root.getData();
        root.setData(sum - root.getData());
        createGreaterSumTree(root.getLeftChild());
    }
}
