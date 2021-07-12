package com.algorithms.subStringSearch;

public class App {
    public static void main(String[] args) {
        BoyerMooreSearch boyerMooreSearch = new BoyerMooreSearch("this is a test...", "is");
        System.out.println(boyerMooreSearch.search());
    }
}
