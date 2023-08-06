package com.awadinhoo.code.mastercodinginterview.tries;

public class TestTrie {

    public static void main(String[] args) {


        Trie trie = new Trie();
        trie.insert("CAT");
        trie.insert("CANADA");
        System.out.println(trie);
        trie.insert("BOY");
        trie.insert("BOOK");
        System.out.println(trie);
        System.out.println(trie.contains("CAN"));
        System.out.println(trie.contains("CANADA"));
        System.out.println(trie.contains("BOOK"));
        System.out.println(trie.contains("BOO"));

        //System.out.println(trie.remove("CAN"));
        //System.out.println(trie.remove("CANADA"));
        System.out.println(trie.contains("CANADA"));
        System.out.println(trie.autoComplete("B"));
        System.out.println(trie.autoComplete("CA"));
        System.out.println(trie.autoComplete("CAN"));
        System.out.println(trie.autoComplete("CARGO"));
        System.out.println(trie.autoComplete(null));
        System.out.println(trie.autoComplete("C"));
    }
}
