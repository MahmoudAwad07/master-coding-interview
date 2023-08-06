package com.awadinhoo.code.mastercodinginterview.trees;

public class TestAVLTree {

    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(15);
        avlTree.insert(6);
        avlTree.insert(1);
        avlTree.insert(8);
        avlTree.insert(12);
        avlTree.insert(18);
        avlTree.insert(17);
        System.out.println(avlTree);


        AVLTree avlTree2 = new AVLTree();
        avlTree2.insert_enhanced(10);
        avlTree2.insert_enhanced(5);
        avlTree2.insert_enhanced(15);
        avlTree2.insert_enhanced(6);
        avlTree2.insert_enhanced(1);
        avlTree2.insert_enhanced(8);
        avlTree2.insert_enhanced(12);
        avlTree2.insert_enhanced(18);
        avlTree2.insert_enhanced(17);
        System.out.println(avlTree2);


        AVLTree avlTree3 = new AVLTree();
        avlTree3.insert_enhanced(10);
        avlTree3.insert_enhanced(20);
        avlTree3.insert_enhanced(30);
        System.out.println(avlTree3);


        AVLTree avlTree4 = new AVLTree();
        avlTree4.insert_enhanced(30);
        avlTree4.insert_enhanced(20);
        avlTree4.insert_enhanced(10);
        System.out.println(avlTree4);

        AVLTree avlTree5 = new AVLTree();
        avlTree5.insert_enhanced(10);
        avlTree5.insert_enhanced(30);
        avlTree5.insert_enhanced(20);
        System.out.println(avlTree5);

        AVLTree avlTree6 = new AVLTree();
        avlTree6.insert_enhanced(30);
        avlTree6.insert_enhanced(10);
        avlTree6.insert_enhanced(20);
        System.out.println(avlTree6);

    }
}
