package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalDiagonal {

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

        //leftUpToRightDown(binaryTree.getRootNode());
        rightUpToLeftDown(binaryTree.getRootNode());
    }

    //Time complexity is O(n)
    //Space complexity is O(n)
    public static void leftUpToRightDown(TreeNode root) {
        Queue<TreeNode> qu1 = new ArrayDeque<>();
        Queue<TreeNode> qu2 = new ArrayDeque<>();
        qu1.add(root);

        while (!qu1.isEmpty()) {
            while (!qu1.isEmpty()) {
                TreeNode temp = qu1.poll();
                while (temp != null) {
                    System.out.print(temp.getData() + " - ");
                    if (temp.getLeftChild() != null) {
                        qu2.add(temp.getLeftChild());
                    }
                    temp = temp.getRightChild();
                }
            }
            System.out.println();
            qu1.addAll(qu2);
            qu2.clear();
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(n)
    public static void rightUpToLeftDown(TreeNode root) {
        Queue<TreeNode> qu1 = new ArrayDeque<>();
        Queue<TreeNode> qu2 = new ArrayDeque<>();
        qu1.add(root);

        while (!qu1.isEmpty()) {
            while (!qu1.isEmpty()) {
                TreeNode temp = qu1.poll();
                while (temp != null) {
                    System.out.print(temp.getData() + " - ");
                    if (temp.getRightChild() != null) {
                        qu2.add(temp.getRightChild());
                    }
                    temp = temp.getLeftChild();
                }
            }
            System.out.println();
            qu1.addAll(qu2);
            qu2.clear();
        }
    }
}
