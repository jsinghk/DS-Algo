package com.company.practice;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

public class TreeInorderSuccessor {

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

        TreeNode searchNode = binaryTree.get(27);
        System.out.println("Inorder Successor of " + searchNode.getData() + " : " +
                binarySearchTree(binaryTree.getRootNode(), searchNode));
        binaryTree(binaryTree.getRootNode(), searchNode);
    }

    //Time complexity is O(h)
    //Space complexity is O(1)
    public static int binarySearchTree(TreeNode root, TreeNode node) {
        TreeNode curr = root;
        TreeNode succ = new TreeNode(-1);
        if (node.getRightChild() != null) {
            return node.getRightChild().min();
        }
        while (curr != null) {
            if (curr.getData() < node.getData()) {
                curr = curr.getRightChild();
            } else if (curr.getData() > node.getData()) {
                succ = curr;
                curr = curr.getLeftChild();
            } else {
                break;
            }
        }
        return succ.getData();
    }

    //Time complexity is O(h)
    //Space complexity is O{n} for recursive stack
    public static void binaryTree(TreeNode root, TreeNode node) {
        if (node.getRightChild() != null) {
            System.out.println("Inorder Successor of " + node.getData() + " : " +
                    node.getRightChild().min());
            return;
        }
        //If Node is right most child
        if (root.max() == node.getData()) {
            System.out.println("Inorder Successor of " + node.getData() + " : -1");
            return;
        }
        InorderSucc(root, node);

    }

    private static TreeNode InorderSucc(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }
        TreeNode temp = null;
        if (root == node || (temp = InorderSucc(root.getLeftChild(), node)) != null ||
                (temp = InorderSucc(root.getRightChild(), node)) != null) {
            if (temp != null) {
                if (root.getLeftChild() == temp) {
                    System.out.println("Inorder Successor of " + node.getData() + " : " + root.getData());
                    return null;
                }
            }
            return root;
        }
        return null;
    }
}
