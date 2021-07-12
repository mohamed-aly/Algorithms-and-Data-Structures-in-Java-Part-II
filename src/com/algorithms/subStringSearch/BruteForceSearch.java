package com.algorithms.subStringSearch;

public class BruteForceSearch {
    public static int search(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }

            }
            if (j == patternLength) return i;
        }

        return -1;
    }
}
