public class Variables {

    // Instance variable
    String studentName;

    // Static variable
    static String college = "NMIT";

    // Constructor
    Variables(String name) {
        studentName = name;
    }

    // Method demonstrating local variable
    public void display() {

        // Local variable
        int age = 22;

        System.out.println("Name: " + studentName);
        System.out.println("Age: " + age);
        System.out.println("College: " + college);
    }

    public static void main(String[] args) {

        Variables s1 = new Variables("Ayush");
        Variables s2 = new Variables("Rahul");

        s1.display();

        System.out.println();

        s2.display();

        // Updating static variable
        Variables.college = "ABC University";

        System.out.println("\nAfter updating college:");

        s1.display();
        s2.display();
    }
}