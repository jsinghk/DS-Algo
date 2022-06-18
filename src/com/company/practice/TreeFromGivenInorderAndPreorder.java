package com.company.practice;

import java.util.Arrays;

public class TreeFromGivenInorderAndPreorder {
    static int pInd = 0;
    public static void main(String[] args) {
        char[] inOrder = {'D','B','E','A','F','C'};
        char[] preOrder = {'A','B','D','E','C','F'};
        Tree tree = new Tree();
        tree.rootNode = createTree(inOrder, preOrder, 0, inOrder.length);
        tree.traverseInorder();
    }

    //Time complexity is O(n2)
    //Space complexity is O(n) for recursive stack
    public static Node createTree(char[] inOrder, char[] preOrder, int st, int end) {
        if (st>=end) {
            return null;
        }

        Tree tree = new Tree();
        Node root = new Node(preOrder[pInd++]);
        tree.rootNode = root;
        if (st==end-1) {
            return root;
        }
        int index=-1;
        for (int i=st; i<end; i++) {
            if (inOrder[i] == root.data) {
                index = i;
                break;
            }
        }
        tree.rootNode.left = createTree(inOrder,preOrder,st,index);
        tree.rootNode.right = createTree(inOrder,preOrder,index+1,end);
        return tree.rootNode;
    }

    static class Tree{
        Node rootNode;
        void traverseInorder() {
            rootNode.traverseInorder();
        }
    }
    static class Node{
        Node left;
        Node right;
        char data;
        Node(char data){
            this.data = data;
        }
        void traverseInorder() {
            if (left != null) {
                left.traverseInorder();
            }
            System.out.print(data + " - ");
            if (right != null) {
                right.traverseInorder();
            }
        }
    }
}
