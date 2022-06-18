package com.company.practice;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeCheckTypeBinaryTree {

    public static void main(String[] arr) {
        Tree binaryTree = new Tree();
        binaryTree.insert(25);
        binaryTree.insert(20);
        binaryTree.insert(27);
        binaryTree.insert(15);
        binaryTree.insert(30);
        binaryTree.insert(32);
        binaryTree.insert(29);
        binaryTree.insert(22);
        binaryTree.insert(26);
        binaryTree.insert(17);
        binaryTree.insert(40);
        System.out.println("Tree is Full Binary Tree : " + checkIfFullBinaryTreeIterative(binaryTree.getRootNode()));
        System.out.println("Tree is Full Binary Tree : " + checkIfFullBinaryTreeRecursive(binaryTree.getRootNode()));
        System.out.println("Tree is Complete Binary Tree : " + checkIfCompleteBinaryTreeIterative(binaryTree.getRootNode()));
        System.out.println("Tree is Perfect Binary Tree : " + checkIfPerfectBinaryTreeIterative(binaryTree.getRootNode()));
        System.out.println("Tree is Balanced Binary Tree : " + checkIfBalancedBinaryTreeRecursive(binaryTree.getRootNode(), new Height()));
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue
    public static boolean checkIfFullBinaryTreeIterative(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            TreeNode temp = qu.poll();
            if (temp.getLeftChild() != null && temp.getRightChild() != null) {
                qu.add(temp.getLeftChild());
                qu.add(temp.getRightChild());
            } else if (temp.isLeaf()) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static boolean checkIfFullBinaryTreeRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.isLeaf()) {
            return true;
        }
        if (root.getLeftChild() != null && root.getRightChild() != null) {
            return (checkIfFullBinaryTreeRecursive(root.getLeftChild()) &&
                    checkIfFullBinaryTreeRecursive(root.getRightChild()));
        }
        return false;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue
    public static boolean checkIfCompleteBinaryTreeIterative(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        boolean flag = false;
        while (!qu.isEmpty()) {
            TreeNode temp = qu.poll();
            if (temp.getData() == -1) {
                flag = true;
            } else {
                if (flag == true) {
                    return false;
                }
                if (temp.getLeftChild() != null) {
                    qu.add(temp.getLeftChild());
                } else {
                    qu.add(new TreeNode(-1));
                }
                if (temp.getRightChild() != null) {
                    qu.add(temp.getRightChild());
                } else {
                    qu.add(new TreeNode(-1));
                }
            }
        }

        return true;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue
    public static boolean checkIfPerfectBinaryTreeIterative(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        boolean flag = false;
        while (!qu.isEmpty()) {
            TreeNode temp = qu.poll();
            if (temp.isLeaf()) {
                flag = true;
            } else {
                if (flag == true) {
                    return false;
                }
                if (temp.getLeftChild() != null) {
                    qu.add(temp.getLeftChild());
                } else {
                    return false;
                }
                if (temp.getRightChild() != null) {
                    qu.add(temp.getRightChild());
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static boolean checkIfBalancedBinaryTreeRecursive(TreeNode root, Height ht) {
        if (root == null) {
            ht.height = 0;
            return true;
        }
        Height lht = new Height();
        Height rht = new Height();
        boolean ltree = checkIfBalancedBinaryTreeRecursive(root.getLeftChild(), lht);
        boolean rtree = checkIfBalancedBinaryTreeRecursive(root.getRightChild(), rht);
        ht.height = 1 + Math.max(lht.height, rht.height);

        if (Math.abs(lht.height - rht.height) >= 2) {
            return false;
        } else {
            return ltree && rtree;
        }
    }

    static class Height {
        int height;
    }
}
