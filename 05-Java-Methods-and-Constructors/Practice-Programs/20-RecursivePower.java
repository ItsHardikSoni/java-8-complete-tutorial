import java.util.Scanner;

class RecursivePower {
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        if (exponent % 2 == 0) {
            double half = power(base, exponent / 2);
            return half * half;
        }
        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        int exponent = scanner.nextInt();
        System.out.println(base + " ^ " + exponent + " = " + power(base, exponent));
        scanner.close();
    }
}
