package com.algorithms.subStringSearch;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreSearch {
    private String text;
    private String pattern;
    private Map<Character, Integer> mismatchShiftTable;

    public BoyerMooreSearch(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.mismatchShiftTable = new HashMap<>();
        misMatchShiftTableBuilder();
    }

    public int search() {
        int patternLength = this.pattern.length();
        int textLength = this.text.length();
        int numOfSkips;

        for (int i = 0; i <= textLength - patternLength; i += numOfSkips) {
            numOfSkips = 0;

            for (int j = patternLength - 1; j >= 0; j--) {
                if (this.text.charAt(i + j) != this.pattern.charAt(j)) {
                    char c = this.text.charAt(i + j);
                    if (this.mismatchShiftTable.get(c) != null) {
                        numOfSkips = this.mismatchShiftTable.get(c);
                    } else {
                        numOfSkips = patternLength;
                    }
                    break;
                }
            }

            if (numOfSkips == 0) return i;

        }

        return -1;
    }

    private void misMatchShiftTableBuilder() {
        int patternLength = this.pattern.length();
        for (int index = 0; index < patternLength; index++) {
            char c = this.pattern.charAt(index);
            int maxSkip = Math.max(1, patternLength - index - 1);
            this.mismatchShiftTable.put(c, maxSkip);
        }
    }
}
