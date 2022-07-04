package com.company.practice.Tree;

import java.util.HashSet;
import java.util.Set;

public class TreeFromGivenOrders {

    public static void main(String[] args) {
        char[] inOrder = {'D','B','E','A','F','C'};
        char[] preOrder = {'A','B','D','E','C','F'};
        char[] levelOrder = {'A','B','C','D','E','F'};
        char[] postOrder = {'D','E','B','F','C','A'};
        Tree tree = new Tree();
        tree.rootNode = createTreeFromInorderAndPreorder(inOrder, preOrder, 0, inOrder.length);
        tree.traverseInorder();
        System.out.println();
        Tree tree1 = new Tree();
        tree1.rootNode = createTreeFromInorderAndLevelOrder(inOrder, levelOrder, 0, inOrder.length-1, inOrder.length);
        tree1.traverseInorder();
        System.out.println();
        Tree tree2 = new Tree();
        tree2.rootNode = createTreeFromPreOrderAndPostOrder(preOrder, postOrder);
        tree2.traverseInorder();
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

    //Time complexity is O(n2)
    //Space complexity is O(n) for recursive stack
    static int pInd = 0;
    public static Node createTreeFromInorderAndPreorder(char[] inOrder, char[] preOrder, int st, int end) {
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
        tree.rootNode.left = createTreeFromInorderAndPreorder(inOrder,preOrder,st,index);
        tree.rootNode.right = createTreeFromInorderAndPreorder(inOrder,preOrder,index+1,end);
        return tree.rootNode;
    }

    //Time complexity is O(n2)
    //Space complexity is O(n) for arrays
    public static Node createTreeFromInorderAndLevelOrder(char[] inOrder, char[] levelOrder, int st, int end, int n) {
        if (n<=0) {
            return null;
        }
        Node root =  new Node(levelOrder[0]);

        int index=-1;
        for (int i=st; i<=end; i++) {
            if (inOrder[i] == root.data) {
                index=i;
                break;
            }
        }
        Set<Character> s = new HashSet<>();
        for(int i=st; i<index; i++) {
            s.add(inOrder[i]);
        }
        int li = 0, ri = 0;
        char[] llo = new char[index-st];
        char[] rlo = new char[end-index];
        for (int i=1; i<n; i++){
            if (s.contains(levelOrder[i])){
                llo[li++] = levelOrder[i];
            } else {
                rlo[ri++] = levelOrder[i];
            }
        }
        root.left = createTreeFromInorderAndLevelOrder(inOrder, llo, st, index-1, index-st);
        root.right = createTreeFromInorderAndLevelOrder(inOrder, rlo, index+1, end, end-index);
        return root;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    static int preInd = 0, postInd=0;
    public static Node createTreeFromPreOrderAndPostOrder(char[] preOrder, char[] postOrder) {
        if (preInd == preOrder.length) {
            return null;
        }
        if (preOrder[preInd] == postOrder[postInd]) {
            return new Node(preOrder[preInd]);
        }
        Node root = new Node(preOrder[preInd++]);
        root.left = createTreeFromPreOrderAndPostOrder(preOrder, postOrder);
        preInd++;
        postInd++;
        root.right = createTreeFromPreOrderAndPostOrder(preOrder, postOrder);
        postInd++;
        return root;
    }
}
