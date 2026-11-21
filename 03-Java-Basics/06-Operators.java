class Operators {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        // Arithmetic Operators
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // Unary Operators
        int number = 10;

        System.out.println("\nPre-Increment: " + (++number));
        System.out.println("Post-Increment: " + (number++));
        System.out.println("After Increment: " + number);

        // Relational Operators
        System.out.println("\nEqual: " + (a == b));
        System.out.println("Not Equal: " + (a != b));
        System.out.println("Greater: " + (a > b));

        // Logical Operators
        System.out.println("\nAND: " + (a > 5 && b < 10));
        System.out.println("OR: " + (a < 5 || b < 10));
        System.out.println("NOT: " + !(a > b));

        // Assignment Operators
        int x = 10;
        x += 5;

        System.out.println("\nAssignment: " + x);

        // Bitwise Operators
        System.out.println("\nBitwise AND: " + (a & b));
        System.out.println("Bitwise OR: " + (a | b));
        System.out.println("Bitwise XOR: " + (a ^ b));

        // Shift Operators
        System.out.println("\nLeft Shift: " + (a << 1));
        System.out.println("Right Shift: " + (a >> 1));

        // Ternary Operator
        int age = 22;

        String result = age >= 18 ? "Adult" : "Minor";

        System.out.println("\nTernary Result: " + result);
    }
}