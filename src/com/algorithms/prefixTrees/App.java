package com.algorithms.prefixTrees;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();
        trie.insert("adam", "Mohamed@Gmail.com");
        trie.insert("adaa", "ahmed@Gmail.com");
        trie.insert("adazz", "aly@Gmail.com");
        trie.insert("adamm", "elena@Gmail.com");

        System.out.println(trie.longestCommonPrefix());
    }
}
