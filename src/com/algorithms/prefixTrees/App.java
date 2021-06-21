package com.algorithms.prefixTrees;

public class App {
    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();
        trie.insert("Mohamed", "Mohamed@Gmail.com");
        trie.insert("ahmed", "ahmed@Gmail.com");
        trie.insert("aly", "aly@Gmail.com");
        trie.insert("elena", "elena@Gmail.com");

        System.out.println(trie.searchAsMap("elena"));
    }
}
