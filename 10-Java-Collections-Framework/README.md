# Chapter 10: Java Collections Framework (JCF)

**Navigation:** [Main Tutorial Index](../README.md) | [Practice Programs](Practice-Programs/) | [Previous: Exception Handling](../09-Java-Exception-Handling/README.md) | [Next: Java 8 Features](../11-Java-8-Features/README.md)

## 1. Introduction to the Java Collections Framework

The **Java Collections Framework (JCF)** is a set of interfaces, classes, and utility methods used to store, manage, retrieve, and manipulate groups of objects.

Before Collections, Java developers commonly used arrays to store multiple values. However, arrays have a fixed size, which makes them less flexible.

Collections solve this limitation by providing dynamic data structures.

### Why do we need Collections?

Consider an array:

```java
int[] numbers = new int[3];

numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
```

The array can store only three elements. To store more elements, we need to create another array.

Using an ArrayList:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println(numbers);
    }
}
```

**Output:**

```text
[10, 20, 30, 40]
```

The ArrayList automatically grows when new elements are added.

### Advantages of Collections

1. Dynamic size.
2. Ready-made data structures.
3. Easy insertion and deletion.
4. Searching and sorting utilities.
5. Type safety through Generics.
6. Reusable and maintainable code.
7. Support for different data organization techniques.

---

## 2. Collection vs Collections

These two terms are different.

| Collection | Collections |
|---|---|
| An interface | A utility class |
| Part of the Collections Framework | Provides utility methods |
| Represents a group of objects | Provides sorting, searching, reversing, etc. |
| Parent interface of List, Set, and Queue | Contains static methods |

Example:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(30);
        numbers.add(10);
        numbers.add(20);

        Collections.sort(numbers);

        System.out.println(numbers);
    }
}
```

**Output:**

```text
[10, 20, 30]
```

Here:
- `Collection` is an interface.
- `Collections` is a utility class.
- `ArrayList` is a class implementing the List interface.

---

## 3. Collections Framework Hierarchy

The Collections Framework provides different interfaces for storing data.

```text
                    Iterable
                       |
                   Collection
                       |
          +------------+------------+
          |            |            |
         List         Set         Queue
          |            |            |
     +----+----+    +--+-------+    +----------+
     |    |    |    |  |       |    |          |
 ArrayList | Vector | HashSet | LinkedHashSet PriorityQueue
          LinkedList|         |
              Stack|       SortedSet
                   |           |
                TreeSet   NavigableSet
```

The Map hierarchy is separate from Collection:

```text
                    Map
                     |
        +------------+------------+
        |            |            |
      HashMap    LinkedHashMap  SortedMap
                                   |
                                TreeMap
```

**Important:** Map belongs to the Java Collections Framework, but Map does not extend the Collection interface.

---

## 4. List Interface

The List interface stores elements in an ordered sequence.

### Characteristics

- Maintains insertion order.
- Allows duplicate elements.
- Supports index-based access.
- Usually allows multiple null elements, depending on implementation.

Examples of List implementations:

1. ArrayList
2. LinkedList
3. Vector
4. Stack

### 4.1 ArrayList

ArrayList is a resizable-array implementation of the List interface.

It automatically increases its capacity when additional elements are inserted.

#### Characteristics

- Maintains insertion order.
- Allows duplicates.
- Allows null elements.
- Provides fast index-based access.
- Insertion or deletion in the middle may require shifting elements.
- It is not synchronized by default.

#### Example: Creating an ArrayList

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Ayush");
        names.add("Rahul");
        names.add("Amit");
        names.add("Ayush");

        System.out.println(names);
    }
}
```

**Output:**

```text
[Ayush, Rahul, Amit, Ayush]
```

#### Common ArrayList Methods

| Method | Description |
|---|---|
| add() | Adds an element |
| get() | Retrieves an element by index |
| set() | Updates an element |
| remove() | Removes an element |
| size() | Returns the number of elements |
| contains() | Checks whether an element exists |
| indexOf() | Returns the first matching index |
| isEmpty() | Checks whether the list is empty |
| clear() | Removes all elements |

#### Example: ArrayList Operations

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("Original List: " + numbers);

        // Accessing an element
        System.out.println("Element at index 1: " + numbers.get(1));

        // Updating an element
        numbers.set(1, 25);

        // Removing an element by index
        numbers.remove(2);

        // Checking an element
        System.out.println("Contains 10: " + numbers.contains(10));

        // Size
        System.out.println("Size: " + numbers.size());

        System.out.println("Final List: " + numbers);
    }
}
```

**Output:**

```text
Original List: [10, 20, 30, 40]
Element at index 1: 20
Contains 10: true
Size: 3
Final List: [10, 25, 40]
```

#### Traversing an ArrayList

Using a for loop:

```java
for (int i = 0; i < numbers.size(); i++) {
    System.out.println(numbers.get(i));
}
```

Using an enhanced for loop:

```java
for (Integer number : numbers) {
    System.out.println(number);
}
```

Using an Iterator:

```java
import java.util.Iterator;

Iterator<Integer> iterator = numbers.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

Using Java 8 forEach:

```java
numbers.forEach(number -> System.out.println(number));
```

### 4.2 LinkedList

LinkedList is a doubly linked list implementation of the List and Deque interfaces.

Each node stores:
- Data.
- Reference to the previous node.
- Reference to the next node.

#### Structure

```text
NULL <- [10] <-> [20] <-> [30] -> NULL
```

#### Characteristics

- Maintains insertion order.
- Allows duplicate elements.
- Allows null elements.
- Efficient insertion and deletion at the ends.
- Random index-based access is slower than ArrayList.
- Uses additional memory for node references.

#### Example

```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.add("Ayush");
        names.add("Rahul");
        names.add("Amit");

        names.addFirst("Rohit");
        names.addLast("Vikas");

        System.out.println(names);

        names.removeFirst();
        names.removeLast();

        System.out.println("After deletion: " + names);
    }
}
```

**Output:**

```text
[Rohit, Ayush, Rahul, Amit, Vikas]
After deletion: [Ayush, Rahul, Amit]
```

### 4.3 Vector

Vector is a legacy resizable-array implementation of the List interface.

#### Characteristics

- Maintains insertion order.
- Allows duplicates.
- Allows null values.
- Synchronized methods.
- Automatically grows when required.
- Usually slower than ArrayList in single-threaded situations because of synchronization overhead.

#### Example

```java
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        Vector<Integer> numbers = new Vector<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers);
        System.out.println("Capacity: " + numbers.capacity());
    }
}
```

**Output:**

```text
[10, 20, 30]
Capacity: 10
```

The default initial capacity of Vector is 10.

### 4.4 Stack

Stack is a legacy class that extends Vector and follows the LIFO principle.

**LIFO = Last In, First Out**

The element inserted last is removed first.

#### Stack Operations

| Method | Description |
|---|---|
| push() | Inserts an element |
| pop() | Removes and returns the top element |
| peek() | Returns the top element without removing it |
| empty() | Checks whether the stack is empty |
| search() | Searches for an element |

#### Stack Diagram

```text
       +------+
       |  30  |  <- Top
       +------+
       |  20  |
       +------+
       |  10  |
       +------+
```

#### Example

```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);

        System.out.println("Top: " + stack.peek());

        System.out.println("Removed: " + stack.pop());

        System.out.println("Final Stack: " + stack);
    }
}
```

**Output:**

```text
Stack: [10, 20, 30]
Top: 30
Removed: 30
Final Stack: [10, 20]
```

**Modern recommendation:** Prefer `Deque` with `ArrayDeque` for stack operations in new Java code.

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
```

**Output:**

```text
30
20
```

---

## 5. Set Interface

Set is an interface that stores unique elements.

It does not allow duplicate elements according to the `equals()` and `hashCode()` contract.

### Characteristics

- Does not allow duplicate elements.
- Implementations differ in ordering.
- Some implementations allow null values, while others do not.
- Does not provide index-based access.

Main implementations:

1. HashSet
2. LinkedHashSet
3. TreeSet

### 5.1 HashSet

HashSet stores unique elements using a hash table.

#### Characteristics

- Does not maintain insertion order.
- Does not allow duplicates.
- Allows one null element.
- Provides efficient average-case insertion, deletion, and lookup.
- Does not guarantee iteration order.

#### Example

```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20);

        System.out.println(numbers);

        System.out.println("Contains 10: " + numbers.contains(10));
    }
}
```

**Possible Output:**

```text
[20, 10, 30]
Contains 10: true
```

The order may differ because HashSet does not guarantee iteration order.

### 5.2 LinkedHashSet

LinkedHashSet extends HashSet and maintains insertion order.

#### Example

```java
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {

        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("Patna");
        cities.add("Bangalore");
        cities.add("Delhi");
        cities.add("Patna");

        System.out.println(cities);
    }
}
```

**Output:**

```text
[Patna, Bangalore, Delhi]
```

### 5.3 TreeSet

TreeSet stores unique elements in sorted order.

By default, it uses natural ordering.

#### Characteristics

- Stores unique elements.
- Maintains sorted order.
- Does not allow null elements under natural ordering.
- Generally provides O(log n) insertion, deletion, and lookup.

#### Example

```java
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(10);

        System.out.println(numbers);

        System.out.println("First: " + numbers.first());
        System.out.println("Last: " + numbers.last());
    }
}
```

**Output:**

```text
[10, 20, 40, 50]
First: 10
Last: 50
```

### Difference Between HashSet, LinkedHashSet, and TreeSet

| Feature | HashSet | LinkedHashSet | TreeSet |
|---|---|---|---|
| Duplicates | No | No | No |
| Ordering | No guarantee | Insertion order | Sorted order |
| Null | One allowed | One allowed | Not with natural ordering |
| Typical operations | O(1) average | O(1) average | O(log n) |
| Internal structure | Hash table | Hash table + linked structure | Balanced search tree |

---

## 6. Queue Interface

Queue is an interface used to store elements for processing.

A typical Queue follows FIFO.

**FIFO = First In, First Out**

The first inserted element is normally removed first.

#### Queue Diagram

```text
Front                         Rear
  |                             |
  v                             v
+------+    +------+    +------+
|  10  | -> |  20  | -> |  30  |
+------+    +------+    +------+
```

### Important Queue Methods

| Method | Description |
|---|---|
| add() | Inserts an element; may throw an exception |
| offer() | Inserts an element; returns false if unsuccessful |
| remove() | Removes the head; throws an exception if empty |
| poll() | Removes the head; returns null if empty |
| element() | Retrieves the head; throws an exception if empty |
| peek() | Retrieves the head; returns null if empty |

### Example

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Queue: " + queue);

        System.out.println("Front: " + queue.peek());

        System.out.println("Removed: " + queue.poll());

        System.out.println("Final Queue: " + queue);
    }
}
```

**Output:**

```text
Queue: [10, 20, 30]
Front: 10
Removed: 10
Final Queue: [20, 30]
```

### 6.1 PriorityQueue

PriorityQueue processes elements according to priority rather than insertion order.

By default, the smallest element has the highest priority for natural ordering.

#### Example

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(40);
        queue.offer(10);
        queue.offer(30);
        queue.offer(20);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
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
```

**Important:** PriorityQueue's iterator does not guarantee sorted traversal. Repeatedly calling `poll()` retrieves elements according to priority.

### Max PriorityQueue

```java
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue =
                new PriorityQueue<>(Collections.reverseOrder());

        queue.add(10);
        queue.add(40);
        queue.add(20);
        queue.add(30);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
```

**Output:**

```text
40
30
20
10
```

---

## 7. Map Interface

Map stores data in key-value pairs.

Each key must be unique, but multiple keys can have the same value.

### Characteristics

- Stores key-value pairs.
- Does not permit duplicate keys.
- Values can be duplicated.
- Provides methods for accessing values through keys.
- Map does not extend the Collection interface.

### Example

```text
Key        Value
------------------
101        Ayush
102        Rahul
103        Amit
```

### Important Map Methods

| Method | Description |
|---|---|
| put() | Inserts or updates a key-value pair |
| get() | Retrieves a value by key |
| remove() | Removes an entry |
| containsKey() | Checks whether a key exists |
| containsValue() | Checks whether a value exists |
| keySet() | Returns all keys |
| values() | Returns all values |
| entrySet() | Returns all key-value entries |
| size() | Returns the number of entries |
| clear() | Removes all entries |

### 7.1 HashMap

HashMap stores key-value pairs using hashing.

#### Characteristics

- Does not guarantee insertion order.
- Does not allow duplicate keys.
- Allows one null key.
- Allows multiple null values.
- Not synchronized by default.
- Provides average O(1) lookup and insertion under good hash distribution.

#### Example

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ayush");
        students.put(102, "Rahul");
        students.put(103, "Amit");

        System.out.println(students);

        System.out.println("Student 101: " + students.get(101));

        students.put(102, "Rohit");

        System.out.println("Updated Map: " + students);
    }
}
```

**Possible Output:**

```text
{101=Ayush, 102=Rahul, 103=Amit}
Student 101: Ayush
Updated Map: {101=Ayush, 102=Rohit, 103=Amit}
```

HashMap iteration order is not guaranteed.

### 7.2 LinkedHashMap

LinkedHashMap maintains insertion order by default.

#### Example

```java
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(3, "Amit");
        map.put(1, "Ayush");
        map.put(2, "Rahul");

        System.out.println(map);
    }
}
```

**Output:**

```text
{3=Amit, 1=Ayush, 2=Rahul}
```

LinkedHashMap can also be configured for access-order iteration, which is useful when implementing an LRU cache.

### 7.3 TreeMap

TreeMap stores key-value pairs sorted by keys.

It uses a balanced search tree.

#### Example

```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        TreeMap<Integer, String> students = new TreeMap<>();

        students.put(103, "Amit");
        students.put(101, "Ayush");
        students.put(102, "Rahul");

        System.out.println(students);
    }
}
```

**Output:**

```text
{101=Ayush, 102=Rahul, 103=Amit}
```

### Difference Between HashMap, LinkedHashMap, and TreeMap

| Feature | HashMap | LinkedHashMap | TreeMap |
|---|---|---|---|
| Ordering | No guarantee | Insertion order by default | Sorted by keys |
| Null keys | One allowed | One allowed | Not with natural ordering |
| Duplicate keys | No | No | No |
| Typical lookup | O(1) average | O(1) average | O(log n) |
| Internal structure | Hash table | Hash table + linked structure | Balanced search tree |

---

## 8. Iterator and ListIterator

Iterators are used to traverse elements in collections.

### 8.1 Iterator

Iterator provides forward traversal.

Important methods:

- `hasNext()` – checks whether another element exists.
- `next()` – returns the next element.
- `remove()` – removes the last element returned by next(), if supported.

#### Example

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

**Output:**

```text
10
20
30
```

### Removing Elements Using Iterator

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {

            Integer number = iterator.next();

            if (number == 20) {
                iterator.remove();
            }
        }

        System.out.println(numbers);
    }
}
```

**Output:**

```text
[10, 30, 40]
```

### 8.2 ListIterator

ListIterator is available only for List implementations.

It supports:
- Forward traversal.
- Backward traversal.
- Adding elements.
- Updating elements.
- Removing elements.

#### Example

```java
import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Ayush");
        names.add("Rahul");
        names.add("Amit");

        ListIterator<String> iterator = names.listIterator();

        System.out.println("Forward:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Backward:");

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
```

**Output:**

```text
Forward:
Ayush
Rahul
Amit
Backward:
Amit
Rahul
Ayush
```

### Iterator vs ListIterator

| Iterator | ListIterator |
|---|---|
| Works with collections | Works only with Lists |
| Forward traversal | Forward and backward traversal |
| Supports remove() | Supports remove(), add(), and set() |
| No index information | Provides nextIndex() and previousIndex() |

**Fail-fast behavior:** Many standard collection iterators are fail-fast. Structural modification outside the iterator during iteration may cause ConcurrentModificationException. This is best-effort behavior, not a thread-safety guarantee.

---

## 9. Comparable and Comparator

Comparable and Comparator are used to define sorting order.

### 9.1 Comparable

Comparable defines the natural ordering of objects.

It is implemented by the class whose objects need to be compared.

It contains:

```java
int compareTo(T object);
```

#### Example: Sorting Students by Marks

```java
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {

    int marks;
    String name;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }

    public String toString() {
        return name + " - " + marks;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Ayush", 85));
        students.add(new Student("Rahul", 70));
        students.add(new Student("Amit", 90));

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
```

**Output:**

```text
Rahul - 70
Ayush - 85
Amit - 90
```

### 9.2 Comparator

Comparator defines custom sorting logic outside the class.

It contains:

```java
int compare(T object1, T object2);
```

#### Example: Sorting Students by Name

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {

    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Ayush", 85));
        students.add(new Student("Rahul", 70));
        students.add(new Student("Amit", 90));

        Comparator<Student> byName =
                (s1, s2) -> s1.name.compareTo(s2.name);

        Collections.sort(students, byName);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
```

**Output:**

```text
Amit - 90
Ayush - 85
Rahul - 70
```

### Comparable vs Comparator

| Comparable | Comparator |
|---|---|
| Defines natural ordering | Defines custom ordering |
| Uses compareTo() | Uses compare() |
| Implemented inside the class | Can be defined outside the class |
| Usually one natural order | Multiple sorting strategies possible |

---

## 10. Generics in Collections

Generics allow classes and interfaces to work with specified data types.

They provide compile-time type safety.

### Without Generics

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        list.add("Ayush");
        list.add(100);

        String name = (String) list.get(0);

        System.out.println(name);
    }
}
```

Raw collections can store different types, so incorrect values may cause runtime errors.

### With Generics

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Ayush");
        names.add("Rahul");

        // names.add(100); // Compilation error

        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

**Output:**

```text
Ayush
Rahul
```

### Benefits of Generics

1. Type safety.
2. Fewer explicit type casts.
3. Errors detected at compile time.
4. More reusable code.
5. Better readability.

---

## 11. Java 8 Collection Features

Java 8 introduced useful methods and lambda-based operations.

### 11.1 forEach()

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

**Output:**

```text
Ayush
Rahul
Amit
```

### 11.2 removeIf()

Removes elements matching a condition.

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

        numbers.removeIf(number -> number % 2 != 0);

        System.out.println(numbers);
    }
}
```

**Output:**

```text
[10, 20, 30]
```

### 11.3 getOrDefault()

Returns the value associated with a key, or a default value if the key is absent.

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ayush");

        System.out.println(students.getOrDefault(101, "Unknown"));
        System.out.println(students.getOrDefault(102, "Unknown"));
    }
}
```

**Output:**

```text
Ayush
Unknown
```

### 11.4 putIfAbsent()

Adds a mapping only if the key does not already have a non-null value.

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ayush");
        students.putIfAbsent(101, "Rahul");
        students.putIfAbsent(102, "Amit");

        System.out.println(students);
    }
}
```

**Output:**

```text
{101=Ayush, 102=Amit}
```

### 11.5 computeIfAbsent()

Computes and inserts a value when a key is absent or currently mapped to null.

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.computeIfAbsent(101, key -> "Ayush");
        students.computeIfAbsent(102, key -> "Rahul");

        System.out.println(students);
    }
}
```

**Output:**

```text
{101=Ayush, 102=Rahul}
```

### 11.6 Map forEach()

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ayush");
        students.put(102, "Rahul");
        students.put(103, "Amit");

        students.forEach((id, name) ->
                System.out.println(id + " : " + name)
        );
    }
}
```

**Output:**

```text
101 : Ayush
102 : Rahul
103 : Amit
```

The displayed iteration order is not guaranteed for HashMap.

---

## 12. Important Array and Collection Conversion

### Array to List

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] names = {"Ayush", "Rahul", "Amit"};

        List<String> list = Arrays.asList(names);

        System.out.println(list);
    }
}
```

**Output:**

```text
[Ayush, Rahul, Amit]
```

**Important:** `Arrays.asList()` returns a fixed-size list backed by the original array. You can use `set()`, but `add()` and `remove()` are unsupported.

To create a resizable ArrayList:

```java
List<String> list = new ArrayList<>(Arrays.asList(names));
```

### List to Array

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Ayush");
        names.add("Rahul");

        String[] array = names.toArray(new String[0]);

        for (String name : array) {
            System.out.println(name);
        }
    }
}
```

**Output:**

```text
Ayush
Rahul
```

---

## 13. Important Differences for Interviews

### Array vs ArrayList

| Array | ArrayList |
|---|---|
| Fixed size | Dynamic size |
| Stores primitives and objects | Stores objects; primitives use wrapper classes |
| Uses length | Uses size() |
| Built-in language feature | Collections Framework class |
| Can be multidimensional | Can contain other lists |

### ArrayList vs LinkedList

| ArrayList | LinkedList |
|---|---|
| Resizable array | Doubly linked list |
| Fast indexed access | Slower indexed access |
| Middle insertion may require shifting | Insertion after reaching a node does not require shifting |
| Less memory overhead per element | More memory for node references |
| Not synchronized | Not synchronized |

### List vs Set

| List | Set |
|---|---|
| Allows duplicates | Does not allow duplicates |
| Maintains positional order | Ordering depends on implementation |
| Supports index-based access | No index-based access |

### Queue vs Stack

| Queue | Stack |
|---|---|
| Usually FIFO | LIFO |
| Insert at the rear and remove from the head | Insert and remove at the top |
| Examples: scheduling | Examples: undo operations |

### HashMap vs Hashtable

| HashMap | Hashtable |
|---|---|
| Not synchronized | Synchronized methods |
| Allows one null key | Does not allow null keys |
| Allows null values | Does not allow null values |
| Generally preferred in non-concurrent code | Legacy class |

For concurrent access, consider `ConcurrentHashMap` rather than choosing Hashtable for new applications.

---

## 14. Real-World Applications of Collections

### Example 1: Student Management System Using ArrayList

```java
import java.util.ArrayList;

class Student {

    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + " - " + name + " - " + marks;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Ayush", 85.5));
        students.add(new Student(102, "Rahul", 90.0));
        students.add(new Student(103, "Amit", 78.5));

        System.out.println("Student Records:");

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
```

**Output:**

```text
Student Records:
101 - Ayush - 85.5
102 - Rahul - 90.0
103 - Amit - 78.5
```

### Example 2: Word Frequency Counter Using HashMap

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String sentence = "java is easy and java is powerful";

        String[] words = sentence.split(" ");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        frequency.forEach((word, count) ->
                System.out.println(word + " : " + count)
        );
    }
}
```

**Output (order may vary):**

```text
java : 2
is : 2
easy : 1
and : 1
powerful : 1
```

### Example 3: Removing Duplicate Elements

```java
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        LinkedHashSet<Integer> unique =
                new LinkedHashSet<>(numbers);

        ArrayList<Integer> result = new ArrayList<>(unique);

        System.out.println(result);
    }
}
```

**Output:**

```text
[10, 20, 30]
```

### Example 4: Browser History Using Stack

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

        Deque<String> history = new ArrayDeque<>();

        history.push("google.com");
        history.push("github.com");
        history.push("stackoverflow.com");

        System.out.println("Current Page: " + history.peek());

        history.pop();

        System.out.println("After Back: " + history.peek());
    }
}
```

**Output:**

```text
Current Page: stackoverflow.com
After Back: github.com
```

### Example 5: Employee Records Using TreeMap

```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        TreeMap<Integer, String> employees = new TreeMap<>();

        employees.put(103, "Amit");
        employees.put(101, "Ayush");
        employees.put(102, "Rahul");

        employees.forEach((id, name) ->
                System.out.println(id + " : " + name)
        );
    }
}
```

**Output:**

```text
101 : Ayush
102 : Rahul
103 : Amit
```

---

## 15. Common Mistakes in Collections

1. Assuming HashSet maintains insertion order.
2. Assuming HashMap maintains insertion order.
3. Trying to access Set elements using indexes.
4. Using `==` instead of `equals()` for object-value comparison.
5. Modifying a collection directly during fail-fast iteration.
6. Using raw collections instead of Generics.
7. Assuming Arrays.asList() creates a resizable ArrayList.
8. Using Stack instead of Deque in new code.
9. Assuming PriorityQueue iteration is sorted.
10. Forgetting that Map does not extend Collection.
11. Using mutable objects as HashMap keys without considering hashCode changes.
12. Ignoring the equals() and hashCode() contract when using custom objects in HashSet or HashMap.

### Important: remove() Overloading in ArrayList<Integer>

Consider:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.remove(1);
```

This removes the element at index 1, which is 20.

To remove the value 20:

```java
numbers.remove(Integer.valueOf(20));
```

This distinction is frequently asked in interviews.

---

## 16. Best Practices

- Use interface references where practical, such as `List<String> names = new ArrayList<>();`.
- Use Generics for type safety.
- Choose the collection according to the required operations.
- Prefer ArrayList for general-purpose list usage.
- Prefer HashSet when uniqueness matters and ordering does not.
- Prefer LinkedHashSet when uniqueness and insertion order matter.
- Prefer TreeSet when sorted unique elements are required.
- Prefer HashMap for general key-value storage.
- Prefer TreeMap when sorted keys are required.
- Prefer ArrayDeque for stack and queue operations.
- Use ConcurrentHashMap for suitable concurrent key-value operations.
- Override equals() and hashCode() consistently for custom objects used in hash-based collections.

---

## 17. Java Collections Framework Interview Questions

### Basic Questions

1. What is the Java Collections Framework?

**Answer:** The Java Collections Framework is a set of interfaces and implementations for storing, retrieving, and processing groups of objects.

2. Why do we use Collections in Java?

**Answer:** Collections provide dynamic sizing, useful implementations, type safety through generics, and common search and sort algorithms.

3. What is the difference between Collection and Collections?

**Answer:** `Collection` is a root interface for element containers; `Collections` is a utility class with static collection algorithms and wrappers.

4. What is the Collection interface?

**Answer:** The `Collection` interface defines common operations such as `add`, `remove`, `contains`, `size`, and `iterator`.

5. What is the difference between List, Set, and Queue?

**Answer:** `List` preserves order and allows duplicates, `Set` stores unique elements, and `Queue` models ordered element processing.

6. What is the difference between an array and an ArrayList?

**Answer:** Arrays have fixed length and may hold primitives or objects; `ArrayList` has dynamic capacity and stores objects through generics.

7. What is ArrayList?

**Answer:** `ArrayList` is a resizable-array `List` implementation with fast indexed access and amortized-constant-time appends.

8. What is LinkedList?

**Answer:** `LinkedList` is a doubly linked `List` and `Deque` implementation, efficient for operations at or near either end.

9. What is HashSet?

**Answer:** `HashSet` is a hash-table-based `Set` that rejects duplicate elements and does not guarantee iteration order.

10. What is HashMap?

**Answer:** `HashMap` stores key-value pairs in a hash table, provides average O(1) lookup, and allows one `null` key and multiple `null` values.

### Intermediate Questions

11. What is the difference between ArrayList and LinkedList?

**Answer:** `ArrayList` is faster for indexed access; `LinkedList` is efficient for end operations but slower for indexes and has per-node overhead.

12. What is the difference between HashSet and TreeSet?

**Answer:** `HashSet` is unordered; `TreeSet` keeps elements in natural or comparator-defined sorted order.

13. What is the difference between HashMap and LinkedHashMap?

**Answer:** `HashMap` has no iteration-order guarantee; `LinkedHashMap` maintains insertion order or access order.

14. Why does HashMap allow only one null key?

**Answer:** HashMap permits only one `null` key because key lookup requires at most one distinct key equal to `null`; later entries with that key replace its value.

15. How does HashMap work internally?

**Answer:** HashMap hashes the key, chooses a bucket, compares candidates with `hashCode()` and `equals()`, and updates or retrieves the entry; Java 8 may treeify long chains.

16. What is hashing?

**Answer:** Hashing converts an object to an integer used to select a hash-table bucket.

17. What is a hash collision?

**Answer:** A collision occurs when different keys have the same hash or bucket; hash-based classes distinguish them using `equals()`.

18. What is the difference between Iterator and ListIterator?

**Answer:** `Iterator` supports forward traversal; `ListIterator` supports bidirectional traversal and list element modification.

19. What is the difference between Comparable and Comparator?

**Answer:** `Comparable` defines natural object ordering with `compareTo()`; `Comparator` defines a separate ordering with `compare()`.

20. What is the difference between fail-fast and fail-safe terminology in collection iteration?

**Answer:** Fail-fast iterators detect concurrent structural modification and throw `ConcurrentModificationException`; fail-safe/weakly consistent views do not promise the newest state and usually do not throw it.

### Advanced Questions

21. Explain the internal working of HashMap in Java 8.

**Answer:** Java 8 HashMap uses a spread key hash to choose a bucket, compares colliding keys with `hashCode()` and `equals()`, and represents sufficiently large collision chains as red-black trees.

22. What happens when two keys have the same hash code?

**Answer:** Keys with the same hash remain in the same bucket and are distinguished with `equals()`; equal keys identify the same entry.

23. Why should equals() and hashCode() be overridden together?

**Answer:** Hash-based collections use `hashCode()` to select a bucket and `equals()` to verify equality, so equal objects must have the same hash code.

24. How does HashSet internally use HashMap?

**Answer:** `HashSet` delegates storage to a `HashMap`, using the element as a key and a constant placeholder as the value.

25. What is the load factor of HashMap?

**Answer:** The load factor is the capacity-to-entry ratio that triggers resizing; HashMap’s default is 0.75.

26. What is the default initial capacity and load factor of HashMap?

**Answer:** The default initial capacity is 16 buckets and the default load factor is 0.75.

27. What is ConcurrentHashMap?

**Answer:** `ConcurrentHashMap` is a thread-safe hash table designed for concurrent reads and updates with no whole-map read lock.

28. What is the difference between HashMap and ConcurrentHashMap?

**Answer:** `HashMap` is unsynchronized and not thread-safe; `ConcurrentHashMap` is thread-safe, more concurrent, and permits neither `null` keys nor `null` values.

29. Why is ArrayDeque preferred over Stack?

**Answer:** `ArrayDeque` is resizable-array-backed, faster and more memory-efficient than legacy `Stack`, and supports consistent double-ended operations.

30. What is the difference between synchronized collections and concurrent collections?

**Answer:** Synchronized collections apply broad method locks; concurrent collections use concurrency-aware structures and generally scale better.

---

## 18. Practice Exercises

**Note:** Try solving each exercise independently before checking the solution.

Completed solutions are available in the [Practice-Programs folder](Practice-Programs/README.md).

### Beginner Level

1. Create an ArrayList of five student names and print all names.
2. Write a Java program to add, update, and remove elements from an ArrayList.
3. Write a program to find the size of an ArrayList.
4. Write a program to check whether a particular element exists in an ArrayList.
5. Create a LinkedList and insert elements at the beginning and end.
6. Write a program to remove duplicate elements using HashSet.
7. Create a LinkedHashSet and demonstrate insertion order.
8. Create a TreeSet and display elements in sorted order.
9. Create a HashMap to store student IDs and names.
10. Write a program to retrieve a value from a HashMap using its key.

### Intermediate Level

11. Write a program to sort an ArrayList in ascending order.
12. Write a program to sort an ArrayList in descending order.
13. Write a program to find the second-largest element in an ArrayList.
14. Write a program to find the frequency of each element in an ArrayList.
15. Write a program to count the frequency of words in a sentence using HashMap.
16. Write a program to remove all even numbers from an ArrayList.
17. Write a program to merge two ArrayLists.
18. Write a program to find common elements between two ArrayLists.
19. Write a program to convert an array into an ArrayList.
20. Write a program to traverse a LinkedList using Iterator and ListIterator.

### Advanced Level

21. Create a Student class and sort students using Comparable based on marks.
22. Create a Student class and sort students using Comparator based on names.
23. Implement a stack using ArrayDeque.
24. Implement a queue using LinkedList.
25. Implement a priority queue to process tasks based on priority.
26. Create a word-frequency counter using HashMap.
27. Create an employee management system using ArrayList and HashMap.
28. Implement a simple browser history system using Deque.
29. Implement an LRU cache using LinkedHashMap.
30. Create a custom class and use its objects as keys in a HashMap by correctly implementing equals() and hashCode().

---

## 19. Chapter Summary

In this chapter, you learned:

- Introduction to Java Collections Framework.
- Collection vs Collections.
- Collections Framework hierarchy.
- List, Set, Queue, and Map.
- ArrayList, LinkedList, Vector, and Stack.
- HashSet, LinkedHashSet, and TreeSet.
- Queue and PriorityQueue.
- HashMap, LinkedHashMap, and TreeMap.
- Iterator and ListIterator.
- Comparable and Comparator.
- Generics.
- Java 8 Collection features.
- Array and Collection conversions.
- Real-world applications and interview questions.

### Key Takeaways

| Requirement | Recommended Collection |
|---|---|
| Dynamic list | ArrayList |
| Frequent operations at both ends | LinkedList or ArrayDeque |
| Unique elements | HashSet |
| Unique elements in insertion order | LinkedHashSet |
| Unique sorted elements | TreeSet |
| Key-value storage | HashMap |
| Key-value storage in insertion order | LinkedHashMap |
| Key-value storage with sorted keys | TreeMap |
| Stack operations | ArrayDeque |
| Priority-based processing | PriorityQueue |

---

## Next Chapter: Chapter 11 – Java 8 Features

In the next chapter, we will explore:

1. Introduction to Java 8.
2. Lambda Expressions.
3. Functional Interfaces.
4. Predicate, Function, Consumer, and Supplier.
5. Method References.
6. Stream API.
7. Filter, Map, Sorted, and Reduce.
8. Optional Class.
9. Default and Static Methods in Interfaces.
10. Date and Time API.
11. Collectors and grouping operations.
12. Practical Java 8 programs.
13. Interview questions and practice exercises.

**Keep practicing every concept by writing and executing the programs yourself. Understanding when and why to choose a particular collection is just as important as knowing its methods.**
