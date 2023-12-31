package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {


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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leafsTree1 = new ArrayList<>();
        List<Integer> leafsTree2 = new ArrayList<>();
        fillLeafNodes(root1, leafsTree1);
        fillLeafNodes(root2, leafsTree2);

        return leafsTree1.equals(leafsTree2);
    }

    private void fillLeafNodes(TreeNode root, List<Integer> leafsTree){

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            leafsTree.add(root.val);
            return;
        }

        fillLeafNodes(root.left, leafsTree);
        fillLeafNodes(root.right, leafsTree);
    }

    public static void main (String[] args ){

    }
}
