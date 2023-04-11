package com.awadinhoo.code.mastercodinginterview.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private BinaryTreeNode root;
    private int size;

    public BinaryTree() {

    }

    public BinaryTree(int val) {
        root = new BinaryTreeNode(val);
    }

    public void add(int val){

        if(root == null){
            root = new BinaryTreeNode(val);
        }else {

            BinaryTreeNode newNode = new BinaryTreeNode(val);
            BinaryTreeNode node = root;
            while (true){

                // Move left
                if(node.val > val){
                     // leaf node
                    if(node.left == null){
                        node.left = newNode;
                        break;
                    }
                    node = node.left;
                // Move right
                }else {
                    // leaf node
                    if(node.right == null){
                        node.right = newNode;
                        break;
                    }
                    node = node.right;
                }

                /*
                if(node.val > val && node.left == null) {
                    node.left = newNode;
                    break;
                }else if(node.val > val && node.left != null){
                    node = node.left;
                }else if(node.val <= val && node.right == null ) {
                    node.right = newNode;
                    break;
                }else if (node.val <= val && node.right != null) {
                    node = node.right;
                }
                 */
            }
        }
    }

    public boolean contains(int val){

        BinaryTreeNode node = root;
        while (node != null){

            if(node.val == val ) {
                return true;
            }else if(node.val > val){
                node = node.left;
            }else {
                node = node.right;
            }
        }
       return false;
    }

    public List<Integer> preOrderTraversalDFS(){
        ArrayList<Integer> list = new ArrayList<>();
        preOrderTraversalDFS(root, list);
        return list;
    }

    private void preOrderTraversalDFS(BinaryTreeNode root, List<Integer> list){

        if(root == null){
            return;
        }
        list.add(root.val);
        preOrderTraversalDFS(root.left,list);
        preOrderTraversalDFS(root.right,list);
    }

    public List<Integer> inOrderTraversalDFS(){
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraversalDFS(root, list);
        return list;
    }

    private void inOrderTraversalDFS(BinaryTreeNode root, List<Integer> list){

        if(root == null){
            return;
        }
        inOrderTraversalDFS(root.left,list);
        list.add(root.val);
        inOrderTraversalDFS(root.right,list);
    }


    public List<Integer> postOrderTraversalDFS(){
        ArrayList<Integer> list = new ArrayList<>();
        postOrderTraversalDFS(root, list);
        return list;
    }

    private void postOrderTraversalDFS(BinaryTreeNode root, List<Integer> list){

        if(root == null){
            return;
        }
        postOrderTraversalDFS(root.left,list);
        postOrderTraversalDFS(root.right,list);
        list.add(root.val);
    }

    public int height(){
        return height(root);
    }

    private int height(BinaryTreeNode root){

        if(root == null){
            return -1;
        }

        if(isLeaf(root)){
            return 0;
        }
        return (1 + Math.max(height(root.left), height(root.right)));

    }

    public int min(){

        if(root == null){
            throw new IllegalStateException("Binary Tree is Empty");
        }
       return minBT(root);
    }

    private int minBST(BinaryTreeNode root){

        if(root.left == null){
            return root.val;
        }

        return minBST(root.left);
    }

    private int minBT(BinaryTreeNode root){

        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(isLeaf(root)){
            return root.val;
        }

        return Math.min(Math.min(minBT(root.left),minBT(root.right)), root.val);
    }

    private boolean isLeaf(BinaryTreeNode root){
        return root.left == null && root.right == null;
    }


    private class BinaryTreeNode{

        private int val;
        private BinaryTreeNode right;
        private BinaryTreeNode left;

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "val=" + val +
                    ", right=" + right +
                    ", left=" + left +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree newTree = (BinaryTree) o;

        return isEqualsBT(root ,newTree.root);
    }

    private boolean isEqualsBT(BinaryTreeNode root, BinaryTreeNode newRoot) {

        if(root == null && newRoot == null){
            return true;
        }

        if( (root != null && newRoot == null) || (root == null && newRoot != null) ){
            return false;
        }

        return  (root.val == newRoot.val) && isEqualsBT(root.left , newRoot.left) && isEqualsBT(root.right , newRoot.right);
    }


    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
