import java.util.Scanner;

class EvenOdd {
    public static void checkEvenOdd(int number) {
        String result = number % 2 == 0 ? "even" : "odd";
        System.out.println(number + " is " + result + ".");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        checkEvenOdd(number);
        scanner.close();
    }
}
