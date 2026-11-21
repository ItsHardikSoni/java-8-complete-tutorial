# Chapter 5: Methods and Constructors in Java

## 1. Introduction to Methods in Java

A method is a block of code that performs a specific task. Instead of writing the same code repeatedly, we can create a method and call it whenever required.

Think of a method like a machine:
- You provide input (parameters).
- The method performs an operation.
- It may return an output.

### Why do we need methods?

Consider a program that calculates the sum of two numbers multiple times. Without methods, we would have to write the same calculation repeatedly.

Using methods, we can write the logic once and reuse it.

**Advantages of methods:**
1. Code reusability.
2. Reduces code duplication.
3. Makes programs easier to understand.
4. Simplifies debugging and testing.
5. Improves code organization.
6. Makes large applications easier to maintain.

---

## 2. Method Declaration and Definition

A method generally consists of the following parts:

```java
accessModifier returnType methodName(parameters) {
    // Method body
    // Statements
}
```

Let's understand each component:

| Component | Meaning |
|---|---|
| Access modifier | Controls where the method can be accessed |
| Return type | Specifies the type of value returned |
| Method name | Name used to call the method |
| Parameters | Input values received by the method |
| Method body | Contains the statements executed by the method |

### Example: Creating a Simple Method

**File: `SimpleMethod.java`**

```java
public class SimpleMethod {

    static void greet() {
        System.out.println("Welcome to Java Programming!");
    }

    public static void main(String[] args) {

        greet();

    }
}
```

**Output:**
```text
Welcome to Java Programming!
```

**Explanation:**

- `static` means the method belongs to the class.
- `void` means the method does not return a value.
- `greet()` is the method name.
- `main()` calls the `greet()` method.
- When `greet()` is called, its statements are executed.

---

## 3. Types of Methods in Java

Methods can be classified in different ways depending on their parameters, return values, and whether they belong to a class or an object.

### 3.1 Predefined Methods

Predefined methods are methods already provided by Java's standard library.

Examples:

```java
public class PredefinedMethods {

    public static void main(String[] args) {

        String name = "java programming";

        System.out.println(name.length());

        System.out.println(name.toUpperCase());

        System.out.println(Math.max(10, 20));

        System.out.println(Math.sqrt(25));

    }
}
```

**Output:**
```text
16
JAVA PROGRAMMING
20
5.0
```

Some commonly used predefined methods:

| Method | Purpose |
|---|---|
| `length()` | Returns string length |
| `toUpperCase()` | Converts text to uppercase |
| `toLowerCase()` | Converts text to lowercase |
| `charAt()` | Returns character at a given index |
| `Math.max()` | Returns the larger number |
| `Math.min()` | Returns the smaller number |
| `Math.sqrt()` | Calculates square root |
| `Math.pow()` | Calculates power |

### 3.2 User-Defined Methods

User-defined methods are methods created by programmers to perform specific tasks.

Example:

```java
public class UserDefinedMethod {

    static void displayMessage() {

        System.out.println("Learning Java is interesting!");

    }

    public static void main(String[] args) {

        displayMessage();

    }
}
```

---

## 4. Methods Based on Parameters and Return Values

Methods can be divided into four common categories.

### 4.1 No Parameters and No Return Value

A method that does not accept any input and does not return any value.

```java
public class MethodExample1 {

    static void display() {

        System.out.println("Hello Java");

    }

    public static void main(String[] args) {

        display();

    }
}
```

**Output:**
```text
Hello Java
```

### 4.2 Parameters but No Return Value

A method that accepts input but does not return a result.

```java
public class MethodExample2 {

    static void add(int a, int b) {

        int sum = a + b;

        System.out.println("Sum = " + sum);

    }

    public static void main(String[] args) {

        add(10, 20);

    }
}
```

**Output:**
```text
Sum = 30
```

### 4.3 No Parameters but Returns a Value

A method that does not accept input but returns a result.

```java
public class MethodExample3 {

    static int getNumber() {

        return 100;

    }

    public static void main(String[] args) {

        int number = getNumber();

        System.out.println("Number = " + number);

    }
}
```

**Output:**
```text
Number = 100
```

### 4.4 Parameters and Returns a Value

A method that accepts input and returns a result.

```java
public class MethodExample4 {

    static int multiply(int a, int b) {

        return a * b;

    }

    public static void main(String[] args) {

        int result = multiply(5, 4);

        System.out.println("Multiplication = " + result);

    }
}
```

**Output:**
```text
Multiplication = 20
```

### Comparison of the Four Types

| Method type | Parameters | Return value |
|---|---|---|
| Type 1 | No | No |
| Type 2 | Yes | No |
| Type 3 | No | Yes |
| Type 4 | Yes | Yes |

---

## 5. Static Methods in Java

A static method belongs to the class rather than an individual object.

You can call a static method using the class name without creating an object.

### Example

```java
public class StaticMethod {

    static void display() {

        System.out.println("This is a static method.");

    }

    public static void main(String[] args) {

        StaticMethod.display();

    }
}
```

**Output:**
```text
This is a static method.
```

### Important Characteristics

1. Static methods belong to the class.
2. They can be called without creating an object.
3. They can directly access static variables and other static methods.
4. They cannot directly access instance variables or instance methods.
5. The `this` keyword cannot be used inside a static method because it does not belong to an object.

### Example: Static Variable and Static Method

```java
public class StaticExample {

    static int count = 10;

    static void display() {

        System.out.println("Count = " + count);

    }

    public static void main(String[] args) {

        StaticExample.display();

    }
}
```

**Output:**
```text
Count = 10
```

---

## 6. Instance Methods in Java

An instance method belongs to an object of a class.

To call an instance method, we generally need to create an object.

### Example

```java
public class InstanceMethod {

    void display() {

        System.out.println("This is an instance method.");

    }

    public static void main(String[] args) {

        InstanceMethod obj = new InstanceMethod();

        obj.display();

    }
}
```

**Output:**
```text
This is an instance method.
```

### Static Method vs Instance Method

| Static Method | Instance Method |
|---|---|
| Belongs to the class | Belongs to an object |
| Called using class name | Called using an object |
| Does not require an object | Requires an object for normal access |
| Cannot directly access instance members | Can access static and instance members |
| Cannot use `this` | Can use `this` |

---

## 7. Method Parameters and Arguments

Parameters and arguments are related, but they are not the same.

**Parameters:** Variables declared in the method definition to receive input.

**Arguments:** Actual values passed when calling the method.

### Example

```java
public class ParametersExample {

    static void studentDetails(String name, int age) {

        System.out.println("Name: " + name);

        System.out.println("Age: " + age);

    }

    public static void main(String[] args) {

        studentDetails("Ayush", 22);

    }
}
```

**Output:**
```text
Name: Ayush
Age: 22
```

In this example:
- `name` and `age` are parameters.
- `"Ayush"` and `22` are arguments.

---

## 8. Method Overloading in Java

Method overloading means creating multiple methods with the same name but different parameter lists within the same class.

It is an example of **compile-time polymorphism**.

Methods can be overloaded by changing:
1. Number of parameters.
2. Types of parameters.
3. Order of parameter types.

### Example 1: Different Number of Parameters

```java
public class MethodOverloading1 {

    static int add(int a, int b) {

        return a + b;

    }

    static int add(int a, int b, int c) {

        return a + b + c;

    }

    public static void main(String[] args) {

        System.out.println(add(10, 20));

        System.out.println(add(10, 20, 30));

    }
}
```

**Output:**
```text
30
60
```

### Example 2: Different Data Types

```java
public class MethodOverloading2 {

    static int add(int a, int b) {

        return a + b;

    }

    static double add(double a, double b) {

        return a + b;

    }

    public static void main(String[] args) {

        System.out.println(add(10, 20));

        System.out.println(add(10.5, 20.5));

    }
}
```

**Output:**
```text
30
31.0
```

### Example 3: Different Order of Parameters

```java
public class MethodOverloading3 {

    static void display(int a, String b) {

        System.out.println(a + " " + b);

    }

    static void display(String a, int b) {

        System.out.println(a + " " + b);

    }

    public static void main(String[] args) {

        display(10, "Java");

        display("Programming", 20);

    }
}
```

**Output:**
```text
10 Java
Programming 20
```

### Important Rule

Changing only the return type does not create valid method overloading.

For example, these two methods cannot coexist in the same class:

```java
int calculate(int a) {
    return a;
}

double calculate(int a) {
    return a;
}
```

Both methods have the same name and parameter list. The compiler cannot distinguish them based only on return type.

---

## 9. Constructors in Java

A constructor is a special member of a class that initializes an object when it is created.

Whenever we create an object using the `new` keyword, Java invokes an appropriate constructor.

### Why do we need constructors?

Suppose we create a Student class with name, age, and course.

Without a constructor, we may need to assign each property separately after creating the object.

A constructor allows us to initialize these values during object creation.

### Syntax

```java
class ClassName {

    ClassName() {

        // Constructor body

    }

}
```

### Example

```java
public class Student {

    String name;

    int age;

    Student() {

        name = "Ayush";

        age = 22;

    }

    void display() {

        System.out.println("Name: " + name);

        System.out.println("Age: " + age);

    }

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.display();

    }
}
```

**Output:**
```text
Name: Ayush
Age: 22
```

### Important Characteristics of Constructors

1. Constructor name must be the same as the class name.
2. A constructor does not have a return type, not even `void`.
3. A constructor is invoked during object creation.
4. Constructors are not inherited.
5. Constructors can be overloaded.
6. A constructor can have access modifiers.
7. A constructor can call another constructor using `this()` or a superclass constructor using `super()`.

---

## 10. Types of Constructors in Java

Java constructors are commonly discussed in two main categories: no-argument constructors and parameterized constructors.

### 10.1 Default Constructor

If a class does not declare any constructor, the Java compiler provides a default no-argument constructor.

It initializes fields to their default values.

Examples of Java default field values:

| Data type | Default value |
|---|---|
| int | 0 |
| double | 0.0 |
| boolean | false |
| char | '\u0000' |
| Object reference | null |

Example:

```java
public class DefaultConstructor {

    int number;

    String name;

    public static void main(String[] args) {

        DefaultConstructor obj = new DefaultConstructor();

        System.out.println(obj.number);

        System.out.println(obj.name);

    }
}
```

**Output:**
```text
0
null
```

**Important:** The compiler provides this constructor only when you do not declare any constructor yourself.

### 10.2 No-Argument Constructor

A no-argument constructor is a constructor explicitly written by the programmer without parameters.

```java
public class NoArgumentConstructor {

    String name;

    NoArgumentConstructor() {

        name = "Java Developer";

    }

    void display() {

        System.out.println(name);

    }

    public static void main(String[] args) {

        NoArgumentConstructor obj = new NoArgumentConstructor();

        obj.display();

    }
}
```

**Output:**
```text
Java Developer
```

### 10.3 Parameterized Constructor

A parameterized constructor accepts arguments to initialize an object with specific values.

```java
public class ParameterizedConstructor {

    String name;

    int age;

    ParameterizedConstructor(String n, int a) {

        name = n;

        age = a;

    }

    void display() {

        System.out.println("Name: " + name);

        System.out.println("Age: " + age);

    }

    public static void main(String[] args) {

        ParameterizedConstructor s1 =
            new ParameterizedConstructor("Ayush", 22);

        ParameterizedConstructor s2 =
            new ParameterizedConstructor("Rahul", 21);

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

### Constructor Comparison

| Default Constructor | No-Argument Constructor | Parameterized Constructor |
|---|---|---|
| Provided by compiler | Written by programmer | Written by programmer |
| Has no parameters | Has no parameters | Accepts parameters |
| Exists only if no constructor is declared | Explicitly declared | Explicitly declared |
| Initializes fields to default values | Can initialize custom values | Initializes values using arguments |

---

## 11. Constructor Overloading

Constructor overloading means defining multiple constructors in the same class with different parameter lists.

It allows objects to be initialized in different ways.

### Example

```java
public class ConstructorOverloading {

    String name;

    int age;

    ConstructorOverloading() {

        name = "Unknown";

        age = 0;

    }

    ConstructorOverloading(String n) {

        name = n;

        age = 18;

    }

    ConstructorOverloading(String n, int a) {

        name = n;

        age = a;

    }

    void display() {

        System.out.println(name + " - " + age);

    }

    public static void main(String[] args) {

        ConstructorOverloading s1 =
            new ConstructorOverloading();

        ConstructorOverloading s2 =
            new ConstructorOverloading("Ayush");

        ConstructorOverloading s3 =
            new ConstructorOverloading("Rahul", 22);

        s1.display();

        s2.display();

        s3.display();

    }
}
```

**Output:**
```text
Unknown - 0
Ayush - 18
Rahul - 22
```

---

## 12. The `this` Keyword in Java

The `this` keyword refers to the current object of a class.

It is commonly used when instance variables and constructor or method parameters have the same name.

### 12.1 Using `this` to Access Instance Variables

```java
public class ThisKeyword {

    String name;

    int age;

    ThisKeyword(String name, int age) {

        this.name = name;

        this.age = age;

    }

    void display() {

        System.out.println(name);

        System.out.println(age);

    }

    public static void main(String[] args) {

        ThisKeyword obj = new ThisKeyword("Ayush", 22);

        obj.display();

    }
}
```

**Output:**
```text
Ayush
22
```

**Explanation:**

- `this.name` refers to the instance variable.
- `name` refers to the constructor parameter.
- `this.age` refers to the instance variable.
- `age` refers to the constructor parameter.

### 12.2 Using `this()` to Call Another Constructor

The `this()` keyword can call another constructor in the same class.

```java
public class ThisConstructor {

    String name;

    int age;

    ThisConstructor() {

        this("Unknown", 0);

    }

    ThisConstructor(String name, int age) {

        this.name = name;

        this.age = age;

    }

    void display() {

        System.out.println(name + " " + age);

    }

    public static void main(String[] args) {

        ThisConstructor obj = new ThisConstructor();

        obj.display();

    }
}
```

**Output:**
```text
Unknown 0
```

**Important Rules:**
1. `this()` must be the first statement in a constructor.
2. A constructor cannot directly call itself using `this()`.
3. A constructor cannot use both `this()` and `super()` explicitly as its first constructor invocation.

### 12.3 Using `this` to Call an Instance Method

```java
public class ThisMethod {

    void display() {

        System.out.println("Hello Java");

    }

    void show() {

        this.display();

    }

    public static void main(String[] args) {

        ThisMethod obj = new ThisMethod();

        obj.show();

    }
}
```

**Output:**
```text
Hello Java
```

---

## 13. Difference Between Constructor and Method

Constructors and methods both contain code, but their purposes are different.

| Constructor | Method |
|---|---|
| Initializes objects | Performs a specific operation |
| Name must match the class name | Can have any valid method name |
| Has no return type | Must declare a return type, including `void` |
| Invoked during object creation or constructor chaining | Called explicitly or through other program operations |
| Cannot be inherited | Can be inherited, subject to access and other rules |
| Can be overloaded | Can be overloaded |

---

## 14. Pass by Value in Java

Java always uses **pass by value**.

This means a method receives a copy of the value passed to it.

For primitive variables, the actual primitive value is copied.

For objects, the value of the reference is copied. Both the original reference and copied reference can refer to the same object.

### 14.1 Pass by Value with Primitive Data Types

```java
public class PassByValue {

    static void change(int number) {

        number = 100;

    }

    public static void main(String[] args) {

        int value = 50;

        change(value);

        System.out.println(value);

    }
}
```

**Output:**
```text
50
```

**Explanation:**

The method receives a copy of `value`. Changing the copied variable does not change the original variable.

### 14.2 Pass by Value with Objects

```java
class Student {

    int marks;

}

public class ObjectPassByValue {

    static void update(Student s) {

        s.marks = 95;

    }

    public static void main(String[] args) {

        Student obj = new Student();

        obj.marks = 75;

        update(obj);

        System.out.println(obj.marks);

    }
}
```

**Output:**
```text
95
```

**Explanation:**

The copied reference points to the same object. Therefore, modifying the object's field through that reference changes the object that the original reference also points to.

Java still passes the reference by value; it does not pass objects by reference.

---

## 15. Recursion in Java

Recursion is a programming technique in which a method calls itself to solve a problem.

A recursive method must have two important parts:

1. **Base case:** The condition that stops recursion.
2. **Recursive case:** The part where the method calls itself with a smaller or simpler problem.

Without a proper base case, recursion may continue until a `StackOverflowError` occurs.

### Example 1: Factorial Using Recursion

Factorial of a number is the product of all positive integers from 1 to that number.

For example:

```text
5! = 5 × 4 × 3 × 2 × 1
5! = 120
```

**Program:**

```java
public class FactorialRecursion {

    static int factorial(int n) {

        if (n == 0 || n == 1) {

            return 1;

        }

        return n * factorial(n - 1);

    }

    public static void main(String[] args) {

        int result = factorial(5);

        System.out.println("Factorial = " + result);

    }
}
```

**Output:**
```text
Factorial = 120
```

### Understanding the Recursive Calls

```text
factorial(5)
    5 * factorial(4)
        4 * factorial(3)
            3 * factorial(2)
                2 * factorial(1)
                    1
```

The calls return in reverse order:

```text
1
2 × 1 = 2
3 × 2 = 6
4 × 6 = 24
5 × 24 = 120
```

### Example 2: Sum of Natural Numbers Using Recursion

```java
public class SumRecursion {

    static int sum(int n) {

        if (n == 0) {

            return 0;

        }

        return n + sum(n - 1);

    }

    public static void main(String[] args) {

        System.out.println(sum(5));

    }
}
```

**Output:**
```text
15
```

### Example 3: Fibonacci Using Recursion

```java
public class FibonacciRecursion {

    static int fibonacci(int n) {

        if (n <= 1) {

            return n;

        }

        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    public static void main(String[] args) {

        for (int i = 0; i < 7; i++) {

            System.out.print(fibonacci(i) + " ");

        }

    }
}
```

**Output:**
```text
0 1 1 2 3 5 8
```

**Note:** Simple recursive Fibonacci is useful for learning recursion, but it performs repeated calculations and is inefficient for large inputs.

---

## 16. Practical Real-World Examples Using Methods and Constructors

### Example 1: Student Management

```java
public class StudentManagement {

    String name;

    int rollNumber;

    double marks;

    StudentManagement(String name, int rollNumber, double marks) {

        this.name = name;

        this.rollNumber = rollNumber;

        this.marks = marks;

    }

    void displayDetails() {

        System.out.println("Name: " + name);

        System.out.println("Roll Number: " + rollNumber);

        System.out.println("Marks: " + marks);

    }

    public static void main(String[] args) {

        StudentManagement s1 =
            new StudentManagement("Ayush", 101, 88.5);

        s1.displayDetails();

    }
}
```

**Output:**
```text
Name: Ayush
Roll Number: 101
Marks: 88.5
```

### Example 2: Bank Account

```java
public class BankAccount {

    String accountHolder;

    double balance;

    BankAccount(String accountHolder, double balance) {

        this.accountHolder = accountHolder;

        this.balance = balance;

    }

    void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            System.out.println("Amount deposited successfully.");

        } else {

            System.out.println("Invalid deposit amount.");

        }

    }

    void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println("Insufficient balance or invalid amount.");

        }

    }

    void displayBalance() {

        System.out.println("Account Holder: " + accountHolder);

        System.out.println("Balance: " + balance);

    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount("Ayush", 5000);

        account.deposit(2000);

        account.withdraw(1000);

        account.displayBalance();

    }
}
```

**Output:**
```text
Amount deposited successfully.
Withdrawal successful.
Account Holder: Ayush
Balance: 6000.0
```

### Example 3: Calculator Using Method Overloading

```java
public class Calculator {

    int add(int a, int b) {

        return a + b;

    }

    double add(double a, double b) {

        return a + b;

    }

    int multiply(int a, int b) {

        return a * b;

    }

    double divide(double a, double b) {

        if (b == 0) {

            System.out.println("Cannot divide by zero.");

            return 0;

        }

        return a / b;

    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println(calc.add(10, 20));

        System.out.println(calc.add(10.5, 20.5));

        System.out.println(calc.multiply(5, 4));

        System.out.println(calc.divide(20, 5));

    }
}
```

**Output:**
```text
30
31.0
20
4.0
```

---

## 17. Common Mistakes in Methods and Constructors

| Mistake | Explanation |
|---|---|
| Giving a constructor a return type | A constructor must not declare a return type |
| Calling an instance method directly from static context | Create an object or use an appropriate static method |
| Changing only the return type for overloading | Overloading requires a different parameter list |
| Forgetting the return statement | A non-void method must return a compatible value on every applicable path |
| Calling `this()` after another statement | `this()` must be the first statement in a constructor |
| Assuming Java passes objects by reference | Java passes a copy of the object reference |
| Missing a recursion base case | May cause `StackOverflowError` |
| Assuming a default constructor always exists | It is generated only when no constructor is declared |

---

## 18. Java Methods and Constructors Interview Questions

### Basic Questions

**Q1. What is a method in Java?**

A method is a block of code that performs a particular task and can be called whenever required.

**Q2. What is a constructor?**

A constructor is a special class member used to initialize an object when it is created.

**Q3. What is the difference between a method and a constructor?**

A constructor initializes an object, whereas a method performs a particular operation. Constructors have the same name as their class and no return type.

**Q4. Can a constructor be overloaded?**

Yes. A class can have multiple constructors with different parameter lists.

**Q5. Can a constructor be static?**

No. Constructors cannot be declared static because they initialize objects.

**Q6. Can a constructor be private?**

Yes. Private constructors are useful in patterns such as Singleton and utility classes.

**Q7. Can we call a constructor directly like a method?**

No. Constructors are invoked during object creation or constructor chaining.

### Intermediate Questions

**Q8. What is method overloading?**

Method overloading means defining multiple methods with the same name but different parameter lists.

**Q9. What is the difference between static and instance methods?**

Static methods belong to the class, whereas instance methods belong to objects.

**Q10. Can we overload the main() method?**

Yes. However, the JVM starts program execution using the standard `public static void main(String[] args)` entry point.

**Q11. Can a method return multiple values?**

A Java method can return one value. To represent multiple values, we can return an object, an array, or a collection.

**Q12. Is Java pass-by-value or pass-by-reference?**

Java is always pass-by-value. For objects, the copied value is the object reference.

**Q13. What is recursion?**

Recursion is a technique in which a method calls itself to solve a smaller version of a problem.

**Q14. What happens if a recursive method has no base case?**

It may continue making calls until the call stack is exhausted, causing a `StackOverflowError`.

**Q15. Can we override static methods?**

Static methods are not overridden in the runtime-polymorphism sense. They can be hidden by a static method in a subclass.

---

## 19. Practice Exercises

**Instructions:** Solve these exercises independently. Focus on understanding the logic, writing clean code, and testing different inputs.

### Beginner Level

1. Write a Java method to print "Welcome to Java Programming".
2. Create a method that accepts two integers and prints their sum.
3. Write a method that returns the square of a number.
4. Create a method to check whether a number is even or odd.
5. Write a method that returns the largest of two numbers.
6. Create a method that accepts a student's name and age and displays the details.
7. Write a method to calculate the area of a rectangle.
8. Create a method that converts Celsius into Fahrenheit.
9. Write a method to calculate the factorial of a number using a loop.
10. Create a method that checks whether a given number is positive, negative, or zero.

### Intermediate Level

11. Write an overloaded method to calculate the area of a circle, rectangle, and square.
12. Create a Calculator class using method overloading for addition, subtraction, multiplication, and division.
13. Create a Student class with a parameterized constructor to initialize name, roll number, and marks.
14. Create a Book class with multiple constructors to initialize book details in different ways.
15. Write a program demonstrating the difference between static and instance methods.
16. Create an Employee class with a constructor and methods to calculate annual salary and display employee details.
17. Write a recursive method to calculate the sum of digits of a number.
18. Write a recursive method to reverse a string.
19. Create a method to check whether a number is prime.
20. Write a recursive method to calculate the power of a number.

### Advanced Level

21. Create a BankAccount class with constructors and methods for deposit, withdrawal, and balance checking.
22. Create a Rectangle class with overloaded constructors and methods to calculate area and perimeter.
23. Create a StudentResult class that calculates total marks, percentage, and grade using separate methods.
24. Create a LibraryBook class with methods to issue and return a book.
25. Create a class demonstrating constructor chaining using `this()`.
26. Write a program demonstrating pass-by-value with primitive variables and objects.
27. Create a class with overloaded methods that accept different combinations of integer, double, and String parameters.
28. Write a recursive method to find the greatest common divisor (GCD) of two numbers.
29. Write a recursive method to check whether a string is a palindrome.
30. Build a menu-driven banking application using separate methods for each operation.

---

## 21. Key Takeaways

After completing this chapter, you should understand:

- What methods are and why they are useful.
- How to declare, define, and call methods.
- The four common combinations of parameters and return values.
- The difference between static and instance methods.
- Method parameters and arguments.
- Method overloading and its rules.
- Constructors and their types.
- Constructor overloading and constructor chaining.
- The `this` keyword and its uses.
- The difference between constructors and methods.
- Java's pass-by-value mechanism.
- Recursion and the importance of a base case.
- How to apply methods and constructors in practical applications.

**Next Chapter: Chapter 6 – Object-Oriented Programming (OOP) in Java**

Topics to explore:
1. Introduction to OOP.
2. Classes and Objects.
3. Encapsulation.
4. Inheritance.
5. Polymorphism.
6. Abstraction.
7. Association, Aggregation, and Composition.
8. Real-world OOP examples.
9. OOP interview questions and practice exercises.

Keep practicing each concept by writing your own programs. Understanding how and why the code works is more important than memorizing syntax.