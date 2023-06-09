package com.awadinhoo.code.mastercodinginterview.trees;

public class TestBinaryTree {



    public static void main(String[] args) {

        // [10, 5, 15, 6, 1, 8, 12, 18, 17]
        BinaryTree binaryTree = new BinaryTree();
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
        //            10
        //        5                   15
        //    1        6         12          18
        // null null       8              17    null

        System.out.println(binaryTree.contains(18));
        System.out.println(binaryTree.contains(20));

        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.add(20);
        binaryTree2.add(10);
        binaryTree2.add(6);
        binaryTree2.add(14);
        binaryTree2.add(3);
        binaryTree2.add(8);
        binaryTree2.add(30);
        binaryTree2.add(24);
        binaryTree2.add(26);

        System.out.println("Pre Order DFS");
        System.out.println(binaryTree.preOrderTraversalDFS());
        System.out.println(binaryTree2.preOrderTraversalDFS());
        System.out.println("*************************************");
        System.out.println("In Order DFS");
        System.out.println(binaryTree.inOrderTraversalDFS());
        System.out.println(binaryTree2.inOrderTraversalDFS());
        System.out.println("*************************************");
        System.out.println("Post Order DFS");
        System.out.println(binaryTree.postOrderTraversalDFS());
        System.out.println(binaryTree2.postOrderTraversalDFS());

        System.out.println("Height of the tree: " + binaryTree.height());
        System.out.println("Height of the tree: " + binaryTree2.height());

        System.out.println("Minimum value of the tree: " + binaryTree.min());
        System.out.println("Minimum value of the tree: " + binaryTree2.min());


        BinaryTree binaryTree3 = new BinaryTree();
        binaryTree3.add(20);
        binaryTree3.add(10);
        binaryTree3.add(6);
        binaryTree3.add(14);
        binaryTree3.add(3);
        binaryTree3.add(8);
        binaryTree3.add(30);
        binaryTree3.add(24);
        binaryTree3.add(26);

        BinaryTree binaryTree4 = new BinaryTree();
        binaryTree4.add(20);
        binaryTree4.add(10);
        binaryTree4.add(6);
        binaryTree4.add(14);
        binaryTree4.add(3);
        binaryTree4.add(8);
        binaryTree4.add(30);
        binaryTree4.add(26);

        System.out.println(binaryTree2.equals(binaryTree4));



    }
}
