package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class MaximumDepthBinaryTree {

    private class TreeNode {
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

    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node , int depth){

        if(node == null){
            return depth -1;
        }

        return Math.max(
                maxDepth(node.left, depth + 1 ),
                maxDepth(node.right , depth +1));
    }


    public int maxDepth_v2(TreeNode node){

        if(node == null){
            return 0;
        }

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
