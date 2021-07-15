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

        while (getOperatorIndex(expression) > 0) {
            expression = replaceSyllablesWithEvaluations(expression, getOperatorIndex(expression));
        }

        return expression;
    }

    private static String replaceSyllablesWithEvaluations(String expression, int operatorIndex) {
        StringBuilder firstOperandBuilder = new StringBuilder();
        StringBuilder secondOperandBuilder = new StringBuilder();

        for (int i = operatorIndex - 1; i >= 0; i--) {
            if (isOperand(expression.charAt(i))) {
                firstOperandBuilder.append(expression.charAt(i));
            }else{
                break;
            }
        }
        
        firstOperandBuilder.reverse();
        
        for(int i = operatorIndex+1; i<expression.length(); i++){
            if (isOperand(expression.charAt(i))) {
                secondOperandBuilder.append(expression.charAt(i));
            }else{
                break;
            }
        }
        
        String firstOperand = firstOperandBuilder.toString();
        String secondOperand = secondOperandBuilder.toString();
        char operator = expression.charAt(operatorIndex);

        String syllable = firstOperand + operator + secondOperand;
        double evaluation = calculateSyllable(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand), operator);
        return expression.replace(syllable, String.valueOf(evaluation));
    }

    private static double calculateSyllable(double firstOperand, double secondOperand, char operator) {
        double evaluation;
        switch (operator){
            case '/': evaluation = firstOperand / secondOperand; break;
            case '*': evaluation = firstOperand * secondOperand; break;
            case '+': evaluation = firstOperand + secondOperand; break;
            case '-': evaluation = firstOperand - secondOperand; break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        
        return evaluation;
    }

    private static boolean isOperand(char c) {
        return (c >= '0' && c <= '9') || c == '.';
    }

    private static int getOperatorIndex(String expression) {
        if (expression.contains("/")) {
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
