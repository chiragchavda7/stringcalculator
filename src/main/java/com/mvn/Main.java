package com.mvn;

import java.util.Scanner;

import com.mvn.StringCalculator.StrCalculator;

public class Main {
    public static void main(String[] args) {
        StrCalculator calculator = new StrCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the String Calculator!");
        System.out.println("=== String Calculator ===");
        System.out.println("Enter input as a string (e.g., \"1,2,3\" or \"//;\n1;2\")");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter your string: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                int result = calculator.add(input);
                System.out.println("Result: " + result);
            } catch (RuntimeException e) {
                System.out.println("Error occurred while processing input: \"" + input + "\"");
                System.out.println("Reason: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error for input: \"" + input + "\"");
                System.out.println("Reason: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }

        scanner.close();
    }
}