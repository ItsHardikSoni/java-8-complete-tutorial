import java.util.Scanner;

public class ReverseThreeDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a three-digit number: ");
        int num = scanner.nextInt();
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;          // Extract the last digit
            reversed = reversed * 10 + digit; // Append it to the reversed number
            num /= 10;                     // Remove the last digit
        }

        System.out.println("Reversed Number: " + reversed);
        scanner.close();
    }
}
