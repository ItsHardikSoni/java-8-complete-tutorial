import java.util.Scanner;

class SimpleTextProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        StringBuilder text = new StringBuilder(scanner.nextLine());
        while (true) {
            System.out.println("\n1. Append");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Reverse");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Text to append: ");
                text.append(scanner.nextLine());
            } else if (choice == 2) {
                System.out.print("Index: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index >= 0 && index <= text.length()) {
                    System.out.print("Text to insert: ");
                    text.insert(index, scanner.nextLine());
                } else {
                    System.out.println("Invalid index");
                }
            } else if (choice == 3) {
                System.out.print("Start index: ");
                int start = scanner.nextInt();
                System.out.print("End index: ");
                int end = scanner.nextInt();
                scanner.nextLine();
                if (start >= 0 && end >= start && end <= text.length()) {
                    text.delete(start, end);
                } else {
                    System.out.println("Invalid range");
                }
            } else if (choice == 4) {
                text.reverse();
            } else if (choice == 5) {
                System.out.println("Text: " + text);
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
