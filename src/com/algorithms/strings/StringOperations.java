package com.algorithms.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperations {



    public static List<String> getSuffixes(String text) {
        int length = text.length();
        List<String> suffixes = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            suffixes.add(text.substring(index, length));
        }

        return suffixes;
    }

    public static List<String> getPrefixes(String text) {
        int length = text.length();
        List<String> prefixes = new ArrayList<>();
        for (int index = 1; index < length + 1; index++) {
            prefixes.add(text.substring(0, index));
        }

        return prefixes;
    }

    public static String longestCommonPrefix(String text1, String text2) {
        int commonLength = Math.min(text1.length(), text2.length());

        for (int index = 0; index < commonLength; index++) {
            if (text1.charAt(index) != text2.charAt(index)) {
                return text1.substring(0, index);
            }
        }

        return text2.substring(0, commonLength);
    }

    public static String longestRepeatedPrefix(String text) {
        int length = text.length();
        List<String> suffixes = getSuffixes(text);
        Collections.sort(suffixes);

        String longestSubstring = "";

        for (int i = 0; i < length - 1; i++) {

            String first = suffixes.get(i);
            String second = suffixes.get(i + 1);

            String temp = longestCommonPrefix(first, second);

            if (temp.length() > longestSubstring.length()) {
                longestSubstring = temp;
            }
        }

        return longestSubstring;
    }

    public static String reverseString(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            stringBuilder.append(text.charAt(i));
        }
        return stringBuilder.toString();
    }


}
