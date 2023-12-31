package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class LowestCommonAncestorInBinaryTree {

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


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        if(root == q || root == p){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);
        
        if(left != null && right != null){
            return root;
        }
        
        return left == null ? right : left;
    }


    public static void main (String[] args){
        
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node6.right = node7;
        node6.left = node8;
        root.left = node1;
        root.right = node6;

        //System.out.println(lowestCommonAncestor(root, node1 , node6).val);
        System.out.println(lowestCommonAncestor(root, node1 , node5).val);

    }
}
