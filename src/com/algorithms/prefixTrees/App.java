package com.algorithms.prefixTrees;

public class App {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Mohamed");
        trie.insert("ahmed");
        trie.insert("aly");
        trie.insert("elena");

        System.out.println(trie.has("Mohamed"));
    }
}
