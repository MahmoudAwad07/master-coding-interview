package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxLevelSumInBinaryTree {


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


    public int maxLevelSum(TreeNode root) {

        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        Queue<TreeNode> levelNodes = new ArrayDeque<>();
        levelNodes.add(root);

        while(!levelNodes.isEmpty()){

            int levelSize = levelNodes.size();
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode currentNode = levelNodes.poll();
                currentSum += currentNode.val;

                if(currentNode.left != null){
                    levelNodes.add(currentNode.left);
                }

                if(currentNode.right != null){
                    levelNodes.add(currentNode.right);
                }

            }

            if(currentSum > maxSum){
                maxSum = currentSum;
                maxLevel = level;
            }

            level++;
            currentSum = 0;
        }

        return maxLevel;
    }

    public static void main (String[] args){

    }
}
