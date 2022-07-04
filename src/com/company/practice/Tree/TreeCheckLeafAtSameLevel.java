package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeCheckLeafAtSameLevel {
    public static void main(String[] args) {
        Tree binaryTree = new Tree();
        binaryTree.insert(25);
        binaryTree.insert(20);
        binaryTree.insert(27);
        binaryTree.insert(15);
        binaryTree.insert(30);
        binaryTree.insert(32);
        //binaryTree.insert(22);
        binaryTree.insert(29);
        //binaryTree.insert(26);
        binaryTree.insert(17);
        System.out.println("Is Leaf at same level : " + checkIfSameLevel(binaryTree.getRootNode(), 0));
        System.out.println("Is Leaf at same level : " + checkIfSameLevelIter(binaryTree.getRootNode()));
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    static int leafLev = 0;
    public static boolean checkIfSameLevel(TreeNode root, int level) {
        if (root == null) {
            return true;
        }
        if (root.isLeaf()) {
            if (leafLev == 0) {
                leafLev = level;
            } else {
                return level == leafLev;
            }
        }
        return checkIfSameLevel(root.getLeftChild(), level + 1) &&
                checkIfSameLevel(root.getRightChild(), level + 1);
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue
    public static boolean checkIfSameLevelIter(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        int leafLev = 0;
        int lev=0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            lev++;
            while (size > 0) {
                TreeNode temp = qu.poll();
                if (temp.getLeftChild() != null) {
                    qu.add(temp.getLeftChild());
                    if (temp.getLeftChild().isLeaf()) {
                        if (leafLev == 0) {
                            leafLev = lev;
                        } else if (leafLev != lev) {
                            return false;
                        }
                    }
                }
                if (temp.getRightChild() != null) {
                    qu.add(temp.getRightChild());
                    if (temp.getRightChild().isLeaf()) {
                        if (leafLev == 0) {
                            leafLev = lev;
                        } else if (leafLev != lev) {
                            return false;
                        }
                    }
                }
                size--;
            }
        }
        return true;
    }
}
