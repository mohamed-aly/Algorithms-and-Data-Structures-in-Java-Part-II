package com.algorithms.datacompression.huffman;

import java.util.PriorityQueue;

public class HuffmanAlgorithm {

    public Tree buildTree(int[] frequencies) {
        PriorityQueue<Tree> queue = new PriorityQueue<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                queue.add(new Leaf(frequencies[i], (char) i));
            }
        }

        while (queue.size() > 1){
            Tree tree1 = queue.poll();
            Tree tree2 = queue.poll();

            queue.add(new Node(tree1, tree2));
        }

        return queue.poll();
    }
}
