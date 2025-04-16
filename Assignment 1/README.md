CMSC204 – Assignment 1: Password Checker

This project is a Java-based application that validates passwords according to a defined set of security rules. Developed for CMSC204 (Montgomery College), the assignment reinforces key programming concepts such as:

ArrayLists

Static methods

Exception handling

File input

JUnit testing

Javadoc documentation

Password Validation Rules

A valid password must:

Be at least 6 characters long

Contain at least one uppercase letter

Contain at least one lowercase letter

Include at least one digit

Include at least one special character

Not have more than two of the same character in a row

Be 10 or more characters for strong status (6–9 is weak but acceptable)

Program Features

GUI Support: Allows users to enter a password manually or upload a file containing passwords.

Validation Utility: A PasswordCheckerUtility class contains methods to validate individual passwords and a list of passwords.

Custom Exceptions: Handles specific validation failures with meaningful exception messages (e.g., NoUpperAlphaException, LengthException).

JUnit Tests: Comprehensive test suite validates each rule with passing and failing cases.

Structure

/src  
   PasswordCheckerUtility.java  
   Exception classes (e.g., LengthException.java)  
   PasswordCheckerTest.java  
/doc  
   Javadoc-generated documentation  
passwords.txt – Sample input file  

How to Run

Compile all .java files in the src folder.

Run the GUI application or the test suite using your IDE or terminal.

Use the “Check Password” or “Check Passwords in File” GUI buttons to test manually or from a file.

