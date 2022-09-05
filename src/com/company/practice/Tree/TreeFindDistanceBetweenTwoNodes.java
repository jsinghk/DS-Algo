package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

public class TreeFindDistanceBetweenTwoNodes {

    static Tree binaryTree = new Tree();

    public static void main(String[] args) {
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
        System.out.println("Distance between nodes : " + findDistance(binaryTree.getRootNode(), 17, 29));
    }

    public static int findDistance(TreeNode root, int n1, int n2) {
        TreeNode lca = TreeLowestCommonAncestor.lcaBinaryTreeRecur(root, n1, n2);
        int l1 = TreeFindLevelOfNode.findLevel(lca, binaryTree.get(n1));
        int l2 = TreeFindLevelOfNode.findLevel(lca, binaryTree.get(n2));
        return l1 + l2;
    }
}
