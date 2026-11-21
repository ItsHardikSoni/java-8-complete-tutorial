import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class MultipleFileExceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) System.out.println(line);
        } catch (FileNotFoundException exception) {
            System.out.println("File not found.");
        } catch (IOException exception) {
            System.out.println("File could not be read.");
        }
        scanner.close();
    }
}
