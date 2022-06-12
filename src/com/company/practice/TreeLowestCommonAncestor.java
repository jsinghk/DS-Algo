package com.company.practice;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

public class TreeLowestCommonAncestor {

    public static void main(String[] ars) {
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
        int data = lca(binaryTree.getRootNode(), 26, 29).getData();
        int data1 = lcaIter(binaryTree.getRootNode(), 26, 29).getData();
        System.out.println("LCA : " + data);
        System.out.println("LCAIter : " + data1);
    }

    //Time complexity is O(h) h is height of tree
    //Space complexity is O(h) for recusrsive stack
    public static TreeNode lca(TreeNode root, int v1, int v2) {
        if (root.getData() > v1 && root.getData() > v2) {
            return lca(root.getLeftChild(), v1, v2);
        } else if (root.getData() < v1 && root.getData() < v2) {
            return lca(root.getRightChild(), v1, v2);
        }
        return root;
    }

    //Time complexity is O(h) h is height of tree
    //Space complexity is O(1)
    public static TreeNode lcaIter(TreeNode root, int v1, int v2) {
        while (root != null) {
            if (root.getData() > v1 && root.getData() > v2) {
                root = root.getLeftChild();
            } else if (root.getData() < v1 && root.getData() < v2) {
                root = root.getRightChild();
            } else {
                break;
            }
        }
        return root;
    }
}
