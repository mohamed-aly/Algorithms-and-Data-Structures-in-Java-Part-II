package com.algorithms.tst;

import com.algorithms.prefixTrees.Constants;

public class Node<T extends Comparable<T>> {
    private char character;
    private T value;
    private Node<T> leftChild;
    private Node<T> middleChild;
    private Node<T> rightChild;

    public Node(char character) {
        this.character = character;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getMiddleChild() {
        return middleChild;
    }

    public void setMiddleChild(Node<T> middleChild) {
        this.middleChild = middleChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.valueOf(this.character);
    }


}
