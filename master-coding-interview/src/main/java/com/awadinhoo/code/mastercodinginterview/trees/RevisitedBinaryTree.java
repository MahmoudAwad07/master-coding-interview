package com.awadinhoo.code.mastercodinginterview.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RevisitedBinaryTree {

    public RevisitedBinaryTreeNode root;
    private int size;

    public RevisitedBinaryTree() {

    }

    public void add(Integer value) {
        // creating new node
        RevisitedBinaryTreeNode newNode = new RevisitedBinaryTreeNode(value);

        // check if the tree is empty
        if (root == null) {
            root = newNode;
        } else {
            // tree contains nodes
            RevisitedBinaryTreeNode current = root;
            while (true) {

                // check if new node is greater
                if (newNode.val > current.val) {

                    // the new position
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    }
                    // still searching
                    current = current.right;
                    // new node is smaller than the current
                } else {

                    // the new position
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    }
                    // still searching
                    current = current.left;
                }
            }
        }
        size++;
    }


    public Boolean contains(Integer value) {

        RevisitedBinaryTreeNode current = root;
        while (current != null) {
            // check if new node is greater than the current
            if (value > current.val) {
                current = current.right;
                // new node is smaller than the current
            } else if (value < current.val) {
                current = current.left;
                // found the value
            } else {
                return true;
            }
        }
        return false;
    }

    public void inOrderTraverse(){
        List<Integer> inOrderList = new ArrayList<>();
        inOrderTraverse(root, inOrderList);
        System.out.println(inOrderList);
    }

    private void inOrderTraverse(RevisitedBinaryTreeNode current, List<Integer> orderedList){

        if(current == null){
            return;
        }
        // Left Branch
        inOrderTraverse(current.left, orderedList);

        orderedList.add(current.val);
        // Right Branch
        inOrderTraverse(current.right, orderedList);

    }


    public void preOrderTraverse(){
        List<Integer> preOrderList = new ArrayList<>();
        preOrderTraverse(root, preOrderList);
        System.out.println(preOrderList);
    }

    private void preOrderTraverse(RevisitedBinaryTreeNode current, List<Integer> orderedList){

        if(current == null){
            return;
        }
        orderedList.add(current.val);
        // Left Branch
        preOrderTraverse(current.left, orderedList);
        // Right Branch
        preOrderTraverse(current.right, orderedList);

    }

    public void postOrderTraverse(){
        List<Integer> postOrderList = new ArrayList<>();
        postOrderTraverse(root, postOrderList);
        System.out.println(postOrderList);
    }

    private void postOrderTraverse(RevisitedBinaryTreeNode current, List<Integer> orderedList){

        if(current == null){
            return;
        }
        // Left Branch
        postOrderTraverse(current.left, orderedList);
        // Right Branch
        postOrderTraverse(current.right, orderedList);

        orderedList.add(current.val);

    }

    public int height(){
        return height(root);
    }

    private int height(RevisitedBinaryTreeNode current){

        if(current == null || isLeaf(current)){
            return 0;
        }
        return 1 + Math.max(height(current.left), height(current.right));
    }

    private boolean isLeaf(RevisitedBinaryTreeNode current) {
        return current.left == null && current.right == null;
    }

    public int minValue(){
        if(root == null)
            throw new NoSuchElementException("Tree is empty");
        return minValue(root);
    }

    private int minValue(RevisitedBinaryTreeNode current){

        if(current == null ){
            return Integer.MAX_VALUE;
        }else if(isLeaf(current)){
            return current.val;
        }

        return Math.min(current.val ,
                Math.min(minValue(current.left) , minValue(current.right)));

    }

    public Boolean equals(RevisitedBinaryTree otherTree){
        if(root == null || otherTree == null || otherTree.root == null){
            return false;
        }
        return equals(root, otherTree.root);
    }

    private Boolean equals(RevisitedBinaryTreeNode node, RevisitedBinaryTreeNode otherNode){

        if(node == null && otherNode == null){
            return true;
        }

        if(node != null && otherNode != null ){
            return node.val.equals(otherNode.val)
                    && equals(node.left, otherNode.left)
                    && equals(node.right, otherNode.right);
        }

        return false;
    }

    public Boolean isValidBST(){
        if(root == null)
            return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Boolean isValidBST(RevisitedBinaryTreeNode current, Integer min, Integer max){

        if(current == null)
            return true;

        Integer currentValue = current.val;
        if (currentValue <= min || currentValue >= max ) {
            return false;
        }

        return isValidBST(current.left, min, currentValue) && isValidBST(current.right, currentValue, max);

    }




//    public Boolean delete(Integer value){
//
//        // check if the tree is empty
//        if (root == null)
//            throw new NoSuchElementException("Tree is empty");
//
//        // tree contains nodes
//        RevisitedBinaryTreeNode current = root;
//        while (current != null){
//
//            // check if new node is greater than the current
//            if(value > current.val){
//                current = current.right;
//                // new node is smaller than the current
//            }else if(value < current.val) {
//                current = current.left;
//                // found the value
//            }else {
//                return true;
//            }
//        }
//        size--;
//    }


    @Override
    public String toString() {
        return "RevisitedBinaryTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    private class RevisitedBinaryTreeNode {
        private Integer val;
        private RevisitedBinaryTreeNode left;
        private RevisitedBinaryTreeNode right;

        private RevisitedBinaryTreeNode(Integer val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "RevisitedBinaryTreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    "}";
        }
    }
}
