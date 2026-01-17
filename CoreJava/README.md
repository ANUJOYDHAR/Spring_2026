# Java Stack vs Heap Memory Demo

This project demonstrates the core differences between Stack and Heap memory in Java using a simple console application.

## Key Concepts Demonstrated

1.  **Stack Memory**:
    *   Stores primitive data types (`int`, `double`, etc.).
    *   Stores *references* to objects on the Heap.
    *   Organized in "Stack Frames" which are created when a method is called and destroyed when it returns.
    *   **Note**: Java does not handle physical addresses for Stack variables to developers.

2.  **Heap Memory**:
    *   Stores all Objects (e.g., `new Person(...)`).
    *   Objects remain on the Heap until they are no longer referenced.
    *   **Garbage Collection**: We demonstrate how objects become "unreachable" (eligible for GC) once their reference on the Stack is lost.

3.  **Memory Addresses**:
    *   We use `System.identityHashCode(obj)` to display the unique "logical address" of objects on the Heap.

## How to Run

1.  **Compile**:
    ```bash
    javac MemoryDemo.java
    ```
2.  **Run**:
    ```bash
    java MemoryDemo
    ```

## Sample Output

```text
[Stack] Created primitiveInt: 10
[Stack -> Heap] Created 'person' reference pointing to Person object.
  Object location: Heap (Person{name='Alice', age=30})
  [Memory] person identity hash: 214b199c
```
