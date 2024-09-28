# Shamir's Secret Sharing Algorithm

## Overview
This project implements a simplified version of Shamir's Secret Sharing algorithm using Lagrange interpolation to find the constant term of an unknown polynomial based on given roots.

## Features
- Reads input from JSON files containing roots of the polynomial.
- Decodes y-values from different bases.
- Calculates the constant term of the polynomial using Lagrange interpolation.

## Requirements
- Java JDK (version 8 or higher)
- [Gson library](https://github.com/google/gson) for JSON parsing

## Project Structure
```
/secret-sharing
│
├── /src
│   ├── SecretSharing.java
│
├── /testcases
│   ├── testcase1.json
│   ├── testcase2.json
│
├── /lib
│   ├── gson-2.8.8.jar (or your Gson version)
│
└── README.md
```

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd secret-sharing
   ```

2. **Add the Gson library**:
   Ensure the Gson library (`gson-2.8.8.jar`) is included in your project. If you're using VS Code, you can add it to the build path.

3. **Compile the Java code**:
   Navigate to the `src` directory and compile the Java code:
   ```bash
   javac -cp "../lib/gson-2.8.8.jar" SecretSharing.java
   ```

4. **Run the application**:
   Execute the program with the Gson library in the classpath:
   ```bash
   java -cp ".;../lib/gson-2.8.8.jar" SecretSharing
   ```

## Test Cases
The project includes two JSON test case files located in the `/testcases` directory:
- `testcase1.json`
- `testcase2.json`

These files contain the roots of the polynomial in a specific format for testing the algorithm.

## Results
The program will output the constant term \( c \) for each test case provided.
![{C5690B5D-BD74-4C25-9CE9-043BA43C39B4}](https://github.com/user-attachments/assets/0cb0b103-04c8-4102-974f-1c320ce15eb0)
