package com.algorithms.strings;

public class StringOperations {

    public static String reverseString(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            stringBuilder.append(text.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String evaluate(String expression) {
        //"5 / 5 + 3 - 2 * 6 / 6"
        expression = expression.replace(" ", "");
        while (operatorIndex(expression) > 0) {
            expression = replaceSyllableWithEvaluation(expression, operatorIndex(expression));
        }

        return expression;

    }

    private static int operatorIndex(String expression) {
        if (expression.indexOf("/") > 0) {
            return expression.indexOf("/");
        } else if (expression.indexOf("*") > 0) {
            return expression.indexOf("*");
        } else if (expression.indexOf("+") > 0) {
            return expression.indexOf("+");
        } else if (expression.indexOf("-") > 0) {
            return expression.indexOf("-");
        }

        return -1;
    }

    private static String replaceSyllableWithEvaluation(String expresion, int operatorIndex) {
        String syllable;
        if (operatorIndex >= expresion.length() - 2) {
            syllable = expresion.substring(operatorIndex - 1);
        } else {
            syllable = expresion.substring(operatorIndex - 1, operatorIndex + 2);
        }

        return expresion.replace(syllable, calculateSyllable(syllable));

    }

    private static String calculateSyllable(String syllable) {
        int firstOperand = operandValue(syllable.charAt(0));
        char operator = syllable.charAt(1);
        int secondOperand = operandValue(syllable.charAt(2));
        int sum;

        switch (operator) {
            case '/':
                sum = firstOperand / secondOperand;
                break;
            case '*':
                sum = firstOperand * secondOperand;
                break;
            case '+':
                sum = firstOperand + secondOperand;
                break;
            case '-':
                sum = firstOperand - secondOperand;
                break;
            default:
                sum = -1;
        }

        return String.valueOf(sum);
    }

    private static int operandValue(char c) {
        return c - '0';
    }
}
