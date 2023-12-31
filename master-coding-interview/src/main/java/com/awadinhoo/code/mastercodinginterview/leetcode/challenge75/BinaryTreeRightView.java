package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView {


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


    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightViewNodes = new ArrayList<>();

        if(root != null)
            rightSideViewHelper(root, rightViewNodes);

        return rightViewNodes;

    }


    private static void rightSideViewHelper(TreeNode root , List<Integer> rightViewNodes){

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            int size = nodes.size();

            for (int i = 0 ; i < size ; i++){
                TreeNode node = nodes.poll();

                if(i == size - 1)
                    rightViewNodes.add(node.val);

                if(node.left != null) {
                    nodes.add(node.left);
                }

                if(node.right != null){
                    nodes.add(node.right);
                }
            }
        }
    }


    public static void main (String[] args){

    }
}
