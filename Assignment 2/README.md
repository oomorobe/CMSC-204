# CMSC 204 - Assignment #2: Notation Converter

## Overview

This project involves creating a utility that handles arithmetic expressions written in **infix** and **postfix** notation. The utility supports:

- Converting **infix expressions** to **postfix**
- Converting **postfix expressions** to **infix**
- Evaluating **postfix** expressions

A **GUI** is provided to allow user interaction with the utility. It supports switching between conversion modes and evaluating expressions via a graphical interface.

## Concepts Practiced

- Generic Data Structures (Stack and Queue)
- Custom Exception Handling
- Algorithm design for expression parsing and evaluation

## Project Structure

### 🧱 Data Structures

- `MyStack<T>`: A generic stack implementation that adheres to a provided `StackInterface`.
- `MyQueue<T>`: A generic queue implementation that adheres to a provided `QueueInterface`.

*Note: These structures must be implemented from scratch. Java's built-in `Stack` or `Queue` should not be used.*

### 🧮 Utility Class - `Notation`

Implements three main static methods:
- `infixToPostfix(String infix)`: Converts an infix expression to postfix using a stack and queue.
- `postfixToInfix(String postfix)`: Converts a postfix expression to infix using a stack.
- `evaluatePostfixExpression(String postfix)`: Evaluates a postfix expression and returns the result as a `double`.

**Simplifying Assumptions:**
- Operands are single-digit integers (0-9)
- Supported operators: `+`, `-`, `*`, `/`

### 🚨 Exception Classes

- `InvalidNotationFormatException`
- `StackOverflowException`, `StackUnderflowException`
- `QueueOverflowException`, `QueueUnderflowException`

These exceptions help handle improper usage or malformed expressions during runtime.

## Algorithms

### ➕ Infix to Postfix

- Uses a stack for operators and a queue for the result
- Handles precedence and parentheses
- Example: `"3 + 4"` → `"3 4 +"`

### 🔁 Postfix to Infix

- Uses a stack to reconstruct the original expression
- Adds parentheses to preserve order
- Example: `"3 4 +"` → `"(3+4)"`

### 🧮 Evaluating Postfix

- Uses a stack to compute results
- Example: `"3 4 +"` → `7.0`

## GUI Features

- Convert between notations
- Evaluate postfix expressions
- Simple layout with buttons for Convert, Evaluate, and Exit

## File Summary

- `MyQueue.java`: Generic queue implementation
- `MyStack.java`: Generic stack implementation
- `Notation.java`: Utility class with conversion and evaluation logic
- `*.java`: Exception classes
- `NotationGUI.java`: Provided GUI (pre-built)

## How to Run

1. Compile all `.java` files.
2. Launch the `NotationGUI` class to start the application.
3. Enter an expression, choose conversion type, and click Convert or Evaluate.



