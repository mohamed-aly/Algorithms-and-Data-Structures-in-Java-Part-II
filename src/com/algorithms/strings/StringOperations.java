package com.algorithms.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    public static String evaluate(String expression) {

        expression = expression.replace(" ", "");


        return replaceSyllablesWithEvaluations(expression);
    }

    private static String replaceSyllablesWithEvaluations(String expression) {
        //"5 / 5 + (3 - 2) * 6 / 6"
        while (getOperatorIndex(expression) > 0) {

            int operatorIndex = getOperatorIndex(expression);
            char operator = expression.charAt(operatorIndex);
            boolean isBracketsSyllable = false;

            if (operator == '(') {
                isBracketsSyllable = true;
                int endBracketIndex = expression.indexOf(')');
                String bracketsSyllable = expression.substring(operatorIndex + 1, endBracketIndex);
                operatorIndex = getOperatorIndex(bracketsSyllable) + operatorIndex + 1;
                operator = expression.charAt(operatorIndex);
            }

            StringBuilder firstOperandBuilder = new StringBuilder();
            StringBuilder secondOperandBuilder = new StringBuilder();
            for (int i = operatorIndex - 1; i >= 0; i--) {
                if (isOperand(expression.charAt(i))) {
                    firstOperandBuilder.append(expression.charAt(i));
                } else {
                    break;
                }
            }

            firstOperandBuilder.reverse();

            for (int i = operatorIndex + 1; i < expression.length(); i++) {
                if (isOperand(expression.charAt(i))) {
                    secondOperandBuilder.append(expression.charAt(i));
                } else {
                    break;
                }
            }

            String firstOperand = firstOperandBuilder.toString();
            String secondOperand = secondOperandBuilder.toString();

            String syllable;
            if (isBracketsSyllable) {
                syllable = '(' + firstOperand + operator + secondOperand + ')';
            } else {
                syllable = firstOperand + operator + secondOperand;
            }

            double evaluation = calculateSyllable(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand), operator);
            expression = expression.replace(syllable, String.valueOf(evaluation));
        }

        return expression;
    }

    private static double calculateSyllable(double firstOperand, double secondOperand, char operator) {
        double evaluation;
        switch (operator) {
            case '^':
                evaluation = Math.pow(firstOperand, secondOperand);
                break;
            case '/':
                evaluation = firstOperand / secondOperand;
                break;
            case '*':
                evaluation = firstOperand * secondOperand;
                break;
            case '+':
                evaluation = firstOperand + secondOperand;
                break;
            case '-':
                evaluation = firstOperand - secondOperand;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        return evaluation;
    }

    private static boolean isOperand(char c) {
        return (c >= '0' && c <= '9') || c == '.';
    }

    private static int getOperatorIndex(String expression) {
        if (expression.contains("(")) {
            return expression.indexOf('(');
        } else if (expression.contains("^")) {
            return expression.indexOf('^');
        } else if (expression.contains("/")) {
            return expression.indexOf('/');
        } else if (expression.contains("*")) {
            return expression.indexOf('*');
        } else if (expression.contains("+")) {
            return expression.indexOf('+');
        } else if (expression.contains("-")) {
            return expression.indexOf('-');
        }

        return -1;
    }


}
