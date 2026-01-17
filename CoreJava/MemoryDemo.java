
public class MemoryDemo {

    public static void main(String[] args) {
        System.out.println("=== Java Stack vs Heap Memory Demo ===\n");

        // 1. Stack Memory: Primitives
        // Primitive variables are stored directly on the Stack.
        int primitiveInt = 10;
        double primitiveDouble = 20.5;
        System.out.println("[Stack] Created primitiveInt: " + primitiveInt);
        System.out.println("[Stack] Created primitiveDouble: " + primitiveDouble);
        // Note: Java does not allow us to see the memory address of Stack variables.
        // We can only see the values. The JVM handles stack addresses internally.

        // 2. Heap Memory: Objects
        // The 'person' reference variable is stored on the Stack.
        // The actual 'Person' object is stored on the Heap.
        Person person = new Person("Alice", 30);
        System.out.println("\n[Stack -> Heap] Created 'person' reference pointing to Person object.");
        System.out.println("  Reference location: Stack");
        System.out.println("  Object location: Heap (" + person + ")");
        printMemoryLocation("person", person);

        // 3. Method Calls and Stack Frames
        System.out.println("\n--- Calling method calculateValues() ---");
        calculateValues(primitiveInt);
        System.out.println("--- Returned from calculateValues() ---");

        System.out.println("\n[Main] Exiting main method. Stack frame destroyed.");
    }

    // A static method to demonstrate a new Stack Frame
    public static void calculateValues(int value) {
        System.out.println("  [Stack Frame: calculateValues] New stack frame created.");

        // This local variable exists only within this stack frame
        int result = value * 2;
        System.out.println("  [Stack] Local variable 'result': " + result);

        // Another object created in this stack frame context
        Person tempPerson = new Person("Bob", 25);
        System.out.println("  [Stack -> Heap] Created local 'tempPerson' reference.");
        System.out.println("  [Heap] Created Person object for Bob: " + tempPerson);
        printMemoryLocation("tempPerson", tempPerson);

        System.out.println("  [Stack Frame: calculateValues] Method finishing. Frame will be popped.");
        // CRITICAL POINT:
        // Once this method finishes, the stack frame is destroyed.
        // The reference 'tempPerson' is gone.
        // The object 'Person(Bob)' on the Heap is now "unreachable".
        // It remains on the Heap until the Garbage Collector (GC) comes along and
        // cleans it up.
    }

    // Helper to print the "Logical Address" (Identity HashCode)
    // Java hides the actual physical RAM address, but this is the unique ID
    // the JVM uses to track the object on the Heap.
    private static void printMemoryLocation(String label, Object obj) {
        int address = System.identityHashCode(obj);
        System.out.println("  [Memory] " + label + " identity hash (pseudo-address): " + Integer.toHexString(address));
    }
}

// Simple class to represent an object on the Heap
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
