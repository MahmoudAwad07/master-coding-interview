package com.awadinhoo.code.mastercodinginterview.trees;

import java.util.ArrayList;
import java.util.List;

public class NodesKDistanceInBinaryTree {


    public static List<Integer> distanceK(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        distanceK(root, nodes, k , 0);
        return nodes;
    }

    private static void distanceK(TreeNode root, List<Integer> nodes, int targetDistance, int distance) {

        if(root == null){
            return;
        }

        if(distance == targetDistance){
            nodes.add(root.val);
            return;
        }

        distanceK(root.left , nodes , targetDistance , distance +1);
        distanceK(root.right , nodes , targetDistance , distance +1);
    }

    public static List<Integer> distanceK_v2(TreeNode root, TreeNode target, int k) {
        List<Integer> nodes = new ArrayList<>();
        distanceK_v2(root, nodes, target , k , 0, false);
        return nodes;
    }

    private static void distanceK_v2(TreeNode root, List<Integer> nodes, TreeNode target ,int targetDistance, int distance, boolean targetFound) {

        if(root == null){
            return;
        }

        if(root.val == target.val){
            targetFound = true;
        }

        if(distance == targetDistance){
            nodes.add(root.val);
            return;
        }

        if(targetFound){
            distanceK_v2(root.left , nodes , target ,targetDistance , distance + 1 , targetFound);
            distanceK_v2(root.right , nodes , target ,targetDistance , distance + 1, targetFound);
        }else {
            distanceK_v2(root.left , nodes , target , targetDistance , distance, targetFound );
            distanceK_v2(root.right , nodes , target ,targetDistance , distance, targetFound);
        }
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

        System.out.println(distanceK(binaryTree, 3));
        System.out.println(distanceK_v2(binaryTree, new TreeNode(10) ,2));

    }
}
