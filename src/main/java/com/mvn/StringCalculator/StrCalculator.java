package com.mvn.StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StrCalculator {

    // Constants for better maintainability
    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE = "\n";
    private static final String SPECIAL_CHAR_PATTERN = "[^0-9,\n\\-]";
    private static final String COMMA_REPLACEMENT = ",";

    // Return 0 when input is empty
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        DelimiterResult delimiterResult = extractDelimiter(numbers);
        String[] numberParts = parseNumbers(delimiterResult.numbers, delimiterResult.delimiter);

        return calculateSum(numberParts);
    }

    // Handle custom delimiter like: //;\n1;2
    private DelimiterResult extractDelimiter(String numbers) {
        // Default delimiter is comma or newline
        String delimiter = DEFAULT_DELIMITER;

        if (numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = numbers.indexOf(NEWLINE);
            String customDelimiter = numbers.substring(2, delimiterIndex);
            delimiter = Pattern.quote(customDelimiter);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        return new DelimiterResult(numbers, delimiter);
    }

    // Replace special characters (except digits, commas, minus, newline) with commas
    // Always split by comma or newline
    private String[] parseNumbers(String numbers, String delimiter) {
        numbers = numbers.replaceAll(SPECIAL_CHAR_PATTERN, COMMA_REPLACEMENT);
        return numbers.split(DEFAULT_DELIMITER);
    }

    // Calculate the sum of numbers, handling negative numbers
    private int calculateSum(String[] numberParts) {
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String numberString : numberParts) {
            if (!numberString.isBlank()) {
                int currentNumber = Integer.parseInt(numberString.trim());
                if (currentNumber < 0) {
                    negativeNumbers.add(currentNumber);
                } else {
                    sum += currentNumber;
                }
            }
        }

        validateNoNegatives(negativeNumbers);
        return sum;
    }

    // Validate that no negative numbers are present in the input
    private void validateNoNegatives(List<Integer> negativeNumbers) {
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }
    }

    private static class DelimiterResult {

        final String numbers;
        final String delimiter;

        DelimiterResult(String numbers, String delimiter) {
            this.numbers = numbers;
            this.delimiter = delimiter;
        }
    }
}
