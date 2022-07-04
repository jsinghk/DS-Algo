package com.company.practice.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Print all paths(from top to down only) whose sum equals k
public class TreeSumEqualKPathPrint {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(1);
        tree.root.left.right.left = new Node(1);
        tree.root.right = new Node(-1);
        tree.root.right.left = new Node(4);
        tree.root.right.left.left = new Node(1);
        tree.root.right.left.right = new Node(2);
        tree.root.right.right = new Node(5);
        tree.root.right.right.right = new Node(6);
        printPathSumEqualK(tree.root);
        System.out.println();
        checkPathSumEqualK(tree.root);
    }

    //Using Level Order traversal
    //Time complexity is O(n2)
    //Space complexity is O(n2) for List
    static int k = 5;
    public static void printPathSumEqualK(Node root) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node temp = qu.poll();
            List<Integer> path = new ArrayList<>();
            if (temp.left != null) {
                qu.add(temp.left);
            }
            if (temp.right != null) {
                qu.add(temp.right);
            }
            findPath(temp, path, 0);
        }
    }
    private static void findPath(Node node, List<Integer> path, int sum) {
        if (node == null) {
            return;
        }
        path.add(node.data);
        sum += node.data;
        if (sum == k){
            path.forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
        findPath(node.left, path, sum);
        findPath(node.right, path, sum);
        path.remove(path.size() - 1);
    }
    static class BinaryTree{
        Node root;
    }
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    //Using Post Order traversal
    //Time complexity is O(n2)
    //Space complexity is O(h) for List
    static List<Integer> pathList = new ArrayList<>();
    public static void checkPathSumEqualK(Node root){
        if (root == null) {
            return;
        }
        pathList.add(root.data);
        checkPathSumEqualK(root.left);
        checkPathSumEqualK(root.right);
        int sum=0;
        for (int j=pathList.size()-1; j>=0; j--) {
            sum += pathList.get(j);
            if (sum == k) {
                printPathUtil(pathList, j);
            }
        }
        pathList.remove(pathList.size() - 1);
    }
    private static void printPathUtil(List<Integer> path, int j) {
        for (int i=j; i<path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
}