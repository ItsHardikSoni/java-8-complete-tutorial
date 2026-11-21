# Chapter 12: Multithreading and Concurrency in Java

**Navigation:** [Main Tutorial Index](../README.md) | [Practice Programs](Practice-Programs/) | [Previous: Java 8 Features](../11-Java-8-Features/README.md) | [Next: JDBC](../13-Java-JDBC/README.md)

## 1. Introduction to Multithreading

Multithreading is a Java feature that allows multiple threads to execute within a single process.

A **thread** is the smallest unit of execution managed by the operating system or Java runtime.

A Java application can have multiple threads running concurrently to perform different tasks.

### Real-world examples

Consider a mobile application:

- One thread handles user interactions.
- Another thread loads images.
- Another thread communicates with the server.
- Another thread processes background data.

These activities can happen concurrently without requiring one task to finish before another begins.

### What is a Process?

A process is an executing instance of a program.

Examples:
- Running a web browser.
- Running a Java application.
- Running a music player.

### What is a Thread?

A thread is an execution path within a process.

A process can contain multiple threads that share the process's memory and resources.

### Process vs Thread

| Process | Thread |
|---|---|
| An independent executing program | An execution unit within a process |
| Has its own address space | Shares process memory with other threads |
| Generally higher creation overhead | Generally lower creation overhead |
| Communication can require IPC | Threads can communicate through shared memory |
| Failure is often isolated by process boundaries | An uncaught failure can affect the process, depending on the thread and application |

### Multitasking vs Multithreading

**Multitasking:** Running multiple processes or tasks at the same time.

**Multithreading:** Running multiple threads within a single process.

---

## 2. Why Do We Need Multithreading?

Without multithreading, a program may execute one task at a time.

Consider an application that performs three tasks:

1. Download a file.
2. Process data.
3. Display results.

If these tasks run sequentially, the user may have to wait for each task to finish.

With multithreading, independent tasks can execute concurrently.

### Advantages

1. Improves application responsiveness.
2. Makes it possible to perform multiple tasks concurrently.
3. Can improve CPU utilization for suitable workloads.
4. Supports background processing.
5. Helps build scalable server applications.
6. Enables asynchronous task execution.

### Disadvantages

1. Debugging becomes more difficult.
2. Race conditions may occur.
3. Deadlocks may occur.
4. Synchronization introduces complexity.
5. Excessive thread creation can reduce performance.

---

## 3. Thread Life Cycle in Java

A thread has different states during its execution.

Java defines six thread states through the `Thread.State` enum.

### Thread Life Cycle Diagram

```text
              NEW
               |
            start()
               |
               v
             RUNNABLE
               |
        Selected by scheduler
               |
               v
            RUNNING
               |
       +-------+--------+
       |                |
       v                v
    BLOCKED           WAITING
       |                |
       +-------+--------+
               |
               v
           RUNNABLE

       RUNNING
          |
          v
  TIMED_WAITING
          |
          v
      RUNNABLE

       RUNNING
          |
       run() ends
          |
          v
      TERMINATED
```

**Important:** Java's official `Thread.State` enum has six states:

| State | Description |
|---|---|
| NEW | Thread is created but not started |
| RUNNABLE | Thread is eligible to run or is running |
| BLOCKED | Waiting to acquire a monitor lock |
| WAITING | Waiting indefinitely for another thread's action |
| TIMED_WAITING | Waiting for a specified period |
| TERMINATED | Thread has completed execution |

Java does not define a separate `RUNNING` state in `Thread.State`; running is included in RUNNABLE.

### Example: Checking Thread State

```java
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });

        System.out.println("Before start: " + thread.getState());

        thread.start();

        thread.join();

        System.out.println("After completion: " + thread.getState());
    }
}
```

**Output:**

```text
Before start: NEW
Thread is running
After completion: TERMINATED
```

---

## 4. Creating Threads in Java

Java provides two commonly taught approaches to creating a thread:

1. Extending the Thread class.
2. Implementing the Runnable interface.

### 4.1 Creating a Thread by Extending Thread Class

The `Thread` class represents a thread of execution.

To create a thread:

1. Extend the Thread class.
2. Override the run() method.
3. Create an object of the class.
4. Call start().

### Example

```java
class MyThread extends Thread {

    public void run() {
        System.out.println("Thread is executing");
    }
}

public class Main {
    public static void main(String[] args) {

        MyThread thread = new MyThread();

        thread.start();
    }
}
```

**Output:**

```text
Thread is executing
```

### Explanation

- `extends Thread` inherits thread functionality.
- `run()` contains the task.
- `start()` requests the JVM to start a new thread.
- The new thread executes `run()`.

### 4.2 Creating a Thread Using Runnable Interface

Runnable is a Functional Interface.

It contains one abstract method:

```java
void run();
```

### Example

```java
class MyTask implements Runnable {

    public void run() {
        System.out.println("Runnable thread is executing");
    }
}

public class Main {
    public static void main(String[] args) {

        MyTask task = new MyTask();

        Thread thread = new Thread(task);

        thread.start();
    }
}
```

**Output:**

```text
Runnable thread is executing
```

### 4.3 Creating a Thread Using Lambda Expression

Since Runnable is a Functional Interface, Java 8 allows Lambda Expressions.

```java
public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Thread created using Lambda");
        });

        thread.start();
    }
}
```

**Output:**

```text
Thread created using Lambda
```

### Thread Class vs Runnable Interface

| Thread | Runnable |
|---|---|
| Class | Functional Interface |
| Extend Thread | Implement Runnable |
| Cannot extend another class at the same time | Class can extend another class |
| Task and thread are more tightly coupled | Separates task from execution mechanism |
| Less flexible for reusable tasks | More flexible for executors and thread pools |

**Best practice:** Prefer Runnable or Callable for defining tasks. Use Thread directly when you specifically need to manage a thread yourself.

---

## 5. start() vs run()

This is a frequently asked Java interview question.

### start()

- Starts a new thread.
- The JVM schedules the new thread.
- The new thread executes the run() method.

### run()

- Contains the task's execution logic.
- Calling run() directly does not create a new thread.
- It executes like an ordinary method call on the current thread.

### Example

```java
class MyThread extends Thread {

    public void run() {
        System.out.println(
                "Executing thread: " +
                Thread.currentThread().getName()
        );
    }
}

public class Main {
    public static void main(String[] args) {

        MyThread thread = new MyThread();

        thread.run();

        thread.start();
    }
}
```

**Possible Output:**

```text
Executing thread: main
Executing thread: Thread-0
```

The second thread name may differ.

**Important:** Calling `start()` more than once on the same Thread object causes `IllegalThreadStateException`.

---

## 6. Important Thread Methods

Java provides several methods to control and inspect threads.

| Method | Description |
|---|---|
| start() | Starts a new thread |
| run() | Contains the thread's task |
| sleep() | Pauses the current thread temporarily |
| join() | Waits for another thread to finish |
| yield() | Hints that the current thread is willing to yield CPU time |
| currentThread() | Returns the currently executing thread |
| getName() | Returns the thread name |
| setName() | Sets the thread name |
| getPriority() | Returns the thread priority |
| setPriority() | Sets the thread priority |
| isAlive() | Checks whether a thread has started and not yet terminated |
| interrupt() | Requests interruption of a thread |
| isInterrupted() | Checks the thread's interrupt status |

### 6.1 sleep()

The sleep() method pauses the current thread for a specified duration.

It is a static method of the Thread class.

### Example

```java
public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
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

Each number is printed approximately one second apart.

**Important:** sleep() does not release any monitor lock currently held by the sleeping thread.

### 6.2 join()

The join() method makes the current thread wait until another thread terminates.

### Example

```java
class MyThread extends Thread {

    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread thread = new MyThread();

        thread.start();

        thread.join();

        System.out.println("Main Thread Completed");
    }
}
```

**Output:**

```text
Child Thread: 1
Child Thread: 2
Child Thread: 3
Main Thread Completed
```

The main thread waits for the child thread to finish.

### 6.3 yield()

The yield() method gives a scheduling hint that the current thread is willing to let other runnable threads execute.

```java
public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                System.out.println("Child: " + i);

                Thread.yield();
            }
        });

        thread.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main: " + i);
        }
    }
}
```

The output order is not guaranteed.

**Important:** yield() is only a scheduling hint. It does not guarantee that another thread will execute next.

### 6.4 currentThread()

Returns the currently executing thread.

```java
public class Main {
    public static void main(String[] args) {

        Thread thread = Thread.currentThread();

        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread ID: " + thread.getId());
    }
}
```

**Possible Output:**

```text
Thread Name: main
Thread ID: 1
```

Thread IDs and names may vary depending on execution environment.

### 6.5 isAlive()

Checks whether a thread has started and has not yet terminated.

```java
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println(thread.isAlive());

        thread.start();

        System.out.println(thread.isAlive());

        thread.join();

        System.out.println(thread.isAlive());
    }
}
```

**Possible Output:**

```text
false
true
false
```

---

## 7. Thread Priority

Thread priority is a scheduling hint provided to the JVM and operating system.

Java supports priorities from 1 to 10.

| Constant | Value |
|---|---:|
| MIN_PRIORITY | 1 |
| NORM_PRIORITY | 5 |
| MAX_PRIORITY | 10 |

### Example

```java
public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(() ->
                System.out.println("Low Priority Thread"));

        Thread t2 = new Thread(() ->
                System.out.println("Normal Priority Thread"));

        Thread t3 = new Thread(() ->
                System.out.println("High Priority Thread"));

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
```

The output order is not guaranteed.

**Important:** Higher priority does not guarantee earlier execution. Never depend on thread priority for program correctness.

---

## 8. Synchronization in Java

Synchronization is a mechanism used to control access to shared resources by multiple threads.

It helps prevent race conditions when multiple threads modify shared mutable data.

### What is a Race Condition?

A race condition occurs when the result of a program depends on the unpredictable timing or interleaving of multiple threads accessing shared state.

### Example Without Synchronization

```java
class Counter {

    int count = 0;

    public void increment() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + counter.count);
    }
}
```

**Expected logical result:** 2000.

However, the actual result may be less than 2000 because `count++` is not an atomic operation.

### Why Does This Happen?

The statement:

```java
count++;
```

involves multiple steps:

1. Read the current value.
2. Add one.
3. Write the updated value.

Two threads can interleave these steps and overwrite each other's updates.

### 8.1 Synchronized Method

The synchronized keyword ensures that only one thread at a time can execute a synchronized instance method on the same object monitor.

### Corrected Example

```java
class Counter {

    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + counter.count);
    }
}
```

**Output:**

```text
Count: 2000
```

### 8.2 Synchronized Block

A synchronized block allows synchronization of only a specific section of code.

```java
class Counter {

    int count = 0;

    public void increment() {

        synchronized (this) {
            count++;
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);
    }
}
```

**Output:**

```text
2000
```

### 8.3 Static Synchronization

A static synchronized method locks the Class object rather than an individual instance.

```java
class Counter {

    static int count = 0;

    public static synchronized void increment() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                Counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                Counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(Counter.count);
    }
}
```

**Output:**

```text
2000
```

### Synchronized Method vs Synchronized Block

| Synchronized Method | Synchronized Block |
|---|---|
| Locks the method's monitor | Locks the specified object's monitor |
| Entire method is protected | Only selected code is protected |
| Simpler to write | More control over the critical section |
| May hold the lock longer | Can reduce lock duration |

---

## 9. volatile Keyword

The volatile keyword ensures visibility of a variable's latest value across threads.

It prevents threads from relying on stale cached values for that volatile variable.

### Example

```java
class SharedData {

    volatile boolean running = true;
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SharedData data = new SharedData();

        Thread worker = new Thread(() -> {

            while (data.running) {
                // Continue working
            }

            System.out.println("Worker stopped");
        });

        worker.start();

        Thread.sleep(1000);

        data.running = false;

        worker.join();
    }
}
```

**Output:**

```text
Worker stopped
```

### volatile vs synchronized

| volatile | synchronized |
|---|---|
| Ensures visibility | Provides visibility and mutual exclusion |
| Does not make compound operations atomic | Protects compound operations inside the critical section |
| Does not acquire a monitor lock | Acquires a monitor lock |
| Suitable for simple shared flags | Suitable for protecting shared mutable state |

**Important:** `volatile int count` does not make `count++` thread-safe.

---

## 10. Deadlock in Java

Deadlock occurs when two or more threads wait indefinitely for locks held by each other.

### Deadlock Example

```java
public class Main {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            synchronized (lock1) {

                System.out.println("Thread 1 acquired lock1");

                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (lock2) {

                System.out.println("Thread 2 acquired lock2");

                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

This program can enter a deadlock depending on thread scheduling.

### Deadlock Diagram

```text
Thread 1                     Thread 2
   |                            |
   v                            v
Locks lock1                 Locks lock2
   |                            |
   v                            v
Waits for lock2             Waits for lock1
   |                            |
   +---------- DEADLOCK --------+
```

### Four Necessary Conditions for Deadlock

1. Mutual Exclusion – A resource can be held by only one thread at a time.
2. Hold and Wait – A thread holds one resource while waiting for another.
3. No Preemption – A resource cannot be forcibly taken away.
4. Circular Wait – Threads form a circular chain of resource dependencies.

### How to Prevent Deadlock

- Acquire locks in a consistent order.
- Avoid unnecessary nested synchronization.
- Use timed lock acquisition with ReentrantLock when appropriate.
- Keep synchronized sections short.
- Avoid holding locks while performing slow external operations.

---

## 11. Inter-Thread Communication

Inter-thread communication allows threads to coordinate their execution.

Java provides three important methods:

1. wait()
2. notify()
3. notifyAll()

These methods belong to the Object class.

### wait()

Causes the current thread to wait and releases the monitor lock on that object.

### notify()

Wakes one thread waiting on that object's monitor.

### notifyAll()

Wakes all threads waiting on that object's monitor. They must compete to reacquire the lock.

**Important:** These methods must be called by a thread that owns the object's monitor, normally from a synchronized method or block.

### Example: Producer and Consumer

```java
class SharedData {

    private int value;
    private boolean available = false;

    public synchronized void produce(int value)
            throws InterruptedException {

        while (available) {
            wait();
        }

        this.value = value;
        available = true;

        System.out.println("Produced: " + value);

        notifyAll();
    }

    public synchronized void consume()
            throws InterruptedException {

        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + value);

        available = false;

        notifyAll();
    }
}

public class Main {
    public static void main(String[] args) {

        SharedData data = new SharedData();

        Thread producer = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {
                    data.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {
                    data.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

**Possible Output:**

```text
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5
```

The exact interleaving can vary.

### Why Use while Instead of if?

A waiting thread can wake up without the condition becoming true. This is called a spurious wakeup.

Therefore, always check the condition again using a while loop.

---

## 12. Executor Framework

Creating a new Thread for every task can become expensive and difficult to manage.

Java provides the Executor Framework to manage task execution.

It supports thread pools and separates task submission from thread management.

Important interfaces and classes:

- Executor
- ExecutorService
- ScheduledExecutorService
- Executors
- Future
- Callable

### What is a Thread Pool?

A Thread Pool is a group of reusable worker threads.

Instead of creating a new thread for every task, tasks are submitted to the pool.

### Thread Pool Diagram

```text
          Task 1
          Task 2
          Task 3
          Task 4
             |
             v
      +---------------+
      |  Thread Pool  |
      +---------------+
       |      |      |
       v      v      v
     Thread Thread Thread
       1      2      3
```

### Example: Fixed Thread Pool

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {

            final int taskId = i;

            executor.execute(() -> {
                System.out.println(
                        "Task " + taskId +
                        " executed by " +
                        Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
```

**Possible Output:**

```text
Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
Task 3 executed by pool-1-thread-3
Task 4 executed by pool-1-thread-1
Task 5 executed by pool-1-thread-2
```

The actual order and worker assignment may differ.

### Important ExecutorService Methods

| Method | Description |
|---|---|
| execute() | Submits a Runnable task |
| submit() | Submits a task and returns a Future |
| shutdown() | Stops accepting new tasks and allows submitted tasks to finish |
| shutdownNow() | Attempts to stop active tasks and returns tasks not started |
| isShutdown() | Checks whether shutdown was initiated |
| isTerminated() | Checks whether all tasks have completed after shutdown |
| awaitTermination() | Waits for termination up to a specified time |

**Best practice:** Shut down an ExecutorService when it is no longer needed.

---

## 13. Callable and Future

Runnable is used for tasks that do not return a result.

Callable is used for tasks that return a result and may throw checked exceptions.

### Runnable vs Callable

| Runnable | Callable |
|---|---|
| Defines run() | Defines call() |
| Returns void | Returns a value |
| Cannot declare checked exceptions in its method signature | Can throw checked exceptions |
| Can be submitted using execute() or submit() | Submitted using submit() |

### Example: Callable

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {

            int a = 10;
            int b = 20;

            return a + b;
        };

        Future<Integer> future =
                executor.submit(task);

        System.out.println("Result: " + future.get());

        executor.shutdown();
    }
}
```

**Output:**

```text
Result: 30
```

### What is Future?

Future represents the result of an asynchronous computation.

Important methods:

| Method | Description |
|---|---|
| get() | Retrieves the result, waiting if necessary |
| isDone() | Checks whether the task has completed |
| isCancelled() | Checks whether the task was cancelled |
| cancel() | Attempts to cancel the task |

**Important:** Calling `get()` may block until the result becomes available.

---

## 14. ScheduledExecutorService

ScheduledExecutorService is used to execute tasks after a delay or periodically.

### Example: Scheduled Task

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.schedule(() -> {
            System.out.println("Task executed after 2 seconds");
            scheduler.shutdown();
        }, 2, TimeUnit.SECONDS);
    }
}
```

**Output:**

```text
Task executed after 2 seconds
```

### Important Methods

- schedule() – Executes a task once after a delay.
- scheduleAtFixedRate() – Schedules repeated executions using a fixed rate.
- scheduleWithFixedDelay() – Schedules the next execution after a fixed delay from the previous execution's completion.

---

## 15. Concurrent Collections

Traditional collections such as ArrayList and HashMap are not designed for unrestricted concurrent modification by multiple threads.

Java provides concurrent collections for multithreaded applications.

### Important Concurrent Collections

| Collection | Purpose |
|---|---|
| ConcurrentHashMap | Thread-safe key-value storage |
| CopyOnWriteArrayList | Thread-safe list suited to read-heavy workloads |
| BlockingQueue | Queue supporting blocking operations |
| ConcurrentLinkedQueue | Thread-safe non-blocking queue |
| CopyOnWriteArraySet | Thread-safe set based on copy-on-write |

### 15.1 ConcurrentHashMap

ConcurrentHashMap supports concurrent access and updates.

```java
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>();

        map.put(101, "Ayush");
        map.put(102, "Rahul");
        map.put(103, "Amit");

        System.out.println(map.get(101));

        map.remove(102);

        System.out.println(map);
    }
}
```

**Possible Output:**

```text
Ayush
{101=Ayush, 103=Amit}
```

ConcurrentHashMap does not allow null keys or null values.

### 15.2 CopyOnWriteArrayList

CopyOnWriteArrayList creates a fresh underlying array when a modification occurs.

It is useful when reads are frequent and modifications are relatively rare.

```java
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> names =
                new CopyOnWriteArrayList<>();

        names.add("Ayush");
        names.add("Rahul");
        names.add("Amit");

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
Amit
```

### 15.3 BlockingQueue

BlockingQueue supports operations that can wait when the queue is full or empty.

It is useful in producer-consumer applications.

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(3);

        queue.put(10);
        queue.put(20);
        queue.put(30);

        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
```

**Output:**

```text
10
20
```

---

## 16. Atomic Classes

Java provides atomic classes in `java.util.concurrent.atomic`.

They support thread-safe operations on individual variables without requiring explicit synchronization for each operation.

Examples:

- AtomicInteger
- AtomicLong
- AtomicBoolean
- AtomicReference

### Example: AtomicInteger

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger count = new AtomicInteger(0);

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + count.get());
    }
}
```

**Output:**

```text
Count: 2000
```

AtomicInteger provides atomic increment operations, making it suitable for this counter example.

---

## 17. ReentrantLock

ReentrantLock is an explicit locking mechanism available in `java.util.concurrent.locks`.

It provides more flexibility than synchronized blocks.

Features include:

- tryLock()
- lock()
- unlock()
- lockInterruptibly()
- Fairness option
- Condition support

### Example

```java
import java.util.concurrent.locks.ReentrantLock;

class Counter {

    private int count = 0;

    private final ReentrantLock lock =
            new ReentrantLock();

    public void increment() {

        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}
```

**Output:**

```text
2000
```

**Important:** Always release a ReentrantLock in a finally block to avoid accidentally keeping the lock forever.

---

## 18. Daemon Threads

A daemon thread is a background thread that does not prevent the JVM from exiting when all non-daemon threads have finished.

Examples of JVM background activities include certain housekeeping and service tasks.

### Example

```java
public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            while (true) {
                System.out.println("Background task running");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        thread.setDaemon(true);

        thread.start();

        System.out.println("Main thread completed");
    }
}
```

**Possible Output:**

```text
Main thread completed
Background task running
```

The output can vary because the JVM may terminate daemon threads when no non-daemon threads remain.

**Important:** Call `setDaemon(true)` before `start()`. Daemon threads should not be used for tasks that must complete reliably, such as saving important data.

---

## 19. Thread Interruption

Interruption is a cooperative mechanism for requesting that a thread stop or change its activity.

It does not forcibly terminate a thread.

### Example

```java
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {

                System.out.println("Worker running");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            System.out.println("Worker stopped");
        });

        worker.start();

        Thread.sleep(1500);

        worker.interrupt();

        worker.join();
    }
}
```

**Possible Output:**

```text
Worker running
Worker running
Worker running
Worker stopped
```

The exact number of messages may vary.

---

## 20. Real-World Multithreading Applications

### Example 1: Ticket Booking System

```java
class TicketBooking {

    private int availableSeats = 2;

    public synchronized void bookTicket(String user) {

        if (availableSeats > 0) {

            System.out.println(user + " booked a ticket");

            availableSeats--;

        } else {

            System.out.println(user + " - No seats available");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TicketBooking booking = new TicketBooking();

        Thread t1 = new Thread(() ->
                booking.bookTicket("Ayush"));

        Thread t2 = new Thread(() ->
                booking.bookTicket("Rahul"));

        Thread t3 = new Thread(() ->
                booking.bookTicket("Amit"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
```

**Possible Output:**

```text
Ayush booked a ticket
Rahul booked a ticket
Amit - No seats available
```

The booking order may vary, but only two tickets can be booked.

### Example 2: Bank Account With Synchronization

```java
class BankAccount {

    private double balance = 10000;

    public synchronized void withdraw(double amount) {

        if (balance >= amount) {

            balance -= amount;

            System.out.println(
                    "Withdrawn: " + amount
            );

            System.out.println(
                    "Remaining Balance: " + balance
            );

        } else {

            System.out.println("Insufficient Balance");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() ->
                account.withdraw(6000));

        Thread t2 = new Thread(() ->
                account.withdraw(5000));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
```

**Possible Output:**

```text
Withdrawn: 6000.0
Remaining Balance: 4000.0
Insufficient Balance
```

The order of the two withdrawal attempts can vary.

### Example 3: Producer-Consumer Using BlockingQueue

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {

                    queue.put(i);

                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {

                    int value = queue.take();

                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

**Possible Output:**

```text
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5
```

The output interleaving may differ.

---

## 21. Common Multithreading Mistakes

1. Calling run() instead of start() when a new thread is required.
2. Starting the same Thread object more than once.
3. Assuming thread execution order is predictable.
4. Accessing shared mutable data without synchronization or another suitable concurrency mechanism.
5. Assuming volatile makes every operation atomic.
6. Forgetting to call shutdown() on ExecutorService.
7. Calling wait() outside synchronized code.
8. Calling notify() without owning the object's monitor.
9. Using if instead of while to check a wait condition.
10. Acquiring locks in inconsistent orders.
11. Forgetting to unlock ReentrantLock in finally.
12. Ignoring InterruptedException.
13. Assuming thread priority guarantees execution order.
14. Creating too many threads without considering resource usage.
15. Using daemon threads for tasks that must finish before application shutdown.

---

## 22. Best Practices

- Prefer Runnable or Callable for task definitions.
- Prefer ExecutorService for managing groups of tasks.
- Use synchronization only where necessary.
- Keep critical sections small.
- Use concurrent collections for shared concurrent data structures.
- Use AtomicInteger and related classes for simple atomic operations.
- Follow a consistent lock ordering strategy.
- Always release explicit locks in finally blocks.
- Handle InterruptedException properly and preserve interruption when appropriate.
- Shut down executor services.
- Avoid unnecessary shared mutable state.
- Do not depend on thread priority or scheduling order for correctness.
- Use thread-safe design instead of adding synchronization everywhere.

---

## 23. Multithreading Interview Questions

### Basic Questions

1. What is multithreading in Java?

**Answer:** Multithreading allows several independent execution paths to run concurrently inside one Java process.

2. What is a thread?

**Answer:** A thread is an execution path managed by the JVM and platform within a process.

3. What is a process?

**Answer:** A process is an executing program instance with operating-system resources and a separate address space; it may contain threads.

4. What is the difference between a process and a thread?

**Answer:** Processes are isolated and have separate memory; threads share process memory and resources.

5. What are the advantages of multithreading?

**Answer:** Multithreading improves responsiveness, supports background work, enables concurrent tasks, and can improve processor utilization.

6. What are the six states in the Java thread lifecycle?

**Answer:** The states are NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, and TERMINATED.

7. How can you create a thread in Java?

**Answer:** Create a `Thread` subclass or implement `Runnable`, pass it to `Thread`, and call `start()`.

8. What is the Thread class?

**Answer:** `Thread` represents an execution thread and provides thread lifecycle, naming, priority, interruption, and control methods.

9. What is the Runnable interface?

**Answer:** `Runnable` is a functional interface whose `run()` method represents the work to execute.

10. What is the difference between start() and run()?

**Answer:** `start()` schedules a new thread and invokes `run()` there; calling `run()` directly executes synchronously in the current thread.

11. What is the purpose of sleep()?

**Answer:** `sleep()` pauses the current thread for a timed interval without releasing monitor locks and throws `InterruptedException`.

12. What is the purpose of join()?

**Answer:** `join()` makes a thread wait for another thread to terminate or for a timeout to expire.

13. What is thread priority?

**Answer:** Priority is a scheduling hint and does not guarantee execution order or CPU share.

14. What is a daemon thread?

**Answer:** A daemon thread runs in the background and does not prevent JVM shutdown after non-daemon threads finish.

15. What is thread interruption?

**Answer:** Interruption is cooperative cancellation: a thread checks `isInterrupted()` or receives `InterruptedException` in a blocking method.

### Intermediate Questions

16. What is synchronization?

**Answer:** Synchronization restricts or coordinates access to shared state or critical sections.

17. What is a race condition?

**Answer:** A race condition is incorrect behavior that depends on the unpredictable ordering of concurrent operations.

18. What is a critical section?

**Answer:** A critical section is code that accesses shared state and must be synchronized or otherwise made thread-safe.

19. What is the synchronized keyword?

**Answer:** `synchronized` provides mutual exclusion and monitor visibility for a block or method.

20. What is the difference between a synchronized method and block?

**Answer:** A synchronized method locks its entire scope; a synchronized block locks only selected statements using an explicit monitor.

21. What is static synchronization?

**Answer:** Static synchronization uses the class object as the monitor, serializing synchronized static methods across instances.

22. What is the volatile keyword?

**Answer:** `volatile` guarantees visibility and ordering for a variable but does not make compound operations atomic.

23. What is the difference between volatile and synchronized?

**Answer:** `volatile` provides visibility for individual accesses; `synchronized` provides mutual exclusion and visibility for compound operations.

24. What is deadlock?

**Answer:** Deadlock is circular waiting in which threads hold resources needed by one another and cannot proceed.

25. What are the four necessary conditions for deadlock?

**Answer:** The four conditions are mutual exclusion, hold-and-wait, no preemption, and circular wait.

26. What is inter-thread communication?

**Answer:** Inter-thread communication coordinates thread activity using shared monitor state and wait/notification methods.

27. What is the difference between wait(), notify(), and notifyAll()?

**Answer:** `wait()` releases the monitor and waits; `notify()` wakes one waiter; `notifyAll()` wakes all waiters.

28. Why should wait() be called inside a while loop?

**Answer:** A condition may change or must be rechecked after notification, so waiting should occur inside a `while` loop.

29. What is the Executor Framework?

**Answer:** The Executor Framework separates task submission from thread creation and lifecycle management.

30. What is a thread pool?

**Answer:** A thread pool maintains reusable worker threads and executes queued tasks, limiting thread creation and resource use.

### Advanced Questions

31. What is the difference between Runnable and Callable?

**Answer:** `Runnable` has no result and cannot throw a checked exception; `Callable<V>` returns a result and may throw an exception.

32. What is Future?

**Answer:** `Future` represents an asynchronous task’s eventual result or exception and supports status, cancellation, and blocking retrieval.

33. What is the difference between execute() and submit()?

**Answer:** `execute()` has no result and accepts `Runnable`; `submit()` accepts `Runnable` or `Callable` and returns a `Future`.

34. What is ScheduledExecutorService?

**Answer:** `ScheduledExecutorService` schedules delayed or repeated tasks with fixed delays or fixed rates.

35. What is ConcurrentHashMap?

**Answer:** `ConcurrentHashMap` is a thread-safe map optimized for concurrent reads and updates without a whole-map read lock.

36. What is CopyOnWriteArrayList?

**Answer:** `CopyOnWriteArrayList` replaces its backing array for writes and provides snapshot-stable iteration, suited to read-heavy workloads.

37. What is BlockingQueue?

**Answer:** `BlockingQueue` provides queue operations that block when the queue is full or empty.

38. What is AtomicInteger?

**Answer:** `AtomicInteger` provides lock-free, thread-safe integer operations using atomic compare-and-update primitives.

39. What is ReentrantLock?

**Answer:** `ReentrantLock` is an explicit reentrant lock with try-lock, timed/interruptible acquisition, and conditions.

40. What is the difference between synchronized and ReentrantLock?

**Answer:** Synchronized is implicit and scope-based; `ReentrantLock` is explicit and offers try-lock, timed or interruptible acquisition, fairness, and conditions.

41. What is the difference between shutdown() and shutdownNow()?

**Answer:** `shutdown()` refuses new work and drains accepted work; `shutdownNow()` attempts to stop active tasks and returns queued tasks.

42. What is a race condition in a banking application?

**Answer:** Concurrent withdrawals can read the same balance and both update it, so each account operation must be synchronized or otherwise atomic.

43. What is the difference between concurrency and parallelism?

**Answer:** Concurrency manages overlapping tasks; parallelism executes tasks simultaneously on multiple processors.

44. What is the Java Memory Model?

**Answer:** The Java Memory Model defines visibility, ordering, and synchronization guarantees for shared thread data.

45. What is a happens-before relationship?

**Answer:** Happens-before means an action is ordered before and visible to another action under the JVM memory rules.

---

## 24. Practice Exercises (Questions Only)

**Important:** Try to implement every program independently before reviewing the solutions.

Completed solutions are available in the [Practice-Programs folder](Practice-Programs/README.md).

### Beginner Level

1. Create a thread by extending the Thread class.
2. Create a thread by implementing the Runnable interface.
3. Create a thread using a Lambda Expression.
4. Write a program to print numbers from 1 to 10 using a thread.
5. Write a program to display the current thread name.
6. Write a program to set and retrieve a thread name.
7. Write a program to demonstrate the sleep() method.
8. Write a program to demonstrate the join() method.
9. Write a program to demonstrate isAlive().
10. Write a program to demonstrate thread priority.

### Intermediate Level

11. Create two threads to print odd and even numbers.
12. Write a program to demonstrate a race condition.
13. Solve the race condition using synchronized.
14. Demonstrate a synchronized block.
15. Demonstrate static synchronization.
16. Write a program demonstrating volatile variable visibility.
17. Create a program demonstrating thread interruption.
18. Create a daemon thread and observe its behavior.
19. Create a program demonstrating deadlock.
20. Implement a thread-safe counter using AtomicInteger.
21. Implement a producer-consumer problem using wait() and notifyAll().
22. Implement a producer-consumer problem using BlockingQueue.
23. Create a fixed thread pool and execute multiple tasks.
24. Write a program using Callable and Future to calculate a result.
25. Schedule a task using ScheduledExecutorService.

### Advanced Level

26. Build a thread-safe bank account withdrawal system.
27. Build a ticket booking system using synchronization.
28. Implement a producer-consumer system with multiple producers and consumers.
29. Implement a task execution system using ExecutorService.
30. Create an employee-processing application using Callable and Future.
31. Implement a thread-safe cache using ConcurrentHashMap.
32. Create a read-heavy application using CopyOnWriteArrayList.
33. Demonstrate ReentrantLock with multiple threads.
34. Implement a program to prevent deadlock using consistent lock ordering.
35. Create a program to demonstrate the difference between sequential and parallel execution.
36. Build a multithreaded file-processing application.
37. Create a background logging task using ExecutorService.
38. Implement a bounded task queue using BlockingQueue.
39. Create a program that demonstrates thread coordination using wait(), notify(), and notifyAll().
40. Build a small multithreaded order-processing system.

---

## 25. Chapter Summary

In this chapter, you learned:

- Introduction to multithreading.
- Process vs Thread.
- Thread lifecycle.
- Creating threads using Thread and Runnable.
- Lambda-based thread creation.
- start() vs run().
- Important thread methods.
- Thread priority.
- Synchronization.
- Race conditions.
- volatile keyword.
- Deadlock and its prevention.
- Inter-thread communication.
- wait(), notify(), and notifyAll().
- Executor Framework.
- Callable and Future.
- ScheduledExecutorService.
- Concurrent Collections.
- Atomic Classes.
- ReentrantLock.
- Daemon Threads.
- Thread interruption.
- Real-world multithreading programs.

### Key Takeaways

| Concept | Purpose |
|---|---|
| Thread | Unit of execution |
| Runnable | Defines a task without a return value |
| Callable | Defines a task with a return value |
| start() | Starts a new thread |
| sleep() | Temporarily pauses the current thread |
| join() | Waits for another thread to finish |
| synchronized | Provides monitor-based mutual exclusion |
| volatile | Ensures visibility of a variable |
| wait()/notify() | Coordinates threads using object monitors |
| ExecutorService | Manages task execution |
| Future | Represents an asynchronous result |
| ConcurrentHashMap | Supports concurrent map operations |
| AtomicInteger | Provides atomic integer operations |
| ReentrantLock | Provides explicit locking |

---

## Next Chapter: Chapter 13 – JDBC (Java Database Connectivity)

In the next chapter, we will learn how Java applications communicate with databases.

Topics:

1. Introduction to JDBC.
2. JDBC Architecture.
3. JDBC Drivers and Driver Types.
4. Installing and Configuring MySQL JDBC Driver.
5. Connecting Java to MySQL.
6. Connection, Statement, and ResultSet.
7. PreparedStatement.
8. Executing INSERT, UPDATE, DELETE, and SELECT.
9. CRUD Operations.
10. SQL Injection and Prevention.
11. Batch Processing.
12. Transactions and Commit/Rollback.
13. CallableStatement and Stored Procedures.
14. JDBC Exception Handling.
15. DAO Pattern.
16. Real-World JDBC Project.
17. Interview Questions and Practice Exercises.

**Final Note:** Multithreading is not just about creating multiple threads. The real skill is coordinating them safely, preventing data corruption, and managing shared resources efficiently. Practice synchronization, deadlocks, and ExecutorService carefully because these concepts are widely used in real-world Java applications.
