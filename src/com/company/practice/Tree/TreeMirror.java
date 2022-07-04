package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeMirror {

    //Binary Tree is foldable if left and right subtree are mirror
    public static void main(String[] arr) {
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
//        System.out.println(checkTreesAreMirrorRecursive(binaryTree.getRootNode().getLeftChild(),
//                binaryTree.getRootNode().getRightChild()));
//        System.out.println(checkTreesAreMirrorIterative(binaryTree.getRootNode().getLeftChild(),
//                binaryTree.getRootNode().getRightChild()));
        binaryTree.traverseLevelOrder();
        System.out.println();
        mirrorTreeIterative(binaryTree.getRootNode());
        binaryTree.traverseLevelOrder();
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static boolean checkTreesAreMirrorRecursive(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null &&
                checkTreesAreMirrorRecursive(t1.getLeftChild(), t2.getRightChild()) &&
                checkTreesAreMirrorRecursive(t1.getRightChild(), t2.getLeftChild())) {
            return true;
        }
        return false;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue
    public static boolean checkTreesAreMirrorIterative(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(t1);
        qu.add(t2);
        while (!qu.isEmpty()) {
            TreeNode lt = qu.poll();
            TreeNode rt = qu.poll();
            if (lt.getData() == -1 && rt.getData() == -1) {
                continue;
            }
            if ((lt.getData() == -1 && rt.getData() != -1) ||
                    (lt.getData() != -1 && rt.getData() == -1)) {
                return false;
            }

            if (lt.getLeftChild() != null) {
                qu.add(lt.getLeftChild());
            } else {
                qu.add(new TreeNode(-1));
            }
            if (rt.getRightChild() != null) {
                qu.add(rt.getRightChild());
            } else {
                qu.add(new TreeNode(-1));
            }
            if (lt.getRightChild() != null) {
                qu.add(lt.getRightChild());
            } else {
                qu.add(new TreeNode(-1));
            }
            if (rt.getLeftChild() != null) {
                qu.add(rt.getLeftChild());
            } else {
                qu.add(new TreeNode(-1));
            }
        }
        return true;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static void mirrorTreeRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        mirrorTreeRecursive(root.getLeftChild());
        mirrorTreeRecursive(root.getRightChild());

        //Swap children
        TreeNode temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue
    public static void mirrorTreeIterative(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            TreeNode curr = qu.poll();
            TreeNode temp;
            if (!curr.isLeaf()) {
                if (curr.getLeftChild() != null) {
                    qu.add(curr.getLeftChild());
                    temp = curr.getLeftChild();
                } else {
                    temp = null;
                }
                if (curr.getRightChild() != null) {
                    qu.add(curr.getRightChild());
                    curr.setLeftChild(curr.getRightChild());
                } else {
                    curr.setLeftChild(null);
                }
                curr.setRightChild(temp);
            }
        }
    }
}

