package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TreeFindPairEqualToGivenSum {

    static int sum = 45;
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
        findPairLessTime(binaryTree.rootNode);
    }

    //Time complexity is O(n)
    //Space complexity is O{n} for Auxiliary space of Set
    //Space complexity is O{n} for recursive stack
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

    //Traverse Inorder and ReverseInorder to find pair
    //Time complexity is O(n)
    //Space complexity is O{Log(n)} for Auxiliary space of Stack
    public static boolean findPairLessTime(TreeNode root) {

        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        boolean done1=false, done2=false;
        int val1=0, val2=0;
        TreeNode curr1 = root, curr2 = root;

        while (true) {
            //Traverse inorder
            while (!done1) {
                if (curr1 != null) {
                    s1.push(curr1);
                    curr1 = curr1.leftChild;
                } else {
                    if (s1.isEmpty()) {
                        done1 = true;
                    } else {
                        curr1 = s1.pop();
                        val1 = curr1.data;
                        curr1 = curr1.rightChild;
                        done1 = true;
                    }
                }
            }
            //Traverse reverse inorder
            while (!done2) {
                if (curr2 != null) {
                    s2.push(curr2);
                    curr2 = curr2.rightChild;
                } else {
                    if (s2.isEmpty()) {
                        done2 = true;
                    } else {
                        curr2 = s2.pop();
                        val2 = curr2.data;
                        curr2 = curr2.leftChild;
                        done2 = true;
                    }
                }
            }

            //Pair Found
            if (val1 != val2 && (val1+val2 == sum)) {
                System.out.println("Pair : (" + val1 + "," + val2 + ")");
                return true;
            } else if (val1+val2 < sum) {
                done1 = false;
            } else if (val1+val2 > sum){
                done2 = false;
            }

            if (val1 >= val2) {
                break;
            }
        }
        return false;
    }
}
