package com.algorithms.datacompression;

public class App {
    public static void main(String[] args) {
        String source = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBCCDEEEEEF";
        String encoded = RunLengthEncoder.encode(source);

        System.out.println(encoded);

        String decoded = RunLengthEncoder.decode(encoded);
        System.out.println(decoded);
    }
}
