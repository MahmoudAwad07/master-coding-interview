package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class LongestZigZagPathBinaryTree {


    int longestZigzag = 0;
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


    public int longestZigZag(TreeNode root) {

        if(root.left != null)
            longestZigZag(root.left, true, 1);

        if(root.right != null)
            longestZigZag(root.right, false, 1);

        return longestZigzag;

    }

    public void longestZigZag(TreeNode node, boolean left, int depth) {

        if(longestZigzag < depth){
            longestZigzag = depth;
        }

        if(node.left != null)
            longestZigZag(node.left, true , left ? 1 : depth + 1);

        if (node.right != null)
            longestZigZag(node.right , false , left ? depth + 1 : 1);
    }

    public static void main(String[] args) {

    }
}
