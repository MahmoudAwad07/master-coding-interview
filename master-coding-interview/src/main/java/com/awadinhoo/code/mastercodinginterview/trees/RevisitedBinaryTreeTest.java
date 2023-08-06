package com.awadinhoo.code.mastercodinginterview.trees;

public class RevisitedBinaryTreeTest {



    public static void main(String[] args) {

        RevisitedBinaryTree binaryTree = new RevisitedBinaryTree();
        binaryTree.add(10);
        binaryTree.add(5);
        binaryTree.add(15);
        binaryTree.add(6);
        binaryTree.add(1);
        binaryTree.add(8);
        binaryTree.add(12);
        binaryTree.add(18);
        binaryTree.add(17);
        System.out.println(binaryTree);
        System.out.println(binaryTree.contains(17));
        System.out.println(binaryTree.contains(12));
        System.out.println(binaryTree.contains(30));


        RevisitedBinaryTree binaryTree2 = new RevisitedBinaryTree();
        binaryTree2.add(20);
        binaryTree2.add(10);
        binaryTree2.add(6);
        binaryTree2.add(14);
        binaryTree2.add(3);
        binaryTree2.add(8);
        binaryTree2.add(30);
        binaryTree2.add(24);
        binaryTree2.add(26);
        binaryTree2.add(7);
        System.out.println(binaryTree2);
        binaryTree2.inOrderTraverse();
        binaryTree2.preOrderTraverse();
        binaryTree2.postOrderTraverse();

        System.out.println(binaryTree2.height());
        System.out.println(binaryTree2.minValue());


        RevisitedBinaryTree binaryTree3 = new RevisitedBinaryTree();
        binaryTree3.add(20);
        binaryTree3.add(10);
        binaryTree3.add(6);
        binaryTree3.add(14);
        binaryTree3.add(3);
        binaryTree3.add(8);
        binaryTree3.add(30);
        binaryTree3.add(24);
        binaryTree3.add(26);
        binaryTree3.add(7);
        System.out.println(binaryTree2.equals(binaryTree3));
        binaryTree3.add(5);
        System.out.println(binaryTree2.equals(binaryTree3));

        System.out.println(binaryTree2.isValidBST());



    }
}
