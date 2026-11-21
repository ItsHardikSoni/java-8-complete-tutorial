# Chapter 4: Java Control Flow Statements – Decision Making and Loops

## 4.1 Introduction to Control Flow Statements

Control flow statements are used to control the order in which instructions are executed in a Java program.

By default, Java executes statements from top to bottom. However, sometimes we need the program to make decisions, repeat certain tasks, or stop execution based on a condition.

For example:

- If a student scores 40 or more marks, display "Pass".
- If a person is 18 or older, allow them to vote.
- Repeat a task 10 times.
- Stop a loop when a particular condition is satisfied.

Java provides control flow statements to handle these situations.

### Types of Control Flow Statements

Java control flow statements are commonly divided into three categories.

**1. Decision-Making Statements**

These statements help a program choose between different execution paths.

- if
- if-else
- else-if ladder
- nested if
- switch

**2. Looping Statements**

These statements execute a block of code repeatedly until a condition is satisfied.

- for loop
- while loop
- do-while loop
- enhanced for loop

**3. Jump Statements**

These statements change the normal execution flow.

- break
- continue
- return

Let's understand each category with practical examples.

---

# 4.2 Decision-Making Statements in Java

Decision-making statements allow Java programs to execute different blocks of code depending on whether a condition is true or false.

For example, consider a student examination system.

If a student's marks are greater than or equal to 40, the student passes. Otherwise, the student fails.

We can implement this using an if-else statement.

## 4.3 if Statement

The `if` statement is the simplest decision-making statement in Java.

It executes a block of code only when the given condition is true.

### Syntax

```java
if (condition) {

    // Code executes when condition is true

}
```

### Example 1: Check Voting Eligibility

```java
public class IfStatement {

    public static void main(String[] args) {

        int age = 22;

        if (age >= 18) {

            System.out.println("You are eligible to vote.");

        }
    }
}
```

**Output:**

```text
You are eligible to vote.
```

### Explanation

1. We declare a variable named `age` and assign it a value of 22.
2. The if statement checks whether `age >= 18`.
3. Since 22 is greater than 18, the condition becomes true.
4. Java executes the code inside the if block.
5. The message is displayed.

### Example 2: Check Whether a Number Is Positive

```java
public class PositiveNumber {

    public static void main(String[] args) {

        int number = 10;

        if (number > 0) {

            System.out.println("Positive Number");

        }
    }
}
```

**Output:**

```text
Positive Number
```

### Example 3: Check Whether a Student Passed

```java
public class StudentPass {

    public static void main(String[] args) {

        int marks = 75;

        if (marks >= 40) {

            System.out.println("Congratulations! You Passed.");

        }
    }
}
```

**Output:**

```text
Congratulations! You Passed.
```

**Important:** If the condition is false, Java skips the if block and continues executing the remaining statements.

---

## 4.4 if-else Statement

Sometimes we need to execute one block of code when a condition is true and another block when it is false.

For this purpose, Java provides the `if-else` statement.

### Syntax

```java
if (condition) {

    // Executes when condition is true

} else {

    // Executes when condition is false

}
```

### Example 1: Even or Odd Number

A number is even if it is completely divisible by 2.

We use the modulus operator `%` to find the remainder.

```java
public class EvenOdd {

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

**Output:**

```text
Odd Number
```

### Explanation

The expression:

```java
number % 2 == 0
```

checks whether the remainder after dividing the number by 2 is zero.

For 15:

```text
15 % 2 = 1
```

The condition becomes false, so the else block executes.

### Example 2: Check Voting Eligibility

```java
public class VotingEligibility {

    public static void main(String[] args) {

        int age = 16;

        if (age >= 18) {

            System.out.println("You are eligible to vote.");

        } else {

            System.out.println("You are not eligible to vote.");

        }
    }
}
```

**Output:**

```text
You are not eligible to vote.
```

### Example 3: Find the Greater Number

```java
public class GreaterNumber {

    public static void main(String[] args) {

        int a = 50;
        int b = 30;

        if (a > b) {

            System.out.println("A is greater");

        } else {

            System.out.println("B is greater or equal");

        }
    }
}
```

**Output:**

```text
A is greater
```

---

## 4.5 else-if Ladder

Sometimes a program needs to check multiple conditions.

For example, a student may receive different grades based on their percentage.

We cannot efficiently handle all these conditions using only one if-else statement.

Java provides the `else-if` ladder for this purpose.

### Syntax

```java
if (condition1) {

    // Executes when condition1 is true

} else if (condition2) {

    // Executes when condition2 is true

} else if (condition3) {

    // Executes when condition3 is true

} else {

    // Executes when all conditions are false

}
```

Java checks conditions from top to bottom.

As soon as a condition becomes true, its corresponding block executes, and the remaining conditions are skipped.

### Example 1: Student Grading System

```java
public class StudentGrade {

    public static void main(String[] args) {

        int marks = 85;

        if (marks >= 90) {

            System.out.println("Grade A+");

        } else if (marks >= 80) {

            System.out.println("Grade A");

        } else if (marks >= 70) {

            System.out.println("Grade B");

        } else if (marks >= 60) {

            System.out.println("Grade C");

        } else if (marks >= 40) {

            System.out.println("Grade D");

        } else {

            System.out.println("Fail");

        }
    }
}
```

**Output:**

```text
Grade A
```

### Explanation

The program checks the conditions in order:

- Is 85 greater than or equal to 90? No.
- Is 85 greater than or equal to 80? Yes.
- Java prints Grade A.
- The remaining conditions are not checked.

### Example 2: Positive, Negative, or Zero

```java
public class NumberCheck {

    public static void main(String[] args) {

        int number = -10;

        if (number > 0) {

            System.out.println("Positive Number");

        } else if (number < 0) {

            System.out.println("Negative Number");

        } else {

            System.out.println("Zero");

        }
    }
}
```

**Output:**

```text
Negative Number
```

### Example 3: Electricity Bill Calculation

```java
public class ElectricityBill {

    public static void main(String[] args) {

        int units = 250;

        double bill;

        if (units <= 100) {

            bill = units * 1.5;

        } else if (units <= 200) {

            bill = (100 * 1.5) + (units - 100) * 2.5;

        } else {

            bill = (100 * 1.5)
                    + (100 * 2.5)
                    + (units - 200) * 4.0;

        }

        System.out.println("Total Electricity Bill: Rs. " + bill);
    }
}
```

**Output:**

```text
Total Electricity Bill: Rs. 650.0
```

Note: These electricity rates are illustrative examples for learning purposes.

---

## 4.6 Nested if Statement

A nested if statement means placing one if statement inside another if statement.

We use nested if statements when a decision depends on multiple conditions that need to be checked in stages.

### Syntax

```java
if (condition1) {

    if (condition2) {

        // Executes when both conditions are true

    }

}
```

### Example 1: Login Authentication

Imagine a login system where a user must enter the correct username and password.

```java
public class LoginSystem {

    public static void main(String[] args) {

        String username = "ayush";
        String password = "java123";

        if (username.equals("ayush")) {

            if (password.equals("java123")) {

                System.out.println("Login Successful!");

            } else {

                System.out.println("Incorrect Password.");

            }

        } else {

            System.out.println("Username Not Found.");

        }
    }
}
```

**Output:**

```text
Login Successful!
```

### Explanation

1. First, Java checks whether the username is correct.
2. If the username is correct, it checks the password.
3. If both are correct, login is successful.
4. Otherwise, the corresponding error message is displayed.

### Example 2: Check Admission Eligibility

A college requires a student to score at least 60% overall and at least 50 marks in mathematics.

```java
public class AdmissionEligibility {

    public static void main(String[] args) {

        double percentage = 75;

        int mathsMarks = 65;

        if (percentage >= 60) {

            if (mathsMarks >= 50) {

                System.out.println("Admission Eligible");

            } else {

                System.out.println("Mathematics Requirement Not Met");

            }

        } else {

            System.out.println("Minimum Percentage Not Met");

        }
    }
}
```

**Output:**

```text
Admission Eligible
```

---

## 4.7 switch Statement

The switch statement is another decision-making statement in Java.

It is useful when we want to compare one expression against multiple possible values.

For example, imagine a calculator application.

A user selects an operation:

- 1 for Addition
- 2 for Subtraction
- 3 for Multiplication
- 4 for Division

Instead of writing multiple if-else conditions, we can use a switch statement.

### Syntax

```java
switch (expression) {

    case value1:
        // Code
        break;

    case value2:
        // Code
        break;

    case value3:
        // Code
        break;

    default:
        // Code when no case matches

}
```

### Understanding Switch Components

**1. switch**

The switch keyword evaluates an expression and compares its result with available case labels.

**2. case**

Each case represents a possible value.

**3. break**

The break statement terminates the switch block and prevents execution from continuing into the next case.

**4. default**

The default block executes when none of the case labels matches.

The default block is optional.

### Example 1: Display Day Name

```java
public class DayName {

    public static void main(String[] args) {

        int day = 3;

        switch (day) {

            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;

            case 7:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Invalid Day");

        }
    }
}
```

**Output:**

```text
Wednesday
```

### Example 2: Simple Calculator Using Switch

```java
public class Calculator {

    public static void main(String[] args) {

        int a = 20;
        int b = 10;

        char operator = '+';

        switch (operator) {

            case '+':
                System.out.println("Addition: " + (a + b));
                break;

            case '-':
                System.out.println("Subtraction: " + (a - b));
                break;

            case '*':
                System.out.println("Multiplication: " + (a * b));
                break;

            case '/':
                if (b != 0) {
                    System.out.println("Division: " + (a / b));
                } else {
                    System.out.println("Cannot divide by zero.");
                }
                break;

            default:
                System.out.println("Invalid Operator");

        }
    }
}
```

**Output:**

```text
Addition: 30
```

### Example 3: Switch with String

Java supports String expressions in switch statements from Java 7 onwards.

Therefore, String-based switch statements work in Java 8.

```java
public class BrowserCheck {

    public static void main(String[] args) {

        String browser = "chrome";

        switch (browser) {

            case "chrome":
                System.out.println("Google Chrome Selected");
                break;

            case "firefox":
                System.out.println("Mozilla Firefox Selected");
                break;

            case "edge":
                System.out.println("Microsoft Edge Selected");
                break;

            default:
                System.out.println("Unknown Browser");

        }
    }
}
```

**Output:**

```text
Google Chrome Selected
```

### What Happens If We Forget break?

This is an important switch concept.

If we forget the break statement, Java continues executing the following case statements until it encounters a break or reaches the end of the switch.

This behaviour is called fall-through.

Example:

```java
public class SwitchFallThrough {

    public static void main(String[] args) {

        int number = 1;

        switch (number) {

            case 1:
                System.out.println("One");

            case 2:
                System.out.println("Two");

            case 3:
                System.out.println("Three");
                break;

            default:
                System.out.println("Invalid");

        }
    }
}
```

**Output:**

```text
One
Two
Three
```

Why?

The matching case is 1. Since there is no break after case 1 or case 2, execution continues into the following cases.

### Multiple Cases with the Same Result

We can use multiple case labels for one block of code.

```java
public class WeekendCheck {

    public static void main(String[] args) {

        int day = 6;

        switch (day) {

            case 6:
            case 7:
                System.out.println("Weekend");
                break;

            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Weekday");
                break;

            default:
                System.out.println("Invalid Day");

        }
    }
}
```

**Output:**

```text
Weekend
```

### Important Java 8 Switch Rules

In Java 8, traditional switch statements support:

- byte
- short
- char
- int
- Their corresponding wrapper types
- String
- enum types

Switch expressions and arrow-style case labels introduced in later Java versions are not part of Java 8.

For example, this is not valid Java 8 syntax:

```java
// Not supported in Java 8

// int result = switch (number) {
//     case 1 -> 10;
//     default -> 0;
// };
```

For this tutorial, we will use traditional Java 8 switch statements.

---

# 4.8 Looping Statements in Java

Until now, we have executed instructions based on conditions.

But what if we want to repeat the same task multiple times?

Imagine you want to print numbers from 1 to 100.

Writing 100 separate print statements would be unnecessary and difficult to maintain.

Instead, Java provides looping statements.

A loop repeatedly executes a block of code while a specified condition allows it to continue.

### Types of Loops in Java

Java provides four commonly used looping constructs:

1. for loop
2. while loop
3. do-while loop
4. enhanced for loop

Let's understand each one.

## 4.9 for Loop

The for loop is used when we generally know how many times a block of code needs to execute.

For example:

- Print numbers from 1 to 10.
- Display a multiplication table.
- Calculate the sum of the first 100 numbers.
- Process a fixed number of records.

### Syntax

```java
for (initialization; condition; update) {

    // Statements to execute

}
```

### Understanding the Three Parts

**1. Initialization**

This part executes once before the loop begins.

Example:

```java
int i = 1;
```

**2. Condition**

Java checks the condition before every iteration.

If the condition is true, the loop executes.

If it is false, the loop terminates.

**3. Update**

The update expression changes the loop variable after each iteration.

Example:

```java
i++;
```

### Example 1: Print Numbers from 1 to 10

```java
public class ForLoop {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            System.out.println(i);

        }
    }
}
```

**Output:**

```text
1
2
3
4
5
6
7
8
9
10
```

### Step-by-Step Execution

| Iteration | i | Condition (i <= 10) | Output |
|---|---:|---|---|
| 1 | 1 | true | 1 |
| 2 | 2 | true | 2 |
| 3 | 3 | true | 3 |
| 4 | 4 | true | 4 |
| 5 | 5 | true | 5 |
| 6 | 6 | true | 6 |
| 7 | 7 | true | 7 |
| 8 | 8 | true | 8 |
| 9 | 9 | true | 9 |
| 10 | 10 | true | 10 |
| Next | 11 | false | Loop stops |

### Example 2: Print Even Numbers from 1 to 20

```java
public class EvenNumbers {

    public static void main(String[] args) {

        for (int i = 2; i <= 20; i += 2) {

            System.out.println(i);

        }
    }
}
```

**Output:**

```text
2
4
6
8
10
12
14
16
18
20
```

### Example 3: Sum of First 10 Natural Numbers

```java
public class SumNumbers {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i <= 10; i++) {

            sum = sum + i;

        }

        System.out.println("Sum: " + sum);
    }
}
```

**Output:**

```text
Sum: 55
```

### Explanation

The loop adds each number to the sum variable.

```text
sum = 0 + 1
sum = 1 + 2
sum = 3 + 3
sum = 6 + 4
...
sum = 45 + 10
sum = 55
```

### Example 4: Multiplication Table

```java
public class MultiplicationTable {

    public static void main(String[] args) {

        int number = 5;

        for (int i = 1; i <= 10; i++) {

            System.out.println(number + " x " + i
                    + " = " + (number * i));

        }
    }
}
```

**Output:**

```text
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
```

---

## 4.10 while Loop

The while loop executes a block of code repeatedly as long as the specified condition is true.

Unlike the for loop, initialization and updating are generally written separately.

The while loop is useful when we do not know exactly how many times a task needs to be repeated.

### Syntax

```java
initialization;

while (condition) {

    // Statements

    update;
}
```

### Example 1: Print Numbers from 1 to 10

```java
public class WhileLoop {

    public static void main(String[] args) {

        int i = 1;

        while (i <= 10) {

            System.out.println(i);

            i++;

        }
    }
}
```

**Output:**

```text
1
2
3
4
5
6
7
8
9
10
```

### Explanation

1. Initially, `i = 1`.
2. Java checks whether `i <= 10`.
3. If true, it prints the value of i.
4. The increment statement increases i by 1.
5. The condition is checked again.
6. When i becomes 11, the condition becomes false.
7. The loop terminates.

### Example 2: Reverse Counting

```java
public class ReverseCounting {

    public static void main(String[] args) {

        int i = 10;

        while (i >= 1) {

            System.out.println(i);

            i--;

        }
    }
}
```

**Output:**

```text
10
9
8
7
6
5
4
3
2
1
```

### Example 3: Sum of Digits of a Number

Suppose the number is 1234.

We want to calculate:

```text
1 + 2 + 3 + 4 = 10
```

We can use the modulus and division operators.

```java
public class SumOfDigits {

    public static void main(String[] args) {

        int number = 1234;

        int sum = 0;

        while (number > 0) {

            int digit = number % 10;

            sum = sum + digit;

            number = number / 10;

        }

        System.out.println("Sum of Digits: " + sum);
    }
}
```

**Output:**

```text
Sum of Digits: 10
```

### Explanation

For every iteration:

- `number % 10` extracts the last digit.
- `sum + digit` adds that digit.
- `number / 10` removes the last digit.

| Number | Extracted Digit | Sum |
|---|---:|---:|
| 1234 | 4 | 4 |
| 123 | 3 | 7 |
| 12 | 2 | 9 |
| 1 | 1 | 10 |

This technique is frequently used in programming problems.

---

## 4.11 do-while Loop

The do-while loop is similar to the while loop, but there is one important difference.

In a do-while loop, the code executes at least once, even if the condition is false.

Why?

Because Java checks the condition after executing the loop body.

### Syntax

```java
do {

    // Statements

} while (condition);
```

Notice the semicolon after the while condition.

### Example 1: Print Numbers from 1 to 5

```java
public class DoWhileLoop {

    public static void main(String[] args) {

        int i = 1;

        do {

            System.out.println(i);

            i++;

        } while (i <= 5);
    }
}
```

**Output:**

```text
1
2
3
4
5
```

### Example 2: Condition Is False

This example explains the most important difference between while and do-while.

```java
public class DoWhileExample {

    public static void main(String[] args) {

        int i = 10;

        do {

            System.out.println("Hello Java");

            i++;

        } while (i < 5);
    }
}
```

**Output:**

```text
Hello Java
```

Why?

Even though `i < 5` is false, Java executes the do block once before checking the condition.

### Example 3: Menu-Driven Program

A menu-driven program allows users to select different operations.

```java
import java.util.Scanner;

public class MenuDrivenProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n----- MENU -----");
            System.out.println("1. Say Hello");
            System.out.println("2. Say Welcome");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Hello!");
                    break;

                case 2:
                    System.out.println("Welcome to Java!");
                    break;

                case 3:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while (choice != 3);

        sc.close();
    }
}
```

**Sample Output:**

```text
----- MENU -----
1. Say Hello
2. Say Welcome
3. Exit
Enter your choice: 1

Hello!

----- MENU -----
1. Say Hello
2. Say Welcome
3. Exit
Enter your choice: 3

Thank you!
```

This is a common real-world use of the do-while loop.

---

## 4.12 Difference Between for, while, and do-while Loops

Although all three loops perform repetition, their execution styles are different.

| Feature | for | while | do-while |
|---|---|---|---|
| Condition checked | Before execution | Before execution | After execution |
| Minimum execution | Zero times | Zero times | One time |
| Initialization | Usually in loop header | Usually outside | Usually outside |
| Update | Usually in loop header | Usually inside body | Usually inside body |
| Best suited for | Known iterations | Condition-based repetition | At least one execution |

### Example: Same Task Using Three Loops

**Using for loop:**

```java
for (int i = 1; i <= 5; i++) {

    System.out.println(i);

}
```

**Using while loop:**

```java
int i = 1;

while (i <= 5) {

    System.out.println(i);

    i++;

}
```

**Using do-while loop:**

```java
int i = 1;

do {

    System.out.println(i);

    i++;

} while (i <= 5);
```

All three produce:

```text
1
2
3
4
5
```

---

## 4.13 Nested Loops in Java

A nested loop means placing one loop inside another loop.

Nested loops are useful when working with rows and columns, matrices, tables, and pattern printing.

For example, imagine printing five rows of stars, with each row containing five stars.

We can use nested loops.

### Syntax

```java
for (initialization; condition; update) {

    for (initialization; condition; update) {

        // Inner loop statements

    }

}
```

### Example 1: Print a 5 × 5 Star Pattern

```java
public class NestedLoop {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5; j++) {

                System.out.print("* ");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
```

### Explanation

The outer loop controls the number of rows.

The inner loop controls the number of columns.

For each iteration of the outer loop, the inner loop executes completely.

For a 5 × 5 pattern:

- Outer loop executes 5 times.
- Inner loop executes 5 times for each outer iteration.
- Total inner loop executions = 5 × 5 = 25.

### Example 2: Print a Right-Angled Triangle

```java
public class RightTriangle {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print("* ");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
*
* *
* * *
* * * *
* * * * *
```

### Example 3: Print Number Triangle

```java
public class NumberTriangle {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

### Example 4: Multiplication Table from 1 to 5

```java
public class MultiplicationTables {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 10; j++) {

                System.out.print(i * j + "\t");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
1   2   3   4   5   6   7   8   9   10
2   4   6   8   10  12  14  16  18  20
3   6   9   12  15  18  21  24  27  30
4   8   12  16  20  24  28  32  36  40
5   10  15  20  25  30  35  40  45  50
```

---

## 4.14 Enhanced for Loop (for-each Loop)

The enhanced for loop is also called the for-each loop.

It is used to iterate through arrays and objects that implement the Iterable interface.

Instead of manually managing an index, the enhanced for loop directly accesses each element.

### Syntax

```java
for (dataType variable : collection) {

    // Statements

}
```

### Example 1: Print Array Elements

```java
public class EnhancedForLoop {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        for (int number : numbers) {

            System.out.println(number);

        }
    }
}
```

**Output:**

```text
10
20
30
40
50
```

### Explanation

- `numbers` is an integer array.
- `number` receives each element one by one.
- The loop executes once for every array element.

### Example 2: Calculate Sum of Array Elements

```java
public class ArraySum {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int sum = 0;

        for (int number : numbers) {

            sum += number;

        }

        System.out.println("Sum: " + sum);
    }
}
```

**Output:**

```text
Sum: 150
```

### Example 3: Iterate Through a String Array

```java
public class StudentNames {

    public static void main(String[] args) {

        String[] students = {
            "Ayush",
            "Rahul",
            "Amit",
            "Priya"
        };

        for (String name : students) {

            System.out.println("Student: " + name);

        }
    }
}
```

**Output:**

```text
Student: Ayush
Student: Rahul
Student: Amit
Student: Priya
```

### Difference Between for and Enhanced for Loop

| for loop | Enhanced for loop |
|---|---|
| Uses an index or counter | Uses an element variable |
| Can move forward or backward | Naturally iterates in traversal order |
| Useful when index is needed | Useful when only elements are needed |
| Can update array elements using indexes | Does not directly provide an index |
| More control over iteration | Simpler syntax |

Important: Assigning a new value to the enhanced for loop variable does not replace the original array element. To modify array elements, use an indexed loop.

---

# 4.15 Jump Statements in Java

Jump statements change the normal execution flow of a program.

Java provides three important jump statements:

1. break
2. continue
3. return

Let's understand each one.

## 4.16 break Statement

The break statement is used to terminate a loop or switch statement immediately.

When Java encounters break, execution moves to the first statement after the loop or switch.

### Example 1: Stop a Loop at 5

```java
public class BreakExample {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            if (i == 6) {

                break;

            }

            System.out.println(i);

        }
    }
}
```

**Output:**

```text
1
2
3
4
5
```

### Explanation

The loop starts from 1.

When i becomes 6, the condition becomes true and break terminates the loop.

### Example 2: Search for a Number in an Array

```java
public class SearchNumber {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int search = 30;

        for (int number : numbers) {

            if (number == search) {

                System.out.println("Number Found!");

                break;

            }
        }
    }
}
```

**Output:**

```text
Number Found!
```

The loop stops once the required number is found.

### Labeled break

Java also supports labeled break statements.

They allow us to terminate an outer loop from inside a nested loop.

Example:

```java
public class LabeledBreak {

    public static void main(String[] args) {

        outer:
        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {

                if (i == 2 && j == 2) {

                    break outer;

                }

                System.out.println(i + " " + j);

            }
        }
    }
}
```

**Output:**

```text
1 1
1 2
1 3
2 1
```

When the condition becomes true, the outer loop is also terminated.

---

## 4.17 continue Statement

The continue statement skips the remaining statements in the current loop iteration and moves to the next iteration.

Unlike break, continue does not terminate the entire loop.

### Example 1: Skip Number 5

```java
public class ContinueExample {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            if (i == 5) {

                continue;

            }

            System.out.println(i);

        }
    }
}
```

**Output:**

```text
1
2
3
4
6
7
8
9
10
```

### Explanation

When i becomes 5, the continue statement skips the print statement for that iteration.

The loop then continues with 6.

### Example 2: Print Only Odd Numbers

```java
public class OddNumbers {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            if (i % 2 == 0) {

                continue;

            }

            System.out.println(i);

        }
    }
}
```

**Output:**

```text
1
3
5
7
9
```

### Labeled continue

A labeled continue skips the remaining statements in a specified outer loop iteration and proceeds to its next iteration.

Example:

```java
public class LabeledContinue {

    public static void main(String[] args) {

        outer:
        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {

                if (j == 2) {

                    continue outer;

                }

                System.out.println(i + " " + j);

            }
        }
    }
}
```

**Output:**

```text
1 1
2 1
3 1
```

---

## 4.18 return Statement

The return statement is used to exit a method.

It can also return a value from a method to the place where that method was called.

We will study methods in detail in the next chapter, but understanding return is important here.

### Example 1: Return from a void Method

```java
public class ReturnExample {

    public static void display() {

        System.out.println("Java Programming");

        return;

    }

    public static void main(String[] args) {

        display();

        System.out.println("Program Completed");

    }
}
```

**Output:**

```text
Java Programming
Program Completed
```

### Example 2: Return a Value from a Method

```java
public class ReturnValue {

    public static int add(int a, int b) {

        return a + b;

    }

    public static void main(String[] args) {

        int result = add(10, 20);

        System.out.println("Sum: " + result);

    }
}
```

**Output:**

```text
Sum: 30
```

### Example 3: Stop Method Execution

```java
public class ReturnControl {

    public static void checkAge(int age) {

        if (age < 18) {

            System.out.println("Not Eligible");

            return;

        }

        System.out.println("Eligible");

    }

    public static void main(String[] args) {

        checkAge(16);

        checkAge(22);

    }
}
```

**Output:**

```text
Not Eligible
Eligible
```

### Difference Between break, continue, and return

| Statement | Purpose |
|---|---|
| break | Terminates the nearest enclosing loop or switch, or a labeled enclosing statement |
| continue | Skips the current iteration of a loop |
| return | Exits the current method, optionally returning a value |

Remember:

- break = Stop the loop.
- continue = Skip the current iteration.
- return = Exit the method.

---

# 4.19 Practical Java Programs

Now let's combine the concepts we have learned and solve practical programming problems.

These programs are useful for college examinations, coding practice, and Java interviews.

## Program 1: Print Numbers from 1 to 100

```java
public class PrintNumbers {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {

            System.out.print(i + " ");

        }
    }
}
```

## Program 2: Print Even Numbers from 1 to 100

```java
public class PrintEvenNumbers {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {

            if (i % 2 == 0) {

                System.out.print(i + " ");

            }
        }
    }
}
```

## Program 3: Find Factorial of a Number

Factorial means multiplying a positive integer by all positive integers smaller than it down to 1.

For example:

```text
5! = 5 × 4 × 3 × 2 × 1

5! = 120
```

Java Program:

```java
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int number = sc.nextInt();

        if (number < 0) {

            System.out.println("Factorial is not defined for negative integers.");

        } else {

            long factorial = 1;

            for (int i = 1; i <= number; i++) {

                factorial *= i;

            }

            System.out.println("Factorial: " + factorial);
        }

        sc.close();
    }
}
```

**Sample Input:**

```text
5
```

**Output:**

```text
Factorial: 120
```

Note: The long data type can store factorials only up to a limited input size. For larger values, use BigInteger.

## Program 4: Reverse a Number

```java
import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int number = sc.nextInt();

        int reverse = 0;

        while (number != 0) {

            int digit = number % 10;

            reverse = reverse * 10 + digit;

            number = number / 10;

        }

        System.out.println("Reverse: " + reverse);

        sc.close();
    }
}
```

**Input:**

```text
1234
```

**Output:**

```text
Reverse: 4321
```

## Program 5: Check Palindrome Number

A palindrome number reads the same forward and backward.

Examples:

- 121
- 1331
- 12321

```java
import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int number = sc.nextInt();

        int original = number;

        int reverse = 0;

        if (number < 0) {

            System.out.println("Not a Palindrome");

        } else {

            while (number > 0) {

                int digit = number % 10;

                reverse = reverse * 10 + digit;

                number /= 10;

            }

            if (original == reverse) {

                System.out.println("Palindrome Number");

            } else {

                System.out.println("Not a Palindrome");

            }
        }

        sc.close();
    }
}
```

**Input:**

```text
121
```

**Output:**

```text
Palindrome Number
```

## Program 6: Check Prime Number

A prime number is a natural number greater than 1 that has exactly two positive divisors: 1 and itself.

Examples:

2, 3, 5, 7, 11, 13.

```java
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int number = sc.nextInt();

        boolean isPrime = number > 1;

        for (int i = 2; isPrime && i <= number / i; i++) {

            if (number % i == 0) {

                isPrime = false;

            }
        }

        if (isPrime) {

            System.out.println("Prime Number");

        } else {

            System.out.println("Not a Prime Number");

        }

        sc.close();
    }
}
```

**Input:**

```text
17
```

**Output:**

```text
Prime Number
```

Why do we check only up to the square root of the number?

If a number has a divisor greater than its square root, it must also have a corresponding divisor smaller than its square root.

Therefore, checking all numbers up to the square root is sufficient.

## Program 7: Fibonacci Series

The Fibonacci series is a sequence in which each number is the sum of the previous two numbers.

Example:

```text
0 1 1 2 3 5 8 13 21 34
```

```java
import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");

        int n = sc.nextInt();

        long first = 0;
        long second = 1;

        if (n <= 0) {

            System.out.println("Enter a positive number.");

        } else {

            for (int i = 1; i <= n; i++) {

                System.out.print(first + " ");

                long next = first + second;

                first = second;

                second = next;

            }
        }

        sc.close();
    }
}
```

**Input:**

```text
10
```

**Output:**

```text
0 1 1 2 3 5 8 13 21 34
```

Note: The long data type eventually overflows for large Fibonacci terms.

## Program 8: Armstrong Number

An Armstrong number is a number equal to the sum of its digits, each raised to the power of the total number of digits.

Example:

```text
153

1³ + 5³ + 3³

1 + 125 + 27 = 153
```

Java Program:

```java
import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int number = sc.nextInt();

        if (number < 0) {

            System.out.println("Not an Armstrong Number");

        } else {

            int original = number;

            int temp = number;

            int digits = 0;

            do {

                digits++;

                temp /= 10;

            } while (temp != 0);

            temp = number;

            int sum = 0;

            do {

                int digit = temp % 10;

                sum += (int) Math.pow(digit, digits);

                temp /= 10;

            } while (temp != 0);

            if (sum == original) {

                System.out.println("Armstrong Number");

            } else {

                System.out.println("Not an Armstrong Number");

            }
        }

        sc.close();
    }
}
```

**Input:**

```text
153
```

**Output:**

```text
Armstrong Number
```

Note: This example uses `Math.pow()`, which returns a double. For general integer arithmetic, be aware that floating-point calculations can introduce precision issues for sufficiently large values.

## Program 9: Find the Greatest Common Divisor (GCD)

GCD is the greatest positive integer that divides two numbers without leaving a remainder.

Example:

```text
12 and 18

Factors of 12: 1, 2, 3, 4, 6, 12

Factors of 18: 1, 2, 3, 6, 9, 18

GCD = 6
```

Java Program:

```java
import java.util.Scanner;

public class GCD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        int x = a;
        int y = b;

        while (y != 0) {

            int remainder = x % y;

            x = y;

            y = remainder;

        }

        System.out.println("GCD: " + x);

        sc.close();
    }
}
```

**Input:**

```text
12
18
```

**Output:**

```text
GCD: 6
```

This program uses the Euclidean algorithm.

## Program 10: Count the Digits of a Number

```java
import java.util.Scanner;

public class CountDigits {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        long number = sc.nextLong();

        long temp = Math.abs(number);

        int count = 0;

        do {

            count++;

            temp /= 10;

        } while (temp != 0);

        System.out.println("Number of Digits: " + count);

        sc.close();
    }
}
```

**Input:**

```text
12345
```

**Output:**

```text
Number of Digits: 5
```

---

# 4.20 Pattern Programming in Java

Pattern programming is one of the best ways to understand nested loops.

It helps improve logical thinking and teaches us how to control rows, columns, spaces, and repeated characters.

Let's practice some common patterns.

## Pattern 1: Square Star Pattern

```java
public class SquarePattern {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5; j++) {

                System.out.print("* ");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
```

## Pattern 2: Right-Angled Triangle

```java
public class TrianglePattern {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print("* ");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
*
* *
* * *
* * * *
* * * * *
```

## Pattern 3: Inverted Right-Angled Triangle

```java
public class InvertedTriangle {

    public static void main(String[] args) {

        for (int i = 5; i >= 1; i--) {

            for (int j = 1; j <= i; j++) {

                System.out.print("* ");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
* * * * *
* * * *
* * *
* *
*
```

## Pattern 4: Pyramid Pattern

```java
public class PyramidPattern {

    public static void main(String[] args) {

        int n = 5;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {

                System.out.print(" ");

            }

            for (int j = 1; j <= (2 * i - 1); j++) {

                System.out.print("*");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
    *
   ***
  *****
 *******
*********
```

## Pattern 5: Number Triangle

```java
public class NumberPattern {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

## Pattern 6: Floyd's Triangle

```java
public class FloydTriangle {

    public static void main(String[] args) {

        int number = 1;

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(number + " ");

                number++;

            }

            System.out.println();

        }
    }
}
```

**Output:**

```text
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
```

---

# 4.21 Common Beginner Mistakes in Java

When working with conditions and loops, beginners often make mistakes that result in incorrect output or infinite loops.

Let's understand some common problems.

### Mistake 1: Using = Instead of ==

Incorrect:

```java
int number = 10;

if (number = 10) {

    System.out.println("Equal");

}
```

This causes a compilation error because assignment does not produce a boolean condition.

Correct:

```java
int number = 10;

if (number == 10) {

    System.out.println("Equal");

}
```

### Mistake 2: Forgetting to Update the Loop Variable

Incorrect:

```java
int i = 1;

while (i <= 5) {

    System.out.println(i);

}
```

This creates an infinite loop because `i` never changes.

Correct:

```java
int i = 1;

while (i <= 5) {

    System.out.println(i);

    i++;

}
```

### Mistake 3: Using a Semicolon After a Loop

Incorrect:

```java
for (int i = 1; i <= 5; i++);

{

    System.out.println("Hello Java");

}
```

The semicolon terminates the loop immediately. The following block is separate and executes once.

Correct:

```java
for (int i = 1; i <= 5; i++) {

    System.out.println("Hello Java");

}
```

### Mistake 4: Forgetting break in switch

Without break, execution may continue into subsequent cases.

Always use break when you want to terminate the matched case rather than intentionally allowing fall-through.

### Mistake 5: Incorrect Loop Condition

Incorrect:

```java
for (int i = 1; i < 10; i++) {

    System.out.println(i);

}
```

This prints only 1 to 9.

Correct when you want to print 1 to 10:

```java
for (int i = 1; i <= 10; i++) {

    System.out.println(i);

}
```

### Mistake 6: Confusing break and continue

- break terminates the loop.
- continue skips the current iteration.

These two statements are not interchangeable.

### Mistake 7: Incorrect Nested Loop Condition

Always understand which loop controls rows and which controls columns.

For a triangle pattern, the inner loop commonly depends on the outer loop variable.

### Mistake 8: Using == to Compare Strings

Incorrect:

```java
String name = "Java";

if (name == "Java") {
    System.out.println("Matched");
}
```

This may work in some situations because of String interning, but it is not the correct way to compare String contents generally.

Correct:

```java
String name = "Java";

if (name.equals("Java")) {
    System.out.println("Matched");
}
```

---

# 4.22 Java Interview Questions and Answers

Here are important Java interview questions related to control flow statements and loops.

### Q1. What are control flow statements in Java?

**Answer:** Control flow statements control the order of execution of instructions in a Java program. They include decision-making statements, looping statements, and jump statements.

### Q2. What are the types of control flow statements?

**Answer:**

1. Decision-making: if, if-else, else-if, switch.
2. Looping: for, while, do-while, enhanced for.
3. Jump: break, continue, return.

### Q3. What is the difference between if and if-else?

**Answer:** The if statement executes a block only when its condition is true. The if-else statement provides two execution paths depending on whether the condition is true or false.

### Q4. What is an else-if ladder?

**Answer:** An else-if ladder is used to check multiple conditions in sequence. The first matching condition executes, and the remaining conditions are skipped.

### Q5. What is a nested if statement?

**Answer:** A nested if statement is an if statement placed inside another if statement. It is used when one decision depends on another condition.

### Q6. What is a switch statement?

**Answer:** A switch statement selects one execution path from multiple alternatives by matching an expression against case labels.

### Q7. What is the difference between if-else and switch?

**Answer:**

- if-else can handle ranges, complex conditions, and multiple boolean expressions.
- switch is useful for selecting among multiple discrete values.

### Q8. What happens if break is not used in a switch?

**Answer:** Java may continue executing the following case statements. This behaviour is called fall-through.

### Q9. Does Java 8 support String in switch?

**Answer:** Yes. Java supports String-based switch statements from Java 7 onwards.

### Q10. How many types of loops are available in Java?

**Answer:** Java has three traditional loop statements: for, while, and do-while. It also provides the enhanced for loop for arrays and Iterable collections.

### Q11. What is the difference between for and while?

**Answer:** A for loop is convenient when the iteration structure is known. A while loop is useful when repetition depends on a condition and the number of iterations may not be known beforehand.

### Q12. What is the difference between while and do-while?

**Answer:** A while loop checks the condition before executing the loop body. A do-while loop checks the condition after executing the body, so it executes at least once.

### Q13. What is an infinite loop?

**Answer:** An infinite loop is a loop that continues indefinitely because its termination condition never becomes false or because it has no terminating condition.

Example:

```java
while (true) {

    System.out.println("Running");

}
```

### Q14. What is a nested loop?

**Answer:** A nested loop is a loop placed inside another loop. It is commonly used for patterns, matrices, and multidimensional data.

### Q15. What is an enhanced for loop?

**Answer:** An enhanced for loop is a simplified way to iterate over arrays and objects implementing Iterable. It eliminates the need to manage an index manually.

### Q16. What is the difference between break and continue?

**Answer:**

- break terminates the loop or switch.
- continue skips the current loop iteration and proceeds to the next iteration.

### Q17. What is the return statement?

**Answer:** The return statement terminates the current method and optionally sends a value back to the calling method.

### Q18. Can we use break inside an if statement?

**Answer:** A break statement can appear inside an if statement when that if statement is contained within an enclosing loop or switch. It terminates the enclosing loop or switch, not the if statement itself.

### Q19. Can a for loop run without initialization?

**Answer:** Yes. The initialization section is optional.

Example:

```java
int i = 1;

for (; i <= 5; i++) {

    System.out.println(i);

}
```

### Q20. Can we write a for loop without a condition?

**Answer:** Yes. If the condition is omitted, it is treated as always true, unless the loop is terminated using a break or another control-flow mechanism.

Example:

```java
for (;;) {

    System.out.println("Infinite Loop");

    break;

}
```

### Q21. Can we use a loop inside another loop?

**Answer:** Yes. This is called a nested loop.

### Q22. Which loop executes at least once?

**Answer:** The do-while loop executes at least once because its condition is checked after the loop body.

### Q23. Can we use continue inside a switch statement?

**Answer:** A continue statement cannot target a switch by itself. It can be used in a switch nested inside a loop, where it applies to the enclosing loop.

### Q24. What is fall-through in Java switch?

**Answer:** Fall-through occurs when execution continues from one matching case into subsequent case bodies because a break or another control-flow statement is missing.

### Q25. Which loop is best for iterating through an array?

**Answer:** The enhanced for loop is convenient when we only need to access array elements. A traditional for loop is better when we need indexes or want to modify elements by position.

---

# 4.23 Practice Exercises

Now it's time to test your understanding.

Try solving these problems without looking at the solutions first.

### Beginner Level

1. Write a Java program to check whether a number is positive or negative.
2. Write a program to check whether a number is even or odd.
3. Write a program to find the largest of two numbers.
4. Write a program to find the largest of three numbers.
5. Write a program to check whether a person is eligible to vote.
6. Write a program to check whether a year is a leap year.
7. Print numbers from 1 to 100.
8. Print all even numbers between 1 and 100.
9. Print all odd numbers between 1 and 100.
10. Print the multiplication table of any number.

### Intermediate Level

11. Calculate the factorial of a number.
12. Reverse a given number.
13. Find the sum of digits of a number.
14. Count the number of digits.
15. Check whether a number is a palindrome.
16. Check whether a number is prime.
17. Print all prime numbers between 1 and 100.
18. Generate the Fibonacci series.
19. Check whether a number is an Armstrong number.
20. Find the GCD of two numbers.
21. Find the LCM of two numbers.
22. Check whether a number is divisible by both 5 and 11.
23. Calculate the sum of the first N natural numbers.
24. Calculate the power of a number without using Math.pow().
25. Find the reverse of a String using a loop.

### Pattern Programming

26. Print a square star pattern.
27. Print a right-angled triangle.
28. Print an inverted triangle.
29. Print a pyramid pattern.
30. Print a number triangle.
31. Print Floyd's triangle.
32. Print a diamond pattern.
33. Print a hollow square pattern.
34. Print a multiplication table from 1 to 10.

### Real-World Programming

35. Create a simple calculator using switch.
36. Create a student grading system.
37. Create an electricity bill calculator.
38. Create a shopping discount calculator.
39. Create a menu-driven program using do-while.
40. Create a simple ATM menu with balance inquiry, deposit, and withdrawal operations.

---

# 4.24 Practice Exercise Solutions

Here are solutions to selected exercises. Try solving each problem independently before checking the code.

Practice the concepts with the [Java Control Flow Practice Programs](Practice-Programs/README.md).

This is a learning example, not a real banking implementation. Real financial applications require secure authentication, transaction validation, persistent storage, and concurrency controls.

---

# 4.25 Key Takeaways

Let's quickly revise the important concepts from this chapter.

| Topic | What We Learned |
|---|---|
| Control Flow | Controls program execution |
| if | Executes code when a condition is true |
| if-else | Provides two execution paths |
| else-if | Checks multiple conditions |
| Nested if | Places one if inside another |
| switch | Selects among multiple cases |
| for | Repeats code using a loop counter |
| while | Repeats while a condition is true |
| do-while | Executes at least once |
| Nested Loops | Places one loop inside another |
| Enhanced for | Iterates through arrays and Iterable collections |
| break | Terminates a loop or switch |
| continue | Skips the current loop iteration |
| return | Exits a method |
| Pattern Programming | Uses nested loops to print patterns |

### Important Points to Remember

1. Java executes statements sequentially unless control flow changes the order.
2. Conditions used in Java if and loop statements must evaluate to boolean values.
3. The else-if ladder checks conditions from top to bottom.
4. Switch supports String and enum values in Java 8.
5. A missing break in a traditional switch may cause fall-through.
6. A for loop is useful when the iteration structure is known.
7. A while loop is useful for condition-based repetition.
8. A do-while loop always executes at least once.
9. Nested loops are useful for patterns and matrices.
10. Enhanced for loops simplify array and collection traversal.
11. break terminates the targeted loop or switch.
12. continue skips the current iteration.
13. return exits the current method.

---

# What's Next?

## Chapter 5: Java Methods and Constructors

In the next chapter, we will learn how to divide large programs into smaller, reusable blocks of code.

Topics we will cover:

- Introduction to Methods in Java
- What is a Method?
- Method Declaration and Definition
- Method Calling
- Types of Methods
- Static Methods
- Instance Methods
- Parameterized and Non-Parameterized Methods
- Return Types and void Methods
- Method Parameters and Arguments
- Method Overloading
- Constructor in Java
- Default and Parameterized Constructors
- Constructor Overloading
- `this` Keyword
- Constructor vs Method
- Pass by Value in Java
- Recursion
- Practical Java Programs
- Java Interview Questions and Answers
- Practice Exercises with Solutions

**Remember:** Don't just memorize syntax. Understand why a particular statement is used, write the code yourself, and experiment with different inputs.

**Happy Learning, Keep Practicing, and Keep Coding!**