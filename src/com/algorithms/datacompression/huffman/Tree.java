package com.algorithms.datacompression.huffman;

public class Tree implements Comparable<Tree> {

    private int frequency;

    public Tree(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Tree o) {
        return Integer.compare(this.frequency, o.getFrequency());
    }
}
