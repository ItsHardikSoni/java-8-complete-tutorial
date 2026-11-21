# Chapter 8: Strings in Java

**Navigation:** [Main Tutorial Index](../README.md) | [Previous: Arrays](../07-Java-Arrays/README.md)

**Practice:** [Practice Programs](Practice-Programs/) | [Practice Program Index](Practice-Programs/README.md)

## 1. Introduction to Strings

A String is a sequence of characters used to represent text.

For example:

```java
String name = "Ayush";

String language = "Java Programming";

String message = "Welcome to Java";
```

In Java, `String` is a predefined class available in the `java.lang` package.

Unlike primitive data types such as `int`, `char`, and `double`, String is a reference type.

### Why Do We Need Strings?

Strings are used to:
- Store names and addresses.
- Store passwords and usernames.
- Display messages.
- Process user input.
- Validate email addresses and other text.
- Search and manipulate text.
- Read and process files.
- Exchange information between applications.

### Important Characteristics of Strings

1. A String represents a sequence of characters.
2. String is a class, not a primitive data type.
3. Strings are immutable in Java.
4. String objects can be created using literals or the `new` keyword.
5. String provides many built-in methods.
6. String belongs to the `java.lang` package, so no explicit import is required.

---

## 2. Creating Strings in Java

Java provides two commonly used ways to create String objects.

### 2.1 Using String Literals

A String literal is created by writing text inside double quotation marks.

```java
public class StringLiteral {

    public static void main(String[] args) {

        String name = "Ayush";

        String language = "Java";

        System.out.println(name);

        System.out.println(language);

    }
}
```

**Output:**

```text
Ayush
Java
```

String literals are stored in the String Constant Pool when an equivalent pooled String is not already available.

### 2.2 Using the `new` Keyword

We can also create a String object using the `new` keyword.

```java
public class StringUsingNew {

    public static void main(String[] args) {

        String name = new String("Ayush");

        System.out.println(name);

    }
}
```

**Output:**

```text
Ayush
```

Using `new String("Ayush")` explicitly creates a new String object, even if an equivalent String already exists in the pool.

### String Literal vs `new String()`

| String Literal | `new String()` |
|---|---|
| Uses double quotation marks | Uses the `new` keyword |
| Uses the String Constant Pool | Explicitly creates a new String object |
| Reuses an existing pooled String when available | Creates a distinct object |
| Generally preferred for ordinary String creation | Useful when a distinct object is specifically required |

---

## 3. String Constant Pool (SCP)

The String Constant Pool is a special area associated with the JVM's String handling.

It allows Java to reuse String literals instead of creating unnecessary duplicate pooled objects.

### Why Does Java Use the String Constant Pool?

Consider the following code:

```java
String s1 = "Java";

String s2 = "Java";
```

Both variables refer to the same pooled String object.

Instead of storing two identical literal objects, Java can reuse one.

### Example

```java
public class StringPoolExample {

    public static void main(String[] args) {

        String s1 = "Java";

        String s2 = "Java";

        System.out.println(s1 == s2);

    }
}
```

**Output:**

```text
true
```

Both references point to the same object.

### Understanding `new String()`

```java
public class StringPoolExample2 {

    public static void main(String[] args) {

        String s1 = "Java";

        String s2 = new String("Java");

        System.out.println(s1 == s2);

        System.out.println(s1.equals(s2));

    }
}
```

**Output:**

```text
false
true
```

**Explanation:**

- `s1` refers to the pooled String.
- `s2` refers to a newly created String object.
- `==` compares references.
- `equals()` compares String contents.

### Using `intern()`

The `intern()` method returns the canonical pooled representation of a String.

```java
public class InternExample {

    public static void main(String[] args) {

        String s1 = "Java";

        String s2 = new String("Java");

        String s3 = s2.intern();

        System.out.println(s1 == s2);

        System.out.println(s1 == s3);

    }
}
```

**Output:**

```text
false
true
```

### String Pool Summary

| Expression | Behavior |
|---|---|
| `String s1 = "Java";` | Uses pooled literal |
| `String s2 = "Java";` | Reuses equivalent pooled literal |
| `String s3 = new String("Java");` | Creates a new String object |
| `String s4 = s3.intern();` | Returns the pooled representation |

**Important:** The String Constant Pool is managed by the JVM. In modern Java, pooled Strings are stored in the heap.

---

## 4. String Immutability in Java

One of the most important characteristics of String is immutability.

Immutability means that once a String object is created, its contents cannot be changed.

If we perform an operation that appears to modify a String, Java creates or returns another String rather than modifying the original object.

### Example

```java
public class StringImmutability {

    public static void main(String[] args) {

        String name = "Java";

        name.concat(" Programming");

        System.out.println(name);

    }
}
```

**Output:**

```text
Java
```

Why?

Because `concat()` returns a new String. It does not modify the original String.

### Correct Way to Store the Result

```java
public class StringImmutability2 {

    public static void main(String[] args) {

        String name = "Java";

        name = name.concat(" Programming");

        System.out.println(name);

    }
}
```

**Output:**

```text
Java Programming
```

The original String was not modified. The variable `name` was reassigned to refer to the returned String.

### Why Are Strings Immutable?

String immutability provides several benefits:

1. **Security:** Strings are widely used for usernames, file paths, URLs, and configuration values.
2. **Thread Safety:** Immutable String objects can safely be shared between threads.
3. **String Pooling:** Shared String literals can be reused without one reference changing their contents for another.
4. **Hash Code Caching:** A String's hash code can be cached because its contents do not change.
5. **Reliability:** String values cannot be unexpectedly modified through another reference.

---

## 5. String Length

The `length()` method returns the number of UTF-16 code units in a String.

### Syntax

```java
stringName.length();
```

### Example

```java
public class StringLength {

    public static void main(String[] args) {

        String name = "Ayush";

        System.out.println("Length: " + name.length());

    }
}
```

**Output:**

```text
Length: 5
```

**Important:** Java's `String.length()` counts UTF-16 code units, not necessarily user-perceived characters. Some Unicode characters use two code units.

---

## 6. Important String Methods in Java

Java provides many built-in methods for working with Strings.

### 6.1 `length()`

Returns the number of UTF-16 code units.

```java
String str = "Java";

System.out.println(str.length());
```

**Output:**

```text
4
```

### 6.2 `charAt()`

Returns the character at the specified index.

```java
public class CharAtExample {

    public static void main(String[] args) {

        String str = "Java";

        System.out.println(str.charAt(0));

        System.out.println(str.charAt(2));

    }
}
```

**Output:**

```text
J
v
```

### 6.3 `toUpperCase()`

Converts a String to uppercase.

```java
String str = "java";

System.out.println(str.toUpperCase());
```

**Output:**

```text
JAVA
```

### 6.4 `toLowerCase()`

Converts a String to lowercase.

```java
String str = "JAVA";

System.out.println(str.toLowerCase());
```

**Output:**

```text
java
```

### 6.5 `trim()`

Removes leading and trailing characters whose code point is at most U+0020.

```java
String str = "   Java Programming   ";

System.out.println(str.trim());
```

**Output:**

```text
Java Programming
```

Note: `trim()` does not remove every Unicode whitespace character. Java 8 does not provide the later `strip()` methods.

### 6.6 `substring()`

Extracts a portion of a String.

There are two commonly used forms:

```java
substring(int beginIndex)

substring(int beginIndex, int endIndex)
```

The beginning index is included, but the ending index is excluded.

```java
public class SubstringExample {

    public static void main(String[] args) {

        String str = "Java Programming";

        System.out.println(str.substring(5));

        System.out.println(str.substring(0, 4));

    }
}
```

**Output:**

```text
Programming
Java
```

### 6.7 `contains()`

Checks whether a String contains a particular sequence of characters.

```java
String str = "Java Programming";

System.out.println(str.contains("Java"));

System.out.println(str.contains("Python"));
```

**Output:**

```text
true
false
```

### 6.8 `startsWith()`

Checks whether a String begins with a specified prefix.

```java
String str = "Java Programming";

System.out.println(str.startsWith("Java"));
```

**Output:**

```text
true
```

### 6.9 `endsWith()`

Checks whether a String ends with a specified suffix.

```java
String str = "Java Programming";

System.out.println(str.endsWith("Programming"));
```

**Output:**

```text
true
```

### 6.10 `indexOf()`

Returns the index of the first occurrence of a character or substring.

If the value is not found, it returns `-1`.

```java
String str = "Java Programming";

System.out.println(str.indexOf('a'));

System.out.println(str.indexOf("Programming"));
```

**Output:**

```text
1
5
```

### 6.11 `lastIndexOf()`

Returns the index of the last occurrence.

```java
String str = "Java Programming";

System.out.println(str.lastIndexOf('a'));
```

**Output:**

```text
3
```

### 6.12 `replace()`

Replaces matching characters or character sequences.

```java
String str = "Java Programming";

System.out.println(str.replace('a', 'o'));
```

**Output:**

```text
Jovo Progr omming
```

### 6.13 `replaceAll()`

Replaces all substrings matching a regular expression.

```java
String str = "Java123Programming456";

System.out.println(str.replaceAll("[0-9]", ""));
```

**Output:**

```text
JavaProgramming
```

### 6.14 `replaceFirst()`

Replaces the first substring matching a regular expression.

```java
String str = "Java Java Java";

System.out.println(str.replaceFirst("Java", "Python"));
```

**Output:**

```text
Python Java Java
```

### 6.15 `isEmpty()`

Checks whether the String length is zero.

```java
String str1 = "";

String str2 = "Java";

System.out.println(str1.isEmpty());

System.out.println(str2.isEmpty());
```

**Output:**

```text
true
false
```

### 6.16 `equals()`

Compares two Strings based on their contents.

```java
String s1 = "Java";

String s2 = "Java";

System.out.println(s1.equals(s2));
```

**Output:**

```text
true
```

### 6.17 `equalsIgnoreCase()`

Compares Strings without considering case differences.

```java
String s1 = "JAVA";

String s2 = "java";

System.out.println(s1.equalsIgnoreCase(s2));
```

**Output:**

```text
true
```

### 6.18 `compareTo()`

Compares two Strings lexicographically.

It returns:
- A negative number if the first String comes before the second.
- Zero if the Strings are equal.
- A positive number if the first String comes after the second.

```java
String s1 = "Apple";

String s2 = "Banana";

System.out.println(s1.compareTo(s2));
```

**Output:**

```text
-1
```

The exact nonzero return value is not guaranteed to be `-1` or `1`; it only indicates the comparison result's sign.

### 6.19 `concat()`

Joins two Strings.

```java
String s1 = "Hello";

String s2 = " Java";

System.out.println(s1.concat(s2));
```

**Output:**

```text
Hello Java
```

### 6.20 `split()`

Splits a String into an array using a regular expression.

```java
public class SplitExample {

    public static void main(String[] args) {

        String str = "Java,Python,C++";

        String[] languages = str.split(",");

        for (String language : languages) {

            System.out.println(language);

        }

    }
}
```

**Output:**

```text
Java
Python
C++
```

### Quick Reference: String Methods

| Method | Purpose |
|---|---|
| `length()` | Returns String length in UTF-16 code units |
| `charAt()` | Returns a character at an index |
| `toUpperCase()` | Converts to uppercase |
| `toLowerCase()` | Converts to lowercase |
| `trim()` | Removes leading and trailing basic whitespace/control characters |
| `substring()` | Extracts a portion |
| `contains()` | Checks for a sequence |
| `startsWith()` | Checks prefix |
| `endsWith()` | Checks suffix |
| `indexOf()` | Finds first occurrence |
| `lastIndexOf()` | Finds last occurrence |
| `replace()` | Replaces characters or literal sequences |
| `replaceAll()` | Replaces regex matches |
| `replaceFirst()` | Replaces first regex match |
| `isEmpty()` | Checks whether length is zero |
| `equals()` | Compares contents |
| `equalsIgnoreCase()` | Compares contents ignoring case |
| `compareTo()` | Lexicographic comparison |
| `concat()` | Joins Strings |
| `split()` | Splits into an array |
| `intern()` | Returns pooled canonical String |

---

## 7. Difference Between `==` and `equals()` in Java

This is one of the most frequently asked Java interview questions.

### `==` Operator

The `==` operator compares primitive values when used with primitive operands.

When used with object references, it checks whether both references point to the same object.

### `equals()` Method

The `equals()` method checks logical equality based on the class implementation.

For String, it compares character contents.

### Example

```java
public class StringComparison {

    public static void main(String[] args) {

        String s1 = "Java";

        String s2 = "Java";

        String s3 = new String("Java");

        System.out.println(s1 == s2);

        System.out.println(s1 == s3);

        System.out.println(s1.equals(s3));

    }
}
```

**Output:**

```text
true
false
true
```

### Understanding the Difference

| `==` | `equals()` |
|---|---|
| Compares primitive values or object references | Compares logical equality according to the implementation |
| For references, checks object identity | For String, checks character contents |
| Operator | Method |
| Does not compare String contents by itself | Compares String contents |

### Interview Tip

When comparing two Strings for content equality, normally use:

```java
str1.equals(str2);
```

If the String reference might be `null`, use a null-safe comparison such as:

```java
"Java".equals(str);
```

---

## 8. String Concatenation

String concatenation means joining two or more Strings.

Java provides multiple ways to concatenate Strings.

### 8.1 Using the `+` Operator

```java
public class StringConcatenation {

    public static void main(String[] args) {

        String firstName = "Ayush";

        String lastName = "Soni";

        String fullName = firstName + " " + lastName;

        System.out.println(fullName);

    }
}
```

**Output:**

```text
Ayush Soni
```

### 8.2 Using `concat()`

```java
String s1 = "Hello";

String s2 = " World";

System.out.println(s1.concat(s2));
```

**Output:**

```text
Hello World
```

### 8.3 Using StringBuilder

```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" World");

System.out.println(sb);
```

**Output:**

```text
Hello World
```

### Important Difference

Repeated String concatenation can create many temporary String objects because Strings are immutable.

For repeated modifications, StringBuilder is generally more efficient.

---

## 9. StringBuilder in Java

StringBuilder is a mutable sequence of characters.

Unlike String, its contents can be modified without creating a new String object for every operation.

It was introduced in Java 5.

### Why Do We Need StringBuilder?

Consider the following code:

```java
String str = "Java";

str = str + " Programming";

str = str + " Language";
```

Each concatenation produces another String result.

For repeated modifications, this can create unnecessary temporary objects.

StringBuilder provides a more efficient alternative.

### Creating StringBuilder

```java
StringBuilder sb = new StringBuilder("Java");
```

### Example

```java
public class StringBuilderExample {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Java");

        sb.append(" Programming");

        System.out.println(sb);

    }
}
```

**Output:**

```text
Java Programming
```

### Important StringBuilder Methods

#### 9.1 `append()`

Adds content at the end.

```java
StringBuilder sb = new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb);
```

**Output:**

```text
Java Programming
```

#### 9.2 `insert()`

Inserts content at a specified position.

```java
StringBuilder sb = new StringBuilder("Java");

sb.insert(4, " Programming");

System.out.println(sb);
```

**Output:**

```text
Java Programming
```

#### 9.3 `replace()`

Replaces a range of characters.

The start index is included and the end index is excluded.

```java
StringBuilder sb = new StringBuilder("Java Programming");

sb.replace(5, 16, "Development");

System.out.println(sb);
```

**Output:**

```text
Java Development
```

#### 9.4 `delete()`

Deletes characters within a specified range.

```java
StringBuilder sb = new StringBuilder("Java Programming");

sb.delete(4, 16);

System.out.println(sb);
```

**Output:**

```text
Java
```

#### 9.5 `reverse()`

Reverses the character sequence.

```java
StringBuilder sb = new StringBuilder("Java");

sb.reverse();

System.out.println(sb);
```

**Output:**

```text
avaJ
```

#### 9.6 `capacity()`

Returns the current capacity of the StringBuilder.

```java
StringBuilder sb = new StringBuilder();

System.out.println(sb.capacity());
```

**Output:**

```text
16
```

A default StringBuilder starts with a capacity of 16 characters.

#### 9.7 `ensureCapacity()`

Ensures that the capacity is at least the specified minimum.

```java
StringBuilder sb = new StringBuilder();

sb.ensureCapacity(50);

System.out.println(sb.capacity() >= 50);
```

**Output:**

```text
true
```

#### 9.8 `setCharAt()`

Changes the character at a specified index.

```java
StringBuilder sb = new StringBuilder("Java");

sb.setCharAt(0, 'K');

System.out.println(sb);
```

**Output:**

```text
Kava
```

### StringBuilder Method Summary

| Method | Purpose |
|---|---|
| `append()` | Adds content at the end |
| `insert()` | Inserts content at an index |
| `replace()` | Replaces a range |
| `delete()` | Removes a range |
| `reverse()` | Reverses the sequence |
| `capacity()` | Returns current capacity |
| `ensureCapacity()` | Ensures minimum capacity |
| `setCharAt()` | Changes a character |
| `length()` | Returns the current length |
| `toString()` | Converts to String |

---

## 10. StringBuffer in Java

StringBuffer is another mutable sequence of characters.

It is similar to StringBuilder, but its methods are synchronized.

This makes individual StringBuffer operations synchronized, which can be useful when multiple threads access the same StringBuffer.

### Example

```java
public class StringBufferExample {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Java");

        sb.append(" Programming");

        System.out.println(sb);

    }
}
```

**Output:**

```text
Java Programming
```

### StringBuffer Methods

StringBuffer provides many methods similar to StringBuilder:

- `append()`
- `insert()`
- `replace()`
- `delete()`
- `reverse()`
- `capacity()`
- `length()`
- `setCharAt()`

### Example: StringBuffer Reverse

```java
public class StringBufferReverse {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Programming");

        sb.reverse();

        System.out.println(sb);

    }
}
```

**Output:**

```text
gnimmargorP
```

---

## 11. String vs StringBuilder vs StringBuffer

This is a very important Java interview topic.

| Feature | String | StringBuilder | StringBuffer |
|---|---|---|---|
| Mutability | Immutable | Mutable | Mutable |
| Thread safety | Safe to share because immutable | Not synchronized | Synchronized methods |
| Performance for repeated modifications | Often less efficient | Generally faster | Generally slower than StringBuilder |
| Introduced | Java 1.0 | Java 5 | Java 1.0 |
| Use case | Fixed text | Frequent modifications in one thread | Shared mutable text with synchronized operations |

### When Should You Use Each?

**Use String when:**
- Storing fixed text.
- Comparing names.
- Working with messages.
- Building values that do not require frequent modification.

**Use StringBuilder when:**
- Building large Strings.
- Repeatedly appending or modifying text.
- Working in a single-threaded context or when access is externally controlled.

**Use StringBuffer when:**
- Multiple threads share the same mutable character sequence.
- You need synchronized individual operations.

**Important:** StringBuffer's synchronized methods do not automatically make a multi-operation workflow atomic. Additional synchronization may still be necessary.

---

## 12. String Formatting in Java

Java provides `String.format()` to create formatted Strings.

It uses format specifiers.

### Common Format Specifiers

| Specifier | Meaning |
|---|---|
| `%s` | String |
| `%d` | Integer |
| `%f` | Floating-point value |
| `%c` | Character |
| `%b` | Boolean |
| `%n` | Platform-specific line separator |

### Example

```java
public class StringFormatExample {

    public static void main(String[] args) {

        String name = "Ayush";

        int age = 22;

        double percentage = 88.75;

        String result = String.format(
            "Name: %s, Age: %d, Percentage: %.2f",
            name,
            age,
            percentage
        );

        System.out.println(result);

    }
}
```

**Output:**

```text
Name: Ayush, Age: 22, Percentage: 88.75
```

---

## 13. String Conversion in Java

Java provides methods to convert values between Strings and other data types.

### 13.1 Primitive to String

Using `String.valueOf()`:

```java
int number = 100;

String str = String.valueOf(number);

System.out.println(str);
```

**Output:**

```text
100
```

### 13.2 String to Integer

Using `Integer.parseInt()`:

```java
String str = "100";

int number = Integer.parseInt(str);

System.out.println(number + 50);
```

**Output:**

```text
150
```

### 13.3 String to Double

```java
String str = "25.75";

double value = Double.parseDouble(str);

System.out.println(value);
```

**Output:**

```text
25.75
```

### 13.4 String to Boolean

```java
String str = "true";

boolean value = Boolean.parseBoolean(str);

System.out.println(value);
```

**Output:**

```text
true
```

### Important Exception

If a String does not contain a valid numeric representation, parsing may throw `NumberFormatException`.

Example:

```java
String str = "Java";

int number = Integer.parseInt(str);
```

This causes a `NumberFormatException`.

---

## 14. String and Regular Expressions

Regular expressions (Regex) are patterns used to search, match, and manipulate text.

Java supports regular expressions through the `java.util.regex` package and methods such as `matches()`, `replaceAll()`, and `split()`.

### Common Regex Symbols

| Pattern | Meaning |
|---|---|
| `[0-9]` | Any digit |
| `[a-z]` | Lowercase letter |
| `[A-Z]` | Uppercase letter |
| `[a-zA-Z]` | Any English alphabetic letter |
| `\\d` | Digit |
| `\\w` | Word character |
| `\\s` | Whitespace |
| `+` | One or more occurrences |
| `*` | Zero or more occurrences |
| `?` | Zero or one occurrence |
| `.` | Any character except line terminators by default |
| `^` | Beginning of input |
| `$` | End of input |

### Example: Check Whether a String Contains Only Digits

```java
public class RegexExample {

    public static void main(String[] args) {

        String number = "123456";

        System.out.println(number.matches("[0-9]+"));

    }
}
```

**Output:**

```text
true
```

### Example: Remove All Digits

```java
public class RemoveDigits {

    public static void main(String[] args) {

        String text = "Java123Programming456";

        String result = text.replaceAll("[0-9]", "");

        System.out.println(result);

    }
}
```

**Output:**

```text
JavaProgramming
```

**Note:** Regular expressions are powerful, but validation of complex data such as email addresses should generally use appropriate validation rules rather than a simplistic pattern.

---

## 15. Important String Programs

### Program 1: Reverse a String

```java
public class ReverseString {

    public static void main(String[] args) {

        String str = "Java";

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {

            reversed += str.charAt(i);

        }

        System.out.println("Reversed: " + reversed);

    }
}
```

**Output:**

```text
Reversed: avaJ
```

For better efficiency when building a result character by character, use StringBuilder.

### Program 2: Reverse Using StringBuilder

```java
public class ReverseUsingBuilder {

    public static void main(String[] args) {

        String str = "Programming";

        StringBuilder sb = new StringBuilder(str);

        System.out.println(sb.reverse());

    }
}
```

**Output:**

```text
gnimmargorP
```

### Program 3: Check Whether a String Is a Palindrome

A palindrome is a word or sequence that reads the same forward and backward.

Examples:
- madam
- level
- radar

```java
public class StringPalindrome {

    public static void main(String[] args) {

        String str = "madam";

        boolean isPalindrome = true;

        int left = 0;

        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {

                isPalindrome = false;

                break;

            }

            left++;

            right--;

        }

        if (isPalindrome) {

            System.out.println("Palindrome");

        } else {

            System.out.println("Not a palindrome");

        }

    }
}
```

**Output:**

```text
Palindrome
```

### Program 4: Count Vowels and Consonants

```java
public class VowelsConsonants {

    public static void main(String[] args) {

        String str = "Java Programming";

        int vowels = 0;

        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

            if (ch >= 'a' && ch <= 'z') {

                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {

                    vowels++;

                } else {

                    consonants++;

                }

            }

        }

        System.out.println("Vowels: " + vowels);

        System.out.println("Consonants: " + consonants);

    }
}
```

**Output:**

```text
Vowels: 5
Consonants: 10
```

Spaces and non-English characters are not counted in this example.

### Program 5: Count Words in a String

```java
public class CountWords {

    public static void main(String[] args) {

        String str = "Java is a programming language";

        String trimmed = str.trim();

        int count = trimmed.isEmpty()
            ? 0
            : trimmed.split("\\s+").length;

        System.out.println("Word count: " + count);

    }
}
```

**Output:**

```text
Word count: 5
```

### Program 6: Count Character Frequency

```java
public class CharacterFrequency {

    public static void main(String[] args) {

        String str = "programming";

        char target = 'g';

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == target) {

                count++;

            }

        }

        System.out.println("Frequency: " + count);

    }
}
```

**Output:**

```text
Frequency: 2
```

### Program 7: Remove Spaces from a String

```java
public class RemoveSpaces {

    public static void main(String[] args) {

        String str = "Java Programming Language";

        String result = str.replaceAll("\\s+", "");

        System.out.println(result);

    }
}
```

**Output:**

```text
JavaProgrammingLanguage
```

### Program 8: Convert First Letter of Each Word to Uppercase

```java
public class CapitalizeWords {

    public static void main(String[] args) {

        String str = "java programming language";

        String[] words = str.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            if (!word.isEmpty()) {

                String formatted = word.substring(0, 1).toUpperCase()
                    + word.substring(1).toLowerCase();

                if (result.length() > 0) {

                    result.append(" ");

                }

                result.append(formatted);

            }

        }

        System.out.println(result);

    }
}
```

**Output:**

```text
Java Programming Language
```

### Program 9: Check Whether Two Strings Are Anagrams

Two Strings are anagrams if they contain the same characters with the same frequencies, regardless of order.

Example:
- listen
- silent

```java
import java.util.Arrays;

public class AnagramCheck {

    public static void main(String[] args) {

        String s1 = "listen";

        String s2 = "silent";

        char[] a = s1.toLowerCase().toCharArray();

        char[] b = s2.toLowerCase().toCharArray();

        Arrays.sort(a);

        Arrays.sort(b);

        if (Arrays.equals(a, b)) {

            System.out.println("Anagrams");

        } else {

            System.out.println("Not Anagrams");

        }

    }
}
```

**Output:**

```text
Anagrams
```

This example assumes English letters and ignores case, but does not ignore spaces or punctuation.

### Program 10: Find Duplicate Characters

```java
public class DuplicateCharacters {

    public static void main(String[] args) {

        String str = "programming";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            boolean alreadyChecked = false;

            for (int j = 0; j < i; j++) {

                if (str.charAt(j) == ch) {

                    alreadyChecked = true;

                    break;

                }

            }

            if (alreadyChecked) {

                continue;

            }

            int count = 0;

            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) == ch) {

                    count++;

                }

            }

            if (count > 1) {

                System.out.println(ch + " = " + count);

            }

        }

    }
}
```

**Output:**

```text
r = 2
g = 2
m = 2
```

### Program 11: Find the First Non-Repeating Character

```java
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        String str = "swiss";

        boolean found = false;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            int count = 0;

            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {

                    count++;

                }

            }

            if (count == 1) {

                System.out.println("First non-repeating: " + ch);

                found = true;

                break;

            }

        }

        if (!found) {

            System.out.println("No non-repeating character.");

        }

    }
}
```

**Output:**

```text
First non-repeating: w
```

### Program 12: Check Whether a String Contains Only Digits

```java
public class OnlyDigits {

    public static void main(String[] args) {

        String str = "123456";

        boolean valid = !str.isEmpty();

        for (int i = 0; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {

                valid = false;

                break;

            }

        }

        System.out.println(valid ? "Only digits" : "Contains non-digits");

    }
}
```

**Output:**

```text
Only digits
```

### Program 13: Count Uppercase and Lowercase Letters

```java
public class UpperLowerCount {

    public static void main(String[] args) {

        String str = "Java Programming";

        int upper = 0;

        int lower = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isUpperCase(ch)) {

                upper++;

            } else if (Character.isLowerCase(ch)) {

                lower++;

            }

        }

        System.out.println("Uppercase: " + upper);

        System.out.println("Lowercase: " + lower);

    }
}
```

**Output:**

```text
Uppercase: 2
Lowercase: 13
```

### Program 14: Remove Duplicate Characters

```java
public class RemoveDuplicateCharacters {

    public static void main(String[] args) {

        String str = "programming";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (result.indexOf(String.valueOf(ch)) == -1) {

                result.append(ch);

            }

        }

        System.out.println(result);

    }
}
```

**Output:**

```text
progamin
```

### Program 15: Find the Longest Word in a Sentence

```java
public class LongestWord {

    public static void main(String[] args) {

        String str = "Java is a powerful programming language";

        String[] words = str.split("\\s+");

        String longest = "";

        for (String word : words) {

            if (word.length() > longest.length()) {

                longest = word;

            }

        }

        System.out.println("Longest word: " + longest);

    }
}
```

**Output:**

```text
Longest word: programming
```

---

## 16. Common Mistakes in Strings

| Mistake | Explanation |
|---|---|
| Using `==` to compare String contents | Use `equals()` for content comparison |
| Assuming String is mutable | String is immutable |
| Ignoring the return value of `concat()` | Store the returned String if needed |
| Using an invalid `charAt()` index | Valid indexes range from 0 to `length() - 1` |
| Confusing `length` with `length()` | Strings use `length()` |
| Using String concatenation repeatedly in large loops | Prefer StringBuilder in many such cases |
| Calling methods on a null String | Can cause NullPointerException |
| Assuming `trim()` removes all Unicode whitespace | It only removes a limited range of characters |
| Assuming `replaceAll()` uses literal text | It interprets the search pattern as a regular expression |
| Forgetting case sensitivity | Most String comparison methods are case-sensitive |

---

## 17. String Interview Questions

### Basic Questions

**Q1. What is a String in Java?**

A String is an object representing a sequence of characters.

**Q2. Is String a primitive or non-primitive data type?**

String is a reference type.

**Q3. Why is String immutable in Java?**

Immutability provides benefits such as safe sharing, security, String pooling, and reliable hash codes.

**Q4. What is the String Constant Pool?**

It is a JVM-managed pool used to reuse canonical String literals.

**Q5. What is the difference between String literal and `new String()`?**

A literal uses the pooled representation, while `new String()` explicitly creates a new String object.

**Q6. What is the use of `intern()`?**

It returns the canonical pooled representation of a String.

**Q7. What is the difference between `==` and `equals()`?**

For object references, `==` compares identity. For String, `equals()` compares contents.

**Q8. What is the use of `charAt()`?**

It returns the character at a specified index.

**Q9. What is the use of `substring()`?**

It extracts a portion of a String.

**Q10. What is String concatenation?**

It is the process of joining multiple Strings.

### Intermediate Questions

**Q11. What is StringBuilder?**

StringBuilder is a mutable sequence of characters used for efficient String construction and modification.

**Q12. What is StringBuffer?**

StringBuffer is a mutable sequence of characters with synchronized methods.

**Q13. What is the difference between StringBuilder and StringBuffer?**

StringBuilder is not synchronized and is generally faster in single-threaded use. StringBuffer synchronizes its methods.

**Q14. Is StringBuilder thread-safe?**

No. It is not synchronized.

**Q15. Is StringBuffer thread-safe?**

Its individual methods are synchronized, although compound operations may still require external synchronization.

**Q16. What is the use of `append()`?**

It adds content to the end of a StringBuilder or StringBuffer.

**Q17. What is the use of `reverse()`?**

It reverses the character sequence in StringBuilder or StringBuffer.

**Q18. What is the difference between `equals()` and `equalsIgnoreCase()`?**

`equals()` compares content with case sensitivity, while `equalsIgnoreCase()` ignores case differences.

**Q19. What is the difference between `replace()` and `replaceAll()`?**

`replace()` performs literal character or sequence replacement, while `replaceAll()` uses a regular expression.

**Q20. What is the use of `split()`?**

It divides a String into an array using a regular expression.

### Advanced Questions

**Q21. Why is String commonly used as a HashMap key?**

String is immutable and provides stable equality and hash-code behavior.

**Q22. Can we create a mutable String?**

String itself is immutable. For mutable character sequences, use StringBuilder or StringBuffer.

**Q23. What is the default capacity of StringBuilder?**

The default initial capacity is 16 characters.

**Q24. What happens when StringBuilder exceeds its capacity?**

Its internal storage grows automatically.

**Q25. What is the difference between `isEmpty()` and `isBlank()`?**

`isEmpty()` checks whether the length is zero. `isBlank()` checks whether the String is empty or contains only whitespace, but `isBlank()` was introduced in Java 11 and is not available in Java 8.

**Q26. What is the difference between `trim()` and `strip()`?**

`trim()` is available in Java 8 and removes leading and trailing characters up to U+0020. `strip()` uses Unicode whitespace rules and was introduced in Java 11.

**Q27. Does String length always equal the number of visible characters?**

No. `length()` counts UTF-16 code units. Some Unicode characters use multiple code units, and visible grapheme clusters may contain multiple code points.

**Q28. Can we override the String class?**

No. String is final, so it cannot be subclassed.

**Q29. Why is String declared final?**

It prevents subclasses from changing String's behavior and helps preserve its design guarantees.

**Q30. What is the difference between String and char array?**

String is immutable, while a character array can be modified. Character arrays can be useful when handling sensitive data, although they still require careful memory management.

---

## 18. Practice Exercises

**Instructions:** Solve the following questions independently. Write separate Java programs and test your code using different inputs. Do not rely entirely on built-in methods; implement the logic manually where possible.

### Beginner Level

1. Write a Java program to accept a String from the user and display it.
2. Find the length of a String without using the `length()` method.
3. Convert a String into uppercase without using `toUpperCase()`.
4. Convert a String into lowercase without using `toLowerCase()`.
5. Reverse a String using a loop.
6. Reverse a String using StringBuilder.
7. Check whether a String is a palindrome.
8. Count vowels and consonants in a String.
9. Count the number of words in a sentence.
10. Count the number of spaces in a String.
11. Count uppercase and lowercase characters.
12. Count digits, letters, and special characters.
13. Find the frequency of a particular character.
14. Check whether a String contains only digits.
15. Remove all spaces from a String.

### Intermediate Level

16. Find duplicate characters in a String.
17. Remove duplicate characters while preserving their first occurrence.
18. Find the first non-repeating character.
19. Find the first repeating character.
20. Check whether two Strings are anagrams.
21. Check whether two Strings are rotations of each other.
22. Find the longest word in a sentence.
23. Find the shortest word in a sentence.
24. Reverse each word in a sentence.
25. Reverse the order of words in a sentence.
26. Capitalize the first letter of every word.
27. Count the frequency of every character.
28. Find the most frequently occurring character.
29. Compare two Strings without using `equals()`.
30. Remove all duplicate words from a sentence.

### Advanced Level

31. Find the longest substring without repeating characters.
32. Find the longest palindromic substring.
33. Find the longest common prefix among multiple Strings.
34. Find the longest common subsequence of two Strings.
35. Implement String pattern matching without using `contains()`.
36. Implement a basic version of `indexOf()`.
37. Implement a basic version of `replace()`.
38. Check whether a String is a valid palindrome after ignoring spaces, punctuation, and case.
39. Compress a String using character counts.
40. Find all permutations of a String.
41. Find all substrings of a String.
42. Implement a basic run-length encoding algorithm.
43. Validate a password using suitable conditions.
44. Create a word-frequency counter for a paragraph.
45. Build a simple text-processing application using StringBuilder.

---

## 20. Key Takeaways

After completing this chapter, you should understand:

- What Strings are and how they are used in Java.
- Different ways to create String objects.
- The String Constant Pool.
- The purpose of the `intern()` method.
- Why Strings are immutable.
- Important built-in String methods.
- The difference between `==` and `equals()`.
- String concatenation and formatting.
- StringBuilder and StringBuffer.
- The differences between String, StringBuilder, and StringBuffer.
- String conversion and regular expressions.
- Common String programming problems.
- How to compare, search, reverse, and manipulate Strings.
- Common String interview questions.

## What's Next?

**Chapter 9: Java Exception Handling**

Topics to explore:

1. Introduction to Exception Handling.
2. Errors vs Exceptions.
3. Exception Hierarchy.
4. Checked and Unchecked Exceptions.
5. try and catch Blocks.
6. Multiple Catch Blocks.
7. Nested try Blocks.
8. finally Block.
9. throw Keyword.
10. throws Keyword.
11. Custom Exceptions.
12. Exception Propagation.
13. try-with-resources.
14. Common Exception Handling Programs.
15. Exception Handling Interview Questions.
16. Practice Exercises.

**Learning Tip:** String questions are extremely common in Java coding interviews. Practice reversing Strings, checking palindromes, finding duplicate characters, anagrams, and character frequencies. Also understand why Strings are immutable and when to use StringBuilder instead of String.