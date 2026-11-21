# Chapter 6: Object-Oriented Programming (OOP) in Java

## 1. Introduction to Object-Oriented Programming

Object-Oriented Programming (OOP) is a programming approach in which we organize programs around objects rather than writing everything as separate instructions.

An object represents something that has:
- **State:** Data or properties of an object.
- **Behavior:** Actions that an object can perform.
- **Identity:** A unique identity that distinguishes one object from another.

For example, consider a Car.

**State:**
- Brand
- Color
- Model
- Speed

**Behavior:**
- Start
- Stop
- Accelerate
- Brake

In Java, we use classes to define the structure and behavior of objects.

### Why do we need OOP?

Imagine developing a banking application. It may contain customers, accounts, transactions, employees, and branches.

Without proper organization, managing all this information and functionality can become difficult.

OOP helps us organize the application into meaningful classes and objects.

### Advantages of OOP

1. **Code Reusability:** Existing classes can be reused through inheritance and composition.
2. **Modularity:** Programs can be divided into separate classes.
3. **Data Security:** Encapsulation helps control access to data.
4. **Maintainability:** Changes can be managed more easily.
5. **Flexibility:** Polymorphism allows different implementations through common interfaces.
6. **Scalability:** OOP helps organize large applications.

### Four Pillars of OOP

The four main principles of OOP are:

1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

---

## 2. Class in Java

A class is a blueprint or template used to create objects.

It defines the properties (variables) and behaviors (methods) that objects of that class can have.

### Syntax

```java
class ClassName {

    // Variables

    // Constructors

    // Methods

}
```

### Example: Student Class

```java
public class Student {

    String name;

    int age;

    void study() {

        System.out.println(name + " is studying.");

    }

    void displayDetails() {

        System.out.println("Name: " + name);

        System.out.println("Age: " + age);

    }

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = "Ayush";

        s1.age = 22;

        s1.displayDetails();

        s1.study();

    }
}
```

**Output:**

```text
Name: Ayush
Age: 22
Ayush is studying.
```

**Explanation:**

- `Student` is the class.
- `name` and `age` are instance variables.
- `study()` and `displayDetails()` are methods.
- `s1` is a reference variable that refers to the created object.

---

## 3. Object in Java

An object is an instance of a class.

When an object is created, memory is allocated for its instance variables.

### Syntax

```java
ClassName referenceVariable = new ClassName();
```

For example:

```java
Student s1 = new Student();
```

This statement has three parts:

| Part | Meaning |
|---|---|
| `Student` | Class or reference type |
| `s1` | Reference variable |
| `new Student()` | Creates an object by invoking a constructor |

### Creating Multiple Objects

```java
public class Employee {

    String name;

    int salary;

    public static void main(String[] args) {

        Employee e1 = new Employee();

        Employee e2 = new Employee();

        e1.name = "Rahul";

        e1.salary = 30000;

        e2.name = "Amit";

        e2.salary = 40000;

        System.out.println(e1.name + " " + e1.salary);

        System.out.println(e2.name + " " + e2.salary);

    }
}
```

**Output:**

```text
Rahul 30000
Amit 40000
```

Each object has its own copy of instance variables.

### Class vs Object

| Class | Object |
|---|---|
| Blueprint or template | Instance of a class |
| Defines properties and behaviors | Contains actual instance data |
| Logical definition | Runtime entity |
| One class can create multiple objects | Each object has its own identity |

---

# 4. Encapsulation in Java

Encapsulation is the process of combining data and the methods that operate on that data into a single unit (class), while controlling direct access to the internal data.

In Java, encapsulation is commonly implemented using:

1. Private instance variables.
2. Public getter methods.
3. Public setter methods.

### Why is Encapsulation Important?

Consider a bank account.

If anyone can directly modify the account balance, the application may allow invalid operations.

For example:

```java
account.balance = -50000;
```

This is not desirable.

Encapsulation allows us to control how the balance is accessed and modified.

### Example: Encapsulation

```java
public class BankAccount {

    private String accountHolder;

    private double balance;

    public void setAccountHolder(String accountHolder) {

        this.accountHolder = accountHolder;

    }

    public String getAccountHolder() {

        return accountHolder;

    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            System.out.println("Deposit successful.");

        } else {

            System.out.println("Invalid amount.");

        }

    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println("Invalid amount or insufficient balance.");

        }

    }

    public double getBalance() {

        return balance;

    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.setAccountHolder("Ayush");

        account.deposit(5000);

        account.withdraw(1000);

        System.out.println("Account Holder: " +
            account.getAccountHolder());

        System.out.println("Balance: " + account.getBalance());

    }
}
```

**Output:**

```text
Deposit successful.
Withdrawal successful.
Account Holder: Ayush
Balance: 4000.0
```

### Understanding Getters and Setters

**Getter:** A method used to retrieve the value of a private variable.

```java
public double getBalance() {

    return balance;

}
```

**Setter:** A method used to update the value of a private variable, usually with validation.

```java
public void setAge(int age) {

    if (age > 0) {

        this.age = age;

    }

}
```

### Advantages of Encapsulation

- Protects internal data from uncontrolled access.
- Allows validation before changing values.
- Makes code easier to maintain.
- Gives control over how data is accessed.
- Reduces unwanted dependencies between classes.

**Important:** Encapsulation is not simply making every variable private. It is about controlling access to an object's internal state through a well-designed public interface.

---

# 5. Inheritance in Java

Inheritance is an OOP concept in which one class acquires accessible properties and behaviors from another class.

It helps us reuse existing code and create relationships between classes.

For example:

- Animal is a parent class.
- Dog is a child class.
- Dog can use accessible methods inherited from Animal.

### Important Terminology

| Term | Meaning |
|---|---|
| Parent class | Class whose members are inherited |
| Child class | Class that extends another class |
| Superclass | Another name for parent class |
| Subclass | Another name for child class |
| `extends` | Keyword used for class inheritance |

### Syntax

```java
class Parent {

    // Parent class members

}

class Child extends Parent {

    // Child class members

}
```

### Example: Single Inheritance

```java
class Animal {

    void eat() {

        System.out.println("Animal is eating.");

    }

}

class Dog extends Animal {

    void bark() {

        System.out.println("Dog is barking.");

    }

}

public class SingleInheritance {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();

        d.bark();

    }
}
```

**Output:**

```text
Animal is eating.
Dog is barking.
```

**Explanation:**

- `Animal` is the parent class.
- `Dog` is the child class.
- `Dog extends Animal` establishes inheritance.
- The Dog object can call the accessible `eat()` method inherited from Animal.

## 5.1 Types of Inheritance in Java

Inheritance is commonly explained using five structures.

### A. Single Inheritance

One child class inherits from one parent class.

<pre>
       Animal
          |
          v
         Dog
</pre>

```java
class Animal {

    void eat() {

        System.out.println("Eating...");

    }

}

class Dog extends Animal {

    void bark() {

        System.out.println("Barking...");

    }

}
```

### B. Multilevel Inheritance

A class inherits from another child class, creating a chain.

<pre>
       Animal
          |
          v
        Mammal
          |
          v
         Dog
</pre>

```java
class Animal {

    void eat() {

        System.out.println("Eating...");

    }

}

class Mammal extends Animal {

    void walk() {

        System.out.println("Walking...");

    }

}

class Dog extends Mammal {

    void bark() {

        System.out.println("Barking...");

    }

}
```

```java
public class MultilevelInheritance {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();

        d.walk();

        d.bark();

    }
}
```

**Output:**

```text
Eating...
Walking...
Barking...
```

### C. Hierarchical Inheritance

Multiple child classes inherit from the same parent class.

<pre>
          Animal
         /      \
        v        v
       Dog      Cat
</pre>

```java
class Animal {

    void eat() {

        System.out.println("Animal is eating.");

    }

}

class Dog extends Animal {

    void bark() {

        System.out.println("Dog is barking.");

    }

}

class Cat extends Animal {

    void meow() {

        System.out.println("Cat is meowing.");

    }

}
```

### D. Multiple Inheritance

Multiple inheritance means one class inherits from more than one parent class.

Java does not support multiple inheritance through classes.

For example, this is not valid Java:

```java
class A {

}

class B {

}

// Not valid Java
class C extends A, B {

}
```

However, Java supports multiple inheritance of type through interfaces.

### E. Hybrid Inheritance

Hybrid inheritance combines two or more inheritance structures.

Java does not support hybrid inheritance through classes alone, but it can be achieved using interfaces.

### Quick Comparison

| Inheritance type | Supported in Java? |
|---|---|
| Single | Yes, using classes |
| Multilevel | Yes, using classes |
| Hierarchical | Yes, using classes |
| Multiple | Through interfaces, not multiple classes |
| Hybrid | Can be achieved using interfaces |

---

# 6. The `super` Keyword in Java

The `super` keyword refers to the immediate parent class object.

It is commonly used to:

1. Access parent class variables.
2. Call parent class methods.
3. Call parent class constructors.

### 6.1 Access Parent Class Variables

```java
class Parent {

    int number = 100;

}

class Child extends Parent {

    int number = 200;

    void display() {

        System.out.println(number);

        System.out.println(super.number);

    }

}

public class SuperVariable {

    public static void main(String[] args) {

        Child obj = new Child();

        obj.display();

    }
}
```

**Output:**

```text
200
100
```

Here:
- `number` accesses the child class variable.
- `super.number` accesses the parent class variable.

### 6.2 Call Parent Class Method

```java
class Parent {

    void display() {

        System.out.println("Parent method.");

    }

}

class Child extends Parent {

    void display() {

        System.out.println("Child method.");

        super.display();

    }

}

public class SuperMethod {

    public static void main(String[] args) {

        Child obj = new Child();

        obj.display();

    }
}
```

**Output:**

```text
Child method.
Parent method.
```

### 6.3 Call Parent Class Constructor

```java
class Parent {

    Parent() {

        System.out.println("Parent constructor.");

    }

}

class Child extends Parent {

    Child() {

        super();

        System.out.println("Child constructor.");

    }

}

public class SuperConstructor {

    public static void main(String[] args) {

        Child obj = new Child();

    }
}
```

**Output:**

```text
Parent constructor.
Child constructor.
```

**Important Rules:**

- `super()` calls a parent class constructor.
- An explicit `super()` call must be the first statement in a constructor.
- If no explicit constructor invocation is written, Java normally inserts an implicit `super()` call when applicable.
- A child constructor cannot use both `this()` and `super()` as explicit constructor invocations.

---

# 7. Polymorphism in Java

Polymorphism means "many forms."

In Java, polymorphism allows the same method name or reference type to represent different behaviors depending on the context.

For example, a method named `sound()` can behave differently for a Dog, Cat, and Cow.

Java supports two commonly discussed forms of polymorphism:

1. Compile-time polymorphism.
2. Runtime polymorphism.

## 7.1 Compile-Time Polymorphism

Compile-time polymorphism is commonly achieved through method overloading.

The compiler determines which overloaded method should be called based on the arguments.

```java
public class CompileTimePolymorphism {

    int add(int a, int b) {

        return a + b;

    }

    int add(int a, int b, int c) {

        return a + b + c;

    }

    public static void main(String[] args) {

        CompileTimePolymorphism obj =
            new CompileTimePolymorphism();

        System.out.println(obj.add(10, 20));

        System.out.println(obj.add(10, 20, 30));

    }
}
```

**Output:**

```text
30
60
```

## 7.2 Runtime Polymorphism

Runtime polymorphism is achieved through method overriding.

When a subclass provides its own implementation of an inherited instance method, the JVM determines which implementation to execute based on the actual object.

### Example: Method Overriding

```java
class Animal {

    void sound() {

        System.out.println("Animal makes a sound.");

    }

}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks.");

    }

}

class Cat extends Animal {

    @Override
    void sound() {

        System.out.println("Cat meows.");

    }

}

public class RuntimePolymorphism {

    public static void main(String[] args) {

        Animal a;

        a = new Dog();

        a.sound();

        a = new Cat();

        a.sound();

    }
}
```

**Output:**

```text
Dog barks.
Cat meows.
```

### Understanding the Example

```java
Animal a = new Dog();
```

Here:
- `Animal` is the reference type.
- `Dog` is the actual object type.
- The reference can access members available through the Animal type.
- The overridden instance method implementation is selected according to the actual object.

This behavior is called **dynamic method dispatch**.

## 7.3 Method Overloading vs Method Overriding

| Method Overloading | Method Overriding |
|---|---|
| Same method name with different parameter lists | Subclass provides a new implementation of an inherited method |
| Usually happens within the same class | Happens between parent and child classes |
| Compile-time polymorphism | Runtime polymorphism |
| Return type alone cannot distinguish overloaded methods | Return type must be compatible with the overridden method |
| Inheritance is not required | Inheritance is required |

### Important Rules of Method Overriding

1. The method must be inherited and eligible for overriding.
2. The method name and parameter list must match.
3. The return type must be the same or covariant.
4. Access visibility cannot be reduced.
5. A final method cannot be overridden.
6. A private method is not overridden because it is not inherited.
7. Static methods are hidden, not overridden in the runtime-polymorphism sense.
8. The `@Override` annotation helps the compiler verify the intended override.

---

# 8. Abstraction in Java

Abstraction means hiding unnecessary implementation details and exposing only the essential functionality.

Consider an ATM machine.

When you withdraw money, you interact with buttons and the screen. You do not need to understand all the internal banking operations.

The ATM provides a simple interface while hiding its internal implementation.

Java provides two major ways to achieve abstraction:

1. Abstract classes.
2. Interfaces.

## 8.1 Abstract Class

An abstract class is a class declared using the `abstract` keyword.

It cannot be instantiated directly.

It can contain:
- Abstract methods.
- Concrete methods.
- Instance variables.
- Constructors.
- Static methods.

### Syntax

```java
abstract class ClassName {

    abstract void methodName();

    void display() {

        System.out.println("Concrete method.");

    }

}
```

### Example: Abstract Class

```java
abstract class Animal {

    abstract void sound();

    void eat() {

        System.out.println("Animal is eating.");

    }

}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks.");

    }

}

public class AbstractClassExample {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound();

        d.eat();

    }
}
```

**Output:**

```text
Dog barks.
Animal is eating.
```

**Explanation:**

- `Animal` is an abstract class.
- `sound()` is an abstract method.
- `eat()` is a concrete method.
- `Dog` provides an implementation of `sound()`.
- We cannot create an object directly using `new Animal()`.

## 8.2 Interface in Java

An interface is a reference type that defines a contract for classes.

A class implements an interface and provides implementations for its abstract methods.

### Syntax

```java
interface InterfaceName {

    void methodName();

}

class ClassName implements InterfaceName {

    public void methodName() {

        // Implementation

    }

}
```

### Example: Interface

```java
interface Vehicle {

    void start();

    void stop();

}

class Car implements Vehicle {

    @Override
    public void start() {

        System.out.println("Car started.");

    }

    @Override
    public void stop() {

        System.out.println("Car stopped.");

    }

}

public class InterfaceExample {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();

        car.stop();

    }
}
```

**Output:**

```text
Car started.
Car stopped.
```

### Important Interface Features in Java 8

An interface can contain:

1. Abstract methods.
2. Default methods.
3. Static methods.
4. Constants.

Interface fields are implicitly `public static final`.

Methods declared without `private`, `static`, or `default` modifiers are implicitly public and abstract.

### Default Method in Java 8

A default method contains an implementation and is declared using the `default` keyword.

```java
interface Vehicle {

    void start();

    default void fuelType() {

        System.out.println("Vehicle fuel information.");

    }

}

class Car implements Vehicle {

    public void start() {

        System.out.println("Car started.");

    }

}

public class DefaultMethodExample {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();

        car.fuelType();

    }
}
```

**Output:**

```text
Car started.
Vehicle fuel information.
```

### Static Method in Interface

Java 8 also allows static methods inside interfaces.

```java
interface Calculator {

    static int add(int a, int b) {

        return a + b;

    }

}

public class InterfaceStaticMethod {

    public static void main(String[] args) {

        System.out.println(Calculator.add(10, 20));

    }
}
```

**Output:**

```text
30
```

The static method is called using the interface name.

---

# 9. Abstract Class vs Interface

| Abstract Class | Interface |
|---|---|
| Declared using `abstract class` | Declared using `interface` |
| A class extends an abstract class | A class implements an interface |
| Can have instance variables | Fields are implicitly `public static final` |
| Can have constructors | Cannot have constructors |
| Can contain abstract and concrete methods | Java 8 supports abstract, default, and static methods |
| A class can extend only one class | A class can implement multiple interfaces |
| Can maintain instance state | Does not have per-object instance fields |

### When Should You Use an Abstract Class?

Use an abstract class when related classes share common state, constructors, and implementation.

Example: `Animal`, `Vehicle`, `Employee`.

### When Should You Use an Interface?

Use an interface when you want to define a capability or contract that different classes can implement.

Example: `Runnable`, `Comparable`, `Serializable`.

---

# 10. Multiple Inheritance Using Interfaces

Java does not allow a class to extend multiple classes, but it allows a class to implement multiple interfaces.

### Example

```java
interface Camera {

    void takePhoto();

}

interface MusicPlayer {

    void playMusic();

}

class Smartphone implements Camera, MusicPlayer {

    public void takePhoto() {

        System.out.println("Taking photo.");

    }

    public void playMusic() {

        System.out.println("Playing music.");

    }

}

public class MultipleInheritance {

    public static void main(String[] args) {

        Smartphone phone = new Smartphone();

        phone.takePhoto();

        phone.playMusic();

    }
}
```

**Output:**

```text
Taking photo.
Playing music.
```

This demonstrates multiple inheritance of type through interfaces.

### What Happens When Two Interfaces Have the Same Default Method?

If a class implements two interfaces containing conflicting default methods with the same signature, the class must resolve the conflict by overriding that method.

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

class C implements A, B {

    @Override
    public void display() {

        A.super.display();

        B.super.display();

    }

}
```

---

# 11. Association, Aggregation, and Composition

These concepts describe relationships between objects.

## 11.1 Association

Association represents a relationship between two independent objects.

Example: A teacher teaches students.

A teacher and a student can exist independently.

```java
class Teacher {

    String name;

    Teacher(String name) {

        this.name = name;

    }

}

class Student {

    String name;

    Student(String name) {

        this.name = name;

    }

}

public class AssociationExample {

    public static void main(String[] args) {

        Teacher teacher = new Teacher("Mr. Sharma");

        Student student = new Student("Ayush");

        System.out.println(teacher.name + " teaches " + student.name);

    }
}
```

**Output:**

```text
Mr. Sharma teaches Ayush
```

## 11.2 Aggregation

Aggregation is a specialized form of association representing a weak whole-part relationship.

The contained object can exist independently of the container.

Example: A Department has Teachers.

Teachers can exist even if the Department object is removed.

```java
class Teacher {

    String name;

    Teacher(String name) {

        this.name = name;

    }

}

class Department {

    String departmentName;

    Teacher teacher;

    Department(String departmentName, Teacher teacher) {

        this.departmentName = departmentName;

        this.teacher = teacher;

    }

    void display() {

        System.out.println(departmentName);

        System.out.println(teacher.name);

    }

}

public class AggregationExample {

    public static void main(String[] args) {

        Teacher t1 = new Teacher("Mr. Sharma");

        Department d1 = new Department("Computer Science", t1);

        d1.display();

    }
}
```

**Output:**

```text
Computer Science
Mr. Sharma
```

## 11.3 Composition

Composition is a stronger whole-part relationship.

The containing object controls the lifecycle of its contained parts as part of its design.

Example: A House contains Rooms.

```java
class Room {

    void display() {

        System.out.println("Room exists inside the house.");

    }

}

class House {

    private Room room;

    House() {

        room = new Room();

    }

    void display() {

        room.display();

    }

}

public class CompositionExample {

    public static void main(String[] args) {

        House house = new House();

        house.display();

    }
}
```

**Output:**

```text
Room exists inside the house.
```

### Association vs Aggregation vs Composition

| Association | Aggregation | Composition |
|---|---|---|
| General relationship | Weak whole-part relationship | Strong whole-part relationship |
| Objects are independent | Part can exist independently | Part lifecycle is controlled by the whole |
| Example: Teacher and Student | Department and Teacher | House and Room |

**Important:** These relationships describe design and ownership. Java does not automatically enforce aggregation or composition through special keywords.

---

# 12. Access Modifiers in Java

Access modifiers control the visibility of classes, variables, constructors, and methods.

Java provides four access levels:

1. `public`
2. `protected`
3. Default (package-private)
4. `private`

### Access Modifier Comparison

| Access modifier | Same class | Same package | Subclass in another package | Other package |
|---|---|---|---|---|
| `public` | Yes | Yes | Yes | Yes |
| `protected` | Yes | Yes | Yes, through inheritance rules | No, except eligible subclass access |
| Default | Yes | Yes | No | No |
| `private` | Yes | No | No | No |

### Example

```java
public class AccessModifierExample {

    public int a = 10;

    protected int b = 20;

    int c = 30;

    private int d = 40;

    public void display() {

        System.out.println(a);

        System.out.println(b);

        System.out.println(c);

        System.out.println(d);

    }

    public static void main(String[] args) {

        AccessModifierExample obj =
            new AccessModifierExample();

        obj.display();

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

**Note:** A top-level class can be declared `public` or package-private, not `private` or `protected`.

---

# 13. The `final` Keyword in Java

The `final` keyword is used to restrict modification.

It can be applied to variables, methods, and classes.

## 13.1 Final Variable

A final variable can be assigned only once.

```java
public class FinalVariable {

    public static void main(String[] args) {

        final int MAX = 100;

        System.out.println(MAX);

    }
}
```

**Output:**

```text
100
```

Trying to assign another value to `MAX` will cause a compilation error.

## 13.2 Final Method

A final method cannot be overridden by a subclass.

```java
class Parent {

    final void display() {

        System.out.println("Parent method.");

    }

}

class Child extends Parent {

    // Cannot override display()

}
```

## 13.3 Final Class

A final class cannot be extended.

```java
final class Vehicle {

    void start() {

        System.out.println("Vehicle started.");

    }

}

// Cannot extend Vehicle
```

### Final vs Finally vs Finalize

| Keyword | Purpose |
|---|---|
| `final` | Restricts reassignment, overriding, or inheritance depending on usage |
| `finally` | Exception-handling block that normally executes after try/catch processing |
| `finalize()` | Deprecated object-finalization method in modern Java; not a reliable resource-management mechanism |

---

# 14. Real-World OOP Example: Employee Management System

This example combines classes, objects, encapsulation, inheritance, and method overriding.

```java
class Employee {

    private int id;

    private String name;

    protected double salary;

    Employee(int id, String name, double salary) {

        this.id = id;

        this.name = name;

        this.salary = salary;

    }

    public void displayDetails() {

        System.out.println("Employee ID: " + id);

        System.out.println("Name: " + name);

        System.out.println("Salary: " + salary);

    }

    public double calculateBonus() {

        return salary * 0.05;

    }

}

class Manager extends Employee {

    Manager(int id, String name, double salary) {

        super(id, name, salary);

    }

    @Override
    public double calculateBonus() {

        return salary * 0.15;

    }

}

public class EmployeeManagement {

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Rahul", 30000);

        Manager m1 = new Manager(102, "Ayush", 50000);

        e1.displayDetails();

        System.out.println("Bonus: " + e1.calculateBonus());

        System.out.println();

        m1.displayDetails();

        System.out.println("Bonus: " + m1.calculateBonus());

    }
}
```

**Output:**

```text
Employee ID: 101
Name: Rahul
Salary: 30000.0
Bonus: 1500.0

Employee ID: 102
Name: Ayush
Salary: 50000.0
Bonus: 7500.0
```

### OOP Concepts Used

- **Class:** Employee and Manager.
- **Object:** e1 and m1.
- **Encapsulation:** Private employee ID and name.
- **Inheritance:** Manager extends Employee.
- **Polymorphism:** Manager overrides calculateBonus().
- **Abstraction:** This example does not use an abstract class or interface.

---

# 15. Common Mistakes in OOP

| Mistake | Explanation |
|---|---|
| Confusing class and object | A class is a blueprint; an object is an instance |
| Making all fields public | Can expose internal state without control |
| Assuming Java supports multiple class inheritance | A class can extend only one class |
| Confusing overloading and overriding | Overloading changes parameter lists; overriding redefines an inherited method |
| Trying to instantiate an abstract class | Abstract classes cannot be directly instantiated |
| Forgetting public when implementing interface methods | Implementations of public interface methods must be public |
| Using `super()` after another constructor statement | An explicit `super()` invocation must be first |
| Assuming private methods are overridden | Private methods are not inherited |
| Assuming static methods are overridden | Static methods are hidden |
| Confusing aggregation and composition | Their difference concerns ownership and lifecycle |

---

# 16. OOP Interview Questions

## Basic Questions

**Q1. What is OOP in Java?**

OOP is a programming approach that organizes programs around classes and objects.

**Q2. What is a class?**

A class is a blueprint that defines the properties and behaviors of objects.

**Q3. What is an object?**

An object is an instance of a class that has state, behavior, and identity.

**Q4. What are the four pillars of OOP?**

Encapsulation, inheritance, polymorphism, and abstraction.

**Q5. What is encapsulation?**

Encapsulation combines data and related methods into a class and controls access to internal data.

**Q6. What is inheritance?**

Inheritance allows a subclass to acquire accessible members from a superclass.

**Q7. What is polymorphism?**

Polymorphism allows one interface or method name to represent different behaviors.

**Q8. What is abstraction?**

Abstraction hides implementation details and exposes essential functionality.

## Intermediate Questions

**Q9. What is the difference between an abstract class and an interface?**

An abstract class can maintain instance state and constructors. An interface defines a contract and, in Java 8, supports abstract, default, and static methods.

**Q10. Does Java support multiple inheritance?**

Java does not support multiple inheritance through classes, but a class can implement multiple interfaces.

**Q11. What is method overriding?**

Method overriding occurs when a subclass provides a compatible implementation of an inherited instance method.

**Q12. What is dynamic method dispatch?**

It is the mechanism through which an overridden instance method is selected at runtime based on the actual object.

**Q13. What is the use of `super`?**

It is used to access parent class members and invoke a parent class constructor.

**Q14. What is the use of `this`?**

It refers to the current object and can be used to access its members or invoke another constructor.

**Q15. Can an abstract class have a constructor?**

Yes. Its constructor is invoked as part of subclass object construction.

**Q16. Can an interface have a constructor?**

No. Interfaces cannot be instantiated and do not have constructors.

**Q17. Can a final class be inherited?**

No. A final class cannot be extended.

**Q18. What is the difference between aggregation and composition?**

Aggregation is a weak whole-part relationship in which parts can exist independently. Composition represents stronger ownership and lifecycle dependency.

**Q19. Can a constructor be overridden?**

No. Constructors are not inherited, so they cannot be overridden.

**Q20. Why is encapsulation important?**

It protects internal data and provides controlled access through methods.

---

# 17. Practice Exercises

**Instructions:** Solve these questions independently. Do not skip the practical exercises. Create separate Java files and test your programs with different inputs.

## Beginner Level

1. Create a Student class with name, roll number, and age. Create two objects and display their details.
2. Create a Car class with brand, model, and color. Add methods to start and stop the car.
3. Create an Employee class with employee ID, name, and salary.
4. Create a Rectangle class with methods to calculate area and perimeter.
5. Create a BankAccount class with private account number and balance. Implement getter and setter methods with suitable validation.
6. Create a Person class with a parameterized constructor to initialize name and age.
7. Create a class demonstrating the use of the `this` keyword.
8. Create a class demonstrating the difference between static and instance variables.
9. Create a class demonstrating constructor overloading.
10. Create a class demonstrating the use of the `final` keyword.

## Intermediate Level

11. Create a program demonstrating single inheritance using Animal and Dog classes.
12. Create a program demonstrating multilevel inheritance using Person, Employee, and Manager classes.
13. Create a program demonstrating hierarchical inheritance using Vehicle, Car, and Bike classes.
14. Create a program demonstrating method overriding using a parent and child class.
15. Create a program demonstrating runtime polymorphism using Animal, Dog, and Cat classes.
16. Create a Calculator class demonstrating compile-time polymorphism through method overloading.
17. Create an abstract Shape class with abstract methods for calculating area and perimeter. Implement Circle and Rectangle subclasses.
18. Create an interface Payment with a payment method. Implement it using CreditCardPayment and UPIPayment classes.
19. Create a program demonstrating multiple inheritance through interfaces.
20. Create a program demonstrating the use of the `super` keyword for variables, methods, and constructors.

## Advanced Level

21. Design a Banking Management System using encapsulation, inheritance, and polymorphism.
22. Design an Employee Management System with different employee types and salary calculations.
23. Create a Library Management System using classes for Book, Member, and Library.
24. Create a Vehicle Rental System using abstraction and inheritance.
25. Create an Online Shopping System using Product, Customer, Cart, and Order classes.
26. Create a Hospital Management System using inheritance and encapsulation.
27. Create a Payment Gateway design using interfaces and runtime polymorphism.
28. Demonstrate association, aggregation, and composition using separate Java programs.
29. Design a Shape Management System that calculates areas of different shapes using runtime polymorphism.
30. Build a complete Student Management System using the four pillars of OOP.

---

# 19. Key Takeaways

After completing this chapter, you should understand:

- What object-oriented programming is and why Java uses it.
- The difference between classes and objects.
- How encapsulation protects internal data.
- How inheritance supports code reuse.
- The different inheritance structures supported by Java.
- How to use `this` and `super`.
- The difference between method overloading and overriding.
- Compile-time and runtime polymorphism.
- How abstract classes and interfaces work.
- Java 8 interface features, including default and static methods.
- The difference between association, aggregation, and composition.
- Access modifiers and the `final` keyword.
- How to design practical applications using OOP concepts.

## What's Next?

**Chapter 7: Java Arrays**

Topics to explore:

1. Introduction to Arrays.
2. Declaration and Initialization.
3. One-Dimensional Arrays.
4. Two-Dimensional Arrays.
5. Multidimensional Arrays.
6. Array Traversal.
7. Searching and Sorting.
8. Common Array Programs.
9. Arrays Interview Questions.
10. Practice Exercises.

**Learning Tip:** Don't just memorize the four pillars of OOP. Try to identify where each principle is used in real applications such as banking systems, shopping apps, employee management systems, and payment gateways.