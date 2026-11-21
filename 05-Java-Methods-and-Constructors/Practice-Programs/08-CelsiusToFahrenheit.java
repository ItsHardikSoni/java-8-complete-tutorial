import java.util.Scanner;

class CelsiusToFahrenheit {
    public static double convert(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Celsius temperature: ");
        double celsius = scanner.nextDouble();
        System.out.printf("Fahrenheit: %.2f%n", convert(celsius));
        scanner.close();
    }
}
