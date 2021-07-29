package com.algorithms.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String expression;

    private final static String OPERAND_PATTERN = "[-+]?\\d+(\\.\\d+)?";
    private final static String ANY_OPERATOR_PATTERN = "\\s*[\\^\\/\\*\\+\\-]\\s*";
    private final static String PARENTHESIS_PATTERN = "\\(" + OPERAND_PATTERN + ANY_OPERATOR_PATTERN + OPERAND_PATTERN + "\\)";
    private final static String POWER_PATTERN = OPERAND_PATTERN + "\\s*\\^\\s*" + OPERAND_PATTERN;
    private final static String DIVISION_PATTERN = OPERAND_PATTERN + "\\s*\\/\\s*" + OPERAND_PATTERN;
    private final static String MULTIPLY_PATTERN = OPERAND_PATTERN + "\\s*\\*\\s*" + OPERAND_PATTERN;
    private final static String ADDITION_PATTERN = OPERAND_PATTERN + "\\s*\\+\\s*" + OPERAND_PATTERN;
    private final static String SUBTRACT_PATTERN = OPERAND_PATTERN + "\\s*\\-\\s*" + OPERAND_PATTERN;

    public Calculator(String expression) {
        this.expression = expression;
    }

    public void calculate() {
        //"5.5/ 5 + (3 - 2) * 6 / 6"
        while (selectPattern() != null){
            Pattern pattern = selectPattern();
            Matcher matcher = pattern.matcher(this.expression);
            while (matcher.find()) {
                String syllable = matcher.group();
                this.expression = replaceSyllableWithEvaluation(syllable);
            }
        }

        System.out.println(this.expression);

    }

    private Pattern selectPattern() {
        if (this.expression.contains("(")) {
            return Pattern.compile(PARENTHESIS_PATTERN);
        } else if (this.expression.contains("^")) {
            return Pattern.compile(POWER_PATTERN);
        } else if (this.expression.contains("/")) {
            return Pattern.compile(DIVISION_PATTERN);
        } else if (this.expression.contains("*")) {
            return Pattern.compile(MULTIPLY_PATTERN);
        } else if (this.expression.contains("+")) {
            return Pattern.compile(ADDITION_PATTERN);
        } else if (this.expression.contains("-")) {
            return Pattern.compile(SUBTRACT_PATTERN);
        } else {
            return null;
        }
    }

    private String replaceSyllableWithEvaluation(String syllable) {
        Pattern operatorPattern = Pattern.compile(ANY_OPERATOR_PATTERN);
        Matcher operatorMatcher = operatorPattern.matcher(syllable);

        Pattern operandPattern = Pattern.compile(OPERAND_PATTERN);
        Matcher operandMatcher = operandPattern.matcher(syllable);

        operatorMatcher.find();
        char operator = operatorMatcher.group().trim().charAt(0);

        operandMatcher.find();
        double firstOperand = Double.parseDouble(operandMatcher.group());

        operandMatcher.find();
        double secondOperand = Double.parseDouble(operandMatcher.group());

        double evaluation = calculateSyllable(firstOperand, secondOperand, operator);

        return this.expression.replace(syllable, String.valueOf(evaluation));
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

}
