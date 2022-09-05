package com.company.practice.Tree;

import com.company.list.IntegerLinkedList;
import com.company.list.IntegerNode;
import com.company.tree.Tree;
import com.company.tree.TreeNode;

//Balanced BST
public class TreeFromSortedLinkedList {

    static IntegerLinkedList list = new IntegerLinkedList();
    static IntegerNode head;
    public static void main(String[] args) {
        list.addSorted(1);
        list.addSorted(2);
        list.addSorted(3);
        list.addSorted(4);
        list.addSorted(5);
        list.addSorted(6);
        list.addSorted(7);
        list.printList();
        head = list.head;
        System.out.println();
        Tree tree = new Tree();
        tree.rootNode = treeFromSortedLinkedList(7);
        tree.traverseLevelOrder();
    }

    //Time complexity is O(n)
    //Space complexity is O(n) for recursive stack
    public static TreeNode treeFromSortedLinkedList(int n) {
        if (n <= 0) {
            return null;
        }
        TreeNode left = treeFromSortedLinkedList(n/2);
        TreeNode root = new TreeNode(head.getValue());
        root.leftChild = left;
        head = head.getNext();
        root.rightChild = treeFromSortedLinkedList(n-n/2-1);
        return root;
    }
}
