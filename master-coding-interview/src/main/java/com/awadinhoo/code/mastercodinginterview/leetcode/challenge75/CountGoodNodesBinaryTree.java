package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class CountGoodNodesBinaryTree {


    private class TreeNode {
        int val;
        TreeNode left;
         TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int goodNodes(TreeNode root) {

        return getNumberOfGoodNodes(root, root.val);
    }

    private int getNumberOfGoodNodes(TreeNode node , int max){

        int numberOfGoodNodes = 0;

        if(node == null){
            return 0;
        }

        if(node.val >= max){
            max = node.val;
            numberOfGoodNodes++;
        }

        numberOfGoodNodes += getNumberOfGoodNodes(node.left, max) + getNumberOfGoodNodes(node.right, max);
        return numberOfGoodNodes;

    }

    public static void main (String[] args){

    }
}
