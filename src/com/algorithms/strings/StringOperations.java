package com.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class StringOperations {

    public static List<String> getSuffixes(String text){
        int length = text.length();
        List<String> suffixes = new ArrayList<>();
        for(int index = 0; index<length; index++){
            suffixes.add(text.substring(index, length));
        }

        return suffixes;
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
        }else if (expression.contains("^")) {
            return expression.indexOf('^');
        }else if (expression.contains("/")) {
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
