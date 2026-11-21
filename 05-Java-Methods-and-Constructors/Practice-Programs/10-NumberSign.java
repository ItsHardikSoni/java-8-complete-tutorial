import java.util.Scanner;

class NumberSign {
    public static String checkSign(int number) {
        if (number > 0) {
            return "Positive";
        }
        if (number < 0) {
            return "Negative";
        }
        return "Zero";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("The number is " + checkSign(number));
        scanner.close();
    }
}
