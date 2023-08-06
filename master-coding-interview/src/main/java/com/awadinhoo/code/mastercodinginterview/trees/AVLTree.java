package com.awadinhoo.code.mastercodinginterview.trees;

public class AVLTree {

    public AVLNode root;
    private int size;

    public AVLTree(){

    }

    public void insert(int val){
        if(root == null){
            root = new AVLNode(val);
            size++;
            return;
        }
        insert(root, val);
        size++;
    }

    private void insert(AVLNode current, int val){

        if( current.val > val){
            if( current.left == null ){
                current.left = new AVLNode(val);
                return;
            }
            insert(current.left, val);
        }else if(current.val < val ){
            if(current.right == null){
                current.right = new AVLNode(val);
                return;
            }
            insert(current.right, val);
        }
    }

    public void insert_enhanced(int val){
        root = insert_enhanced(root, val);
        size++;
    }

    private AVLNode insert_enhanced(AVLNode root, int val){

        if(root == null)
            return new AVLNode(val);

        // Insert node
        if( root.val > val){
            root.left = insert_enhanced(root.left, val);
        }else if(root.val < val ){
            root.right = insert_enhanced(root.right, val);
        }

        // update Height after inserting
        updateHeight(root);

        // check for balance, and rotate if there is unbalance
        return balanceTree(root);
    }

    private AVLNode balanceTree(AVLNode root) {

        if( isLeftHeavy(root)){
            // Left-Right Heavy
            if(getBalanceFactor(root.left) < 0)
                root.left = rotateLeft(root.left);
            // Left-Left Heavy
            return rotateRight(root);
        }else if(isRightHeavy(root)){
            // Right-Left Heavy
            if(getBalanceFactor(root.right) > 0)
                root.right = rotateRight(root.right);
            // Right-Right Heavy
            // Rotate Left
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {

        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;

    }

    private AVLNode rotateRight(AVLNode root) {

        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    private boolean isLeftHeavy(AVLNode root) {
        return getBalanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root) {
        return getBalanceFactor(root) < -1;
    }

    private int getNodeHeight(AVLNode node){
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(AVLNode node){
        return getNodeHeight(node.left) - getNodeHeight(node.right);
    }

    private void updateHeight(AVLNode node){
        node.height = 1 +
                Math.max(getNodeHeight(node.left), getNodeHeight(node.right));
    }


    @Override
    public String toString() {
        return "AVLTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    private class AVLNode {
        private int val;
        private AVLNode left;
        private AVLNode right;
        private int height = 1;

        public AVLNode(int val){
            this.val = val;
        }

        public AVLNode (int val, AVLNode left, AVLNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "AVLNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", height=" + height +
                    '}';
        }
    }
}
