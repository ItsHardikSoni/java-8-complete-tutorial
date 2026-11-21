---
title: "Java 8 Features Tutorial | Lambda, Streams and Interview Questions"
description: "Learn Java 8 features with examples, practice exercises, and concise interview answers."
---

# Chapter 11: Java 8 Features

**Navigation:** [Main Tutorial Index](../README.md) | [Practice Programs](Practice-Programs/) | [Previous: Collections](../10-Java-Collections-Framework/README.md) | [Next: Multithreading](../12-Java-Multithreading/README.md)

## 1. Introduction to Java 8

Java 8 was released in March 2014. It introduced several important features that changed how developers write Java applications.

Before Java 8, developers commonly used anonymous inner classes and traditional loops to perform operations.

Java 8 introduced functional programming capabilities that allow developers to write cleaner and more expressive code.

### Major Features of Java 8

1. Lambda Expressions
2. Functional Interfaces
3. Built-in Functional Interfaces
4. Method References
5. Stream API
6. Optional Class
7. Default Methods in Interfaces
8. Static Methods in Interfaces
9. New Date and Time API
10. forEach() Method
11. Collectors
12. Parallel Streams

### Why Java 8?

Consider the following example.

**Before Java 8:**

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Ayush", "Rahul", "Amit"
        );

        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

**Using Java 8:**

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Ayush", "Rahul", "Amit"
        );

        names.forEach(name -> System.out.println(name));
    }
}
```

Both programs produce:

```text
Ayush
Rahul
Amit
```

The Java 8 version uses a Lambda Expression to make the code more concise.

---

## 2. Lambda Expressions

A Lambda Expression is a short way to represent an anonymous function.

It allows us to pass behavior as an argument to a method.

Lambda Expressions are mainly used with Functional Interfaces.

### Syntax

```java
(parameters) -> expression
```

Or:

```java
(parameters) -> {
    // Multiple statements
};
```

### Examples

**No parameters:**

```java
() -> System.out.println("Hello Java 8");
```

**One parameter:**

```java
name -> System.out.println(name);
```

**Multiple parameters:**

```java
(a, b) -> a + b;
```

### 2.1 Lambda Expression Without Parameters

```java
public class Main {
    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("Java 8 Lambda Expression");
        };

        task.run();
    }
}
```

**Output:**

```text
Java 8 Lambda Expression
```

### 2.2 Lambda Expression With One Parameter

```java
interface Greeting {
    void sayHello(String name);
}

public class Main {
    public static void main(String[] args) {

        Greeting greeting =
                name -> System.out.println("Hello " + name);

        greeting.sayHello("Ayush");
    }
}
```

**Output:**

```text
Hello Ayush
```

### 2.3 Lambda Expression With Multiple Parameters

```java
interface Calculator {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {

        Calculator calculator = (a, b) -> a + b;

        System.out.println(calculator.add(10, 20));
    }
}
```

**Output:**

```text
30
```

### 2.4 Lambda Expression With Multiple Statements

```java
interface Calculator {
    int calculate(int a, int b);
}

public class Main {
    public static void main(String[] args) {

        Calculator calculator = (a, b) -> {

            int sum = a + b;

            System.out.println("Calculating...");

            return sum;
        };

        System.out.println("Result: " +
                calculator.calculate(10, 20));
    }
}
```

**Output:**

```text
Calculating...
Result: 30
```

### Advantages of Lambda Expressions

1. Reduces boilerplate code.
2. Improves readability.
3. Supports functional programming.
4. Makes collection processing easier.
5. Works naturally with Stream API.
6. Reduces the need for anonymous inner classes in many situations.

---

## 3. Functional Interfaces

A Functional Interface is an interface that contains exactly one abstract method.

It is also known as a Single Abstract Method (SAM) interface.

Functional Interfaces can contain:
- One abstract method.
- Multiple default methods.
- Multiple static methods.
- Methods inherited from Object do not count as additional abstract methods for this purpose.

### Syntax

```java
@FunctionalInterface
interface MyInterface {
    void display();
}
```

The `@FunctionalInterface` annotation is optional, but recommended because the compiler checks that the interface follows the functional-interface rules.

### Example

```java
@FunctionalInterface
interface Message {
    void showMessage();
}

public class Main {
    public static void main(String[] args) {

        Message message = () ->
                System.out.println("Welcome to Java 8");

        message.showMessage();
    }
}
```

**Output:**

```text
Welcome to Java 8
```

### Functional Interface Without Lambda

```java
@FunctionalInterface
interface Message {
    void display();
}

public class Main {
    public static void main(String[] args) {

        Message message = new Message() {

            public void display() {
                System.out.println("Traditional Implementation");
            }
        };

        message.display();
    }
}
```

### Functional Interface With Lambda

```java
@FunctionalInterface
interface Message {
    void display();
}

public class Main {
    public static void main(String[] args) {

        Message message =
                () -> System.out.println("Lambda Implementation");

        message.display();
    }
}
```

**Output:**

```text
Lambda Implementation
```

### Common Built-in Functional Interfaces

Java 8 provides several built-in Functional Interfaces in the `java.util.function` package.

| Interface | Abstract Method | Purpose |
|---|---|---|
| Predicate<T> | test() | Tests a condition |
| Function<T,R> | apply() | Converts one value into another |
| Consumer<T> | accept() | Consumes a value |
| Supplier<T> | get() | Supplies a value |
| UnaryOperator<T> | apply() | Takes and returns the same type |
| BinaryOperator<T> | apply() | Takes two values of the same type and returns that type |

---

## 4. Predicate Functional Interface

Predicate is a Functional Interface used to test a condition.

It accepts one argument and returns a boolean value.

### Syntax

```java
Predicate<T>
```

Abstract method:

```java
boolean test(T value);
```

### Example: Check Even Number

```java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> isEven =
                number -> number % 2 == 0;

        System.out.println(isEven.test(10));
        System.out.println(isEven.test(15));
    }
}
```

**Output:**

```text
true
false
```

### Example: Check String Length

```java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<String> checkLength =
                name -> name.length() > 5;

        System.out.println(checkLength.test("Ayush"));
        System.out.println(checkLength.test("RahulSharma"));
    }
}
```

**Output:**

```text
false
true
```

### Combining Predicates

Predicate provides useful methods:

- `and()`
- `or()`
- `negate()`

```java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> greaterThanTen =
                number -> number > 10;

        Predicate<Integer> even =
                number -> number % 2 == 0;

        Predicate<Integer> result =
                greaterThanTen.and(even);

        System.out.println(result.test(20));
        System.out.println(result.test(15));
    }
}
```

**Output:**

```text
true
false
```

---

## 5. Function Functional Interface

Function is used to transform one value into another.

It accepts one input and returns one output.

### Syntax

```java
Function<T, R>
```

Abstract method:

```java
R apply(T value);
```

### Example: Convert String to Uppercase

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<String, String> convert =
                name -> name.toUpperCase();

        System.out.println(convert.apply("ayush"));
    }
}
```

**Output:**

```text
AYUSH
```

### Example: Find Square of a Number

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> square =
                number -> number * number;

        System.out.println(square.apply(5));
    }
}
```

**Output:**

```text
25
```

### Function Chaining

Function provides `andThen()` and `compose()`.

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> multiply =
                number -> number * 2;

        Function<Integer, Integer> add =
                number -> number + 10;

        Function<Integer, Integer> result =
                multiply.andThen(add);

        System.out.println(result.apply(5));
    }
}
```

**Output:**

```text
20
```

Explanation:

1. Input = 5.
2. Multiply by 2 = 10.
3. Add 10 = 20.

`andThen()` executes the current Function first and the next Function afterward.

`compose()` executes the supplied Function first and the current Function afterward.

---

## 6. Consumer Functional Interface

Consumer accepts an argument but does not return a result.

### Syntax

```java
Consumer<T>
```

Abstract method:

```java
void accept(T value);
```

### Example

```java
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Consumer<String> print =
                name -> System.out.println("Hello " + name);

        print.accept("Ayush");
    }
}
```

**Output:**

```text
Hello Ayush
```

### Consumer With ArrayList

```java
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Ayush");
        names.add("Rahul");
        names.add("Amit");

        Consumer<String> display =
                name -> System.out.println(name);

        names.forEach(display);
    }
}
```

**Output:**

```text
Ayush
Rahul
Amit
```

---

## 7. Supplier Functional Interface

Supplier does not accept an argument but returns a value.

### Syntax

```java
Supplier<T>
```

Abstract method:

```java
T get();
```

### Example

```java
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> message =
                () -> "Welcome to Java Programming";

        System.out.println(message.get());
    }
}
```

**Output:**

```text
Welcome to Java Programming
```

### Example: Generate Random Number

```java
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        Supplier<Integer> generate =
                () -> random.nextInt(100) + 1;

        System.out.println(generate.get());
    }
}
```

**Output:**

```text
A random number between 1 and 100
```

The actual output changes on each execution.

### Predicate vs Function vs Consumer vs Supplier

| Interface | Input | Output | Method |
|---|---|---|---|
| Predicate<T> | One | boolean | test() |
| Function<T,R> | One | R | apply() |
| Consumer<T> | One | void | accept() |
| Supplier<T> | None | T | get() |

---

## 8. Method References

Method References are a shorthand for Lambda Expressions when an existing method already performs the required operation.

They use the `::` operator.

### Syntax

```java
ClassName::methodName
```

### Types of Method References

1. Reference to a static method.
2. Reference to an instance method of a particular object.
3. Reference to an instance method of an arbitrary object of a particular type.
4. Reference to a constructor.

### 8.1 Static Method Reference

```java
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void print(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("Ayush", "Rahul", "Amit");

        names.forEach(Main::print);
    }
}
```

**Output:**

```text
Ayush
Rahul
Amit
```

### 8.2 Instance Method Reference

```java
import java.util.Arrays;
import java.util.List;

public class Main {

    public void display(String name) {
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {

        Main obj = new Main();

        List<String> names =
                Arrays.asList("Ayush", "Rahul");

        names.forEach(obj::display);
    }
}
```

**Output:**

```text
Hello Ayush
Hello Rahul
```

### 8.3 Arbitrary Object Method Reference

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("ayush", "rahul", "amit");

        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
```

**Output:**

```text
AYUSH
RAHUL
AMIT
```

### 8.4 Constructor Reference

```java
import java.util.function.Supplier;

class Student {

    Student() {
        System.out.println("Student Object Created");
    }
}

public class Main {
    public static void main(String[] args) {

        Supplier<Student> student =
                Student::new;

        student.get();
    }
}
```

**Output:**

```text
Student Object Created
```

---

## 9. Stream API

Stream API is one of the most important Java 8 features.

It allows developers to process collections of data in a declarative way.

A Stream represents a sequence of elements that can be processed through operations such as filtering, mapping, sorting, and reducing.

### Why Stream API?

Before Java 8:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);

        for (Integer number : numbers) {

            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
```

Using Stream API:

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);

        numbers.stream()
               .filter(number -> number % 2 == 0)
               .forEach(System.out::println);
    }
}
```

**Output:**

```text
10
20
30
```

### Characteristics of Streams

1. A Stream does not store data.
2. It processes data from a source such as a collection or array.
3. It supports functional-style operations.
4. Stream operations do not normally modify the original source.
5. Intermediate operations are lazy.
6. A Stream cannot be reused after a terminal operation.
7. Streams can be sequential or parallel.

### Stream Processing Flow

```text
Collection
    |
    v
Source Stream
    |
    v
Intermediate Operations
    |
    +---- filter()
    |
    +---- map()
    |
    +---- sorted()
    |
    v
Terminal Operation
    |
    +---- collect()
    |
    +---- forEach()
    |
    +---- count()
    |
    v
Result
```

---

## 10. Intermediate Operations in Stream API

Intermediate operations return another Stream.

They are lazy and execute when a terminal operation is invoked.

### 10.1 filter()

Filters elements based on a condition.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);

        numbers.stream()
               .filter(number -> number > 20)
               .forEach(System.out::println);
    }
}
```

**Output:**

```text
25
30
```

### 10.2 map()

Transforms each element into another value.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("ayush", "rahul", "amit");

        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
```

**Output:**

```text
AYUSH
RAHUL
AMIT
```

### 10.3 sorted()

Sorts the elements.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(50, 10, 40, 20, 30);

        numbers.stream()
               .sorted()
               .forEach(System.out::println);
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

### Descending Order

```java
numbers.stream()
       .sorted((a, b) -> b.compareTo(a))
       .forEach(System.out::println);
```

**Output:**

```text
50
40
30
20
10
```

### 10.4 distinct()

Removes duplicate elements.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 10, 30, 20);

        numbers.stream()
               .distinct()
               .forEach(System.out::println);
    }
}
```

**Output:**

```text
10
20
30
```

### 10.5 limit()

Limits the number of elements.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40, 50);

        numbers.stream()
               .limit(3)
               .forEach(System.out::println);
    }
}
```

**Output:**

```text
10
20
30
```

### 10.6 skip()

Skips the first specified number of elements.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40, 50);

        numbers.stream()
               .skip(2)
               .forEach(System.out::println);
    }
}
```

**Output:**

```text
30
40
50
```

### 10.7 flatMap()

Transforms each element into a Stream and combines the resulting Streams into one Stream.

It is useful for processing nested collections.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        numbers.stream()
               .flatMap(list -> list.stream())
               .forEach(System.out::println);
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
```

---

## 11. Terminal Operations in Stream API

Terminal operations produce a result or side effect and consume the Stream.

### 11.1 forEach()

Performs an action for every element.

```java
numbers.stream()
       .forEach(System.out::println);
```

### 11.2 count()

Returns the number of elements.

```java
long count = numbers.stream()
                    .filter(n -> n > 20)
                    .count();

System.out.println(count);
```

### 11.3 collect()

Collects the elements into a collection or another result container.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);

        List<Integer> evenNumbers =
                numbers.stream()
                       .filter(n -> n % 2 == 0)
                       .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}
```

**Output:**

```text
[10, 20, 30]
```

### 11.4 reduce()

Combines Stream elements into a single result.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40);

        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);
    }
}
```

**Output:**

```text
Sum: 100
```

### 11.5 min() and max()

Finds the minimum and maximum values.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(50, 10, 40, 20, 30);

        int min = numbers.stream()
                         .min(Integer::compareTo)
                         .get();

        int max = numbers.stream()
                         .max(Integer::compareTo)
                         .get();

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
```

**Output:**

```text
Minimum: 10
Maximum: 50
```

In production code, consider handling an empty Stream using Optional instead of calling `get()` without checking.

### 11.6 anyMatch(), allMatch(), and noneMatch()

These operations test conditions and return boolean values.

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40);

        System.out.println(
                numbers.stream().anyMatch(n -> n > 30)
        );

        System.out.println(
                numbers.stream().allMatch(n -> n > 0)
        );

        System.out.println(
                numbers.stream().noneMatch(n -> n < 0)
        );
    }
}
```

**Output:**

```text
true
true
true
```

---

## 12. Collectors in Java 8

Collectors are utility methods used with Stream's `collect()` operation.

They are available in the `java.util.stream.Collectors` class.

### Important Collectors Methods

| Method | Purpose |
|---|---|
| toList() | Collects elements into a List |
| toSet() | Collects elements into a Set |
| toMap() | Collects elements into a Map |
| joining() | Joins strings |
| counting() | Counts elements |
| groupingBy() | Groups elements by a classifier |
| partitioningBy() | Splits elements into true and false groups |
| averagingInt() | Calculates an average |
| summingInt() | Calculates a sum |

### 12.1 Joining Strings

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("Ayush", "Rahul", "Amit");

        String result = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
```

**Output:**

```text
Ayush, Rahul, Amit
```

### 12.2 Grouping By

```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("Amit", "Ayush", "Ankit",
                              "Rahul", "Rohit");

        Map<Character, List<String>> grouped =
                names.stream()
                     .collect(Collectors.groupingBy(
                             name -> name.charAt(0)
                     ));

        System.out.println(grouped);
    }
}
```

**Possible Output:**

```text
{A=[Amit, Ayush, Ankit], R=[Rahul, Rohit]}
```

The order of map entries is not guaranteed by the default groupingBy collector.

### 12.3 Partitioning By

Partitions elements into two groups based on a boolean condition.

```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);

        Map<Boolean, List<Integer>> result =
                numbers.stream()
                       .collect(Collectors.partitioningBy(
                               n -> n % 2 == 0
                       ));

        System.out.println(result);
    }
}
```

**Output:**

```text
{false=[15, 25], true=[10, 20, 30]}
```

---

## 13. Optional Class

Optional is a container object that may or may not contain a non-null value.

It helps developers represent the absence of a value and reduce accidental NullPointerException.

### Problem Without Optional

```java
public class Main {
    public static void main(String[] args) {

        String name = null;

        if (name != null) {
            System.out.println(name.length());
        } else {
            System.out.println("Name is not available");
        }
    }
}
```

**Output:**

```text
Name is not available
```

### Creating Optional Objects

```java
Optional<String> value1 = Optional.of("Ayush");

Optional<String> value2 = Optional.empty();

Optional<String> value3 = Optional.ofNullable(null);
```

Important methods:

| Method | Description |
|---|---|
| of() | Creates Optional with a non-null value |
| empty() | Creates an empty Optional |
| ofNullable() | Accepts a nullable value |
| isPresent() | Checks whether a value exists |
| ifPresent() | Performs an action if a value exists |
| orElse() | Returns a default value if empty |
| orElseGet() | Gets a fallback value from a Supplier if empty |
| orElseThrow() | Throws an exception if empty |
| get() | Retrieves the value; throws if empty |
| map() | Transforms the contained value |

### Example: Optional

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> name =
                Optional.ofNullable(null);

        System.out.println(
                name.orElse("Unknown")
        );
    }
}
```

**Output:**

```text
Unknown
```

### Example: ifPresent()

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> name =
                Optional.of("Ayush");

        name.ifPresent(value ->
                System.out.println("Name: " + value)
        );
    }
}
```

**Output:**

```text
Name: Ayush
```

### Example: map()

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> name =
                Optional.of("ayush");

        Optional<String> result =
                name.map(String::toUpperCase);

        System.out.println(result.orElse("Unknown"));
    }
}
```

**Output:**

```text
AYUSH
```

**Important:** `Optional.get()` should not be called without checking whether a value is present. Optional is primarily intended for return types where a result may be absent, not as a replacement for every nullable field or variable.

---

## 14. Default Methods in Interfaces

Java 8 introduced default methods in interfaces.

A default method is an interface method with an implementation.

It allows developers to add new behavior to an existing interface without forcing every existing implementation class to implement the new method.

### Syntax

```java
default void methodName() {
    // Implementation
}
```

### Example

```java
interface Vehicle {

    void start();

    default void stop() {
        System.out.println("Vehicle Stopped");
    }
}

class Car implements Vehicle {

    public void start() {
        System.out.println("Car Started");
    }
}

public class Main {
    public static void main(String[] args) {

        Car car = new Car();

        car.start();
        car.stop();
    }
}
```

**Output:**

```text
Car Started
Vehicle Stopped
```

### Multiple Interface Default Methods

If a class implements two interfaces that provide conflicting default methods with the same signature, the class must resolve the conflict by overriding the method.

```java
interface A {

    default void display() {
        System.out.println("Interface A");
    }
}

interface B {

    default void display() {
        System.out.println("Interface B");
    }
}

class Test implements A, B {

    public void display() {
        A.super.display();
        B.super.display();
    }
}

public class Main {
    public static void main(String[] args) {

        Test obj = new Test();

        obj.display();
    }
}
```

**Output:**

```text
Interface A
Interface B
```

---

## 15. Static Methods in Interfaces

Java 8 allows interfaces to contain static methods with implementations.

They are called using the interface name.

### Example

```java
interface Calculator {

    static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {

        int result = Calculator.add(10, 20);

        System.out.println(result);
    }
}
```

**Output:**

```text
30
```

**Important:** Interface static methods are not inherited as instance methods by implementing classes.

---

## 16. New Date and Time API

Before Java 8, developers commonly used `Date` and `Calendar`.

These older APIs had usability problems, including mutable date objects and confusing month handling.

Java 8 introduced the `java.time` package.

### Important Classes

| Class | Purpose |
|---|---|
| LocalDate | Represents a date |
| LocalTime | Represents a time |
| LocalDateTime | Represents date and time |
| ZonedDateTime | Represents date and time with a time zone |
| Instant | Represents a point on the UTC timeline |
| Period | Represents a date-based amount of time |
| Duration | Represents a time-based amount of time |
| DateTimeFormatter | Formats and parses dates and times |

### 16.1 LocalDate

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();

        System.out.println(date);
    }
}
```

**Output:**

```text
The current date in YYYY-MM-DD format
```

The actual date depends on the system clock.

### Creating a Specific Date

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate date =
                LocalDate.of(2026, 11, 21);

        System.out.println(date);
    }
}
```

**Output:**

```text
2026-11-21
```

### 16.2 LocalTime

```java
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        LocalTime time = LocalTime.now();

        System.out.println(time);
    }
}
```

**Output:**

```text
The current local time
```

### 16.3 LocalDateTime

```java
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDateTime dateTime =
                LocalDateTime.now();

        System.out.println(dateTime);
    }
}
```

### 16.4 Adding and Subtracting Dates

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate today =
                LocalDate.of(2026, 11, 21);

        System.out.println(today.plusDays(5));
        System.out.println(today.minusDays(5));
        System.out.println(today.plusMonths(2));
        System.out.println(today.plusYears(1));
    }
}
```

**Output:**

```text
2026-11-26
2026-11-16
2027-01-21
2027-11-21
```

### 16.5 Date Formatting

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        LocalDate date =
                LocalDate.of(2026, 11, 21);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(date.format(formatter));
    }
}
```

**Output:**

```text
21-11-2026
```

### 16.6 Period

Period measures date-based differences in years, months, and days.

```java
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {

        LocalDate start =
                LocalDate.of(2020, 1, 1);

        LocalDate end =
                LocalDate.of(2025, 1, 1);

        Period period =
                Period.between(start, end);

        System.out.println(period.getYears());
    }
}
```

**Output:**

```text
5
```

### 16.7 Duration

Duration measures time-based differences.

```java
import java.time.Duration;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        LocalTime start =
                LocalTime.of(10, 0);

        LocalTime end =
                LocalTime.of(12, 30);

        Duration duration =
                Duration.between(start, end);

        System.out.println(duration.toMinutes());
    }
}
```

**Output:**

```text
150
```

---

## 17. Parallel Streams

Parallel Streams allow processing of Stream elements using multiple threads.

They use the common ForkJoinPool by default.

### Sequential Stream

```java
numbers.stream()
       .forEach(System.out::println);
```

### Parallel Stream

```java
numbers.parallelStream()
       .forEach(System.out::println);
```

### Example

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.parallelStream()
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Sum: " + sum);
    }
}
```

**Output:**

```text
Sum: 15
```

### Advantages

1. Can improve performance for suitable workloads.
2. Allows parallel processing.
3. Reduces the need to manually manage threads for many data-processing tasks.

### Disadvantages and Precautions

1. Parallel execution has overhead.
2. Small datasets may perform worse.
3. Shared mutable state can cause race conditions.
4. Encounter order is not always preserved by terminal operations such as `forEach()`.
5. Blocking operations may reduce performance.

**Important:** Parallel Streams are not automatically faster. Benchmark with realistic data before using them in production.

---

## 18. Real-World Java 8 Programs

### Example 1: Filter Even Numbers and Calculate Their Sum

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);

        int sum = numbers.stream()
                         .filter(n -> n % 2 == 0)
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Sum of even numbers: " + sum);
    }
}
```

**Output:**

```text
Sum of even numbers: 60
```

### Example 2: Find Students Who Passed

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {

    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Ayush", 85),
                new Student("Rahul", 35),
                new Student("Amit", 75),
                new Student("Rohit", 25)
        );

        List<String> passed = students.stream()
                .filter(student -> student.marks >= 40)
                .map(student -> student.name)
                .collect(Collectors.toList());

        System.out.println(passed);
    }
}
```

**Output:**

```text
[Ayush, Amit]
```

### Example 3: Find the Highest Marks

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Student {

    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Ayush", 85),
                new Student("Rahul", 90),
                new Student("Amit", 78)
        );

        Optional<Student> topper =
                students.stream()
                        .max((s1, s2) ->
                                Integer.compare(s1.marks, s2.marks));

        topper.ifPresent(student ->
                System.out.println(
                        student.name + " - " + student.marks
                )
        );
    }
}
```

**Output:**

```text
Rahul - 90
```

### Example 4: Sort Employees by Salary

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Ayush", 45000),
                new Employee("Rahul", 60000),
                new Employee("Amit", 35000)
        );

        employees.stream()
                 .sorted(Comparator.comparingDouble(
                         employee -> employee.salary
                 ))
                 .forEach(employee ->
                         System.out.println(
                                 employee.name + " - " + employee.salary
                         )
                 );
    }
}
```

**Output:**

```text
Amit - 35000.0
Ayush - 45000.0
Rahul - 60000.0
```

### Example 5: Count Word Frequency

```java
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String sentence =
                "java is easy and java is powerful";

        Map<String, Long> frequency =
                Arrays.stream(sentence.split("\\s+"))
                      .collect(Collectors.groupingBy(
                              Function.identity(),
                              Collectors.counting()
                      ));

        System.out.println(frequency);
    }
}
```

**Possible Output:**

```text
{java=2, is=2, easy=1, and=1, powerful=1}
```

### Example 6: Convert Names to Uppercase

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("ayush", "rahul", "amit");

        List<String> result =
                names.stream()
                     .map(String::toUpperCase)
                     .collect(Collectors.toList());

        System.out.println(result);
    }
}
```

**Output:**

```text
[AYUSH, RAHUL, AMIT]
```

---

## 19. Common Mistakes in Java 8

1. Thinking every interface is a Functional Interface.
2. Writing a Lambda Expression without understanding the target Functional Interface.
3. Trying to reuse a Stream after a terminal operation.
4. Modifying a collection while processing its Stream.
5. Confusing map() with flatMap().
6. Using Optional.get() without checking whether a value exists.
7. Assuming parallelStream() is always faster.
8. Using side effects in Stream pipelines unnecessarily.
9. Confusing Predicate with Function.
10. Confusing Consumer with Supplier.
11. Assuming intermediate Stream operations execute immediately.
12. Using mutable shared state inside parallel Stream operations.
13. Confusing LocalDate with LocalDateTime.
14. Assuming a Stream changes the original collection.

---

## 20. Best Practices

- Use Lambda Expressions when they make code easier to understand.
- Use `@FunctionalInterface` for custom single-abstract-method interfaces.
- Prefer built-in Functional Interfaces when suitable.
- Use Method References when they make a Lambda Expression clearer.
- Use Streams for declarative data processing.
- Avoid unnecessarily long Stream pipelines.
- Prefer Optional return types when a method may have no result.
- Use `java.time` classes instead of legacy Date and Calendar for new date-time code.
- Use sequential Streams by default unless parallel processing has a clear benefit.
- Avoid modifying external state inside Stream operations.
- Use `orElseGet()` when fallback creation should be lazy.
- Remember that Streams are single-use.

---

## 21. Java 8 Features Interview Questions

### Basic Questions

1. What is Java 8?

**Answer:** Java 8 is a Java release that added lambda expressions and functional interfaces plus Streams, Optional, default methods, and the java.time API.

2. What are the major features introduced in Java 8?

**Answer:** Major features include lambdas, functional interfaces, built-in function types, method references, Streams, Optional, interface default/static methods, and the new Date/Time API.

3. What is a Lambda Expression?

**Answer:** A lambda expression is a concise implementation of a functional interface method, written as parameters, `->`, and a body.

4. What is the syntax of a Lambda Expression?

**Answer:** The syntax is `(parameters) -> expression` or `(parameters) -> { statements; }`; parameter types are often inferred.

5. What is a Functional Interface?

**Answer:** A functional interface has exactly one abstract method, although it may also declare default or static methods.

6. What is a SAM interface?

**Answer:** SAM means Single Abstract Method: an interface with one abstract method that can therefore be implemented by a lambda.

7. What is the purpose of @FunctionalInterface?

**Answer:** `@FunctionalInterface` documents intent and makes compilation fail if the interface has no or more than one abstract method.

8. What is the difference between an anonymous inner class and a Lambda Expression?

**Answer:** A lambda is a functional-interface implementation without an ordinary inner-class instance; an anonymous class creates a separate class instance and can hold fields.

9. What is a Predicate?

**Answer:** `Predicate<T>` represents a boolean test through `test(T)`.

10. What is a Consumer?

**Answer:** `Consumer<T>` represents an action that accepts a value and returns no result through `accept(T)`.

### Intermediate Questions

11. What is a Supplier?

**Answer:** `Supplier<T>` supplies a value without input through `get()`.

12. What is a Function?

**Answer:** `Function<T,R>` transforms an input of type `T` into a result of type `R` through `apply(T)`.

13. What is the difference between Predicate and Function?

**Answer:** `Predicate` returns boolean and is used for filtering or testing; `Function` returns a value and is used for transformation.

14. What is a Method Reference?

**Answer:** A method reference uses `::` as shorthand for a lambda that invokes an existing method.

15. What are the types of Method References?

**Answer:** The forms are static methods, an instance method on a specific object, an instance method on an arbitrary object of a type, and constructors.

16. What is the Stream API?

**Answer:** The Stream API provides lazy, functional-style pipelines for processing sequences from collections, arrays, or generators.

17. What is the difference between a Collection and a Stream?

**Answer:** A Collection stores data and is reusable; a Stream processes a source and cannot normally be reused after a terminal operation.

18. What are intermediate and terminal operations?

**Answer:** Intermediate operations return streams and are lazy; terminal operations consume the pipeline and produce a result or side effect.

19. What is the difference between map() and flatMap()?

**Answer:** `map()` performs a one-to-one transformation; `flatMap()` transforms each element to a stream and flattens all results.

20. What is the difference between filter() and map()?

**Answer:** `filter()` removes elements that fail a predicate; `map()` transforms each element.

21. What is the purpose of reduce()?

**Answer:** `reduce()` combines stream elements into one result using an accumulator operation.

22. What is the difference between findFirst() and findAny()?

**Answer:** `findFirst()` returns the first element in encounter order; `findAny()` may return any element and is more flexible for parallel streams.

23. What is Optional?

**Answer:** `Optional<T>` is a container that may hold a value, allowing absence to be represented without accidental null dereferences.

24. What is the difference between orElse() and orElseGet()?

**Answer:** `orElse()` takes a ready value and evaluates eagerly; `orElseGet()` invokes a supplier only when the Optional is empty.

25. What are default methods in interfaces?

**Answer:** Default methods provide interface implementations so libraries can evolve without breaking existing implementations.

### Advanced Questions

26. What are static methods in interfaces?

**Answer:** Static interface methods belong to the interface and are called through the interface name, not implementation instances.

27. Why were default methods introduced in Java 8?

**Answer:** Default methods support backward-compatible evolution of interfaces and shared behavior across implementations.

28. What happens when two interfaces have the same default method?

**Answer:** A class with conflicting inherited defaults must override the method explicitly or declare the abstract override to resolve the ambiguity.

29. What is a parallel Stream?

**Answer:** A parallel stream partitions work and executes it concurrently, usually using the Fork/Join common pool.

30. What is the difference between sequential and parallel Streams?

**Answer:** A sequential stream processes elements serially; a parallel stream may speed suitable workloads but adds synchronization and task overhead.

31. What is lazy evaluation in Stream API?

**Answer:** Lazy evaluation defers intermediate stream processing until a terminal operation starts, allowing operations to be fused.

32. What is the difference between forEach() and forEachOrdered()?

**Answer:** `forEach()` is terminal and does not guarantee encounter order for parallel streams; `forEachOrdered()` does preserve encounter order.

33. What is the purpose of Collectors.groupingBy()?

**Answer:** `Collectors.groupingBy()` collects elements into a map whose keys are classifier results.

34. What is the difference between groupingBy() and partitioningBy()?

**Answer:** `groupingBy()` creates groups for each key; `partitioningBy()` creates exactly true/false buckets using a predicate.

35. What is the Java 8 Date and Time API?

**Answer:** The Java 8 Date/Time API is the immutable, thread-safe `java.time` package for dates, times, durations, periods, and formatting.

36. What is the difference between LocalDate and LocalDateTime?

**Answer:** `LocalDate` contains only a date; `LocalDateTime` contains both date and time without a zone.

37. What is the difference between Period and Duration?

**Answer:** `Period` represents date-based calendar differences; `Duration` represents a machine-oriented time difference in seconds and nanoseconds.

38. What is a method reference to a constructor?

**Answer:** A constructor reference has the form `ClassName::new` and implements a functional interface that creates a new instance.

39. What is Function chaining?

**Answer:** Function chaining passes one function’s result into the next, using `andThen()` or `compose()`.

40. Can a Functional Interface contain default and static methods?

**Answer:** Yes; default and static methods are allowed because the functional-interface rule counts only abstract methods.

---

## 22. Practice Exercises (Questions Only)

**Important:** This section contains questions only. Try to solve each exercise independently before checking any external solution.

Completed solutions are available in the [Practice-Programs folder](Practice-Programs/README.md).

### Beginner Level

1. Write a Lambda Expression to print "Hello Java 8".
2. Write a Lambda Expression to add two integers.
3. Create a Functional Interface to calculate the square of a number.
4. Use Predicate to check whether a number is even.
5. Use Predicate to check whether a string starts with the letter A.
6. Use Function to convert a String into uppercase.
7. Use Function to calculate the square of an integer.
8. Use Consumer to print student names.
9. Use Supplier to generate a welcome message.
10. Use a Method Reference to print elements of an ArrayList.

### Intermediate Level

11. Use Stream API to filter even numbers from a list.
12. Use Stream API to find numbers greater than 50.
13. Use map() to convert a list of strings into uppercase.
14. Use sorted() to sort a list of integers in ascending order.
15. Use sorted() to sort a list of integers in descending order.
16. Use distinct() to remove duplicate elements.
17. Use limit() to retrieve the first five elements.
18. Use skip() to skip the first three elements.
19. Use reduce() to calculate the sum of all numbers.
20. Use count() to count strings having more than five characters.
21. Use flatMap() to flatten a list of lists.
22. Use Optional to handle a nullable String.
23. Use DateTimeFormatter to display a date in dd-MM-yyyy format.
24. Use groupingBy() to group names based on their first character.
25. Use partitioningBy() to separate even and odd numbers.

### Advanced Level

26. Create a Student class and use Stream API to find students who passed.
27. Find the student with the highest marks using Stream API.
28. Sort employees by salary using Comparator and Stream API.
29. Calculate the average salary of employees using Collectors.
30. Group employees according to their departments.
31. Create a word-frequency counter using groupingBy() and counting().
32. Use Function chaining to perform multiple transformations.
33. Create a custom Functional Interface and implement it using Lambda.
34. Implement a default method in an interface.
35. Implement a static method in an interface.
36. Create a program demonstrating conflict resolution between two interface default methods.
37. Calculate the difference between two dates using Period.
38. Calculate the duration between two times using Duration.
39. Compare sequential and parallel Stream processing on a sufficiently large dataset.
40. Build a student management program using ArrayList, Lambda Expressions, Streams, and Optional.

---

## 23. Chapter Summary

In this chapter, you learned:

- Introduction to Java 8.
- Lambda Expressions.
- Functional Interfaces.
- Predicate, Function, Consumer, and Supplier.
- Method References.
- Stream API.
- Intermediate and terminal operations.
- Collectors.
- Optional Class.
- Default and Static Methods in Interfaces.
- New Date and Time API.
- Parallel Streams.
- Practical Java 8 programs.
- Interview questions and exercises.

### Key Takeaways

| Feature | Main Purpose |
|---|---|
| Lambda Expression | Write concise anonymous functions |
| Functional Interface | Define a single abstract operation |
| Predicate | Test a condition |
| Function | Transform data |
| Consumer | Consume data |
| Supplier | Supply data |
| Method Reference | Refer to an existing method |
| Stream API | Process sequences of data |
| Optional | Represent a possibly absent value |
| Collectors | Collect and group Stream results |
| Date and Time API | Handle dates and times |
| Parallel Stream | Process data in parallel |

### Final Note

Java 8 is essential for modern Java development. Lambda Expressions, Functional Interfaces, and Stream API are frequently used in enterprise applications, Spring Boot projects, interviews, and competitive programming.

Practice each program yourself and understand how the data flows through each operation.

---

## Next Chapter: Chapter 12 – Multithreading and Concurrency in Java

Topics covered in the next chapter:

1. Introduction to Multithreading.
2. Process vs Thread.
3. Thread Life Cycle.
4. Creating Threads using Thread Class.
5. Creating Threads using Runnable Interface.
6. Thread Methods.
7. Thread Priority.
8. Sleep, Join, and Yield.
9. Synchronization.
10. Race Conditions.
11. Deadlock.
12. Inter-thread Communication.
13. wait(), notify(), and notifyAll().
14. Executor Framework.
15. Callable and Future.
16. Concurrent Collections.
17. Practical Multithreading Programs.
18. Interview Questions and Practice Exercises.

**Keep learning, keep coding, and build strong Java fundamentals one chapter at a time.**
