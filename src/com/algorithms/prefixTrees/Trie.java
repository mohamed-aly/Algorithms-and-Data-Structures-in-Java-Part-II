package com.algorithms.prefixTrees;

import java.util.ArrayList;
import java.util.List;

public class Trie<T extends Comparable<T>> {
    private Node<T> root;

    public Trie() {
        this.root = new Node<>("");
    }

    public void insert(String key, T value) {
        Node<T> tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            key = key.toLowerCase();
            char c = key.charAt(i);
            int asciiIndex = c - 'a';

            if (tempNode.getChild(asciiIndex) == null) {
                Node<T> node = new Node<>(String.valueOf(c));
                tempNode.addChild(asciiIndex, node, value);
                tempNode = node;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        tempNode.setLeaf(true);
    }

    public boolean search(String key) {
        key = key.toLowerCase();
        Node<T> tempNode = this.root;

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

    public T searchAsMap(String key) {
        key = key.toLowerCase();
        Node<T> tempNode = this.root;

        for (int counter = 0; counter < key.length(); counter++) {
            char c = key.charAt(counter);
            int asciiIndex = c - 'a';
            if (tempNode.getChild(asciiIndex) != null) {
                tempNode = tempNode.getChild(asciiIndex);
            } else {
                return null;
            }
        }

        return tempNode.getValue();
    }

    public List<String> allWordsWithPrefix(String prefix) {
        Node<T> node = this.root;
        List<String> words = new ArrayList<>();

        for(int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            int index = c-'a';
            node = node.getChild(index);
        }

        collect(node, prefix, words);

        return words;
    }

    private void collect(Node<T> node, String prefix, List<String> words) {
        if(node == null) return;

        if(node.isLeaf()){
            words.add(prefix);
        }

        for(Node<T> child : node.getChildren()){
            if(child == null) continue;
            String character = child.getCharacter();
            collect(child, prefix+character, words);
        }
    }

    public List<String> traverse(){
        return allWordsWithPrefix("");
    }

}
