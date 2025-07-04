package com.mvn;

import com.mvn.StringCalculator.StrCalculator;

public class Main {
    public static void main(String[] args) {
        StrCalculator calculator = new StrCalculator();

        // Demo the String Calculator
        try {
            System.out.println("String Calculator Demo:");
            System.out.println("Empty string: " + calculator.add(""));
            System.out.println("Single number: " + calculator.add("1"));
            System.out.println("Two numbers: " + calculator.add("1,2"));
            System.out.println("Multiple numbers: " + calculator.add("1,2,3,4,5"));
            System.out.println("New line delimiter: " + calculator.add("1\n2,3"));
            System.out.println("Custom delimiter: " + calculator.add("//;\n1;2"));
            System.out.println("For specialcharacter" + calculator.add("67*7"));
        } catch (RuntimeException e) {
            System.out.println("Exception caught during demo: " + e.getMessage());
        }

        // Example of handling negative numbers
        // This will throw an exception for negative numbers
        try {
            calculator.add("1,-2,3");
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}