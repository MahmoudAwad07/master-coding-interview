package com.awadinhoo.code.mastercodinginterview.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NodesKDistanceInBinaryTreeV2 {


    List<Integer> ans;
    TreeNode target;
    int K;
    public  List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node.val == target.val) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) ans.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
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

        NodesKDistanceInBinaryTreeV2 distance = new NodesKDistanceInBinaryTreeV2();
        distance.distanceK(binaryTree, new TreeNode(10), 2);
        System.out.println(distance.ans);


    }

}
