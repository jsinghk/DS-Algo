package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.Stack;

public class TreeTraversalStack {

    public static void main(String[] args) {
        Tree binaryTree = new Tree();
        binaryTree.insert(25);
        binaryTree.insert(20);
        binaryTree.insert(27);
        binaryTree.insert(15);
        binaryTree.insert(30);
        binaryTree.insert(32);
        binaryTree.insert(22);
        binaryTree.insert(29);
        binaryTree.insert(26);
        binaryTree.insert(17);
        binaryTree.insert(21);

        inorderTraverse(binaryTree.getRootNode());
        System.out.println();
        preorderTraverse(binaryTree.getRootNode());
        System.out.println();
        postorderTraverse(binaryTree.getRootNode());
    }

    //Time complexity is O(n)
    //Space complexity is O(n)
    public static void inorderTraverse(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.getLeftChild();
            }
            curr = st.pop();
            System.out.print(curr.getData() + " - ");
            curr = curr.getRightChild();
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(h)
    public static void preorderTraverse(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !st.isEmpty()){
            while (curr!=null){
                System.out.print(curr.getData() + " - ");
                if (curr.getRightChild() != null){
                    st.push(curr.getRightChild());
                }
                curr = curr.getLeftChild();
            }
            if (!st.isEmpty()) {
                curr = st.pop();
            }
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(n)
    public static void postorderTraverse(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.add(root);
        while (!st1.isEmpty()){
            TreeNode temp = st1.pop();
            st2.push(temp);
            if (temp.getLeftChild() != null){
                st1.push(temp.getLeftChild());
            }
            if (temp.getRightChild() != null){
                st1.push(temp.getRightChild());
            }
        }
        while (!st2.isEmpty()){
            System.out.print(st2.pop().getData() + " - ");
        }
    }
}