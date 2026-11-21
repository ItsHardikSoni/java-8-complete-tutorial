---
title: "Java Basics Tutorial for Beginners"
description: "Learn Java 8 syntax, variables, primitive and reference types, operators, type casting, and Scanner input."
---

# Chapter 3: Java Basics – Syntax, Variables, Data Types, and Operators

**Navigation:** [Main Tutorial Index](../README.md) | [Practice Programs](Practice-Programs/) | [Previous: Installation](../02-Java-Installation-and-Setup/README.md) | [Next: Control Flow](../04-Java-Control-Flow/README.md)


**Practice:** [Practice Programs](Practice-Programs/) | [Practice Program Index](Practice-Programs/README.md)

Welcome to the third chapter of our Java 8 Tutorial!

In the previous chapters, we learned what Java is, how JVM, JRE, and JDK work, and how to install Java on our computer.

Now it's time to understand the actual building blocks of Java programming.

Every Java application is made up of instructions, variables, data types, operators, methods, and classes. Before writing large applications, we need to understand how these basic elements work together.

In this chapter, we will learn Java syntax, variables, data types, type conversion, operators, and user input with practical examples.

## 3.1 Introduction to Java Syntax

Java syntax refers to the set of rules that we must follow when writing Java programs.

Just like human languages have grammar rules, programming languages also have their own rules.

For example, in English, we arrange words to create meaningful sentences. Similarly, in Java, we arrange keywords, variables, operators, and statements to create instructions that a computer can understand.

Let's understand with a simple example.

### Example: First Java Program

```java
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, Java!");

    }
}
```

**Output:**

```text
Hello, Java!
```

### Understanding Java Syntax

Let's understand each part of this program.

**1. `public class Main`**

```java
public class Main
```

- `public` is an access modifier.
- `class` is a Java keyword used to create a class.
- `Main` is the name of the class.

In Java, almost all application code is written inside classes.

**2. `public static void main(String[] args)`**

```java
public static void main(String[] args)
```

This is the main method of the program. It is the standard entry point when launching a traditional Java application.

Let's understand each keyword:

| Keyword | Meaning |
|---|---|
| public | Makes the method accessible to the Java launcher |
| static | Allows the method to be called without creating an object |
| void | Means the method does not return a value |
| main | The recognized entry-point method name |
| String[] args | Receives command-line arguments |

**3. `System.out.println()`**

```java
System.out.println("Hello, Java!");
```

This statement displays information on the console.

- `System` is a predefined Java class.
- `out` represents the standard output stream.
- `println()` prints the given information and moves the cursor to the next line.

**4. Semicolon (`;`)**

In Java, a semicolon is used to terminate most statements.

Example:

```java
int age = 22;
System.out.println(age);
```

If you forget the required semicolon, Java will generally report a compilation error.

**5. Curly Braces `{ }`**

Curly braces define a block of code.

Example:

```java
public class Main {

    public static void main(String[] args) {

        int number = 10;

    }
}
```

The opening brace `{` starts a block, and the closing brace `}` ends it.

**6. Java is Case-Sensitive**

Java treats uppercase and lowercase letters differently.

For example:

```java
int age = 20;
int Age = 25;
int AGE = 30;
```

All three are different variables.

Similarly:

- `main` and `Main` are different.
- `String` and `string` are different.
- `System` and `system` are different.

**7. Comments in Java**

Comments are notes written inside source code to explain what the code does.

The compiler ignores comments during normal compilation.

Java supports three types of comments.

Single-line comment:

```java
// This is a single-line comment

int age = 22;
```

Multi-line comment:

```java
/*
 This is a multi-line comment.
 It can contain multiple lines.
*/

int number = 100;
```

Documentation comment:

```java
/**
 * This method displays a welcome message.
 * @author Java Tutorial
 */
public static void displayMessage() {
    System.out.println("Welcome!");
}
```

Documentation comments are commonly used by the `javadoc` tool to generate API documentation.

## 3.2 Structure of a Java Program

A Java program generally contains several parts.

Let's understand them using an example.

```java
package mypackage;

import java.util.Scanner;

public class Student {

    static String college = "ABC College";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = "Ayush";
        int age = 22;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("College: " + college);

        sc.close();
    }
}
```

### Main Components

1. **Package Declaration:** Defines the package to which the class belongs.
2. **Import Statement:** Allows us to use classes from other packages.
3. **Class Declaration:** Defines the class.
4. **Variables:** Store information used by the program.
5. **Main Method:** Standard entry point of a traditional Java application.
6. **Statements:** Instructions executed by the program.

Note: The package declaration must appear before import statements. Both are optional depending on the program.

## 3.3 Java Keywords and Identifiers

Before creating variables and classes, we should understand keywords and identifiers.

### What are Keywords?

Keywords are reserved words in Java that have predefined meanings.

We cannot use Java keywords as variable names, method names, or class names.

Some commonly used Java keywords are:

| Keyword | Purpose |
|---|---|
| class | Declares a class |
| public | Defines access |
| private | Restricts access |
| static | Associates a member with a class |
| void | Specifies no return value |
| int | Declares an integer variable |
| double | Declares a double-precision number |
| if | Conditional execution |
| else | Alternative execution |
| for | Looping |
| while | Looping |
| break | Terminates a loop or switch |
| continue | Skips the current loop iteration |
| return | Returns from a method |
| new | Creates objects or arrays |
| this | Refers to the current object |
| super | Refers to the parent class |
| extends | Inherits a class |
| implements | Implements an interface |
| final | Prevents certain changes or extensions |
| try | Starts exception-handling code |
| catch | Handles exceptions |
| throw | Explicitly throws an exception |
| throws | Declares possible exceptions |

Java 8 has 50 reserved keywords and 2 reserved but unused keywords: `const` and `goto`.

`true`, `false`, and `null` are literals, not keywords.

### What are Identifiers?

Identifiers are names given to variables, methods, classes, interfaces, and other program elements.

Example:

```java
int studentAge = 21;

String studentName = "Ayush";

class StudentDetails {

}
```

Here:

- `studentAge` is an identifier.
- `studentName` is an identifier.
- `StudentDetails` is an identifier.

### Rules for Naming Identifiers

1. An identifier can contain letters, digits, underscores, and dollar signs.
2. It cannot start with a digit.
3. It cannot contain spaces.
4. It cannot be a reserved Java keyword.
5. Identifiers are case-sensitive.
6. Java identifiers can also contain many Unicode characters.

**Valid identifiers:**

```java
int age;
int studentAge;
int _number;
int $salary;
int number123;
```

**Invalid identifiers:**

```java
// int 123number;
// int student age;
// int class;
// int student-name;
```

### Java Naming Conventions

Naming conventions make code easier to read and maintain.

| Element | Convention | Example |
|---|---|---|
| Class | PascalCase | StudentDetails |
| Interface | PascalCase | Runnable |
| Variable | camelCase | studentName |
| Method | camelCase | calculateSalary() |
| Constant | UPPER_SNAKE_CASE | MAX_VALUE |
| Package | lowercase | com.example.app |

Remember: Naming conventions are recommendations, not compiler-enforced rules.

## 3.4 What are Variables in Java?

A variable is a named storage location used to hold data during program execution.

Think of a variable as a container.

For example, if you want to store a student's age, you can create a variable named `age` and assign a value to it.

```java
int age = 22;
```

Here:

- `int` is the data type.
- `age` is the variable name.
- `22` is the assigned value.

Whenever we need that value, we can access it using the variable name.

### Why Do We Need Variables?

Imagine developing a student management application.

You need to store:

- Student name
- Student age
- Roll number
- Marks
- Email address

Instead of writing values repeatedly, you can store them in variables and reuse them whenever required.

### Declaring a Variable

Variable declaration means specifying the data type and variable name.

```java
int age;
```

### Initializing a Variable

Initialization means assigning a value to a variable.

```java
age = 22;
```

### Declaration and Initialization Together

```java
int age = 22;
```

### Updating a Variable

A variable's value can change during program execution.

```java
int marks = 70;

marks = 85;

System.out.println(marks);
```

**Output:**

```text
85
```

The original value was 70, but we updated it to 85.

### Multiple Variables

You can declare multiple variables of the same data type in one statement.

```java
int a = 10, b = 20, c = 30;

System.out.println(a);
System.out.println(b);
System.out.println(c);
```

**Output:**

```text
10
20
30
```

## 3.5 Types of Variables in Java

Java variables are commonly classified into three categories:

1. Local Variables
2. Instance Variables
3. Static Variables

Let's understand each one.

### 1. Local Variables

A local variable is declared inside a method, constructor, or block.

It can only be accessed within the scope in which it is declared.

Example:

```java
public class Student {

    public void display() {

        int age = 22;

        System.out.println(age);
    }

    public static void main(String[] args) {

        Student obj = new Student();

        obj.display();
    }
}
```

**Output:**

```text
22
```

Here, `age` is a local variable because it is declared inside the `display()` method.

Important points:

- Local variables are created when their execution scope is entered.
- They are accessible only within their scope.
- They do not receive automatic default values.
- They must be initialized before being used.

Example of an error:

```java
public class Main {

    public static void main(String[] args) {

        int age;

        // System.out.println(age); // Compilation error
    }
}
```

The variable must be initialized before it is read.

### 2. Instance Variables

An instance variable is declared inside a class but outside methods, constructors, and blocks.

It belongs to an individual object.

Example:

```java
class Student {

    String name;
    int age;

    public void display() {

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = "Ayush";
        s1.age = 22;

        Student s2 = new Student();

        s2.name = "Rahul";
        s2.age = 21;

        s1.display();
        s2.display();
    }
}
```

**Output:**

```text
Name: Ayush
Age: 22
Name: Rahul
Age: 21
```

Here, `name` and `age` are instance variables.

Each object has its own copy of these variables.

For example:

- `s1` stores Ayush and 22.
- `s2` stores Rahul and 21.

Changing the values of one object does not directly change the values of the other.

### 3. Static Variables

A static variable is declared using the `static` keyword inside a class.

It belongs to the class rather than individual objects.

All objects of that class share the same static variable.

Example:

```java
class Student {

    String name;

    static String college = "NMIT";

    public Student(String name) {

        this.name = name;
    }

    public void display() {

        System.out.println(name + " - " + college);
    }

    public static void main(String[] args) {

        Student s1 = new Student("Ayush");
        Student s2 = new Student("Rahul");

        s1.display();
        s2.display();

        Student.college = "ABC University";

        s1.display();
        s2.display();
    }
}
```

**Output:**

```text
Ayush - NMIT
Rahul - NMIT
Ayush - ABC University
Rahul - ABC University
```

Here, `college` is a static variable.

Both objects share the same college value.

When we change `Student.college`, the updated value is visible to both objects.

### Difference Between Local, Instance, and Static Variables

| Feature | Local | Instance | Static |
|---|---|---|---|
| Declaration | Inside method or block | Inside class, outside methods | Inside class with static |
| Belongs to | Execution scope | Object | Class |
| Default value | No | Yes | Yes |
| Memory association | Method/block execution | Object | Class-level storage |
| Access | Within scope | Through object or instance context | Through class name |
| Shared between objects | No | No | Yes |

### Default Values of Instance and Static Variables

Java automatically provides default values for fields, including instance and static variables.

| Data Type | Default Value |
|---|---|
| byte | 0 |
| short | 0 |
| int | 0 |
| long | 0L |
| float | 0.0f |
| double | 0.0d |
| char | '\u0000' |
| boolean | false |
| Reference types | null |

Important: Local variables do not receive these automatic default values.

## 3.6 What are Data Types in Java?

A data type tells Java what kind of value a variable can store.

For example:

- If you want to store a person's age, you can use `int`.
- If you want to store a person's name, you can use `String`.
- If you want to store a decimal value, you can use `double`.
- If you want to store true or false, you can use `boolean`.

Example:

```java
int age = 22;

double salary = 45000.50;

char grade = 'A';

boolean isStudent = true;

String name = "Ayush";
```

Java is a statically typed language. This means the data type of a variable is known at compile time and determines what values and operations are permitted.

### Classification of Data Types

Java data types are divided into two main categories:

1. Primitive Data Types
2. Non-Primitive Data Types (Reference Types)

## 3.7 Primitive Data Types in Java

Java provides eight primitive data types.

Primitive data types are the basic built-in types used to store simple values.

The eight primitive data types are:

1. byte
2. short
3. int
4. long
5. float
6. double
7. char
8. boolean

Let's understand each one in detail.

### 1. byte

The `byte` data type is used to store small integer values.

- Size: 8 bits (1 byte)
- Range: -128 to 127
- Default field value: 0

Example:

```java
public class Main {

    public static void main(String[] args) {

        byte age = 22;

        System.out.println(age);
    }
}
```

**Output:**

```text
22
```

When should you use byte?

Use `byte` when you need to represent small integer values, such as compact data or binary data.

### 2. short

The `short` data type stores integer values larger than the byte range.

- Size: 16 bits (2 bytes)
- Range: -32,768 to 32,767
- Default field value: 0

Example:

```java
public class Main {

    public static void main(String[] args) {

        short temperature = 250;

        System.out.println(temperature);
    }
}
```

**Output:**

```text
250
```

### 3. int

The `int` data type is commonly used to store whole numbers.

- Size: 32 bits (4 bytes)
- Range: -2,147,483,648 to 2,147,483,647
- Default field value: 0

Example:

```java
public class Main {

    public static void main(String[] args) {

        int salary = 50000;

        System.out.println(salary);
    }
}
```

**Output:**

```text
50000
```

In most everyday Java applications, `int` is the standard choice for whole-number calculations.

### 4. long

The `long` data type is used when an integer value is too large for `int`.

- Size: 64 bits (8 bytes)
- Range: -2^63 to 2^63 - 1
- Default field value: 0L

Example:

```java
public class Main {

    public static void main(String[] args) {

        long population = 8000000000L;

        System.out.println(population);
    }
}
```

**Output:**

```text
8000000000
```

Important: Use the suffix `L` when writing a long literal if it is outside the range of an integer literal. Uppercase `L` is preferred because lowercase `l` can look like the number 1.

### 5. float

The `float` data type is used to store decimal numbers with single precision.

- Size: 32 bits (4 bytes)
- Precision: Approximately 6–7 decimal digits
- Default field value: 0.0f

Example:

```java
public class Main {

    public static void main(String[] args) {

        float price = 99.50f;

        System.out.println(price);
    }
}
```

**Output:**

```text
99.5
```

Important: Java treats decimal literals as `double` by default. Therefore, we use `f` or `F` to specify a float literal.

### 6. double

The `double` data type stores decimal numbers with double precision.

- Size: 64 bits (8 bytes)
- Precision: Approximately 15–16 decimal digits
- Default field value: 0.0d

Example:

```java
public class Main {

    public static void main(String[] args) {

        double price = 999.99;

        System.out.println(price);
    }
}
```

**Output:**

```text
999.99
```

`double` is generally preferred over `float` for ordinary floating-point calculations.

Note: Neither float nor double provides exact decimal arithmetic for every value. For financial calculations requiring decimal accuracy, consider using `BigDecimal`.

### 7. char

The `char` data type stores a single UTF-16 code unit.

- Size: 16 bits (2 bytes)
- Range: '\u0000' to '\uffff'
- Default field value: '\u0000'

Example:

```java
public class Main {

    public static void main(String[] args) {

        char grade = 'A';

        System.out.println(grade);
    }
}
```

**Output:**

```text
A
```

Important points:

- A char literal uses single quotes.
- A String uses double quotes.
- Java char represents a UTF-16 code unit, not necessarily a complete Unicode character. Some Unicode characters require two char values.

Example:

```java
char letter = 'A';

String name = "Ayush";
```

### 8. boolean

The `boolean` data type stores only two possible values:

- `true`
- `false`

Java does not define a standard storage size for boolean values in the language specification.

Example:

```java
public class Main {

    public static void main(String[] args) {

        boolean isJavaEasy = true;

        boolean isRaining = false;

        System.out.println(isJavaEasy);
        System.out.println(isRaining);
    }
}
```

**Output:**

```text
true
false
```

Boolean variables are mainly used in conditions and decision-making.

### Summary of Primitive Data Types

| Data Type | Size | Example |
|---|---:|---|
| byte | 8 bits | 100 |
| short | 16 bits | 20000 |
| int | 32 bits | 50000 |
| long | 64 bits | 8000000000L |
| float | 32 bits | 10.5f |
| double | 64 bits | 99.99 |
| char | 16 bits | 'A' |
| boolean | Not fixed by specification | true |

## 3.8 Non-Primitive Data Types in Java

Non-primitive data types are also called reference types.

Unlike primitive variables, reference variables hold references to objects rather than directly storing the object itself.

Common examples include:

1. String
2. Arrays
3. Classes
4. Objects
5. Interfaces
6. Enums

### 1. String

String is used to store a sequence of characters.

Example:

```java
public class Main {

    public static void main(String[] args) {

        String name = "Ayush";

        System.out.println(name);
    }
}
```

**Output:**

```text
Ayush
```

Important: String is a class in Java, not a primitive data type.

Strings are immutable, which means their contents cannot be changed after creation. Operations that appear to modify a String create another String instead.

### 2. Array

An array stores multiple values of the same declared component type.

Example:

```java
public class Main {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers[0]);
        System.out.println(numbers[2]);
    }
}
```

**Output:**

```text
10
30
```

Array indexing starts from 0.

### 3. Class and Object

A class is a blueprint used to define the properties and behaviour of objects.

An object is an instance of a class.

Example:

```java
class Student {

    String name = "Ayush";

    int age = 22;
}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student();

        System.out.println(s1.name);
        System.out.println(s1.age);
    }
}
```

**Output:**

```text
Ayush
22
```

Here, `Student` is a class, and `s1` is a reference variable referring to a Student object.

### 4. Interface

An interface defines a contract that implementing classes agree to follow.

Example:

```java
interface Animal {

    void sound();
}

class Dog implements Animal {

    public void sound() {

        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound();
    }
}
```

**Output:**

```text
Dog barks
```

### Difference Between Primitive and Non-Primitive Data Types

| Primitive | Non-Primitive |
|---|---|
| Eight built-in types | Many reference types |
| Stores primitive values | Reference variables refer to objects |
| Cannot be null | Can be null |
| Has predefined language-level types | Includes classes, arrays, interfaces, etc. |
| Does not have instance methods | Objects can provide methods |
| Examples: int, char, boolean | Examples: String, arrays, Student |

## 3.9 Type Casting and Type Conversion in Java

Sometimes we need to convert a value from one data type to another.

For example, you may have an integer value but need to store or calculate it as a decimal number.

Java supports two common forms of primitive type conversion:

1. Widening Casting
2. Narrowing Casting

### 1. Widening Casting (Automatic Conversion)

Widening means converting a smaller-range numeric type into a larger-range numeric type.

Java performs this conversion automatically when it is permitted.

The general numeric widening order is:

```text
byte → short → int → long → float → double
```

`char` can also widen to `int`, `long`, `float`, or `double`.

Example:

```java
public class Main {

    public static void main(String[] args) {

        int number = 100;

        double result = number;

        System.out.println(number);
        System.out.println(result);
    }
}
```

**Output:**

```text
100
100.0
```

Here, an integer is automatically converted into a double.

Important: Widening does not always guarantee exact numerical precision. For example, converting a large `long` to `float` may lose precision.

### 2. Narrowing Casting (Manual Conversion)

Narrowing means converting a value into a type that has a smaller range or less precision.

This conversion generally requires explicit casting.

Example:

```java
public class Main {

    public static void main(String[] args) {

        double number = 99.99;

        int result = (int) number;

        System.out.println(number);
        System.out.println(result);
    }
}
```

**Output:**

```text
99.99
99
```

Here, the decimal portion is removed during conversion.

Important: Narrowing can cause data loss, overflow, or changes in precision.

### Example of Data Loss

```java
public class Main {

    public static void main(String[] args) {

        int number = 130;

        byte result = (byte) number;

        System.out.println(result);
    }
}
```

**Output:**

```text
-126
```

Why does this happen?

A byte can store values only between -128 and 127.

When 130 is converted to byte, the value wraps around according to the 8-bit representation.

### Difference Between Widening and Narrowing

| Feature | Widening | Narrowing |
|---|---|---|
| Conversion | Smaller-range to larger-range | Larger-range to smaller-range |
| Casting | Usually automatic | Usually explicit |
| Data loss | Possible in some conversions | More likely |
| Example | int to double | double to int |
| Syntax | `double x = 10;` | `int x = (int) 10.5;` |

### String Conversion

We often need to convert String values into numbers and numbers into Strings.

String to int:

```java
String value = "100";

int number = Integer.parseInt(value);

System.out.println(number);
```

Output:

```text
100
```

String to double:

```java
String value = "99.50";

double price = Double.parseDouble(value);

System.out.println(price);
```

Output:

```text
99.5
```

Number to String:

```java
int number = 100;

String value = String.valueOf(number);

System.out.println(value);
```

Output:

```text
100
```

Remember: `Integer.parseInt()` throws a `NumberFormatException` if the String does not contain a valid integer representation.

## 3.10 Constants and the final Keyword

A constant is a value that should not be reassigned after initialization.

In Java, we commonly use the `final` keyword to create variables that cannot be reassigned.

Example:

```java
public class Main {

    public static void main(String[] args) {

        final double PI = 3.14159;

        System.out.println(PI);
    }
}
```

**Output:**

```text
3.14159
```

If we try to assign another value:

```java
final int age = 22;

// age = 25; // Compilation error
```

Java does not allow reassignment of a final variable.

### Why Use Constants?

Imagine you are developing a banking application.

The value of a fixed service charge or a mathematical constant should not accidentally change throughout the application.

You can use final variables to prevent reassignment.

Example:

```java
class Bank {

    static final double INTEREST_RATE = 7.5;

    public static void main(String[] args) {

        System.out.println(INTEREST_RATE);
    }
}
```

**Output:**

```text
7.5
```

### Important: final with Objects

When a reference variable is declared final, the reference cannot be reassigned, but the object itself may still be modified if it is mutable.

Example:

```java
public class Main {

    public static void main(String[] args) {

        final StringBuilder name = new StringBuilder("Ayush");

        name.append(" Kumar");

        System.out.println(name);
    }
}
```

**Output:**

```text
Ayush Kumar
```

The object was modified, but the reference was not reassigned.

## 3.11 Operators in Java

Operators are special symbols used to perform operations on variables and values.

For example, when you calculate the total marks of a student, you use the addition operator.

```java
int a = 10;
int b = 20;

int sum = a + b;

System.out.println(sum);
```

**Output:**

```text
30
```

Here, `+` is an operator.

### Types of Operators in Java

Java provides several categories of operators:

1. Arithmetic Operators
2. Unary Operators
3. Relational Operators
4. Logical Operators
5. Assignment Operators
6. Bitwise Operators
7. Shift Operators
8. Ternary Operator
9. instanceof Operator

Let's understand them one by one.

### 1. Arithmetic Operators

Arithmetic operators are used to perform mathematical calculations.

| Operator | Meaning | Example | Result |
|---|---|---|---|
| + | Addition | 10 + 5 | 15 |
| - | Subtraction | 10 - 5 | 5 |
| * | Multiplication | 10 * 5 | 50 |
| / | Division | 10 / 5 | 2 |
| % | Modulus | 10 % 3 | 1 |

Example:

```java
public class Main {

    public static void main(String[] args) {

        int a = 20;
        int b = 10;

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));
    }
}
```

**Output:**

```text
Addition: 30
Subtraction: 10
Multiplication: 200
Division: 2
Modulus: 0
```

### Understanding the Modulus Operator (%)

The modulus operator returns the remainder after division.

Example:

```java
int result = 10 % 3;

System.out.println(result);
```

Output:

```text
1
```

Why?

10 divided by 3 gives a quotient of 3 and a remainder of 1.

Modulus is commonly used to check whether a number is even or odd.

Example:

```java
int number = 15;

if (number % 2 == 0) {

    System.out.println("Even Number");

} else {

    System.out.println("Odd Number");
}
```

Output:

```text
Odd Number
```

### Important: Integer Division

When two integer values are divided, Java performs integer division.

Example:

```java
int result = 10 / 3;

System.out.println(result);
```

Output:

```text
3
```

The decimal portion is discarded.

If you want a decimal result, use a floating-point operand.

```java
double result = 10.0 / 3;

System.out.println(result);
```

Output:

```text
3.3333333333333335
```

### 2. Unary Operators

Unary operators work with a single operand.

Common unary operators include:

| Operator | Meaning |
|---|---|
| + | Unary plus |
| - | Unary minus |
| ++ | Increment |
| -- | Decrement |
| ! | Logical NOT |
| ~ | Bitwise complement |

#### Increment Operator (++)

The increment operator increases a value by 1.

Example:

```java
int a = 10;

a++;

System.out.println(a);
```

Output:

```text
11
```

#### Decrement Operator (--)

The decrement operator decreases a value by 1.

Example:

```java
int a = 10;

a--;

System.out.println(a);
```

Output:

```text
9
```

#### Pre-Increment and Post-Increment

This is a very important Java concept and is frequently asked in interviews.

**Pre-Increment (++a)**

The value is incremented first, and then the updated value is used in the expression.

```java
int a = 10;

int result = ++a;

System.out.println(a);
System.out.println(result);
```

Output:

```text
11
11
```

**Post-Increment (a++)**

The original value is used first, and then the variable is incremented.

```java
int a = 10;

int result = a++;

System.out.println(a);
System.out.println(result);
```

Output:

```text
11
10
```

The difference is in the order of evaluation.

#### Pre-Decrement and Post-Decrement

Pre-decrement:

```java
int a = 10;

int result = --a;

System.out.println(a);
System.out.println(result);
```

Output:

```text
9
9
```

Post-decrement:

```java
int a = 10;

int result = a--;

System.out.println(a);
System.out.println(result);
```

Output:

```text
9
10
```

### 3. Relational Operators

Relational operators compare two values and return a boolean result.

The result is always either `true` or `false`.

| Operator | Meaning |
|---|---|
| == | Equal to |
| != | Not equal to |
| > | Greater than |
| < | Less than |
| >= | Greater than or equal to |
| <= | Less than or equal to |

Example:

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
    }
}
```

**Output:**

```text
false
true
false
true
false
true
```

### 4. Logical Operators

Logical operators are used to combine or reverse boolean conditions.

Java provides three main logical operators.

| Operator | Name | Meaning |
|---|---|---|
| && | Logical AND | Both conditions must be true |
| \|\| | Logical OR | At least one condition must be true |
| ! | Logical NOT | Reverses the boolean value |

#### Logical AND (&&)

The result is true only when both conditions are true.

```java
int age = 22;

System.out.println(age >= 18 && age <= 60);
```

Output:

```text
true
```

#### Logical OR (||)

The result is true if at least one condition is true.

```java
int marks = 85;

System.out.println(marks >= 90 || marks >= 80);
```

Output:

```text
true
```

#### Logical NOT (!)

It reverses the boolean result.

```java
boolean isJavaEasy = true;

System.out.println(!isJavaEasy);
```

Output:

```text
false
```

### Short-Circuit Evaluation

This is an important concept in Java.

The `&&` and `||` operators use short-circuit evaluation.

For AND (`&&`):

If the first condition is false, Java does not evaluate the second condition because the final result must be false.

For OR (`||`):

If the first condition is true, Java does not evaluate the second condition because the final result must be true.

Example:

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;

        if (a < 5 && ++a > 10) {

            System.out.println("True");

        }

        System.out.println(a);
    }
}
```

Output:

```text
10
```

Why?

The first condition `a < 5` is false.

Therefore, Java skips the second condition, and `a` is not incremented.

### Difference Between && and &

Both can perform logical AND operations on boolean values.

However:

- `&&` uses short-circuit evaluation.
- `&` evaluates both operands when used with boolean values.

Example:

```java
int a = 10;

boolean result = (a > 5) && (++a > 10);

System.out.println(a);
```

Output:

```text
11
```

Here, the first condition is true, so Java evaluates the second condition.

### 5. Assignment Operators

Assignment operators are used to assign or update variable values.

| Operator | Example | Equivalent Expression |
|---|---|---|
| = | a = 10 | Assign 10 |
| += | a += 5 | a = a + 5 |
| -= | a -= 5 | a = a - 5 |
| *= | a *= 5 | a = a * 5 |
| /= | a /= 5 | a = a / 5 |
| %= | a %= 5 | a = a % 5 |

Example:

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;

        a += 5;
        System.out.println(a);

        a -= 3;
        System.out.println(a);

        a *= 2;
        System.out.println(a);

        a /= 4;
        System.out.println(a);
    }
}
```

Output:

```text
15
12
24
6
```

### 6. Bitwise Operators

Bitwise operators perform operations directly on the individual bits of integer values.

They are commonly used in low-level programming, flags, permissions, and performance-sensitive operations.

Java provides these bitwise operators:

| Operator | Name |
|---|---|
| & | Bitwise AND |
| \| | Bitwise OR |
| ^ | Bitwise XOR |
| ~ | Bitwise Complement |

Let's understand with binary values.

Consider:

```text
a = 5  → 0101
b = 3  → 0011
```

**Bitwise AND (&)**

Returns 1 when both corresponding bits are 1.

```java
int a = 5;
int b = 3;

System.out.println(a & b);
```

Output:

```text
1
```

Binary calculation:

```text
  0101
& 0011
------
  0001
```

**Bitwise OR (|)**

Returns 1 when at least one corresponding bit is 1.

```java
System.out.println(5 | 3);
```

Output:

```text
7
```

**Bitwise XOR (^)**

Returns 1 when the corresponding bits are different.

```java
System.out.println(5 ^ 3);
```

Output:

```text
6
```

**Bitwise Complement (~)**

Reverses all bits of an integer value.

```java
System.out.println(~5);
```

Output:

```text
-6
```

For a 32-bit signed integer, Java uses two's complement representation. Therefore, `~x` is equivalent to `-x - 1`.

### 7. Shift Operators

Shift operators move the bits of an integer value to the left or right.

Java provides three main shift operators.

| Operator | Name | Meaning |
|---|---|---|
| << | Left Shift | Shifts bits to the left |
| >> | Signed Right Shift | Preserves the sign |
| >>> | Unsigned Right Shift | Fills the leftmost bits with zero |

**Left Shift (<<)**

```java
int a = 5;

System.out.println(a << 1);
```

Output:

```text
10
```

Binary:

```text
00000101 << 1

00001010
```

For this example, shifting left by one position multiplies the value by 2.

**Signed Right Shift (>>)**

```java
int a = 8;

System.out.println(a >> 1);
```

Output:

```text
4
```

The right shift moves bits to the right while preserving the sign bit.

**Unsigned Right Shift (>>>)**

```java
int a = -8;

System.out.println(a >>> 1);
```

This produces a large positive integer because zero bits are inserted from the left.

Note: Shift operations on negative values and large shift distances require care. Java masks the shift distance according to the width of the integer type.

### 8. Ternary Operator

The ternary operator is a shorter way to write a simple if-else expression.

Syntax:

```java
condition ? expression1 : expression2;
```

If the condition is true, expression1 is selected. Otherwise, expression2 is selected.

Example:

```java
public class Main {

    public static void main(String[] args) {

        int age = 22;

        String result = (age >= 18) ? "Eligible" : "Not Eligible";

        System.out.println(result);
    }
}
```

Output:

```text
Eligible
```

This is equivalent to:

```java
if (age >= 18) {

    System.out.println("Eligible");

} else {

    System.out.println("Not Eligible");
}
```

Use the ternary operator for simple conditions. For complex decision-making, normal if-else statements are easier to understand.

### 9. instanceof Operator

The `instanceof` operator checks whether an object is an instance of a particular class, subclass, or interface.

It returns a boolean value.

Example:

```java
class Animal {

}

class Dog extends Animal {

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        System.out.println(dog instanceof Dog);
        System.out.println(dog instanceof Animal);
    }
}
```

Output:

```text
true
true
```

Why?

`Dog` extends `Animal`, so a Dog object is also an instance of Animal.

## 3.12 Operator Precedence and Associativity

When multiple operators appear in one expression, Java follows specific rules to decide which operation should be performed first.

This is called operator precedence.

Example:

```java
int result = 10 + 5 * 2;

System.out.println(result);
```

Output:

```text
20
```

Why?

Multiplication has higher precedence than addition.

Therefore:

```text
10 + (5 * 2)
10 + 10
20
```

### Common Operator Precedence

The following table lists common Java operator precedence levels, from higher to lower.

| Priority | Operators | Associativity |
|---|---|---|
| 1 | `()`, `[]`, `.` | Left to right |
| 2 | `expr++`, `expr--` | Left to right |
| 3 | `++`, `--`, `+`, `-`, `!`, `~`, casts | Right to left |
| 4 | `*`, `/`, `%` | Left to right |
| 5 | `+`, `-` | Left to right |
| 6 | `<<`, `>>`, `>>>` | Left to right |
| 7 | `<`, `>`, `<=`, `>=`, `instanceof` | Left to right |
| 8 | `==`, `!=` | Left to right |
| 9 | `&` | Left to right |
| 10 | `^` | Left to right |
| 11 | `\|` | Left to right |
| 12 | `&&` | Left to right |
| 13 | `\|\|` | Left to right |
| 14 | `?:` | Right to left |
| 15 | `=`, `+=`, `-=`, `*=`, `/=`, etc. | Right to left |

### What is Associativity?

Associativity determines the order in which operators of the same precedence are evaluated.

Example:

```java
int result = 20 - 5 - 3;

System.out.println(result);
```

Output:

```text
12
```

Subtraction is evaluated from left to right:

```text
(20 - 5) - 3
15 - 3
12
```

Assignment operators are right-associative.

Example:

```java
int a, b, c;

a = b = c = 10;

System.out.println(a);
System.out.println(b);
System.out.println(c);
```

Output:

```text
10
10
10
```

**Tip:** When an expression becomes complicated, use parentheses to make your intention clear.

## 3.13 Taking User Input Using Scanner

Until now, we have written programs using fixed values.

But real-world applications need to accept information from users.

For example:

- A banking application accepts an account number.
- A student management system accepts a student's name and marks.
- A shopping application accepts product quantities.

Java provides the `Scanner` class to read input from the keyboard.

The Scanner class belongs to the `java.util` package.

### Step 1: Import Scanner

```java
import java.util.Scanner;
```

### Step 2: Create a Scanner Object

```java
Scanner sc = new Scanner(System.in);
```

Here:

- `Scanner` is the class name.
- `sc` is the reference variable.
- `new Scanner()` creates a Scanner object.
- `System.in` represents standard input, usually the keyboard.

### Step 3: Read User Input

Different methods are available to read different types of data.

| Method | Purpose |
|---|---|
| nextInt() | Reads an integer |
| nextLong() | Reads a long integer |
| nextFloat() | Reads a float |
| nextDouble() | Reads a double |
| next() | Reads the next token |
| nextLine() | Reads an entire line |
| nextBoolean() | Reads a boolean |

### Example 1: Read an Integer

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");

        int age = sc.nextInt();

        System.out.println("Your age is: " + age);

        sc.close();
    }
}
```

Sample Input:

```text
22
```

Output:

```text
Enter your age: 22
Your age is: 22
```

### Example 2: Read a String

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = sc.nextLine();

        System.out.println("Welcome, " + name);

        sc.close();
    }
}
```

Sample Input:

```text
Ayush Soni
```

Output:

```text
Enter your name: Ayush Soni
Welcome, Ayush Soni
```

### Difference Between next() and nextLine()

This is a common beginner interview question.

**next()**

Reads input until it encounters whitespace.

Example:

```java
String name = sc.next();
```

Input:

```text
Ayush Soni
```

Result:

```text
Ayush
```

**nextLine()**

Reads the complete line, including spaces, until the Enter key is pressed.

Example:

```java
String name = sc.nextLine();
```

Input:

```text
Ayush Soni
```

Result:

```text
Ayush Soni
```

### Common Scanner Problem: nextInt() Followed by nextLine()

Consider this program:

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");

        int age = sc.nextInt();

        System.out.print("Enter your name: ");

        String name = sc.nextLine();

        System.out.println(age);
        System.out.println(name);

        sc.close();
    }
}
```

You may notice that the program does not wait for the user's name.

**Why does this happen?**

The `nextInt()` method reads the integer but leaves the newline character in the input buffer.

The next `nextLine()` consumes that remaining newline instead of waiting for a new line.

**Solution:**

Use an additional `nextLine()` after reading the integer.

Correct code:

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");

        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter your name: ");

        String name = sc.nextLine();

        System.out.println("Age: " + age);
        System.out.println("Name: " + name);

        sc.close();
    }
}
```

Now the program works correctly.

## 3.14 Practical Java Programs

Let's apply what we have learned through practical programs.

### Program 1: Add Two Numbers

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int sum = a + b;

        System.out.println("Sum: " + sum);
    }
}
```

Output:

```text
Sum: 30
```

### Program 2: Calculate the Area of a Rectangle

Formula:

Area = Length × Width

```java
public class Main {

    public static void main(String[] args) {

        double length = 10.5;
        double width = 5.5;

        double area = length * width;

        System.out.println("Area: " + area);
    }
}
```

Output:

```text
Area: 57.75
```

### Program 3: Swap Two Numbers Using a Third Variable

Swapping means exchanging the values of two variables.

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int temp = a;

        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
```

Output:

```text
a = 20
b = 10
```

Explanation:

1. Store the value of `a` in `temp`.
2. Assign the value of `b` to `a`.
3. Assign the original value of `a`, stored in `temp`, to `b`.

### Program 4: Swap Two Numbers Without a Third Variable

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
```

Output:

```text
a = 20
b = 10
```

Note: This arithmetic approach can cause integer overflow for large values. Using a temporary variable is generally clearer and safer.

### Program 5: Check Whether a Number is Even or Odd

```java
public class Main {

    public static void main(String[] args) {

        int number = 15;

        if (number % 2 == 0) {

            System.out.println("Even Number");

        } else {

            System.out.println("Odd Number");
        }
    }
}
```

Output:

```text
Odd Number
```

### Program 6: Calculate Simple Interest

Formula:

Simple Interest = (Principal × Rate × Time) / 100

```java
public class Main {

    public static void main(String[] args) {

        double principal = 10000;
        double rate = 5;
        double time = 2;

        double interest = (principal * rate * time) / 100;

        System.out.println("Simple Interest: " + interest);
    }
}
```

Output:

```text
Simple Interest: 1000.0
```

### Program 7: Find the Largest of Two Numbers

```java
public class Main {

    public static void main(String[] args) {

        int a = 50;
        int b = 30;

        int largest = (a > b) ? a : b;

        System.out.println("Largest Number: " + largest);
    }
}
```

Output:

```text
Largest Number: 50
```

### Program 8: Calculate Average Marks

```java
public class Main {

    public static void main(String[] args) {

        int subject1 = 80;
        int subject2 = 90;
        int subject3 = 85;

        double average = (subject1 + subject2 + subject3) / 3.0;

        System.out.println("Average Marks: " + average);
    }
}
```

Output:

```text
Average Marks: 85.0
```

Why use `3.0` instead of `3`?

Using `3.0` makes the division a floating-point operation, allowing decimal results when required.

### Program 9: Convert Celsius to Fahrenheit

Formula:

Fahrenheit = (Celsius × 9 / 5) + 32

```java
public class Main {

    public static void main(String[] args) {

        double celsius = 37;

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Fahrenheit: " + fahrenheit);
    }
}
```

Output:

```text
Fahrenheit: 98.6
```

### Program 10: Check Whether a Character is a Vowel

```java
public class Main {

    public static void main(String[] args) {

        char ch = 'a';

        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U') {

            System.out.println("Vowel");

        } else {

            System.out.println("Consonant");
        }
    }
}
```

Output:

```text
Vowel
```

This example assumes the input is an English alphabetic character. A production program should also validate other inputs.

## 3.15 Common Beginner Mistakes in Java

When learning Java, beginners often make small mistakes that lead to compilation errors or unexpected output.

Let's understand some common mistakes.

### Mistake 1: Using the Wrong Data Type

Incorrect:

```java
int price = 99.99;
```

Why?

The value contains a decimal portion, but `int` cannot store decimal values.

Correct:

```java
double price = 99.99;
```

### Mistake 2: Forgetting the Semicolon

Incorrect:

```java
int age = 22
```

Correct:

```java
int age = 22;
```

### Mistake 3: Using Single Quotes for Strings

Incorrect:

```java
String name = 'Ayush';
```

Correct:

```java
String name = "Ayush";
```

Single quotes are used for character literals, while double quotes are used for String literals.

### Mistake 4: Forgetting the Float Suffix

Incorrect:

```java
float price = 10.5;
```

Correct:

```java
float price = 10.5f;
```

### Mistake 5: Comparing Strings Using ==

Incorrect for content comparison:

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);
```

Output:

```text
false
```

Why?

The `==` operator compares object references when used with reference types.

Correct:

```java
System.out.println(a.equals(b));
```

Output:

```text
true
```

The `equals()` method compares String contents.

### Mistake 6: Using an Uninitialized Local Variable

Incorrect:

```java
int age;

System.out.println(age);
```

Correct:

```java
int age = 22;

System.out.println(age);
```

### Mistake 7: Integer Division

Incorrect when a decimal result is expected:

```java
int result = 10 / 3;

System.out.println(result);
```

Output:

```text
3
```

Correct:

```java
double result = 10.0 / 3;

System.out.println(result);
```

Output:

```text
3.3333333333333335
```

## 3.16 Java Interview Questions and Answers

Here are some important Java interview questions related to syntax, variables, data types, and operators.

### Q1. What is Java?

**Answer:** Java is a high-level, class-based, object-oriented, platform-independent programming language used to develop desktop, web, Android, and enterprise applications.

### Q2. What is a variable in Java?

**Answer:** A variable is a named storage location used to store data during program execution.

Example:

```java
int age = 22;
```

### Q3. How many primitive data types are available in Java?

**Answer:** Java provides eight primitive data types:

- byte
- short
- int
- long
- float
- double
- char
- boolean

### Q4. What is the difference between primitive and non-primitive data types?

**Answer:** Primitive types store simple values directly, while reference types are used to refer to objects and arrays.

Examples:

- Primitive: int, double, char.
- Reference: String, arrays, classes.

### Q5. What is the difference between int and Integer?

**Answer:** `int` is a primitive data type, whereas `Integer` is a wrapper class that represents an integer as an object.

Example:

```java
int a = 10;

Integer b = 20;
```

The Integer class also provides useful methods for converting and working with integer values.

### Q6. What is type casting?

**Answer:** Type casting is the process of converting a value from one data type to another.

It can be widening or narrowing.

### Q7. What is the difference between widening and narrowing casting?

**Answer:**

- Widening generally converts a smaller-range numeric type into a larger-range type automatically.
- Narrowing converts a value into a smaller-range or less precise type and usually requires explicit casting.

### Q8. What is the difference between float and double?

**Answer:**

- float uses 32 bits and provides approximately 6–7 decimal digits of precision.
- double uses 64 bits and provides approximately 15–16 decimal digits of precision.

Double is generally preferred for floating-point calculations.

### Q9. What is the difference between == and equals()?

**Answer:**

- `==` compares primitive values or reference identity.
- `equals()` compares logical equality when the class implements it appropriately.

For String objects, `equals()` compares their character contents.

### Q10. What is a static variable?

**Answer:** A static variable belongs to a class rather than an individual object. All instances of that class share the same static variable.

### Q11. What is a local variable?

**Answer:** A local variable is declared inside a method, constructor, or block and can only be accessed within its scope.

### Q12. What is the difference between instance and static variables?

**Answer:** Instance variables have separate values for individual objects, whereas static variables are shared by all objects of the class.

### Q13. What is the final keyword?

**Answer:** The `final` keyword prevents reassignment of a variable. It can also prevent method overriding and class inheritance when applied to methods and classes.

### Q14. What is the modulus operator?

**Answer:** The modulus operator `%` returns the remainder after division.

Example:

```java
System.out.println(10 % 3);
```

Output:

```text
1
```

### Q15. What is the difference between pre-increment and post-increment?

**Answer:**

- Pre-increment (`++a`) increments the value before using it in the expression.
- Post-increment (`a++`) uses the original value first and increments it afterward.

### Q16. What is the difference between && and &?

**Answer:**

- `&&` is logical AND and uses short-circuit evaluation.
- `&` performs bitwise AND on integral operands and non-short-circuit boolean AND on boolean operands.

### Q17. What is the ternary operator?

**Answer:** The ternary operator is a conditional operator that provides a shorter alternative to a simple if-else expression.

Example:

```java
int age = 22;

String result = age >= 18 ? "Adult" : "Minor";
```

### Q18. What is the default value of an int variable?

**Answer:** The default value of an instance or static `int` field is 0. Local variables do not receive automatic default values.

### Q19. Is String a primitive data type?

**Answer:** No. String is a predefined class in Java and is a reference type.

### Q20. What is the Scanner class?

**Answer:** Scanner is a class from the `java.util` package used to read input from different sources, including keyboard input through `System.in`.

### Q21. What is the difference between next() and nextLine()?

**Answer:**

- `next()` reads the next token until whitespace.
- `nextLine()` reads the remaining contents of the current line.

### Q22. Can we use a Java keyword as a variable name?

**Answer:** No. Reserved Java keywords cannot be used as identifiers.

### Q23. What happens when we divide an integer by another integer?

**Answer:** Java performs integer division and discards the fractional portion of the result.

Example:

```java
System.out.println(10 / 3);
```

Output:

```text
3
```

### Q24. Can a final object be modified?

**Answer:** Yes. A final reference cannot point to another object after assignment, but the referenced object may be modified if it is mutable.

### Q25. Is Java case-sensitive?

**Answer:** Yes. Java treats uppercase and lowercase letters differently.

For example, `age`, `Age`, and `AGE` are different identifiers.

## 3.17 Practice Exercises

Now it's your turn to practice.

Try solving these questions yourself before checking the solutions.

### Beginner Level

**Exercise 1:** Write a Java program to print your name, age, and college name.

**Exercise 2:** Write a program to add, subtract, multiply, and divide two numbers.

**Exercise 3:** Write a program to calculate the area and perimeter of a rectangle.

**Exercise 4:** Write a program to convert kilometers into meters.

**Exercise 5:** Write a program to calculate the average of five numbers.

### Intermediate Level

**Exercise 6:** Write a program to swap two numbers using a temporary variable.

**Exercise 7:** Write a program to swap two numbers without using a temporary variable.

### Advanced Practice

**Exercise 8:** Write a program to calculate the compound interest.

**Exercise 9:** Write a program to convert Fahrenheit into Celsius.

## 3.18 Practice Exercise Solutions



Note: This example assumes each subject has a maximum of 100 marks and the entered marks are valid.

---

## 3.19 Final Revision – What We Learned

Let's quickly revise everything covered in this chapter.

| Topic | What We Learned |
|---|---|
| Java Syntax | Rules for writing Java programs |
| Keywords | Reserved words in Java |
| Identifiers | Names given to program elements |
| Variables | Store information during execution |
| Local Variables | Declared inside methods or blocks |
| Instance Variables | Belong to individual objects |
| Static Variables | Shared by all objects of a class |
| Data Types | Define the kind of data a variable can hold |
| Primitive Types | Eight basic Java data types |
| Reference Types | Classes, arrays, interfaces, and more |
| Type Casting | Converts values between compatible types |
| final Keyword | Prevents reassignment of variables |
| Operators | Perform calculations and comparisons |
| Scanner | Reads user input |
| Precedence | Determines the order of operator evaluation |

### Important Points to Remember

1. Java is a statically typed programming language.
2. Java has eight primitive data types.
3. String is a reference type, not a primitive type.
4. Local variables must be initialized before use.
5. Static variables are shared across objects.
6. Instance variables belong to individual objects.
7. Widening conversions are generally automatic.
8. Narrowing conversions generally require explicit casting.
9. `==` and `equals()` have different purposes.
10. Integer division discards the fractional portion.
11. `&&` and `||` support short-circuit evaluation.
12. Scanner is available in the `java.util` package.

## What's Next?

**Chapter 4: Java Control Flow Statements – Decision Making and Loops**

In the next chapter, we will learn how to control the execution of Java programs using conditions and loops.

Topics we will cover:

- Introduction to Control Flow Statements
- if Statement
- if-else Statement
- else-if Ladder
- Nested if Statements
- switch Statement
- Traditional switch and Java 8 switch behavior
- for Loop
- while Loop
- do-while Loop
- Nested Loops
- break Statement
- continue Statement
- return Statement
- Enhanced for Loop (for-each)
- Practical Real-World Programs
- Pattern Programming
- Common Programming Mistakes
- Java Interview Questions and Answers
- Practice Exercises with Solutions

**Happy Learning, Keep Practicing, and Keep Coding!**

