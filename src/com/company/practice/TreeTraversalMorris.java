package com.company.practice;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

public class TreeTraversalMorris {

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
        inorder(binaryTree.getRootNode());
        System.out.println();
        preorder(binaryTree.getRootNode());
    }

    //Time complexity is O(n)
    public static void inorder(TreeNode root) {
        TreeNode pre; //predecessor
        TreeNode curr = root;
        while (curr != null) {
            //If Left Child is NULL, print curr and go to Right Child
            if (curr.getLeftChild() == null) {
                System.out.print(curr.getData() + " - ");
                curr = curr.getRightChild();
            } else {
                //Go to rightmost child of the Left Child
                pre = curr.getLeftChild();
                while (pre.getRightChild() != null && pre.getRightChild() != curr) {
                    pre = pre.getRightChild();
                }

                //Link right child to successor
                //Set curr as Right Child of pre and go to curr Left Child
                if (pre.getRightChild() == null) {
                    pre.setRightChild(curr);
                    curr = curr.getLeftChild();
                } else {
                    //Unlink right child and successor
                    //Print curr and Revert the changes if pre already has Right Child(curr)
                    // and go to curr Right Child
                    System.out.print(curr.getData() + " - ");
                    pre.setRightChild(null);
                    curr = curr.getRightChild();
                }
            }
        }
    }

    //Time complexity is O(n)
    public static void preorder(TreeNode root) {
        TreeNode pre; //predecessor
        TreeNode curr = root;
        while (curr != null) {
            //If Left Child is NULL, print node and go to Right Child
            if (curr.getLeftChild() == null) {
                System.out.print(curr.getData() + " - ");
                curr = curr.getRightChild();
            } else {
                pre = curr.getLeftChild();
                //Go to rightmost child of the Left Child
                while (pre.getRightChild() != null && pre.getRightChild() != curr) {
                    pre = pre.getRightChild();
                }

                //Unlink right child and successor
                //Revert the changes if pre already has Right Child(curr)
                // and go to curr Right Child
                if (pre.getRightChild() == curr) {
                    pre.setRightChild(null);
                    curr = curr.getRightChild();
                } else {
                    //Link right child to successor
                    //Set curr as Right Child of pre and go to curr Left Child
                    System.out.print(curr.getData() + " - ");
                    pre.setRightChild(curr);
                    curr = curr.getLeftChild();
                }
            }
        }
    }
}
