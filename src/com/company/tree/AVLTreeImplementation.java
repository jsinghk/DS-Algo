package com.company.tree;

/*
 Tree for which difference of height between left and right subtree is not
 greater than one for all nodes.
*/
public class AVLTreeImplementation {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.root = avlTree.insertNode(avlTree.root, 10);
        avlTree.root = avlTree.insertNode(avlTree.root, 20);
        avlTree.root = avlTree.insertNode(avlTree.root, 30);
        avlTree.root = avlTree.insertNode(avlTree.root, 40);
        avlTree.root = avlTree.insertNode(avlTree.root, 50);
        avlTree.root = avlTree.insertNode(avlTree.root, 25);
        avlTree.printPreOrder(avlTree.root);
        System.out.println("\nAfter Delete :");
        avlTree.root = avlTree.deleteNode(avlTree.root, 40);
        avlTree.root = avlTree.deleteNode(avlTree.root, 50);
        avlTree.printPreOrder(avlTree.root);
    }

    static class Node {
        int data, height;
        Node left, right;
        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    static class AVLTree {
        Node root;

        //Find Height
        int height(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        //Find Balance Factor
        int getBalFact(Node node) {
            if (node == null) {
                return 0;
            }
            return height(node.left) - height(node.right);
        }

        //Root of rotation is y , x becomes root after rotation
        public Node rightRotate(Node y) {
            Node x = y.left;
            Node t2 = x.right;

            //Rotate
            x.right = y;
            y.left = t2;

            //Update heights
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            //Return new root
            return x;
        }

        //Root of rotation is y , x becomes root after rotation
        public Node leftRotate(Node y) {
            Node x = y.right;
            Node t2 = x.left;

            //Rotate
            x.left = y;
            y.right = t2;

            //Update heights
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            //Return new root
            return x;
        }

        public Node minValNode(Node node) {
            Node curr = node;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        //Time complexity is O(log(n))
        //Auxiliary Space is O(1)
        public Node insertNode(Node node, int data) {
            //Normal BST insertion
            if (node == null) {
                return new Node(data);
            } else if (node.data > data) {
                node.left = insertNode(node.left, data);
            } else if (node.data < data) {
                node.right = insertNode(node.right, data);
            } else { //Duplicate values not allowed
                return node;
            }

            //Update Height of ancestor nodes
            node.height = 1 + Math.max(height(node.left), height(node.right));

            //Find Balance Factor
            int balFact = getBalFact(node);

            //If this node becomes unbalanced
            //Left-Left case
            if (balFact > 1 && data < node.left.data) {
                return rightRotate(node);
            }
            //Right-Right case
            if (balFact < -1 && data > node.right.data) {
                return leftRotate(node);
            }
            //Left-Right case
            if (balFact > 1 && data > node.left.data) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            //Right-Left case
            if (balFact < -1 && data < node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        //Time complexity is O(log(n))
        //Auxiliary Space is O(1)
        public Node deleteNode(Node node, int data) {
            //Normal BST deletion
            if (node == null) {
                return null;
            } else if (node.data > data) {
                node.left = deleteNode(node.left, data);
            } else if (node.data < data) {
                node.right = deleteNode(node.right, data);
            } else {
                Node temp;
                if (node.left == null || node.right == null) {
                    if (node.left == null) {
                        temp = node.right;
                    } else {
                        temp = node.left;
                    }
                    node = temp;
                } else {
                    temp = minValNode(node);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }

            //If node becomes null after deletion (delete node is a leaf)
            if (node == null) {
                return node;
            }

            //Update Height of ancestor nodes
            node.height = 1 + Math.max(height(node.left), height(node.right));

            //Find Balance Factor
            int balFact = getBalFact(node);

            //If this node becomes unbalanced
            //Left-Left case
            if (balFact > 1 && getBalFact(node.left) >= 0) {
                return rightRotate(node);
            }
            //Right-Right case
            if (balFact < -1 && getBalFact(node.right) <= 0) {
                return leftRotate(node);
            }
            //Left-Right case
            if (balFact > 1 && getBalFact(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            //Right-Left case
            if (balFact < -1 && getBalFact(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        public void printPreOrder(Node node) {
            if (node != null){
                System.out.print(node.data + " -> ");
                printPreOrder(node.left);
                printPreOrder(node.right);
            }
        }
    }
}
