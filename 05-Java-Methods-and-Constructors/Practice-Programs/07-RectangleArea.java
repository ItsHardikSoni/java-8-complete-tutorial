import java.util.Scanner;

class RectangleArea {
    public static double area(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        System.out.println("Area: " + area(length, width));
        scanner.close();
    }
}
