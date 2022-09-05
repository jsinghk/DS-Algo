package com.company.tree;

public class Tree {

    public TreeNode rootNode;

    public void insert(int value) {
        if (rootNode == null) {
            rootNode = new TreeNode(value);
        } else {
            rootNode.insert(value);
        }
    }

    public void traverseInorder() {
        if (rootNode != null) {
            rootNode.traverseInorder();
        }
    }

    public void traversePreOrder() {
        if (rootNode != null) {
            rootNode.traversePreOrder();
        }
    }

    public void traverseLevelOrder() {
        if (rootNode != null) {
            rootNode.traverseLevelOrder(rootNode);
        }
    }

    public void traverseZigZag() {
        if (rootNode != null) {
            rootNode.traverseZigZag(rootNode);
        }
    }

    public void getAllLeafNodesAndSum() {
        if (rootNode != null) {
            System.out.println(rootNode.getAllLeafNodesAndSum());
        }
    }

    public void getAllLeafNodesAndSumWhichAreLeftChild() {
        if (rootNode != null) {
            System.out.println(rootNode.getAllLeafNodesAndSumWhichAreLeftChild(true));
        }
    }

    public int getHeightOfTree() {
        return rootNode.getHeightOfTree(rootNode);
    }

    public int getDiameterOfTree() {
        TreeNode.A a = rootNode.new A();
        rootNode.getDiameterOfTree(rootNode, a);
        return a.ans;
    }

    public void delete(int value) {
        rootNode = delete(rootNode, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {
            //Case when node has 0 or 1 child
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            //Case when node has 2 children
            subtreeRoot.setData(subtreeRoot.getRightChild().min());
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }

        return subtreeRoot;
    }

    public TreeNode get(int value) {
        if (rootNode != null) {
            return rootNode.get(value);
        }
        return null;
    }

    public int min() {
        if (rootNode == null) {
            return Integer.MIN_VALUE;
        } else {
            return rootNode.min();
        }
    }

    public int max() {
        if (rootNode == null) {
            return Integer.MAX_VALUE;
        } else {
            return rootNode.max();
        }
    }

    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }
}
