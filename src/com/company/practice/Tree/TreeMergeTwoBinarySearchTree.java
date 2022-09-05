package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

import java.util.Stack;

public class TreeMergeTwoBinarySearchTree {

    public static void main(String[] args) {
        Tree bst1 = new Tree();
        bst1.insert(8);
        bst1.insert(10);
        bst1.insert(2);
        bst1.insert(1);
        Tree bst2 = new Tree();
        bst2.insert(5);
        bst2.insert(3);
        bst2.insert(0);

        mergeTwoBST(bst1.getRootNode(), bst2.getRootNode());
    }

    //Time complexity is O(m+n)
    //Space complexity is O(H(m)+H(n)) for auxiliary stacks
    public static void mergeTwoBST(TreeNode node1, TreeNode node2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        while (node1!=null || node2!=null || !s1.isEmpty() || !s2.isEmpty()) {
            while (node1!=null) {
                s1.push(node1);
                node1=node1.leftChild;
            }
            while (node2 != null){
                s2.push(node2);
                node2=node2.leftChild;
            }
            if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().data <= s2.peek().data)) {
                System.out.print(s1.peek().data + "  ");
                node1 = s1.pop();
                node1 = node1.rightChild;
            } else {
                System.out.print(s2.peek().data + "  ");
                node2 = s2.pop();
                node2 = node2.rightChild;
            }
        }

    }
}
