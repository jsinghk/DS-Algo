package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TreeFindPairEqualToGivenSum {

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
        binaryTree.insert(21);

        Set<Integer> set = new HashSet<>();
        findPair(binaryTree.rootNode, set);
    }

    //Time complexity is O(n)
    //Space complexity is O{n} for Auxiliary space of Set
    //Space complexity is O{n} for recursive stack
    static int sum = 45;
    public static boolean findPair(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        findPair(root.leftChild, set);
        if (set.contains(sum - root.data)) {
            System.out.println("Pair : (" + root.data + "," + (sum - root.data) + ")");
            return true;
        } else {
            set.add(root.data);
        }
        findPair(root.rightChild, set);
        return false;
    }
}
