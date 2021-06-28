package com.algorithms.prefixTrees;

public class Node<T extends Comparable<T>> {
    private String character;
    private Node<T>[] children;
    private T value;
    private boolean isLeaf;
    private boolean isVisited;

    public Node(String character) {
        this.character = character;
        this.children = new Node[Constants.ALPHABET_SIZE];
    }

    public void addChild(int index, Node<T> child, T value) {
        child.setValue(value);
        this.children[index] = child;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getCharacter() {
        return character;
    }

    public Node<T>[] getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public boolean isVisited() {
        return isVisited;
    }

    @Override
    public String toString() {
        return this.character;
    }

    public Node<T> getChild(int index){
        return this.children[index];
    }


}
