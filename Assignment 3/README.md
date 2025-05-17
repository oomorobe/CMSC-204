# CMSC 204 - Assignment #3: Double Linked Lists

## Overview

This assignment involves the implementation of a **generic doubly-linked list** and a **generic sorted doubly-linked list**, each with an iterator. These custom data structures mimic functionality from Java's collection framework but are developed from scratch to reinforce understanding of internal mechanics. A GUI is provided to help visualize how the data structures operate.

## Assignment Objectives

- Build a custom `BasicDoubleLinkedList<T>` class implementing `Iterable<T>`, with its own node structure and bidirectional traversal using an internal iterator.
- Extend this class with `SortedDoubleLinkedList<T>`, which uses a provided `Comparator<T>` to maintain sorted order of elements.
- Implement internal iterator functionality using `ListIterator<T>`.
- Apply exception handling for unsupported operations and boundary conditions.
- Use provided **JUnit tests** and create your own **student-written tests** for validation.
- Integrate with a **GUI** to visualize and interact with your lists.

## Concepts Practiced

- Generics
- Custom iterators (via `ListIterator`)
- Inheritance
- Exception handling (`UnsupportedOperationException`, `NoSuchElementException`)
- Comparator-based sorting
- Encapsulation and object-oriented design

## Class Descriptions

### 📦 `BasicDoubleLinkedList<T>`

- Implements a custom doubly-linked list using an internal `Node` class with `data`, `prev`, and `next`.
- Defines a protected inner class `DoubleLinkedListIterator` that supports:
  - `hasNext()`, `next()`
  - `hasPrevious()`, `previous()`
  - All other `ListIterator` methods throw `UnsupportedOperationException`
- Maintains `head`, `tail`, and `size` attributes.

### 📦 `SortedDoubleLinkedList<T>`

- Extends `BasicDoubleLinkedList<T>`
- Enforces sorted insertion via a provided `Comparator<T>`
- Disallows `addToFront` and `addToEnd`, throwing `UnsupportedOperationException`
- Implements `add()` method to maintain sorted order

## GUI Integration

The GUI allows users to:
- Add and remove elements from the basic or sorted list
- Traverse forward and backward using iterator controls
- Visualize the node connections (head, tail, prev, next)

To use the GUI:
- Stub all required methods
- Implement `addToFront` / `addToEnd` (for basic list)
- Implement `add` (for sorted list)
- Implement `toArrayList()` to return a view of list contents

## Testing Requirements

- Pass all **BasicDoubleLinkedList_Test** cases
- Pass all **SortedDoubleLinkedList_Test** cases
- Write and pass your own tests:
  - `BasicDoubleLinkedList_STUDENT_Test`
  - `SortedDoubleLinkedList_STUDENT_Test`




