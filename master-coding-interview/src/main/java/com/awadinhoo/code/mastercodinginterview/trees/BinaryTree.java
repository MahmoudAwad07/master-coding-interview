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
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
