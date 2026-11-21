# Chapter 7: Arrays in Java

## 1. Introduction to Arrays

An array is a data structure that stores multiple values of the same data type in a single variable.

Suppose you want to store the marks of five students.

Without an array, you might declare five separate variables:

```java
int marks1 = 85;
int marks2 = 90;
int marks3 = 78;
int marks4 = 88;
int marks5 = 95;
```

This approach becomes difficult when you need to store hundreds or thousands of values.

Instead, Java provides arrays.

```java
int[] marks = {85, 90, 78, 88, 95};
```

Now, all five values are stored in a single array variable.

### Why Do We Need Arrays?

Arrays are useful when:
- We need to store multiple values of the same type.
- We want to process collections of data efficiently.
- We need to perform searching and sorting.
- We want to reduce the number of individual variables.
- We need to work with tables and matrices.

### Characteristics of Arrays

1. Arrays store elements of the same declared type.
2. Array indexing starts from `0`.
3. Arrays have a fixed length after creation.
4. Array elements are stored in indexed positions.
5. Arrays are objects in Java.
6. Arrays can store primitive values and object references.
7. The length of an array is available through the `length` property.

---

## 2. Array Declaration in Java

Before using an array, we need to declare it.

### Syntax

```java
dataType[] arrayName;
```

Another valid syntax is:

```java
dataType arrayName[];
```

### Examples

```java
int[] numbers;

double[] prices;

char[] letters;

String[] names;
```

The first syntax is generally preferred because it clearly indicates that the variable is an array.

**Important:** Declaring an array reference does not create the array object.

---

## 3. Array Initialization

After declaration, we can create an array using the `new` keyword.

### Syntax

```java
arrayName = new dataType[size];
```

### Example

```java
public class ArrayInitialization {

    public static void main(String[] args) {

        int[] numbers = new int[5];

        numbers[0] = 10;

        numbers[1] = 20;

        numbers[2] = 30;

        numbers[3] = 40;

        numbers[4] = 50;

        System.out.println(numbers[0]);

        System.out.println(numbers[4]);

    }
}
```

**Output:**

```text
10
50
```

### Understanding Array Indexing

Consider this array:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

Its indexes are:

| Index | Value |
|---:|---:|
| 0 | 10 |
| 1 | 20 |
| 2 | 30 |
| 3 | 40 |
| 4 | 50 |

<pre>
Index:    0     1     2     3     4
        +-----+-----+-----+-----+-----+
Array:  |  10 |  20 |  30 |  40 |  50 |
        +-----+-----+-----+-----+-----+
</pre>

The first element is at index `0`, not index `1`.

For an array of length `n`:
- First index = `0`
- Last index = `n - 1`
- Number of elements = `n`

---

## 4. Different Ways to Initialize Arrays

Java supports several ways to initialize arrays.

### 4.1 Initialize During Declaration

```java
int[] numbers = {10, 20, 30, 40, 50};
```

### 4.2 Declare First, Initialize Later

```java
int[] numbers;

numbers = new int[]{10, 20, 30, 40, 50};
```

### 4.3 Using the `new` Keyword

```java
int[] numbers = new int[5];
```

### 4.4 Using a Loop

```java
public class ArrayLoopInitialization {

    public static void main(String[] args) {

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = (i + 1) * 10;

        }

        for (int i = 0; i < numbers.length; i++) {

            System.out.println(numbers[i]);

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

---

## 5. Default Values of Array Elements

When an array is created using `new`, its elements are automatically initialized with default values.

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
| Object reference | null |

### Example

```java
public class ArrayDefaultValues {

    public static void main(String[] args) {

        int[] numbers = new int[3];

        boolean[] values = new boolean[3];

        String[] names = new String[3];

        System.out.println(numbers[0]);

        System.out.println(values[0]);

        System.out.println(names[0]);

    }
}
```

**Output:**

```text
0
false
null
```

---

## 6. Accessing Array Elements

We can access individual elements using their indexes.

### Example

```java
public class AccessArray {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("First element: " + numbers[0]);

        System.out.println("Third element: " + numbers[2]);

        System.out.println("Last element: " +
            numbers[numbers.length - 1]);

    }
}
```

**Output:**

```text
First element: 10
Third element: 30
Last element: 50
```

### Updating Array Elements

Array elements can be modified using their indexes.

```java
int[] numbers = {10, 20, 30};

numbers[1] = 100;
```

The updated array becomes:

```text
10 100 30
```

---

## 7. Traversing an Array

Array traversal means visiting each element of an array one by one.

Java provides different ways to traverse arrays.

### 7.1 Using a For Loop

```java
public class ArrayTraversal {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        for (int i = 0; i < numbers.length; i++) {

            System.out.println(numbers[i]);

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

### 7.2 Using an Enhanced For Loop

The enhanced for loop is also called the for-each loop.

It is useful when you want to access every element without manually managing indexes.

### Syntax

```java
for (dataType variable : arrayName) {

    // Statements

}
```

### Example

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

### For Loop vs Enhanced For Loop

| For Loop | Enhanced For Loop |
|---|---|
| Uses an index | Directly accesses elements |
| Supports forward and backward traversal | Normally traverses in iteration order |
| Useful when indexes are required | Useful for simple traversal |
| Can update elements using indexes | Assigning to the loop variable does not update array elements |

---

## 8. Taking Array Input Using Scanner

We can use the Scanner class to accept array elements from the user.

### Example

```java
import java.util.Scanner;

public class ArrayInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");

        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {

            numbers[i] = sc.nextInt();

        }

        System.out.println("Array elements:");

        for (int i = 0; i < n; i++) {

            System.out.print(numbers[i] + " ");

        }

        sc.close();

    }
}
```

**Sample Input:**

```text
Enter array size: 5
Enter array elements:
10 20 30 40 50
```

**Output:**

```text
Array elements:
10 20 30 40 50
```

---

# 9. One-Dimensional Array

A one-dimensional array stores elements in a single sequence.

Example:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

<pre>
+----+----+----+----+----+
| 10 | 20 | 30 | 40 | 50 |
+----+----+----+----+----+
  0    1    2    3    4
</pre>

### Example: Sum of Array Elements

```java
public class ArraySum {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {

            sum += numbers[i];

        }

        System.out.println("Sum = " + sum);

    }
}
```

**Output:**

```text
Sum = 150
```

### Example: Average of Array Elements

```java
public class ArrayAverage {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int sum = 0;

        for (int number : numbers) {

            sum += number;

        }

        double average = (double) sum / numbers.length;

        System.out.println("Average = " + average);

    }
}
```

**Output:**

```text
Average = 30.0
```

---

# 10. Two-Dimensional Arrays in Java

A two-dimensional array stores data in rows and columns.

It is commonly used to represent tables, matrices, and grids.

### Example

```java
int[][] matrix = {

    {1, 2, 3},

    {4, 5, 6},

    {7, 8, 9}

};
```

<pre>
        Column
         0  1  2
       +---------+
Row 0  | 1  2  3 |
Row 1  | 4  5  6 |
Row 2  | 7  8  9 |
       +---------+
</pre>

### Declaration

```java
dataType[][] arrayName;
```

### Creation

```java
int[][] matrix = new int[3][3];
```

This creates an array with three rows and three columns.

### Accessing Elements

```java
matrix[0][0]
matrix[1][2]
matrix[2][1]
```

### Example: Display a Matrix

```java
public class MatrixDisplay {

    public static void main(String[] args) {

        int[][] matrix = {

            {1, 2, 3},

            {4, 5, 6},

            {7, 8, 9}

        };

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();

        }

    }
}
```

**Output:**

```text
1 2 3
4 5 6
7 8 9
```

### Understanding Nested Loops

- The outer loop controls rows.
- The inner loop controls columns.
- `matrix[i][j]` accesses the element at row `i` and column `j`.

---

## 11. Taking Two-Dimensional Array Input

```java
import java.util.Scanner;

public class MatrixInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");

        int rows = sc.nextInt();

        System.out.print("Enter columns: ");

        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = sc.nextInt();

            }

        }

        System.out.println("Matrix:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();

        }

        sc.close();

    }
}
```

**Sample Input:**

```text
Enter rows: 2
Enter columns: 3
Enter matrix elements:
1 2 3
4 5 6
```

**Output:**

```text
Matrix:
1 2 3
4 5 6
```

---

# 12. Multidimensional Arrays

An array can have more than two dimensions.

A three-dimensional array can be understood as a collection of two-dimensional arrays.

### Declaration

```java
int[][][] numbers = new int[2][3][4];
```

This creates:
- 2 blocks.
- 3 rows in each block.
- 4 columns in each row.

### Example

```java
public class ThreeDimensionalArray {

    public static void main(String[] args) {

        int[][][] numbers = {

            {

                {1, 2},

                {3, 4}

            },

            {

                {5, 6},

                {7, 8}

            }

        };

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers[i].length; j++) {

                for (int k = 0; k < numbers[i][j].length; k++) {

                    System.out.print(numbers[i][j][k] + " ");

                }

                System.out.println();

            }

            System.out.println();

        }

    }
}
```

**Output:**

```text
1 2
3 4

5 6
7 8
```

### Real-World Uses

- 3D game environments.
- Scientific calculations.
- Image and video processing.
- Data organized by multiple categories.

---

# 13. Jagged Arrays in Java

A jagged array is a two-dimensional array in which each row can have a different number of columns.

Java supports jagged arrays because a two-dimensional array is actually an array of arrays.

### Example

```java
public class JaggedArray {

    public static void main(String[] args) {

        int[][] numbers = new int[3][];

        numbers[0] = new int[2];

        numbers[1] = new int[3];

        numbers[2] = new int[4];

        numbers[0][0] = 10;

        numbers[0][1] = 20;

        numbers[1][0] = 30;

        numbers[1][1] = 40;

        numbers[1][2] = 50;

        numbers[2][0] = 60;

        numbers[2][1] = 70;

        numbers[2][2] = 80;

        numbers[2][3] = 90;

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers[i].length; j++) {

                System.out.print(numbers[i][j] + " ");

            }

            System.out.println();

        }

    }
}
```

**Output:**

```text
10 20
30 40 50
60 70 80 90
```

### Important Difference

| Rectangular Array | Jagged Array |
|---|---|
| Rows have equal column counts | Rows can have different column counts |
| Example: `new int[3][3]` | Example: `new int[3][]` |
| Useful for matrices | Useful for irregular data |

---

# 14. The `length` Property in Arrays

Java arrays have a built-in `length` property.

It returns the number of elements in an array.

### Example

```java
public class ArrayLength {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array length: " + numbers.length);

    }
}
```

**Output:**

```text
Array length: 5
```

### Important Difference: `length`, `length()`, and `size()`

| Expression | Used For |
|---|---|
| `array.length` | Arrays |
| `string.length()` | Strings |
| `collection.size()` | Collections such as ArrayList |

Remember that `length` is a property for arrays, not a method.

---

# 15. The `Arrays` Utility Class

Java provides the `java.util.Arrays` class to perform common array operations.

Import it using:

```java
import java.util.Arrays;
```

### Common Methods

| Method | Purpose |
|---|---|
| `Arrays.toString()` | Converts a one-dimensional array into a readable String |
| `Arrays.sort()` | Sorts an array |
| `Arrays.binarySearch()` | Searches for an element in a sorted array |
| `Arrays.equals()` | Compares two arrays element by element |
| `Arrays.fill()` | Fills array elements with a specified value |
| `Arrays.copyOf()` | Copies an array to a specified length |
| `Arrays.deepToString()` | Displays nested arrays in readable form |
| `Arrays.deepEquals()` | Compares nested arrays |

### Example: Arrays.toString()

```java
import java.util.Arrays;

public class ArrayToString {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40};

        System.out.println(Arrays.toString(numbers));

    }
}
```

**Output:**

```text
[10, 20, 30, 40]
```

### Example: Arrays.sort()

```java
import java.util.Arrays;

public class ArraySorting {

    public static void main(String[] args) {

        int[] numbers = {50, 10, 40, 20, 30};

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

    }
}
```

**Output:**

```text
[10, 20, 30, 40, 50]
```

### Example: Arrays.binarySearch()

```java
import java.util.Arrays;

public class BinarySearchMethod {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int index = Arrays.binarySearch(numbers, 30);

        System.out.println("Element found at index: " + index);

    }
}
```

**Output:**

```text
Element found at index: 2
```

**Important:** `Arrays.binarySearch()` expects the array to be sorted according to the search order. For an unsorted array, its result is not reliable.

---

# 16. Searching in Arrays

Searching means finding whether a particular element exists in an array and identifying its position.

Two important searching algorithms are:

1. Linear Search.
2. Binary Search.

## 16.1 Linear Search

Linear search checks each element one by one until the required element is found or the array ends.

### Algorithm

1. Start from the first element.
2. Compare the current element with the target.
3. If they match, return the index.
4. Otherwise, move to the next element.
5. If no match is found, return `-1`.

### Example

```java
public class LinearSearch {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int target = 30;

        int index = -1;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {

                index = i;

                break;

            }

        }

        if (index != -1) {

            System.out.println("Element found at index: " + index);

        } else {

            System.out.println("Element not found.");

        }

    }
}
```

**Output:**

```text
Element found at index: 2
```

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

Linear search works with both sorted and unsorted arrays.

## 16.2 Binary Search

Binary search is an efficient searching algorithm that repeatedly divides the search range into two halves.

**Important:** The array must be sorted before applying binary search.

### Algorithm

1. Set `low` to the first index.
2. Set `high` to the last index.
3. Calculate the middle index.
4. Compare the middle element with the target.
5. If equal, return the index.
6. If the target is smaller, search the left half.
7. If the target is larger, search the right half.
8. Repeat until the element is found or the search range becomes empty.

### Example

```java
public class BinarySearch {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50, 60, 70};

        int target = 50;

        int low = 0;

        int high = numbers.length - 1;

        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (numbers[mid] == target) {

                result = mid;

                break;

            } else if (numbers[mid] < target) {

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }

        if (result != -1) {

            System.out.println("Element found at index: " + result);

        } else {

            System.out.println("Element not found.");

        }

    }
}
```

**Output:**

```text
Element found at index: 4
```

### Binary Search Example

Consider:

```text
10 20 30 40 50 60 70
```

Search for `50`.

| Step | Low | High | Mid | Middle Value | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 40 | Search right half |
| 2 | 4 | 6 | 5 | 60 | Search left half |
| 3 | 4 | 4 | 4 | 50 | Element found |

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

### Linear Search vs Binary Search

| Linear Search | Binary Search |
|---|---|
| Checks elements one by one | Divides search range into halves |
| Works on unsorted arrays | Requires sorted data |
| Worst case O(n) | Worst case O(log n) |
| Simple to implement | More efficient for large sorted arrays |

---

# 17. Sorting in Arrays

Sorting means arranging array elements in a particular order.

Common sorting orders:
- Ascending order.
- Descending order.

Important sorting algorithms include:

1. Bubble Sort.
2. Selection Sort.
3. Insertion Sort.
4. Merge Sort.
5. Quick Sort.

## 17.1 Bubble Sort

Bubble sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

### Example

```java
public class BubbleSort {

    public static void main(String[] args) {

        int[] numbers = {50, 20, 40, 10, 30};

        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (numbers[j] > numbers[j + 1]) {

                    int temp = numbers[j];

                    numbers[j] = numbers[j + 1];

                    numbers[j + 1] = temp;

                }

            }

        }

        for (int number : numbers) {

            System.out.print(number + " ");

        }

    }
}
```

**Output:**

```text
10 20 30 40 50
```

### Bubble Sort Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n) with an early-exit optimization |
| Average Case | O(n²) |
| Worst Case | O(n²) |
| Space Complexity | O(1) |

The above basic implementation does not use the early-exit optimization, so its best-case time complexity is also O(n²).

## 17.2 Selection Sort

Selection sort repeatedly finds the smallest element from the unsorted part and places it at the beginning.

### Example

```java
public class SelectionSort {

    public static void main(String[] args) {

        int[] numbers = {64, 25, 12, 22, 11};

        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (numbers[j] < numbers[minIndex]) {

                    minIndex = j;

                }

            }

            int temp = numbers[i];

            numbers[i] = numbers[minIndex];

            numbers[minIndex] = temp;

        }

        for (int number : numbers) {

            System.out.print(number + " ");

        }

    }
}
```

**Output:**

```text
11 12 22 25 64
```

### Selection Sort Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |
| Space Complexity | O(1) |

## 17.3 Insertion Sort

Insertion sort builds a sorted section by inserting each new element into its correct position.

### Example

```java
public class InsertionSort {

    public static void main(String[] args) {

        int[] numbers = {5, 3, 4, 1, 2};

        for (int i = 1; i < numbers.length; i++) {

            int key = numbers[i];

            int j = i - 1;

            while (j >= 0 && numbers[j] > key) {

                numbers[j + 1] = numbers[j];

                j--;

            }

            numbers[j + 1] = key;

        }

        for (int number : numbers) {

            System.out.print(number + " ");

        }

    }
}
```

**Output:**

```text
1 2 3 4 5
```

### Insertion Sort Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n) |
| Average Case | O(n²) |
| Worst Case | O(n²) |
| Space Complexity | O(1) |

### Sorting Algorithms Comparison

| Algorithm | Best Case | Average Case | Worst Case |
|---|---|---|---|
| Bubble Sort | O(n) with optimization | O(n²) | O(n²) |
| Selection Sort | O(n²) | O(n²) | O(n²) |
| Insertion Sort | O(n) | O(n²) | O(n²) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) |
| Quick Sort | O(n log n) | O(n log n) | O(n²) |

---

# 18. Copying Arrays in Java

Arrays are objects. Assigning one array reference to another does not create a new array.

### Example: Reference Assignment

```java
public class ArrayReference {

    public static void main(String[] args) {

        int[] a = {10, 20, 30};

        int[] b = a;

        b[0] = 100;

        System.out.println(a[0]);

    }
}
```

**Output:**

```text
100
```

Both references point to the same array.

### 18.1 Copy Using a Loop

```java
public class ArrayCopyLoop {

    public static void main(String[] args) {

        int[] original = {10, 20, 30};

        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {

            copy[i] = original[i];

        }

        copy[0] = 100;

        System.out.println("Original: " +
            java.util.Arrays.toString(original));

        System.out.println("Copy: " +
            java.util.Arrays.toString(copy));

    }
}
```

**Output:**

```text
Original: [10, 20, 30]
Copy: [100, 20, 30]
```

### 18.2 Copy Using Arrays.copyOf()

```java
import java.util.Arrays;

public class ArrayCopyMethod {

    public static void main(String[] args) {

        int[] original = {10, 20, 30};

        int[] copy = Arrays.copyOf(original, original.length);

        System.out.println(Arrays.toString(copy));

    }
}
```

**Output:**

```text
[10, 20, 30]
```

**Note:** These methods create a new array, but copying an array of object references is shallow copying. The referenced objects are not automatically cloned.

---

# 19. Passing Arrays to Methods

Arrays can be passed as arguments to methods.

This allows us to perform operations on arrays using reusable methods.

### Example

```java
public class ArrayAsParameter {

    static void display(int[] numbers) {

        for (int number : numbers) {

            System.out.print(number + " ");

        }

    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        display(arr);

    }
}
```

**Output:**

```text
10 20 30 40
```

### Returning Arrays from Methods

A method can return an array.

```java
public class ReturnArray {

    static int[] getNumbers() {

        int[] numbers = {10, 20, 30, 40};

        return numbers;

    }

    public static void main(String[] args) {

        int[] result = getNumbers();

        for (int number : result) {

            System.out.print(number + " ");

        }

    }
}
```

**Output:**

```text
10 20 30 40
```

---

# 20. Important Array Programs

### Program 1: Find the Largest Element

```java
public class LargestElement {

    public static void main(String[] args) {

        int[] numbers = {10, 50, 30, 90, 20};

        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] > max) {

                max = numbers[i];

            }

        }

        System.out.println("Largest element: " + max);

    }
}
```

**Output:**

```text
Largest element: 90
```

### Program 2: Find the Smallest Element

```java
public class SmallestElement {

    public static void main(String[] args) {

        int[] numbers = {10, 50, 30, 90, 20};

        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] < min) {

                min = numbers[i];

            }

        }

        System.out.println("Smallest element: " + min);

    }
}
```

**Output:**

```text
Smallest element: 10
```

### Program 3: Reverse an Array

```java
public class ReverseArray {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int left = 0;

        int right = numbers.length - 1;

        while (left < right) {

            int temp = numbers[left];

            numbers[left] = numbers[right];

            numbers[right] = temp;

            left++;

            right--;

        }

        for (int number : numbers) {

            System.out.print(number + " ");

        }

    }
}
```

**Output:**

```text
50 40 30 20 10
```

### Program 4: Count Even and Odd Numbers

```java
public class CountEvenOdd {

    public static void main(String[] args) {

        int[] numbers = {10, 15, 20, 25, 30, 35};

        int even = 0;

        int odd = 0;

        for (int number : numbers) {

            if (number % 2 == 0) {

                even++;

            } else {

                odd++;

            }

        }

        System.out.println("Even numbers: " + even);

        System.out.println("Odd numbers: " + odd);

    }
}
```

**Output:**

```text
Even numbers: 3
Odd numbers: 3
```

### Program 5: Find the Second Largest Distinct Element

```java
public class SecondLargest {

    public static void main(String[] args) {

        int[] numbers = {10, 50, 30, 90, 90, 20};

        Integer largest = null;

        Integer secondLargest = null;

        for (int number : numbers) {

            if (largest == null || number > largest) {

                if (largest == null || number != largest) {

                    secondLargest = largest;

                }

                largest = number;

            } else if (number != largest &&
                       (secondLargest == null || number > secondLargest)) {

                secondLargest = number;

            }

        }

        if (secondLargest != null) {

            System.out.println("Second largest: " + secondLargest);

        } else {

            System.out.println("No second distinct largest element.");

        }

    }
}
```

**Output:**

```text
Second largest: 50
```

### Program 6: Remove Duplicate Elements

```java
import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 10, 30, 20, 40};

        int[] result = new int[numbers.length];

        int count = 0;

        for (int i = 0; i < numbers.length; i++) {

            boolean found = false;

            for (int j = 0; j < count; j++) {

                if (numbers[i] == result[j]) {

                    found = true;

                    break;

                }

            }

            if (!found) {

                result[count] = numbers[i];

                count++;

            }

        }

        int[] unique = Arrays.copyOf(result, count);

        System.out.println(Arrays.toString(unique));

    }
}
```

**Output:**

```text
[10, 20, 30, 40]
```

### Program 7: Merge Two Arrays

```java
import java.util.Arrays;

public class MergeArrays {

    public static void main(String[] args) {

        int[] a = {10, 20, 30};

        int[] b = {40, 50, 60};

        int[] merged = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {

            merged[i] = a[i];

        }

        for (int i = 0; i < b.length; i++) {

            merged[a.length + i] = b[i];

        }

        System.out.println(Arrays.toString(merged));

    }
}
```

**Output:**

```text
[10, 20, 30, 40, 50, 60]
```

### Program 8: Add Two Matrices

```java
public class MatrixAddition {

    public static void main(String[] args) {

        int[][] a = {

            {1, 2},

            {3, 4}

        };

        int[][] b = {

            {5, 6},

            {7, 8}

        };

        int[][] sum = new int[2][2];

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                sum[i][j] = a[i][j] + b[i][j];

            }

        }

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                System.out.print(sum[i][j] + " ");

            }

            System.out.println();

        }

    }
}
```

**Output:**

```text
6 8
10 12
```

---

# 21. Common Array Exceptions

Java provides runtime exceptions when array operations are invalid.

### 21.1 ArrayIndexOutOfBoundsException

Occurs when accessing an index outside the valid range.

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

This causes an `ArrayIndexOutOfBoundsException`.

Valid indexes are `0`, `1`, and `2`.

### 21.2 NullPointerException

Occurs when trying to access an array through a reference that is `null`.

```java
int[] numbers = null;

System.out.println(numbers.length);
```

This causes a `NullPointerException`.

### 21.3 NegativeArraySizeException

Occurs when trying to create an array with a negative size.

```java
int[] numbers = new int[-5];
```

### 21.4 ArrayStoreException

Can occur when storing an incompatible object in an array whose runtime component type does not permit it.

```java
Object[] values = new String[3];

values[0] = "Java";

// This causes ArrayStoreException at runtime.
values[1] = 100;
```

---

# 22. Common Mistakes in Arrays

| Mistake | Explanation |
|---|---|
| Starting the index from 1 | Java array indexing starts from 0 |
| Accessing an invalid index | Causes ArrayIndexOutOfBoundsException |
| Using `length()` for an array | Use the `length` property |
| Assuming array size changes automatically | Array length is fixed after creation |
| Using binary search on unsorted data | Search results may be incorrect |
| Confusing reference assignment with copying | Both references may point to the same array |
| Forgetting to initialize the array reference | Can cause NullPointerException |
| Using `<= array.length` in traversal | The final valid index is `array.length - 1` |
| Confusing a 2D array with a rectangular matrix | Java supports rows with different lengths |

---

# 23. Arrays Interview Questions

## Basic Questions

**Q1. What is an array in Java?**

An array is an object that stores a fixed number of elements of the same declared component type.

**Q2. What is the default index of an array?**

Array indexing starts from zero.

**Q3. What is the default value of an integer array?**

The default value of each `int` element is zero.

**Q4. What is the maximum index of an array?**

For an array of length `n`, the maximum valid index is `n - 1`.

**Q5. Are arrays objects in Java?**

Yes. Arrays are objects created at runtime.

**Q6. Can an array store different data types?**

A primitive array stores values of one primitive type. An object array stores references compatible with its declared component type.

**Q7. Can we change the size of an array after creation?**

No. Its length is fixed after creation.

**Q8. What is a multidimensional array?**

It is an array whose elements are themselves arrays.

## Intermediate Questions

**Q9. What is a jagged array?**

A jagged array is a multidimensional array whose rows can have different lengths.

**Q10. What is the difference between length and size()?**

`length` is a property of arrays, while `size()` is a method used by collections such as ArrayList.

**Q11. What is the difference between Linear Search and Binary Search?**

Linear search checks elements one by one. Binary search repeatedly divides a sorted search range into halves.

**Q12. What is the time complexity of Linear Search?**

Its worst-case time complexity is O(n).

**Q13. What is the time complexity of Binary Search?**

Its worst-case time complexity is O(log n).

**Q14. What is the purpose of Arrays.sort()?**

It sorts array elements into ascending order for primitive arrays and uses the applicable natural ordering for object arrays.

**Q15. What is the purpose of Arrays.toString()?**

It converts a one-dimensional array into a readable String representation.

**Q16. What is the difference between array reference assignment and array copying?**

Reference assignment makes two variables point to the same array. Copying creates a separate array.

**Q17. Can we pass an array to a method?**

Yes. Arrays can be passed as method arguments.

**Q18. Can a method return an array?**

Yes. A method can return an array reference.

**Q19. What is ArrayIndexOutOfBoundsException?**

It is a runtime exception that occurs when an invalid array index is accessed.

**Q20. Is an array dynamically resizable?**

No. Java arrays have a fixed length. For dynamically resizable collections, Java provides ArrayList and other collection classes.

---

# 24. Practice Exercises

**Instructions:** Solve the following exercises independently. Write separate Java programs, test your code, and analyze the time complexity wherever applicable.

## Beginner Level

1. Create an integer array of 10 elements and display all elements.
2. Take array elements from the user using Scanner and display them.
3. Calculate the sum of all elements in an array.
4. Calculate the average of array elements.
5. Find the largest element in an array.
6. Find the smallest element in an array.
7. Count even and odd numbers in an array.
8. Count positive, negative, and zero elements.
9. Search for an element using linear search.
10. Reverse an array.
11. Copy one array into another.
12. Find the frequency of a given element in an array.

## Intermediate Level

13. Find the second largest distinct element in an array.
14. Find the second smallest distinct element in an array.
15. Remove duplicate elements from an array.
16. Merge two arrays into a third array.
17. Find common elements between two arrays.
18. Find missing numbers in a sequence stored in an array.
19. Sort an array using Bubble Sort.
20. Sort an array using Selection Sort.
21. Sort an array using Insertion Sort.
22. Implement Binary Search using an iterative approach.
23. Implement Binary Search using recursion.
24. Rotate an array to the left by a given number of positions.
25. Rotate an array to the right by a given number of positions.

## Advanced Level

26. Find the maximum and minimum sum of a subarray of fixed size.
27. Find the maximum sum contiguous subarray.
28. Find all pairs of elements whose sum equals a given target.
29. Find the majority element in an array.
30. Move all zeros to the end of an array without changing the relative order of non-zero elements.
31. Find the intersection and union of two arrays.
32. Implement Merge Sort.
33. Implement Quick Sort.
34. Find the transpose of a matrix.
35. Perform matrix multiplication.
36. Check whether a matrix is symmetric.
37. Find the sum of primary and secondary diagonals of a square matrix.
38. Find the row and column with the maximum sum in a matrix.
39. Rotate a square matrix by 90 degrees.
40. Implement a Student Marks Management System using arrays.

---

# 26. Key Takeaways

After completing this chapter, you should understand:

- What arrays are and why they are used.
- How to declare, create, initialize, and access arrays.
- How array indexing works.
- How to traverse arrays using loops.
- How to accept array input using Scanner.
- One-dimensional, two-dimensional, and multidimensional arrays.
- Jagged arrays and their applications.
- The difference between `length`, `length()`, and `size()`.
- How to use Java's Arrays utility class.
- Linear Search and Binary Search.
- Bubble Sort, Selection Sort, and Insertion Sort.
- How to copy, pass, and return arrays.
- How to perform common array operations.
- Common array exceptions and how to avoid them.

## What's Next?

**Chapter 8: Java Strings**

Topics to explore:

1. Introduction to Strings.
2. String Creation and Initialization.
3. String Constant Pool.
4. String Immutability.
5. String Methods.
6. String Comparison: `==` vs `equals()`.
7. String Concatenation.
8. StringBuilder.
9. StringBuffer.
10. String vs StringBuilder vs StringBuffer.
11. Common String Programs.
12. String Interview Questions.
13. Practice Exercises.

**Learning Tip:** Arrays are one of the most frequently tested topics in coding interviews. Practice searching, sorting, reversing, rotating, and finding elements without relying entirely on built-in methods. Understanding the logic will prepare you for more advanced data structures and algorithms.