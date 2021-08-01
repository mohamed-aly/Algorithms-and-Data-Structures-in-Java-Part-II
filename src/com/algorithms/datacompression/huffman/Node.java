package com.algorithms.datacompression.huffman;

public class Node extends Tree {

    private Tree leftTree;
    private Tree rightTree;

    public Node(Tree leftTree, Tree rightTree) {
        super(leftTree.getFrequency() + rightTree.getFrequency());
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public Tree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(Tree leftTree) {
        this.leftTree = leftTree;
    }

    public Tree getRightTree() {
        return rightTree;
    }

    public void setRightTree(Tree rightTree) {
        this.rightTree = rightTree;
    }
}
