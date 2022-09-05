package com.company.practice.Tree;

import java.util.*;

public class TreePrintView {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root=new Node(20);
        tree.root.left=new Node(8);
        tree.root.right=new Node(22);
        tree.root.left.left=new Node(5);
        tree.root.left.right=new Node(3);
        tree.root.right.left=new Node(4);
        tree.root.right.right=new Node(25);
        tree.root.left.right.left=new Node(10);
        tree.root.left.right.right=new Node(14);
        printBottomView(tree.root);
        System.out.println();
        printTopView(tree.root);
        System.out.println();
        printLeftView(tree.root);
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue and Map
    public static void printBottomView(Node root) {
        Queue<Node> qu = new ArrayDeque<>();
        Map<Integer, Integer> bottomMap = new HashMap<>();
        int hd = 0, minhd = 0, maxhd = 0;
        root.hd = hd;
        qu.add(root);
        while (!qu.isEmpty()) {
            Node temp = qu.poll();
            hd = temp.hd;
            minhd = Math.min(minhd, hd);
            maxhd = Math.max(maxhd, hd);
            bottomMap.put(hd, temp.data);
            if (temp.left != null){
                temp.left.hd = hd - 1;
                qu.add(temp.left);
            }
            if (temp.right != null){
                temp.right.hd = hd + 1;
                qu.add(temp.right);
            }
        }
        System.out.print("Bottom View : ");
        for (int i=minhd; i<=maxhd; i++) {
            if (bottomMap.containsKey(i)) {
                System.out.print(bottomMap.get(i) + " ");
            }
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue and Map
    public static void printTopView(Node root) {
        Queue<Node> qu = new ArrayDeque<>();
        Map<Integer, Integer> topMap = new HashMap<>();
        int hd = 0, minhd = 0, maxhd = 0;
        root.hd = hd;
        qu.add(root);
        while (!qu.isEmpty()) {
            Node temp = qu.poll();
            hd = temp.hd;
            minhd = Math.min(minhd, hd);
            maxhd = Math.max(maxhd, hd);
            if (!topMap.containsKey(hd)) {
                topMap.put(hd, temp.data);
            }
            if (temp.left != null){
                temp.left.hd = hd - 1;
                qu.add(temp.left);
            }
            if (temp.right != null){
                temp.right.hd = hd + 1;
                qu.add(temp.right);
            }
        }
        System.out.print("Top View : ");
        for (int i=minhd; i<=maxhd; i++) {
            if (topMap.containsKey(i)) {
                System.out.print(topMap.get(i) + " ");
            }
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for Queue and Map
    public static void printLeftView(Node root) {
        Queue<Node> qu = new ArrayDeque<>();
        Map<Integer, Integer> topMap = new HashMap<>();
        int vd = 0, maxvd = 0;
        root.hd = vd;
        qu.add(root);
        while (!qu.isEmpty()) {
            Node temp = qu.poll();
            vd = temp.hd;
            maxvd = Math.max(maxvd, vd);
            if (!topMap.containsKey(vd)) {
                topMap.put(vd, temp.data);
            }
            if (temp.left != null){
                temp.left.hd = vd + 1;
                qu.add(temp.left);
            }
            if (temp.right != null){
                temp.right.hd = vd + 1;
                qu.add(temp.right);
            }
        }
        System.out.print("Left View : ");
        for (int i=0; i<=maxvd; i++) {
            if (topMap.containsKey(i)) {
                System.out.print(topMap.get(i) + " ");
            }
        }
    }

    static class BinaryTree{
        Node root;
    }
    static class Node{
        Node left;
        Node right;
        int data;
        int hd; //horizontal distance from root
        Node(int data){
            hd = Integer.MIN_VALUE;
            this.data = data;
        }
    }
}
