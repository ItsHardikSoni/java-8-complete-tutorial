# Chapter 9: Exception Handling in Java

**Navigation:** [Main Tutorial Index](../README.md) | [Practice Programs](Practice-Programs/) | [Previous: Strings](../08-Java-Strings/README.md) | [Next: Collections](../10-Java-Collections-Framework/README.md)

**Practice:** [Practice Programs](Practice-Programs/) | [Practice Program Index](Practice-Programs/README.md)

## 1. Introduction to Exception Handling

An exception is an event that occurs during program execution and disrupts the normal flow of instructions.

For example, imagine a program that divides two numbers.

```java
int a = 10;

int b = 0;

int result = a / b;
```

Division by zero is not valid for integer arithmetic in Java. Therefore, the JVM throws an `ArithmeticException`.

If the exception is not handled, the current thread terminates.

### Why Do We Need Exception Handling?

In real-world applications, unexpected situations can occur:

- A user enters invalid input.
- A file does not exist.
- A database connection fails.
- An application tries to divide by zero.
- An array is accessed using an invalid index.
- A network connection becomes unavailable.

Exception handling allows us to handle many such situations and control how the application responds.

### Advantages of Exception Handling

1. Prevents abrupt termination when an exception is handled appropriately.
2. Separates error-handling code from normal business logic.
3. Helps maintain application stability.
4. Makes debugging easier.
5. Allows meaningful error messages.
6. Supports reliable resource management.

---

## 2. Understanding Errors and Exceptions

Java provides a hierarchy for representing exceptional conditions.

Both errors and exceptions are subclasses of the `Throwable` class.

### Throwable Hierarchy

```text
                 Object
                    |
                    v
                Throwable
                /       \
               /         \
              v           v
           Error       Exception
             |             |
             |             +--------------------+
             |             |                    |
             v             v                    v
      OutOfMemoryError  IOException       RuntimeException
                        SQLException             |
                                                 |
                                  +--------------+--------------+
                                  |              |              |
                                  v              v              v
                            ArithmeticException
                            NullPointerException
                            ArrayIndexOutOfBoundsException
```

This diagram is simplified. Java contains many additional subclasses.

### 2.1 What Is an Error?

An Error represents a serious problem that generally occurs outside the normal application-level recovery process.

Examples:

- `OutOfMemoryError`
- `StackOverflowError`
- `VirtualMachineError`
- `NoClassDefFoundError`

Example:

```java
public class StackOverflowExample {

    static void display() {

        display();

    }

    public static void main(String[] args) {

        display();

    }
}
```

The method calls itself without a base case. Eventually, the JVM may throw a `StackOverflowError`.

**Important:** Errors are generally not intended to be handled using ordinary application-level exception handling.

### 2.2 What Is an Exception?

An exception is an event that occurs during program execution and interrupts normal program flow.

Examples:

- `ArithmeticException`
- `NullPointerException`
- `IOException`
- `SQLException`
- `NumberFormatException`

Example:

```java
public class ExceptionExample {

    public static void main(String[] args) {

        int a = 10;

        int b = 0;

        int result = a / b;

        System.out.println(result);

    }
}
```

**Output:**

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

The exact stack trace includes additional details such as the source file and line number.

### Error vs Exception

| Error | Exception |
|---|---|
| Generally represents serious system or JVM problems | Represents conditions an application may handle |
| Usually not recoverable through normal application logic | Often recoverable |
| Examples: OutOfMemoryError, StackOverflowError | Examples: IOException, ArithmeticException |
| Subclass of Throwable | Subclass of Throwable |

---

## 3. Types of Exceptions in Java

Exceptions are commonly divided into two main categories:

1. Checked Exceptions.
2. Unchecked Exceptions.

### 3.1 Checked Exceptions

Checked exceptions are exceptions that the Java compiler checks during compilation.

A method that can produce a checked exception must either:
- Handle it using try-catch, or
- Declare it using `throws`, allowing callers to handle it.

Examples:

- IOException
- SQLException
- ClassNotFoundException
- InterruptedException
- FileNotFoundException

### Example: Checked Exception

```java
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {

    public static void main(String[] args) {

        try {

            FileReader reader = new FileReader("data.txt");

            reader.close();

        } catch (IOException e) {

            System.out.println("File operation failed.");

        }

    }
}
```

**Possible Output if the File Does Not Exist:**

```text
File operation failed.
```

The compiler requires handling or declaration of the relevant checked exception.

### 3.2 Unchecked Exceptions

Unchecked exceptions are exceptions that the compiler does not require you to catch or declare.

They are generally subclasses of `RuntimeException`.

Examples:

- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException
- IllegalArgumentException

### Example: Unchecked Exception

```java
public class UncheckedExceptionExample {

    public static void main(String[] args) {

        int a = 10;

        int b = 0;

        System.out.println(a / b);

    }
}
```

**Output:**

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

### Checked vs Unchecked Exceptions

| Checked Exception | Unchecked Exception |
|---|---|
| Checked by compiler | Not checked by compiler |
| Must be caught or declared | Catching or declaring is optional |
| Usually subclasses of Exception excluding RuntimeException | Subclasses of RuntimeException |
| Example: IOException | Example: NullPointerException |

**Important:** Both checked and unchecked exceptions occur at runtime. The difference is whether the compiler requires handling or declaration.

---

## 4. Common Built-in Exceptions in Java

Java provides many predefined exception classes.

| Exception | Description |
|---|---|
| ArithmeticException | Invalid arithmetic operation such as integer division by zero |
| NullPointerException | Attempt to use a null reference in an operation that requires an object |
| ArrayIndexOutOfBoundsException | Invalid array index |
| StringIndexOutOfBoundsException | Invalid String index |
| NumberFormatException | Invalid conversion of text into a numeric value |
| ClassCastException | Invalid runtime type casting |
| IllegalArgumentException | Method receives an illegal or inappropriate argument |
| IOException | Input/output operation failure |
| FileNotFoundException | Requested file cannot be found or opened |
| SQLException | Database access or SQL-related failure |
| ClassNotFoundException | Requested class cannot be located during dynamic class loading |

### Example: NumberFormatException

```java
public class NumberFormatExample {

    public static void main(String[] args) {

        String value = "Java";

        int number = Integer.parseInt(value);

        System.out.println(number);

    }
}
```

**Output:**

```text
Exception in thread "main" java.lang.NumberFormatException
```

The String `"Java"` cannot be converted into an integer.

---

## 5. try and catch Blocks

The `try` and `catch` blocks are used to handle exceptions.

- `try`: Contains code that may throw an exception.
- `catch`: Contains code that handles a matching exception.

### Syntax

```java
try {

    // Risky code

} catch (ExceptionType e) {

    // Exception handling code

}
```

### Example

```java
public class TryCatchExample {

    public static void main(String[] args) {

        try {

            int a = 10;

            int b = 0;

            int result = a / b;

            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero.");

        }

        System.out.println("Program continues.");

    }
}
```

**Output:**

```text
Cannot divide by zero.
Program continues.
```

### Understanding the Execution

1. The program enters the try block.
2. Java evaluates `10 / 0`.
3. An ArithmeticException occurs.
4. The remaining statements in that try block are skipped.
5. The matching catch block executes.
6. The program continues after the try-catch structure.

---

## 6. Multiple Catch Blocks

A single try block can be followed by multiple catch blocks.

This is useful when different exceptions need different handling.

### Syntax

```java
try {

    // Risky code

} catch (ArithmeticException e) {

    // Handle arithmetic exception

} catch (ArrayIndexOutOfBoundsException e) {

    // Handle array exception

} catch (Exception e) {

    // Handle other exceptions

}
```

### Example

```java
public class MultipleCatchExample {

    public static void main(String[] args) {

        try {

            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

            int result = 10 / 0;

            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println("Arithmetic error.");

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid array index.");

        } catch (Exception e) {

            System.out.println("Some other exception occurred.");

        }

    }
}
```

**Output:**

```text
Invalid array index.
```

Why?

The array access throws an exception first. The remaining statements in the try block are skipped.

### Important Rule

Specific exception types should be placed before their more general parent exception types.

Incorrect:

```java
try {

    // Code

} catch (Exception e) {

    // General handling

} catch (ArithmeticException e) {

    // Unreachable catch block

}
```

This causes a compilation error because the general catch block already catches ArithmeticException.

---

## 7. Multi-Catch in Java

Java 7 introduced multi-catch.

It allows multiple exception types to be handled by one catch block using the `|` operator.

### Example

```java
public class MultiCatchExample {

    public static void main(String[] args) {

        try {

            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid operation occurred.");

        }

    }
}
```

**Output:**

```text
Invalid operation occurred.
```

**Important:** The exception types in a multi-catch statement cannot be related through a subclass-parent relationship.

---

## 8. Nested try Blocks

A try block inside another try block is called a nested try block.

It is useful when different operations require separate exception-handling logic.

### Example

```java
public class NestedTryExample {

    public static void main(String[] args) {

        try {

            System.out.println("Outer try block.");

            try {

                int result = 10 / 0;

                System.out.println(result);

            } catch (ArithmeticException e) {

                System.out.println("Inner arithmetic exception.");

            }

            int[] numbers = {10, 20};

            System.out.println(numbers[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Outer array exception.");

        }

    }
}
```

**Output:**

```text
Outer try block.
Inner arithmetic exception.
Outer array exception.
```

### Explanation

- The outer try block starts.
- The inner try block causes an ArithmeticException.
- The inner catch block handles it.
- Execution continues in the outer try block.
- An invalid array index causes another exception.
- The outer catch block handles it.

---

## 9. finally Block

The `finally` block contains code that normally executes after try-catch processing, whether an exception occurs or not.

It is commonly used for cleanup operations.

### Syntax

```java
try {

    // Risky code

} catch (Exception e) {

    // Exception handling

} finally {

    // Cleanup code

}
```

### Example 1: Finally with Exception

```java
public class FinallyExample {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println("Exception handled.");

        } finally {

            System.out.println("Finally block executed.");

        }

    }
}
```

**Output:**

```text
Exception handled.
Finally block executed.
```

### Example 2: Finally Without Exception

```java
public class FinallyExample2 {

    public static void main(String[] args) {

        try {

            System.out.println("Inside try block.");

        } catch (Exception e) {

            System.out.println("Exception occurred.");

        } finally {

            System.out.println("Finally block executed.");

        }

    }
}
```

**Output:**

```text
Inside try block.
Finally block executed.
```

### Important Points About finally

1. The finally block normally executes whether an exception occurs or not.
2. It executes after the associated try-catch processing.
3. It is commonly used for cleanup.
4. It may not execute if the JVM terminates abruptly, such as through `System.exit()`, or the process is forcibly terminated.
5. A finally block can be used without a catch block if it follows a try block.

**Best Practice:** Use try-with-resources for automatically closing resources that implement AutoCloseable.

---

## 10. Difference Between final, finally, and finalize()

These three terms look similar but have different meanings.

| Keyword or Method | Meaning |
|---|---|
| `final` | Restricts reassignment, overriding, or inheritance |
| `finally` | Exception-handling block used for cleanup |
| `finalize()` | Legacy object-finalization method |

### Example

```java
public class FinalFinallyExample {

    public static void main(String[] args) {

        final int number = 100;

        try {

            System.out.println(number);

        } finally {

            System.out.println("Cleanup operation.");

        }

    }
}
```

**Output:**

```text
100
Cleanup operation.
```

**Note:** `finalize()` is deprecated in modern Java and should not be used for resource management.

---

## 11. throw Keyword in Java

The `throw` keyword is used to explicitly throw an exception from a method or block of code.

It is useful when a programmer wants to indicate that a particular condition is invalid.

### Syntax

```java
throw new ExceptionType("Error message");
```

### Example

```java
public class ThrowExample {

    public static void main(String[] args) {

        int age = 15;

        if (age < 18) {

            throw new IllegalArgumentException(
                "Age must be 18 or above."
            );

        }

        System.out.println("Eligible.");

    }
}
```

**Output:**

```text
Exception in thread "main" java.lang.IllegalArgumentException:
Age must be 18 or above.
```

### Example: throw with try-catch

```java
public class ThrowExample2 {

    public static void main(String[] args) {

        try {

            int age = 15;

            if (age < 18) {

                throw new IllegalArgumentException(
                    "Not eligible to vote."
                );

            }

            System.out.println("Eligible to vote.");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

    }
}
```

**Output:**

```text
Not eligible to vote.
```

---

## 12. throws Keyword in Java

The `throws` keyword is used in a method declaration to indicate that the method may pass one or more exceptions to its caller.

It is commonly used with checked exceptions.

### Syntax

```java
returnType methodName() throws ExceptionType {

    // Method body

}
```

### Example

```java
import java.io.FileReader;
import java.io.IOException;

public class ThrowsExample {

    static void readFile() throws IOException {

        FileReader reader = new FileReader("data.txt");

        reader.close();

    }

    public static void main(String[] args) {

        try {

            readFile();

        } catch (IOException e) {

            System.out.println("Unable to read the file.");

        }

    }
}
```

**Possible Output if the File Does Not Exist:**

```text
Unable to read the file.
```

### Multiple Exceptions Using throws

```java
import java.io.IOException;
import java.sql.SQLException;

public class MultipleThrowsExample {

    static void performOperation()
            throws IOException, SQLException {

        // Operations that may throw these exceptions

    }

}
```

---

## 13. Difference Between throw and throws

| throw | throws |
|---|---|
| Used to explicitly throw an exception | Used to declare possible exceptions |
| Written inside a method or block | Written in a method declaration |
| Throws one exception object at a time | Can declare multiple exception types |
| Followed by an exception object | Followed by exception class names |
| Example: `throw new IOException();` | Example: `void read() throws IOException` |

### Example Combining throw and throws

```java
import java.io.IOException;

public class ThrowThrowsExample {

    static void checkAge(int age) throws IOException {

        if (age < 18) {

            throw new IOException("Age restriction.");

        }

        System.out.println("Allowed.");

    }

    public static void main(String[] args) {

        try {

            checkAge(15);

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }
}
```

**Output:**

```text
Age restriction.
```

---

## 14. Custom Exceptions in Java

A custom exception is an exception class created by the programmer to represent application-specific error conditions.

Java provides many predefined exceptions, but sometimes they are not meaningful enough for a particular business rule.

For example:
- Insufficient bank balance.
- Invalid employee ID.
- Invalid age.
- Product out of stock.
- Invalid transaction amount.

### Creating a Custom Checked Exception

A custom checked exception generally extends the `Exception` class.

### Example: Invalid Age Exception

```java
class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {

        super(message);

    }

}

public class CustomExceptionExample {

    static void checkAge(int age) throws InvalidAgeException {

        if (age < 18) {

            throw new InvalidAgeException(
                "Age must be 18 or above."
            );

        }

        System.out.println("You are eligible.");

    }

    public static void main(String[] args) {

        try {

            checkAge(16);

        } catch (InvalidAgeException e) {

            System.out.println(e.getMessage());

        }

    }
}
```

**Output:**

```text
Age must be 18 or above.
```

### Creating a Custom Unchecked Exception

A custom unchecked exception generally extends `RuntimeException`.

```java
class InsufficientBalanceException extends RuntimeException {

    InsufficientBalanceException(String message) {

        super(message);

    }

}

public class CustomUncheckedException {

    static void withdraw(double balance, double amount) {

        if (amount > balance) {

            throw new InsufficientBalanceException(
                "Insufficient account balance."
            );

        }

        System.out.println("Withdrawal successful.");

    }

    public static void main(String[] args) {

        try {

            withdraw(5000, 7000);

        } catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        }

    }
}
```

**Output:**

```text
Insufficient account balance.
```

### Checked vs Unchecked Custom Exceptions

| Custom Checked Exception | Custom Unchecked Exception |
|---|---|
| Extends `Exception` | Extends `RuntimeException` |
| Must be caught or declared | Handling or declaration is optional |
| Suitable for conditions callers are expected to handle | Suitable for programming errors or invalid usage, depending on design |

---

## 15. Exception Propagation in Java

Exception propagation means passing an exception from one method to its caller until a matching catch block handles it.

If no matching handler is found, the exception reaches the thread's uncaught exception handler.

### Example

```java
public class ExceptionPropagation {

    static void method1() {

        int result = 10 / 0;

    }

    static void method2() {

        method1();

    }

    static void method3() {

        method2();

    }

    public static void main(String[] args) {

        try {

            method3();

        } catch (ArithmeticException e) {

            System.out.println("Exception handled in main.");

        }

    }
}
```

**Output:**

```text
Exception handled in main.
```

### Understanding the Flow

```text
main()
   |
   v
method3()
   |
   v
method2()
   |
   v
method1()
   |
   v
ArithmeticException
   |
   v
Propagates back to method2()
   |
   v
Propagates back to method3()
   |
   v
Propagates back to main()
   |
   v
Caught by main()
```

**Important:** Unchecked exceptions can propagate without being declared. Checked exceptions must be handled or declared according to Java's compile-time rules.

---

## 16. Exception Handling with Method Overriding

Java has special rules for checked exceptions when overriding methods.

A subclass overriding method:
- Can declare the same checked exception.
- Can declare a narrower checked exception.
- Can declare no checked exception.
- Cannot declare a broader checked exception than the overridden method.

### Example

```java
import java.io.IOException;

class Parent {

    void display() throws IOException {

        System.out.println("Parent method.");

    }

}

class Child extends Parent {

    @Override
    void display() throws java.io.FileNotFoundException {

        System.out.println("Child method.");

    }

}

public class OverrideExceptionExample {

    public static void main(String[] args) throws IOException {

        Parent obj = new Child();

        obj.display();

    }
}
```

**Output:**

```text
Child method.
```

`FileNotFoundException` is a subclass of `IOException`, so this narrower declaration is valid.

---

## 17. try-with-resources in Java

Java 7 introduced try-with-resources.

It automatically closes resources after the try block completes.

It is useful for resources such as:
- File streams.
- Readers and writers.
- Database connections.
- Statements and result sets.
- Other objects implementing AutoCloseable.

### Why Do We Need It?

Consider opening a file or database connection.

After using the resource, we must close it to release system resources.

Without proper cleanup, resources may remain open unnecessarily.

### Syntax

```java
try (ResourceType resource = new ResourceType()) {

    // Use resource

} catch (Exception e) {

    // Handle exception

}
```

### Example

```java
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("data.txt")) {

            int character;

            while ((character = reader.read()) != -1) {

                System.out.print((char) character);

            }

        } catch (IOException e) {

            System.out.println("File operation failed.");

        }

    }
}
```

**Output if data.txt contains `Hello Java`:**

```text
Hello Java
```

The FileReader is automatically closed when the try-with-resources statement completes.

### Multiple Resources

```java
try (
    FileReader reader = new FileReader("input.txt");
    java.io.BufferedReader br =
        new java.io.BufferedReader(reader)
) {

    System.out.println(br.readLine());

} catch (IOException e) {

    System.out.println("File error.");

}
```

Resources are closed automatically in reverse order of their declaration.

---

## 18. Exception Handling with User Input

In real applications, users may enter invalid data.

We can handle such input using try-catch.

### Example: Number Input Validation

```java
import java.util.Scanner;

public class UserInputException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter a number: ");

            int number = sc.nextInt();

            System.out.println("Number: " + number);

        } catch (java.util.InputMismatchException e) {

            System.out.println("Please enter a valid integer.");

        } finally {

            sc.close();

        }

    }
}
```

**Sample Input:**

```text
Enter a number: Java
```

**Output:**

```text
Please enter a valid integer.
```

---

## 19. Real-World Example: Banking Application

This example combines:
- Custom exceptions.
- try-catch.
- throw.
- Encapsulation.
- Methods.

```java
class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {

        super(message);

    }

}

class BankAccount {

    private double balance;

    BankAccount(double balance) {

        this.balance = balance;

    }

    public void deposit(double amount) {

        if (amount <= 0) {

            throw new IllegalArgumentException(
                "Deposit amount must be positive."
            );

        }

        balance += amount;

        System.out.println("Deposit successful.");

    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {

            throw new IllegalArgumentException(
                "Withdrawal amount must be positive."
            );

        }

        if (amount > balance) {

            throw new InsufficientBalanceException(
                "Insufficient balance."
            );

        }

        balance -= amount;

        System.out.println("Withdrawal successful.");

    }

    public double getBalance() {

        return balance;

    }

}

public class BankingApplication {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000);

        try {

            account.deposit(2000);

            account.withdraw(1000);

            account.withdraw(10000);

        } catch (InsufficientBalanceException |
                 IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        System.out.println("Final Balance: " + account.getBalance());

    }
}
```

**Output:**

```text
Deposit successful.
Withdrawal successful.
Insufficient balance.
Final Balance: 6000.0
```

### Concepts Used

| Concept | Application |
|---|---|
| Encapsulation | Private balance |
| Custom Exception | InsufficientBalanceException |
| throw | Explicitly throws an exception |
| throws | Declares a checked exception |
| try-catch | Handles exceptional conditions |
| Methods | Deposit and withdrawal operations |

---

## 20. Best Practices for Exception Handling

1. Catch specific exceptions instead of catching every exception unnecessarily.
2. Do not use empty catch blocks.
3. Provide meaningful error messages.
4. Do not use exceptions for ordinary control flow.
5. Use try-with-resources for AutoCloseable resources.
6. Avoid catching Error unless there is a very specific reason.
7. Preserve the original cause when wrapping exceptions.
8. Do not expose passwords, tokens, or sensitive information in exception messages.
9. Log useful diagnostic information where appropriate.
10. Create custom exceptions when they improve the clarity of business rules.
11. Do not catch an exception and silently ignore it.
12. Avoid unnecessarily large try blocks that combine unrelated operations.

### Example: Avoid Empty Catch Blocks

Poor practice:

```java
try {

    int result = 10 / 0;

} catch (Exception e) {

}
```

Better practice:

```java
try {

    int result = 10 / 0;

} catch (ArithmeticException e) {

    System.out.println("Cannot divide by zero.");

}
```

---

## 21. Common Mistakes in Exception Handling

| Mistake | Explanation |
|---|---|
| Forgetting to handle a checked exception | Causes a compilation error |
| Using a parent exception before a child exception | Makes the child catch block unreachable |
| Writing an empty catch block | Hides failures |
| Confusing throw and throws | They have different purposes |
| Assuming finally always executes | Abrupt JVM termination can prevent it |
| Catching Exception everywhere | Can hide specific problems |
| Forgetting to close resources | May cause resource leaks |
| Creating custom exceptions without meaningful purpose | Makes code unnecessarily complex |
| Catching an exception without handling or propagating it | Can hide application failures |
| Printing only generic messages during debugging | Can make diagnosing problems difficult |

---

## 22. Exception Handling Interview Questions

### Basic Questions

**Q1. What is an exception in Java?**

**Answer:** An exception is an event that interrupts the normal flow of program execution.

**Q2. What is exception handling?**

**Answer:** Exception handling is a mechanism for detecting and managing exceptional conditions during program execution.

**Q3. What is the difference between Error and Exception?**

**Answer:** Error generally represents serious JVM or system-level problems, while exceptions represent conditions an application may be able to handle.

**Q4. What are checked exceptions?**

**Answer:** Checked exceptions are exceptions that the compiler requires you to handle or declare.

**Q5. What are unchecked exceptions?**

**Answer:** Unchecked exceptions are subclasses of RuntimeException and do not require mandatory handling or declaration.

**Q6. What is the purpose of try?**

**Answer:** It contains code that may throw an exception.

**Q7. What is the purpose of catch?**

**Answer:** It handles a matching exception thrown from the associated try block.

**Q8. What is the purpose of finally?**

**Answer:** It contains cleanup code that normally executes after try-catch processing.

**Q9. Can we have multiple catch blocks?**

**Answer:** Yes. A try block can be followed by multiple catch blocks.

**Q10. Can we use try without catch?**

**Answer:** Yes. A try block can be followed by finally without a catch block.

### Intermediate Questions

**Q11. What is the difference between throw and throws?**

**Answer:** `throw` explicitly throws an exception object, while `throws` declares exceptions that a method may pass to its caller.

**Q12. What is a custom exception?**

**Answer:** A custom exception is an exception class created by the programmer for application-specific conditions.

**Q13. What is exception propagation?**

**Answer:** It is the process of passing an exception from a method to its callers until it is handled.

**Q14. Can we write a try block inside another try block?**

**Answer:** Yes. This is called nested try.

**Q15. Can finally execute if an exception occurs?**

**Answer:** Yes. The finally block normally executes after the matching catch block.

**Q16. Can we throw an exception manually?**

**Answer:** Yes. We use the `throw` keyword.

**Q17. What is try-with-resources?**

**Answer:** It is a Java feature that automatically closes resources implementing AutoCloseable.

**Q18. What is the difference between Exception and RuntimeException?**

**Answer:** RuntimeException is a subclass of Exception. RuntimeException and its subclasses are unchecked, while other direct and indirect subclasses of Exception are generally checked.

**Q19. Can we catch multiple exception types in one catch block?**

**Answer:** Yes. Java supports multi-catch using the `|` operator.

**Q20. Can we override a method and throw a broader checked exception?**

**Answer:** No. An overriding method cannot declare a broader checked exception than the overridden method.

### Advanced Questions

**Q21. What happens if an exception is not handled?**

**Answer:** It reaches the thread's uncaught exception handler, which normally prints the stack trace and terminates that thread.

**Q22. Can a constructor throw an exception?**

**Answer:** Yes. A constructor can throw checked or unchecked exceptions.

**Q23. Can we rethrow an exception?**

**Answer:** Yes. We can catch an exception and throw it again.

**Q24. What is exception chaining?**

**Answer:** Exception chaining means preserving an original exception as the cause of another exception.

**Q25. What is the difference between `getMessage()` and `printStackTrace()`?**

**Answer:** `getMessage()` returns the exception message, while `printStackTrace()` prints exception details and the call stack.

**Q26. Can a finally block contain a return statement?**

**Answer:** Yes, but it is discouraged because a return from finally can override a return or exception from the try or catch block.

**Q27. Is it possible to handle an Error using try-catch?**

**Answer:** Technically yes, because Error extends Throwable, but catching serious Error subclasses is generally not recommended as ordinary recovery.

**Q28. What is the purpose of AutoCloseable?**

**Answer:** It defines a `close()` method for resources that can be automatically closed using try-with-resources.

**Q29. What happens when both try and finally throw exceptions?**

**Answer:** If finally throws a new exception while another exception is already propagating, the exception from finally can replace the original exception in ordinary try-finally processing.

**Q30. Why should we avoid catching Throwable?**

**Answer:** Throwable includes both Exception and Error. Catching it broadly can hide serious problems that the application is not designed to recover from.

---

## 23. Practice Exercises

**Instructions:** Solve these exercises independently. Create separate Java files, test different scenarios, and understand why each exception occurs.

### Beginner Level

1. Write a program to handle ArithmeticException during division.
2. Write a program to handle ArrayIndexOutOfBoundsException.
3. Write a program to handle NullPointerException.
4. Write a program to handle NumberFormatException.
5. Write a program using multiple catch blocks.
6. Write a program demonstrating the finally block.
7. Write a program demonstrating nested try blocks.
8. Write a program to accept an integer using Scanner and handle invalid input.
9. Write a program demonstrating the throw keyword.
10. Write a program demonstrating the throws keyword.

### Intermediate Level

11. Create a custom checked exception for invalid age.
12. Create a custom unchecked exception for invalid account balance.
13. Write a program demonstrating exception propagation through multiple methods.
14. Write a program demonstrating multi-catch.
15. Write a program to read a file using try-with-resources.
16. Write a program demonstrating exception handling in constructors.
17. Write a program demonstrating exception handling during method overriding.
18. Write a program to validate a user's age using a custom exception.
19. Write a program to validate a password and throw an appropriate exception.
20. Write a program demonstrating exception chaining.

### Advanced Level

21. Create a Banking Management System with custom exceptions for insufficient balance and invalid transaction amounts.
22. Create a Student Registration System with custom exceptions for invalid student details.
23. Create a File Management System using try-with-resources.
24. Create a Payment Processing System with custom exceptions for failed transactions.
25. Create a Login System that handles invalid credentials.
26. Design an Employee Management System with exception handling for invalid employee records.
27. Create a program that handles multiple file-related exceptions.
28. Demonstrate how exceptions propagate through constructors and methods.
29. Create a menu-driven calculator with appropriate exception handling.
30. Build a small application that combines checked exceptions, unchecked exceptions, custom exceptions, and try-with-resources.

---

## 24. Key Takeaways

After completing this chapter, you should understand:

- What exceptions are and why exception handling is required.
- The difference between Errors and Exceptions.
- The Java exception hierarchy.
- Checked and unchecked exceptions.
- Common built-in exceptions.
- How try and catch blocks work.
- Multiple catch blocks and multi-catch.
- Nested try blocks.
- The finally block.
- The difference between final, finally, and finalize().
- The throw and throws keywords.
- How to create custom checked and unchecked exceptions.
- Exception propagation.
- Exception handling during method overriding.
- try-with-resources and automatic resource closing.
- Exception handling in real-world applications.
- Best practices for writing reliable Java code.

## What's Next?

**Chapter 10: Java Collections Framework (JCF)**

Topics to explore:

1. Introduction to Collections Framework.
2. Collection vs Collections.
3. List Interface.
4. ArrayList.
5. LinkedList.
6. Vector.
7. Stack.
8. Set Interface.
9. HashSet.
10. LinkedHashSet.
11. TreeSet.
12. Queue Interface.
13. PriorityQueue.
14. Map Interface.
15. HashMap.
16. LinkedHashMap.
17. TreeMap.
18. Iterator and ListIterator.
19. Comparable and Comparator.
20. Generics in Collections.
21. Collections Interview Questions.
22. Practice Exercises.

**Learning Tip:** Exception handling is not just about preventing program crashes. Learn to identify the cause of an exception, choose the correct exception type, and handle it at the appropriate level of your application.
