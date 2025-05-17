# CMSC 204 - Assignment #5: Morse Code Converter

## 📜 Overview

This project focuses on building a **Morse Code Converter Utility** that transforms Morse code messages into readable English. The utility uses a **generic linked binary tree** (the Morse code tree) to decode Morse characters. Each node of the tree represents a letter, and traversal through the tree is determined by dots (`.`) and dashes (`-`).

The tree is built with every letter of the English alphabet mapped to its corresponding Morse code, following the international Morse standard.

---

## 💡 Historical Context

Samuel Morse invented the telegraph and the Morse code system in the 1830s, revolutionizing long-distance communication. Morse code is still used today in emergency signaling and some maritime and military contexts.

---

## 📌 Assignment Description

You are to implement the following:

- A generic binary tree with `TreeNode<String>` elements
- A `MorseCodeTree` class that builds the Morse code binary tree for all 26 English letters
- A utility class `MorseCodeConverter` that:
  - Converts Morse code strings or files into English text
  - Uses the binary tree to decode messages by traversing based on dot/dash instructions
  - Provides a `printTree()` method for testing and debugging

---

## 🧠 Concepts Practiced

- Generic Classes
- Static Utility Classes
- Binary Tree Traversal (Left for `.` and Right for `-`)
- Recursive Tree Building
- File I/O and String Parsing
- JUnit Testing

---

## 🧱 Class Descriptions

### 🔹 `TreeNode<T>`

- Generic class to represent nodes in the binary tree
- Contains:
  - `data` of type `T`
  - `left` and `right` children

### 🔹 `MorseCodeTree`

- Implements `LinkedConverterTreeInterface<String>`
- Uses a private `TreeNode<String>` root
- `buildTree()` inserts letters by traversing left or right based on the Morse code
- Methods include:
  - `insert(String code, String letter)`
  - `fetch(String code)`
  - `toArrayList()` – returns the alphabet in LNR traversal

### 🔹 `MorseCodeConverter`

- Utility class with a static `MorseCodeTree` instance
- Static methods:
  - `convertToEnglish(String morseCode)`
  - `convertToEnglish(File file)`
  - `printTree()` – returns a space-separated list of the alphabet in tree order

---

## ✅ Testing Requirements

- JUnit tests must verify:
  - Conversion from Morse code string to English
  - Conversion from Morse code file to English
  - Tree correctness via `printTree()`
- Create:
  - `MorseCodeConverterTest` (must include your own tests)
  - `MorseCodeTreeTest`

---

## 🔁 Tree Structure Example

The Morse code tree is 5 levels deep:

