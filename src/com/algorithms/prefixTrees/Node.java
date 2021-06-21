package com.algorithms.prefixTrees;

public class Node {
    private String character;
    private Node[] children;
    private boolean isLeaf;
    private boolean isVisited;

    public Node(String character) {
        this.character = character;
        this.children = new Node[Constants.ALPHABET_SIZE];
    }

    public void addChild(int index, Node child) {
        this.children[index] = child;
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

    public Node[] getChildren() {
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

    public Node getChild(int index){
        return this.children[index];
    }


}
