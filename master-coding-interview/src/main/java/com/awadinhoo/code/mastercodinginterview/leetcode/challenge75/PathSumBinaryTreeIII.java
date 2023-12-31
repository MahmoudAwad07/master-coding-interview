package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumBinaryTreeIII {

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

    int count = 0 ;
    public int pathSum(TreeNode root, int targetSum) {

        if(root == null)
            return 0;

        pathSumHelper(root, targetSum , 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    private void pathSumHelper(TreeNode node , int targetSum , long currentSum){

        if(node == null)
            return;

        currentSum += node.val;

        if(currentSum == targetSum)
            count++;

        pathSumHelper(node.left, targetSum, currentSum );
        pathSumHelper(node.right, targetSum, currentSum);
    }

    public int pathSum_V2(TreeNode root, int targetSum) {
        return solve(root, targetSum, new ArrayList<>());
    }

    private int solve(TreeNode root, int targetSum, List<TreeNode> path) {

        if (root == null) {
            return 0;
        }

        path.add(root);

        int count = 0;
        long sum = 0;

        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).val;
            if (sum == targetSum) {
                count++;
            }
        }

        count += solve(root.left, targetSum, path);
        count += solve(root.right, targetSum, path);

        // Backtrack: Remove the current node from the path and subtract its value from currentSum
        path.remove(path.size() - 1);

        return count;
    }


    public int pathSum_V3(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initialize with a sum of 0.

        return countPathSum(root, 0, targetSum, prefixSumCount);
    }

    private int countPathSum(TreeNode node, int currentSum, int targetSum, Map<Integer, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        count += countPathSum(node.left, currentSum, targetSum, prefixSumCount);
        count += countPathSum(node.right, currentSum, targetSum, prefixSumCount);

        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return count;
    }

    public static void main(String[] args) {

        // [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        // [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        // [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000] , targetSum = 0
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(-2);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(-3);
        TreeNode node8 = new TreeNode(11);
        node2.left = node3;
        node2.right = node4;
        node1.left = node2;
        node1.right = node5;
        node5.right = node6;
        root.left = node1;
        root.right = node7;
        node7.right = node8;


//        TreeNode root = new TreeNode(1000000000);
//        TreeNode node1 = new TreeNode(1000000000);
//        TreeNode node2 = new TreeNode(294967296);
//        TreeNode node3 = new TreeNode(1000000000);
//        TreeNode node4 = new TreeNode(1000000000);
//        TreeNode node5 = new TreeNode(1000000000);
//        root.left = node1;
//        node1.right = node2;
//        node2.right = node3;
//        node3.right = node4;
//        node4.right = node5;

        System.out.println(new PathSumBinaryTreeIII().pathSum_V3(root, 8));


    }
}
