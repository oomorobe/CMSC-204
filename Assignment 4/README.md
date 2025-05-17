# CMSC 204 - Assignment #4: Course Database with Hash Table

## 📘 Overview

In this assignment, you will implement a course database management system using a **hash table with linked list buckets**. The system can read course data from a file or accept manual input through a GUI. Each course is stored as an object with multiple attributes and is accessed using its unique CRN.

The project emphasizes designing an efficient storage and retrieval system, integrating file I/O, exception handling, and GUI interaction.

---

## 🧠 Concepts Practiced

- Hash Tables with Buckets (Chaining)
- Linked Lists
- Generics and Comparators
- File I/O using `FileChooser`
- Exception Handling
- GUI interaction
- Unit Testing with JUnit

---

## 🧱 Class Summary

### 🔹 `CourseDBElement`

- Implements `Comparable`
- Attributes:
  - `courseID` (String)
  - `crn` (int)
  - `credits` (int)
  - `roomNumber` (String)
  - `instructorName` (String)

### 🔹 `CourseDBStructure`

- Implements `CourseDBStructureInterface`
- Hash table with buckets: an array of `LinkedLists<CourseDBElement>`
- Custom hash code based on CRN (as a String)
- Load factor = 1.5
- Two constructors:
  1. One accepts an estimated number of courses and computes a prime table size using 4K+3 rule
  2. One is used for testing (`CourseDBStructure("Testing", int)`)

### 🔹 `CourseDBManager`

- Implements `CourseDBManagerInterface`
- Handles interaction with GUI and data structure
- Allows course insertion from file or text fields
- Allows CRN-based course lookup

---

## ⚠️ Exception Handling

- `IOException`: Thrown for file errors or invalid course retrieval
- Java built-in exceptions used appropriately (e.g., `NoSuchElementException`)

---

## 🖼️ GUI Features

- File-based or manual course input
- Dynamically enables/disables buttons and fields
- Displays course data using alert boxes
- Retrieves courses by CRN using user input
- Built-in `FileChooser` for file input
- “Clear” functionality to reset text fields

---

## ✅ Testing Requirements

- Pass instructor-provided unit tests
- Implement and pass:
  - `CourseDBManager_STUDENT_Test.java`

---

