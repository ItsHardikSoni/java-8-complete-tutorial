# 2. Java Installation and Environment Setup ☕

**Navigation:** [Main Tutorial Index](../README.md) | [Previous: Introduction](../01-Introduction-to-Java/README.md) | [Next: Java Basics](../03-Java-Basics/README.md)

**Examples:** [HelloWorld.java](HelloWorld.java)

Before writing Java programs, we need to install the Java Development Kit (JDK) on our computer.

In this tutorial, we will learn how to install Java 8, configure the environment, check Java versions, and execute our first Java program.

## 2.1 What is JDK Installation?

JDK (Java Development Kit) is a software package that provides all the necessary tools to develop Java applications.

It includes:
- Java Compiler (`javac`)
- Java Launcher (`java`)
- Java Runtime Components
- Debugging Tools
- Documentation Tools

**Important:** If you want to develop Java applications, you should install the JDK rather than only a runtime environment.

## 2.2 Download Java 8 (JDK 8)

Follow these steps to download Java 8.

**Step 1: Visit the official website**

Download JDK 8 from Oracle:

https://www.oracle.com/java/technologies/downloads/#java8

Alternatively, you can use Eclipse Temurin OpenJDK:

https://adoptium.net/temurin/releases/?version=8

**Step 2: Select your operating system**

Choose the appropriate installer according to your operating system:

- Windows
- macOS
- Linux

**Step 3: Install JDK 8**

Run the downloaded installer and follow the installation instructions.

After installation, remember the location where JDK is installed.

Common installation locations:

Windows:
`C:\Program Files\Java\jdk1.8.0_xxx`

macOS:
`/Library/Java/JavaVirtualMachines/`

Linux:
`/usr/lib/jvm/`

The exact directory depends on the JDK distribution and version.

## 2.3 How to Check Java Installation

After installing Java, open your terminal or command prompt.

Execute the following command:

```bash
java -version
```

Expected output (version details may differ):

```text
java version "1.8.0_XXX"
Java(TM) SE Runtime Environment
Java HotSpot(TM) 64-Bit Server VM
```

Now check the Java compiler version:

```bash
javac -version
```

Expected output:

```text
javac 1.8.0_XXX
```

If both commands work, Java is installed and the Java compiler is available.

**Remember:**
- `java` is used to launch Java applications.
- `javac` is used to compile Java source code.

## 2.4 What is an Environment Variable?

An environment variable is a system-level setting that stores information about the environment in which programs run.

In Java development, two important environment variables are:

**1. JAVA_HOME**

JAVA_HOME stores the installation path of the JDK.

Example:

```text
JAVA_HOME=C:\Program Files\Java\jdk1.8.0_xxx
```

**2. PATH**

PATH tells the operating system where to find executable commands.

We add the JDK `bin` directory to PATH so that commands such as `java` and `javac` can be executed from any terminal directory.

Example:

```text
%JAVA_HOME%\bin
```

## 2.5 Configure Java Environment Variables on Windows

Follow these steps:

1. Install JDK 8.
2. Open Windows Search.
3. Search for Environment Variables.
4. Select **Edit the system environment variables**.
5. Click the **Environment Variables** button.
6. Under System Variables, click New.
7. Enter the variable name:

```text
JAVA_HOME
```

8. Enter the JDK installation path as its value.

Example:

```text
C:\Program Files\Java\jdk1.8.0_xxx
```

9. Find the `Path` variable under System Variables.
10. Click Edit and add:

```text
%JAVA_HOME%\bin
```

11. Save all changes.

Close and reopen the terminal.

Now execute:

```bash
java -version
javac -version
```

## 2.6 Configure Java on macOS

If you are using macOS, follow these steps.

**Step 1: Install JDK 8**

Download the macOS installer from Oracle or Eclipse Temurin.

**Step 2: Check installed Java versions**

Open Terminal and execute:

```bash
/usr/libexec/java_home -V
```

This command displays the installed JDK versions.

**Step 3: Set JAVA_HOME**

For Java 8, execute:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
```

**Step 4: Add Java to PATH**

Execute:

```bash
export PATH="$JAVA_HOME/bin:$PATH"
```

**Step 5: Verify installation**

```bash
java -version
javac -version
echo $JAVA_HOME
```

To make these settings permanent for the Zsh shell, add the following lines to your `~/.zshrc` file:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export PATH="$JAVA_HOME/bin:$PATH"
```

Save the file and reload it:

```bash
source ~/.zshrc
```

## 2.7 Java Development Tools (IDEs)

An IDE (Integrated Development Environment) is software that helps developers write, compile, run, and debug programs.

Popular Java IDEs include:

**1. IntelliJ IDEA**

A popular Java IDE with intelligent code completion, debugging, and project management features.

Website: https://www.jetbrains.com/idea/

**2. Eclipse IDE**

An open-source IDE widely used for Java application development.

Website: https://eclipseide.org/

**3. Visual Studio Code**

A lightweight code editor that supports Java development through extensions.

Website: https://code.visualstudio.com/

**4. NetBeans**

An IDE that provides tools for Java development and project management.

Website: https://netbeans.apache.org/

For beginners, IntelliJ IDEA Community Edition or Eclipse IDE is a good starting point.

## 2.8 Create Your First Java Program

Now that Java is installed, let's create our first program.

Create a file named:

`HelloWorld.java`

Write the following code:

```java
public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Welcome to Java Programming!");

    }
}
```

**Output:**

```text
Welcome to Java Programming!
```

## 2.9 Compile and Run Java Programs Using Terminal

You can compile and execute Java programs without using an IDE.

**Step 1: Open Terminal or Command Prompt**

Navigate to the directory where your Java file is saved.

**Step 2: Compile the Java program**

```bash
javac HelloWorld.java
```

After successful compilation, Java generates:

`HelloWorld.class`

This file contains Java bytecode.

**Step 3: Execute the Java program**

```bash
java HelloWorld
```

**Output:**

```text
Welcome to Java Programming!
```

**Important:** While executing the program, do not include the `.java` or `.class` extension after the class name.

Correct:

```bash
java HelloWorld
```

Incorrect:

```bash
java HelloWorld.java
```

The above incorrect command is not the traditional Java 8 compile-and-run workflow covered in this tutorial.

## 2.10 Common Java Installation Errors

### Error 1: 'java' is not recognized as an internal or external command

**Reason:** Java is not installed correctly, or its `bin` directory is missing from PATH.

**Solution:**
- Check whether JDK is installed.
- Configure JAVA_HOME.
- Add the JDK `bin` directory to PATH.
- Restart the terminal.

### Error 2: 'javac' is not recognized

**Reason:** The JDK compiler is unavailable through the configured PATH.

**Solution:**

Verify that the JDK is installed and add its `bin` directory to PATH.

### Error 3: Could not find or load main class

**Reason:** Java cannot locate the class you want to execute.

**Solution:**
- Check the class name.
- Ensure compilation was successful.
- Verify that you are in the correct directory.
- Check the classpath if necessary.

### Error 4: Unsupported major.minor version

**Reason:** The Java runtime is older than the version used to compile the class.

**Solution:** Use a compatible or newer Java runtime, or compile the source code for the target Java version.

## 2.11 Important Java Commands

| Command | Purpose |
|---|---|
| `java -version` | Check Java version |
| `javac -version` | Check compiler version |
| `javac HelloWorld.java` | Compile Java source code |
| `java HelloWorld` | Run Java application |
| `echo %JAVA_HOME%` | Display JAVA_HOME on Windows |
| `echo $JAVA_HOME` | Display JAVA_HOME on macOS/Linux |
| `where java` | Locate Java executable on Windows |
| `which java` | Locate Java executable on macOS/Linux |
| `javadoc` | Generate Java documentation |
| `jar` | Create and manage JAR files |

## 2.12 Practice Questions

Try answering these questions to test your understanding.

1. What is JDK?
2. Why do we need to install JDK before developing Java applications?
3. What is the difference between `java` and `javac`?
4. What is JAVA_HOME?
5. Why do we configure the PATH variable?
6. What is an IDE?
7. What is the extension of a Java source file?
8. What is the extension of a compiled Java bytecode file?
9. Which command is used to check the Java version?
10. How do you compile and execute a Java program using the terminal?

## 2.13 Key Takeaways

- JDK is required to develop Java applications.
- Java source files use the `.java` extension.
- Java compiler converts source code into bytecode.
- Compiled Java files use the `.class` extension.
- `javac` compiles Java programs.
- `java` launches Java applications.
- JAVA_HOME stores the JDK installation path.
- PATH allows the operating system to locate Java commands.
- IDEs make Java development easier.

---

## What's Next?

**Topic 3: Java Basics – Syntax, Variables, Data Types, and Operators**

In the next tutorial, we will learn how to write Java statements, declare variables, understand primitive and non-primitive data types, and perform operations using Java operators.

**Keep Learning, Keep Practicing, and Keep Coding!**