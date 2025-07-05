# String Calculator

A simple Java program built with Test-Driven Development principles. It reads a string of numbers, applies delimiters, handles edge cases like negatives and special characters, and returns the total sum.

## Features

* Returns **0** for an empty input
* Supports commas and new lines as default delimiters
* Allows a single custom delimiter (e.g. `//; 1;2;3`)
* Throws an exception when negative numbers are found
* Ignores non-numeric/special characters

## Example

* Input: `"2,3,100"`
* Output: `105`

This project follows a TDD cycle: write a failing test first, implement the minimal code to pass it, refactor, and repeat. It’s a great way to learn clean, reliable development!

Simply open and run **Main.java** to see the calculator in action.
