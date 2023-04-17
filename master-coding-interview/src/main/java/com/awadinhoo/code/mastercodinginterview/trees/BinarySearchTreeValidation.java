package com.awadinhoo.code.mastercodinginterview.trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeValidation {


    // the first implementation has an edge case that is the root is the max integer or the min
    // the method will return false
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ;
    }

    private static boolean isValidBST(TreeNode root, int min , int max){

        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        return isValidBST(root.left, min , root.val) && isValidBST(root.right, root.val , max);
    }

    public static boolean isValidBST_v2(TreeNode root) {
        return isValidBST_v2(root, null, null) ;
    }

    private static boolean isValidBST_v2(TreeNode root, Integer min , Integer max){

        if(root == null){
            return true;
        }

        if( (min != null && root.val <= min) || (max != null && root.val >= max) ){
            return false;
        }

        return isValidBST_v2(root.left, min , root.val) && isValidBST_v2(root.right, root.val , max);

    }

    public static boolean isValidBST_v3(TreeNode root) {
        List<Integer> orderedList = new ArrayList<>();
        isValidBST_v3(root,orderedList);

        System.out.println("Ordered List: " + orderedList);
        for(int i = 0; i < orderedList.size() - 1; i++){
            if(orderedList.get(i) > orderedList.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private static void isValidBST_v3(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }

        isValidBST_v3(root.left, list);
        list.add(root.val);
        isValidBST_v3(root.right, list);
    }

    public static boolean isValidBST_v4(TreeNode root) {

        return isValidBST_v4(root,null);
    }

    private static boolean isValidBST_v4(TreeNode root, Integer prev){

        if(root == null){
            return true;
        }

        if(!isValidBST_v4(root.left, prev)){
            return false;
        }

        if(prev != null && prev > root.val){
            return false;
        }

        prev = root.val;
        return isValidBST_v4(root.right, prev);
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

        System.out.println(isValidBST(binaryTree));
        System.out.println(isValidBST_v3(binaryTree));
        System.out.println(isValidBST_v4(binaryTree));

    }
}
