package com.algorithms.prefixTrees;

import java.util.Arrays;

public class Trie {
    private Node root;

    public Trie() {
        this.root = new Node("");
    }

    public void insert(String key) {
        Node tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            key = key.toLowerCase();
            char c = key.charAt(i);
            int asciiIndex = c - 'a';

            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(c));
                tempNode.addChild(asciiIndex, node);
                tempNode = node;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        tempNode.setLeaf(true);
    }

    public boolean has(String key) {
        key = key.toLowerCase();
        Node tempNode = this.root;

        for (int counter = 0; counter < key.length(); counter++) {
            char c = key.charAt(counter);
            int asciiIndex = c - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                return false;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        return tempNode.isLeaf();
    }

}
