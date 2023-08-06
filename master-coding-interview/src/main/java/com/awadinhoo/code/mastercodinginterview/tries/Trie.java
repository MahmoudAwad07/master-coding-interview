package com.awadinhoo.code.mastercodinginterview.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private TrieNode root = new TrieNode(' ');

    public void insert(String word){

        TrieNode current = root;
        for (char ch : word.toCharArray()){
            // check if the character is not in the current children
            // add the new child
            if(!current.hasChild(ch)){
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        // end of word
        current.isEndOfWord = true;
    }


    public boolean contains(String word){

        if(word == null)
            return false;

        TrieNode current = root;
        for (char ch : word.toCharArray()){
            // current does not contain this character
            // word is not found
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        // if the last character is end of word it means that the word is found, else word is not found
        return current.isEndOfWord;
    }

    public boolean remove(String word){
        if(word == null)
            throw new IllegalArgumentException();
        return remove(root, word, 0);
    }

    private boolean remove(TrieNode current, String word , int index){

        // last char && end of word
        if(index == word.length() && current.isEndOfWord){
            current.isEndOfWord = false;
            return true;
        }else if(index == word.length()) {
            return false;
        }
        // get the child
        char ch = word.charAt(index);
        TrieNode child = current.getChild(ch);
        // there is no match
        if(child == null)
           return false;

        boolean removed = remove(child , word, index + 1 );

        if(!child.hasChildren() && !child.isEndOfWord ){
            current.removeChild(ch);
        }

        return removed;
    }

    public void traverse(){
        preOrderTraverse(root);
    }

    private void preOrderTraverse(TrieNode current){
        // Pre-Order Traverse
        System.out.println(current.value);

        // get Children
        for (TrieNode child : current.getChildren()){
            preOrderTraverse(child);
        }
    }

    private void postOrderTraverse(TrieNode current){

        // get Children
        for (TrieNode child : current.getChildren()){
            postOrderTraverse(child);
        }
        // Post-Order Traverse
        System.out.println(current.value);
    }

    public List<String> autoComplete(String prefix) {

        if(prefix == null)
            return new ArrayList<>();

        List<String> words = new ArrayList<>();
        TrieNode lastPrefixNode = findLastPrefixNode(root, prefix);
        autoComplete(lastPrefixNode, prefix, words);
        return words;
    }

    private TrieNode findLastPrefixNode(TrieNode root , String prefix){

        TrieNode current = root;
        for(char ch : prefix.toCharArray()){
            current = current.getChild(ch);
            if(current == null)
                return null;
        }
        return current;
    }

    private void autoComplete(TrieNode current, String prefix, List<String> words){

        if(current == null)
            return;

        // if the current is the end of word add it to the expected words
        if (current.isEndOfWord)
            words.add(prefix);

        // get the children
        for (TrieNode child : current.getChildren()){
            autoComplete(child, prefix + child.value , words);
        }
    }


    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }
    private class TrieNode {
        private char value;
        private HashMap<Character , TrieNode> children = new HashMap<>();
        private boolean isEndOfWord;

        public TrieNode(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch){
            return children.get(ch);
        }

        public TrieNode[] getChildren(){
            return children.values().toArray(new TrieNode[0]);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void removeChild(char ch){
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "value=" + value +
                    ", children=" + children +
                    ", isEndOfWord=" + isEndOfWord +
                    '}';
        }
    }
}
