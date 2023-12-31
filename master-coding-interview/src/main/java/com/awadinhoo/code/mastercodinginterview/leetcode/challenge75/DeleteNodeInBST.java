package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class DeleteNodeInBST {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        TreeNode previousNode = null;
        TreeNode currentNode = root;
        boolean left = false;

        while (currentNode != null) {

            if (currentNode.val == key) {

                if (currentNode.left == null && currentNode.right != null) {

                    if (previousNode == null) {
                        root = currentNode.right;
                    } else {
                        if (left) {
                            previousNode.left = currentNode.right;
                        } else {
                            previousNode.right = currentNode.right;
                        }
                    }

                    currentNode.right = null;
                } else if (currentNode.left != null && currentNode.right == null) {

                    if (previousNode == null) {
                        root = currentNode.left;
                    } else {

                        if (left) {
                            previousNode.left = currentNode.left;
                        } else {
                            previousNode.right = currentNode.left;
                        }
                    }
                    currentNode.left = null;
                } else if (currentNode.left != null && currentNode.right != null) {

                    TreeNode rightLeftMost = getRightLeftMost(currentNode);

                    if (previousNode == null) {
                        root = rightLeftMost;

                        if (rightLeftMost.right == null) {
                            rightLeftMost.right = currentNode.right;
                        }
                    } else {
                        if (left) {
                            previousNode.left = rightLeftMost;
                        } else {
                            previousNode.right = rightLeftMost;
                        }

                    }

                    rightLeftMost.left = currentNode.left;
                    currentNode.right = null;
                    currentNode.left = null;
                } else {

                    if (previousNode == null) {
                        root = null;
                    } else {

                        if (left) {
                            previousNode.left = null;
                        } else {
                            previousNode.right = null;
                        }
                    }
                }

                break;
            } else if (key > currentNode.val) {
                previousNode = currentNode;
                currentNode = currentNode.right;
                left = false;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.left;
                left = true;
            }
        }

        return root;
    }

    private static TreeNode getRightLeftMost(TreeNode node) {

        TreeNode previousNode = node;
        TreeNode currentNode = node.right;
        while (currentNode.left != null) {
            previousNode = currentNode;
            currentNode = currentNode.left;
        }
        if (previousNode != node)
            previousNode.left = null;

        return currentNode;
    }


    public static void main(String[] args) {


        // [50,30,70,null,40,60,80] --> expected --> [60,30,70,null,40,null,80]

//        TreeNode root = new TreeNode(50);
//        TreeNode node1 = new TreeNode(30);
//        TreeNode node2 = new TreeNode(40);
//        TreeNode node3 = new TreeNode(70);
//        TreeNode node4 = new TreeNode(60);
//        TreeNode node5 = new TreeNode(80);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(0);
//        TreeNode node8 = new TreeNode(8);
//        node1.right = node2;
//        node3.right = node5;
//        node3.left = node4;
//        root.left = node1;
//        root.right = node3;


        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node4.right = node5;
        root.left = node1;
        root.right = node4;

        //deleteNode(root, 3);
        //deleteNode(root, 6);
        root = deleteNode(root, 5);

    }
}
