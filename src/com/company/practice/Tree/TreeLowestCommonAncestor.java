package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        int data2 = lcaBinaryTree(binaryTree.getRootNode(), 17, 22);
        TreeNode node = lcaBinaryTreeIter(binaryTree.getRootNode(), 17, 15);
        int res = -1;
        if (v1 && v2) {
            res = node.getData();
        }
        System.out.println("LCA : " + data);
        System.out.println("LCAIter : " + data1);
        System.out.println("LCA Binary Tree : " + data2);
        System.out.println("LCA Binary Tree Iter : " + res);

//        TreeParent treePar = new TreeParent();
//        treePar.root = treePar.insert(treePar.root, 25);
//        treePar.root = treePar.insert(treePar.root, 20);
//        treePar.root = treePar.insert(treePar.root, 27);
//        treePar.root = treePar.insert(treePar.root, 15);
//        treePar.root = treePar.insert(treePar.root, 30);
//        treePar.root = treePar.insert(treePar.root, 32);
//        treePar.root = treePar.insert(treePar.root, 22);
//        treePar.root = treePar.insert(treePar.root, 29);
//        treePar.root = treePar.insert(treePar.root, 26);
//        Node n1 = treePar.root.right.left;
//        Node n2 = treePar.root.right.right;
//        Node lca = lcaParentPointer(n1, n2);
//        System.out.println("LCA : " + lca.data);
    }

    //Time complexity is O(h) h is height of tree
    //Space complexity is O(h) for recursive stack
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

    //Time complexity is O(h) h is height of tree
    //Space complexity is O(h)
    public static Node lcaParentPointer(Node n1, Node n2) {
        Set<Node> ancestor = new LinkedHashSet<>();

        while (n1 != null){
            ancestor.add(n1);
            n1 = n1.parent;
        }

        while (n2 != null){
            if (!ancestor.add(n2)){
                return n2;
            }
            n2 = n2.parent;
        }

        return null;
    }
    static class Node{
        Node left,right,parent;
        int data;
        Node(int data) {
           this.data = data;
        }
    }
    static class TreeParent{
        Node root;

        Node insert(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }
            if (value < node.data) {
                node.left = insert(node.left, value);
                node.left.parent = node;
            } else if (value > node.data) {
                node.right = insert(node.right, value);
                node.right.parent = node;
            }
            return node;
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for List
    public static int lcaBinaryTree(TreeNode root, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return -1;
        }
        int i;
        for (i=0; i< path1.size() && i< path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))){
                break;
            }
        }

        return path1.get(i-1);
    }
    private static boolean findPath(TreeNode root, int data, List<Integer> path) {
        if (root == null){
            return false;
        }
        path.add(root.getData());
        if (root.getData() == data) {
            return true;
        }
        if (root.getLeftChild() !=null && findPath(root.getLeftChild(), data, path)) {
            return true;
        }
        if (root.getRightChild() != null && findPath(root.getRightChild(), data, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    static boolean v1 = false, v2 = false;
    public static TreeNode lcaBinaryTreeIter(TreeNode root, int n1, int n2) {
        if (root == null){
            return null;
        }
        TreeNode temp = null;
        if (root.getData() == n1) {
            v1 = true;
            temp = root;
        }
        if (root.getData() == n2) {
            v2 = true;
            temp = root;
        }
        TreeNode ltree = lcaBinaryTreeIter(root.getLeftChild(), n1, n2);
        TreeNode rtree = lcaBinaryTreeIter(root.getRightChild(), n1, n2);
        if (temp != null) {
            return temp;
        }
        if (ltree!=null && rtree!=null){
            return root;
        }

        return (ltree!=null) ? ltree : rtree;
    }
}
