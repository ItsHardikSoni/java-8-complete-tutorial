import java.util.Scanner;

class AverageOfFiveNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter five numbers: ");

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();

        double average = (a + b + c + d + e) / 5;

        System.out.println("Average: " + average);

        sc.close();
    }
}