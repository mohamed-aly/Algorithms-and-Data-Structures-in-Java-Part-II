package com.algorithms.tst;


public class TernarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void put(String key, T value) {
        this.root = put(this.root, key, value, 0);
    }

    private Node<T> put(Node<T> node, String key, T value, int index) {
        char c = key.charAt(index);
        if (node == null) {
            node = new Node<T>(c);
        }
        if (c < node.getCharacter()) {
            node.setLeftChild(put(node.getLeftChild(), key, value, index));
        } else if (c > node.getCharacter()) {
            node.setRightChild(put(node.getRightChild(), key, value, index));
        } else if (index < key.length() - 1) {
            node.setMiddleChild(put(node.getMiddleChild(), key, value, index + 1));
        } else {
            node.setValue(value);
        }

        return node;


    }

    public T get(String key) {
        Node<T> node = get(this.root, key, 0);

        if (node == null) {
            return null;
        }

        return node.getValue();
    }

    private Node<T> get(Node<T> node, String key, int index) {
        if (node == null) return null;

        char c = key.charAt(index);

        if (c < node.getCharacter()) {
            return get(node.getLeftChild(), key, index);
        } else if (c > node.getCharacter()) {
            return get(node.getRightChild(), key, index);
        } else if (index < key.length() - 1) {
            return get(node.getMiddleChild(), key, index + 1);
        } else {
            return node;
        }

    }


}
