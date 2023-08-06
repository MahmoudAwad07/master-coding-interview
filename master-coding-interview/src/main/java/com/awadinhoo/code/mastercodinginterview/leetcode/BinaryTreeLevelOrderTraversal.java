package com.awadinhoo.code.mastercodinginterview.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        // BFS
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levelOrderList = new ArrayList<>();

        if(root == null)
            return levelOrderList;

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> levelNodes = new ArrayList<>();
            int queueSize = queue.size();

            for (int i =0; i < queueSize ; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode != null){
                    levelNodes.add(currentNode.val);
                }

                if(currentNode.left != null)
                    queue.add(currentNode.left);

                if(currentNode.right != null)
                    queue.add(currentNode.right);

            }

            if(!levelNodes.isEmpty())
                levelOrderList.add(levelNodes);
        }

        return levelOrderList;
    }


    public static List<List<Integer>> levelOrderRec(TreeNode root) {
        // DFS
        List<List<Integer>> levelOrderList = new ArrayList<>();
        levelOrderRec(1, root, levelOrderList);
        return levelOrderList;
    }

    private static void levelOrderRec(int level , TreeNode current, List<List<Integer>> levelOrderList){

        if(current == null){
            return;
        }

        if(levelOrderList.size() < level)
            levelOrderList.add(new ArrayList<>());

        levelOrderList.get(level - 1).add(current.val);
        levelOrderRec(level + 1 , current.left , levelOrderList);
        levelOrderRec(level + 1 , current.right , levelOrderList);

    }
    public static void main(String[] args) {

        TreeNode binaryTree = new TreeNode(20);
        binaryTree.left = new TreeNode(10);
        binaryTree.right = new TreeNode(30);
        binaryTree.left.left = new TreeNode(6);
        binaryTree.left.right = new TreeNode(14);
        binaryTree.left.left.left = new TreeNode(3);
        binaryTree.left.left.right = new TreeNode(8);
        binaryTree.right.left = new TreeNode(24);
        binaryTree.right.left.right = new TreeNode(26);


        System.out.println(levelOrder(binaryTree));
        System.out.println(levelOrder(null));
        System.out.println(levelOrderRec(binaryTree));
        System.out.println(levelOrderRec(null));

    }



     // Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}
