package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeCheckIfAncestorDescendantRelation {

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
        System.out.println("Is Ancestor Descendant : " +
                checkAncestorDescendantRelation(binaryTree.getRootNode(), 30, 26));
        System.out.println("Is Ancestor Descendant : " +
                checkAncestorDescendantRelationRec(binaryTree.getRootNode(), 30, 26, false));
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Lists & recursive stack
    public static boolean checkAncestorDescendantRelation(TreeNode root, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        findPath(root, n1, path1);
        findPath(root, n2, path2);
        if (path1.size() == path2.size() && n1 != n2) {
            return false;
        }
        if (path1.size() > path2.size()) {
            for (int i = path1.size() - 1; i >= 0; i--) {
                if (n2 == path1.get(i)) {
                    return true;
                }
            }
        } else {
            for (int j = path2.size() - 1; j >= 0; j--) {
                if (n1 == path2.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findPath(TreeNode root, int nodeData, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.getData());
        if (root.getData() == nodeData) {
            return true;
        }
        if (root.getLeftChild() != null && findPath(root.getLeftChild(), nodeData, path)) {
            return true;
        }
        if (root.getRightChild() != null && findPath(root.getRightChild(), nodeData, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) recursive stack
    public static boolean checkAncestorDescendantRelationRec(TreeNode root, int n1, int n2, boolean flag) {
        if (root == null) {
            return false;
        }
        if ((n1 != n2) && root.getData() == n1 || root.getData() == n2) {
            if (flag) {
                return true;
            }
            flag = true;
        }
        if (flag && checkAncestorDescendantRelationRec(root.getLeftChild(), n1, n2, flag)) {
            return true;
        }
        if (flag && checkAncestorDescendantRelationRec(root.getRightChild(), n1, n2, flag)) {
            return true;
        }
        return false;
    }
}
