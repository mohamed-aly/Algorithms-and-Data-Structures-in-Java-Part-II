package com.algorithms.prefixTrees;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();
        trie.insert("adam", "Mohamed@Gmail.com");
        trie.insert("adaa", "ahmed@Gmail.com");
        trie.insert("adzzz", "aly@Gmail.com");
        trie.insert("admm", "elena@Gmail.com");

        List<String> list = trie.allWordsWithPrefix("adam");

        System.out.println(list);
    }
}
