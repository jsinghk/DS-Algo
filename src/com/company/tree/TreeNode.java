package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }
        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInorder() {
        if (leftChild != null) {
            leftChild.traverseInorder();
        }
        System.out.print(data + " - ");
        if (rightChild != null) {
            rightChild.traverseInorder();
        }
    }

    public void traversePreOrder() {
        System.out.print(data + " - ");

        if (leftChild != null) {
            leftChild.traversePreOrder();
        }
        if (rightChild != null) {
            rightChild.traversePreOrder();
        }
    }

    public void traverseLevelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            TreeNode temp = qu.poll();
            System.out.print(temp.data + " - ");
            if (temp.leftChild != null) {
                qu.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                qu.add(temp.rightChild);
            }
        }
    }

    public void traverseZigZag(TreeNode root) {
        Stack<TreeNode> curr = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        curr.push(root);
        boolean leftToRight = true;
        while (!curr.isEmpty()) {
            TreeNode temp = curr.pop();
            System.out.print(temp.data + " - ");
            if (leftToRight) {
                if (temp.leftChild != null) {
                    next.push(temp.leftChild);
                }
                if (temp.rightChild != null) {
                    next.push(temp.rightChild);
                }
            } else {
                if (temp.rightChild != null) {
                    next.push(temp.rightChild);
                }
                if (temp.leftChild != null) {
                    next.push(temp.leftChild);
                }
            }
            if (curr.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> tempNode = curr;
                curr = next;
                next = tempNode;
            }
        }
    }

    public int getAllLeafNodesAndSum() {
        int sum = 0;
        if (leftChild != null) {
            sum = sum + leftChild.getAllLeafNodesAndSum();
        }
        if (rightChild != null) {
            sum = sum + rightChild.getAllLeafNodesAndSum();
        }
        if (isLeaf()) {
            System.out.println("Leaf Node : " + data);
            return data;
        }
        return sum;
    }

    public int getAllLeafNodesAndSumWhichAreLeftChild(boolean isLeft) {
        int sum = 0;
        if (leftChild != null) {
            sum = sum + leftChild.getAllLeafNodesAndSumWhichAreLeftChild(true);
        }
        if (rightChild != null) {
            sum = sum + rightChild.getAllLeafNodesAndSumWhichAreLeftChild(false);
        }
        if (isLeaf() && isLeft) {
            System.out.println("Leaf Node : " + data);
            return data;
        }
        return sum;
    }

    public int getHeightOfTree(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int lheight = getHeightOfTree(node.leftChild);
        int rheight = getHeightOfTree(node.rightChild);

        return 1 + Math.max(lheight, rheight);
    }

    class A {
        int ans = 0;
    }
    public int getDiameterOfTree(TreeNode node, A a) {
        if (node == null) {
            return 0;
        }
        int ltree = getDiameterOfTree(node.leftChild, a);
        int rtree = getDiameterOfTree(node.rightChild, a);
        a.ans = Math.max(a.ans, 1 + ltree + rtree);
        return 1 + Math.max(ltree, rtree);
    }

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
