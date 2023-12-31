package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class SearchInBinarySearchTree {

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


    public TreeNode searchBST(TreeNode root, int val) {


        TreeNode currentNode = root;
        while(currentNode != null){

            if(currentNode.val == val){
                return currentNode;
            }

            if( val > currentNode.val){
                currentNode = currentNode.right;
            }else {
                currentNode = currentNode.left;
            }
        }
        return null;
    }


    public static void main (String[] args){

    }
}
