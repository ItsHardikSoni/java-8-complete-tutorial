import java.util.Scanner;

class ShapeArea {
    public static double area(double radius) {
        return Math.PI * radius * radius;
    }

    public static double area(double length, double width) {
        return length * width;
    }

    public static double area(int side) {
        return side * side;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter circle radius: ");
        double radius = scanner.nextDouble();
        System.out.print("Enter rectangle length and width: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        System.out.print("Enter square side: ");
        int side = scanner.nextInt();

        System.out.printf("Circle area: %.2f%n", area(radius));
        System.out.printf("Rectangle area: %.2f%n", area(length, width));
        System.out.printf("Square area: %.2f%n", area(side));
        scanner.close();
    }
}
