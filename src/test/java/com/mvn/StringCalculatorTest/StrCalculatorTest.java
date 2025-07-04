package com.mvn.StringCalculatorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mvn.StringCalculator.StrCalculator;

//TDD Test Cases for String Calculator

public class StrCalculatorTest {
    private StrCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StrCalculator();
    }

    @Test
    @DisplayName("Test 1: Empty string should return 0")
    void shouldReturnZeroForEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    @DisplayName("Test 2: Single number should return the number itself")
    void shouldReturnSameNumberForSingleInput() {
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    @DisplayName("Test 3: Two numbers comma separated should return sum")
    void shouldReturnSumForTwoCommaSeparatedNumbers() {
        assertEquals(3, calculator.add("1,2"));
        assertEquals(10, calculator.add("4,6"));
    }

    @Test
    @DisplayName("Test 4: Multiple numbers comma separated should return sum")
    void shouldReturnSumForMultipleCommaSeparatedNumbers() {
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(10, calculator.add("1,2,3,4"));
    }

    @Test
    @DisplayName("Test 5: Handle new line characters between numbers")
    void shouldHandleNewLineCharactersAsDelimiters() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("1\n2\n3,4"));
    }

    @Test
    @DisplayName("Test 6: Support custom delimiters")
    void shouldSupportCustomDelimiters() {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(10, calculator.add("//|\n1|2|3|4"));
        assertEquals(6, calculator.add("//.\n1.2.3"));
    }

    @Test
    @DisplayName("Test 7: Throw exception for negative numbers")
    void shouldThrowExceptionForNegativeNumbers() {
        IllegalArgumentException negativeNumberException = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3");
        });
        assertTrue(negativeNumberException.getMessage().contains("Negatives not allowed"));
        assertTrue(negativeNumberException.getMessage().contains("[-2]"));
    }

    @Test
    @DisplayName("Test 8: Throw exception for multiple negative numbers")
    void shouldThrowExceptionForMultipleNegativeNumbers() {
        IllegalArgumentException multipleNegativeException = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,-3,4");
        });
        assertTrue(multipleNegativeException.getMessage().contains("Negatives not allowed"));
        assertTrue(multipleNegativeException.getMessage().contains("[-2, -3]"));
    }

    @Test
    @DisplayName("Test 10: Null input should return 0")
    void shouldReturnZeroForNullInput() {
        assertEquals(0, calculator.add(null));
    }

    @Test
    @DisplayName("Test 11: Complex scenario with custom delimiter and large numbers")
    void shouldHandleComplexScenarioWithCustomDelimiterAndLargeNumbers() {
        assertEquals(1007, calculator.add("//;\n1;2;3;1001"));
    }

    @Test
    @DisplayName("Test 12: Whitespace handling")
    void shouldHandleWhitespaceCorrectly() {
        assertEquals(6, calculator.add("1, 2, 3"));
        assertEquals(6, calculator.add(" 1 , 2 , 3 "));
    }

    @Test
    void shouldTreatMultipleSpecialCharactersAsDelimiters() {
        assertEquals(10, calculator.add("1@2#3!4")); // @, #, ! are treated as delimiters
    }

}