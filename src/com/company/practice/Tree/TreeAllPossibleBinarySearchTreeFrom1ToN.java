package com.company.practice.Tree;

import com.company.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeAllPossibleBinarySearchTreeFrom1ToN {

    public static void main(String[] args) {
        List<TreeNode> list = constructPossibleBST(1,3);
        for (int i=0; i< list.size(); i++) {
            TreeNode root = list.get(i);
            System.out.print((i+1) + " : ");
            root.traversePreOrder();
            System.out.println();
        }
    }

    public static List<TreeNode> constructPossibleBST(int st, int end) {

        List<TreeNode> nodeList = new ArrayList<>();
        if (st > end) {
            nodeList.add(null);
            return nodeList;
        }

        for (int i=st; i<=end; i++) {
            List<TreeNode> ltree = constructPossibleBST(st, i-1);
            List<TreeNode> rtree = constructPossibleBST(i+1, end);

            for (int j=0; j<ltree.size(); j++) {
                TreeNode left = ltree.get(j);
                for (int k=0; k<rtree.size(); k++){
                    TreeNode right = rtree.get(k);
                    TreeNode root = new TreeNode(i);
                    root.leftChild = left;
                    root.rightChild = right;
                    nodeList.add(root);
                }
            }
        }
        return nodeList;
    }
}
