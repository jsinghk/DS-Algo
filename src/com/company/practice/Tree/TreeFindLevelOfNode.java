package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

public class TreeFindLevelOfNode {

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
        TreeNode node = binaryTree.get(17);
        System.out.println("Level of Node : " + findLevel(binaryTree.getRootNode(), node));
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static int findLevel(TreeNode root, TreeNode node, int lev) {
        if (root == null) {
            return 0;
        }
        if (root == node) {
            return lev;
        }
        int l = findLevel(root.getLeftChild(), node, lev + 1);
        if (l != 0) {
            return l;
        }
        return findLevel(root.getRightChild(), node, lev + 1);
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static int findLevel(TreeNode root, TreeNode node) {
        if (root == null) {
            return -1;
        }
        int level = -1;
        if ((root == node) || (level = findLevel(root.getLeftChild(), node)) >= 0 ||
                (level = findLevel(root.getRightChild(), node)) >= 0) {
            return level + 1;
        }
        return level;
    }
}
