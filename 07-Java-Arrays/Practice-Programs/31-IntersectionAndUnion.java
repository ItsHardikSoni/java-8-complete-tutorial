import java.util.Scanner;

class IntersectionAndUnion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = readArray(scanner, "first");
        int[] second = readArray(scanner, "second");

        System.out.print("Intersection: ");
        printIntersection(first, second);
        System.out.println();

        System.out.print("Union: ");
        printUnion(first, second);
        System.out.println();
        scanner.close();
    }

    private static void printIntersection(int[] first, int[] second) {
        boolean found = false;
        for (int i = 0; i < first.length; i++) {
            if (contains(second, first[i]) && firstIndex(first, first[i]) == i) {
                System.out.print(first[i] + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
    }

    private static void printUnion(int[] first, int[] second) {
        boolean found = false;
        for (int i = 0; i < first.length; i++) {
            if (firstIndex(first, first[i]) == i) {
                System.out.print(first[i] + " ");
                found = true;
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (secondIndex(second, second[i]) == i && !contains(first, second[i])) {
                System.out.print(second[i] + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
    }

    private static int firstIndex(int[] numbers, int value) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static int secondIndex(int[] numbers, int value) {
        return firstIndex(numbers, value);
    }

    private static boolean contains(int[] numbers, int value) {
        return firstIndex(numbers, value) != -1;
    }

    private static int[] readArray(Scanner scanner, String name) {
        System.out.print("Enter size of " + name + " array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }
}
