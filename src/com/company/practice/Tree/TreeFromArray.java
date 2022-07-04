package com.company.practice.Tree;

import com.company.tree.Tree;
import com.company.tree.TreeNode;

public class TreeFromArray {

    static Tree binaryTree = new Tree();
    public static void main(String[] args){
        int[] parent = {1, 5, 5, 2, 2, -1, 3};
        constructTree(parent);
        binaryTree.traverseLevelOrder();
        int[] treeArray = constructArrayFromTree();
        System.out.println();
        for (int ele : treeArray){
            System.out.print(ele + "  ");
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(n)
    public static void constructTree(int[] parent) {
        TreeNode[] nodeArr = new TreeNode[parent.length];
        for (int i=0; i<parent.length; i++){
            nodeArr[i] = new TreeNode(i);
        }
        for (int i=0; i<parent.length; i++){
            if (parent[i] == -1){
                binaryTree.setRootNode(nodeArr[i]);
            } else {
                if (nodeArr[parent[i]].getLeftChild() == null){
                    nodeArr[parent[i]].setLeftChild(nodeArr[i]);
                } else if (nodeArr[parent[i]].getRightChild() == null){
                    nodeArr[parent[i]].setRightChild(nodeArr[i]);
                }
            }
        }
    }

    //Time complexity is O(n)
    //Space complexity is O(1)
    public static int[] constructArrayFromTree() {
        int count = inorderCount(binaryTree.getRootNode());
        int[] treeArray = new int[count];
        treeArray[binaryTree.getRootNode().getData()] = -1;
        inorderArrayCreation(binaryTree.getRootNode(), treeArray, binaryTree.getRootNode());
        return treeArray;
    }
    private static int inorderCount(TreeNode root){
        if (root == null){
            return 0;
        }
        int count = 1;
        count = count + inorderCount(root.getLeftChild());
        count = count + inorderCount(root.getRightChild());
        return count;
    }
    private static void inorderArrayCreation(TreeNode root, int[] treeArray, TreeNode parent){
        if (root==null){
            return;
        }
        inorderArrayCreation(root.getLeftChild(), treeArray, root);
        if (root != binaryTree.getRootNode()){
            treeArray[root.getData()] = parent.getData();
        }
        inorderArrayCreation(root.getRightChild(), treeArray, parent);
    }


}
