package com.algorithms.datacompression.huffman;

public class Leaf extends Tree {

    private char value;

    public Leaf(int frequency) {
        super(frequency);
    }

    public Leaf(int frequency, char value) {
        super(frequency);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
