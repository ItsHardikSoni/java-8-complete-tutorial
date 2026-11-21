public class FinalKeyword {

    // Constant
    static final double PI = 3.14159;

    public static void main(String[] args) {

        final int MAX_AGE = 100;

        int radius = 5;

        double area = PI * radius * radius;

        System.out.println("PI: " + PI);
        System.out.println("Maximum Age: " + MAX_AGE);
        System.out.println("Circle Area: " + area);

        // MAX_AGE = 200;
        // Compilation error because MAX_AGE is final.
    }
}