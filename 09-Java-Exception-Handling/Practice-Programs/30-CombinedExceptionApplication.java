import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class CombinedExceptionApplication {
    static class InvalidDataException extends Exception {
        InvalidDataException(String message) { super(message); }
    }
    static class DataProcessingException extends RuntimeException {
        DataProcessingException(String message, Throwable cause) { super(message, cause); }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line == null) throw new InvalidDataException("The file is empty.");
            int number = Integer.parseInt(line);
            if (number < 0) throw new IllegalArgumentException("Number cannot be negative.");
            System.out.println("Valid number: " + number);
        } catch (InvalidDataException exception) {
            System.out.println("Checked exception: " + exception.getMessage());
        } catch (java.lang.NumberFormatException exception) {
            throw new DataProcessingException("A number could not be parsed.", exception);
        } catch (IllegalArgumentException exception) {
            throw new DataProcessingException("Unchecked exception during data processing.", exception);
        } catch (IOException exception) {
            throw new DataProcessingException("I/O exception during file processing.", exception);
        } finally {
            scanner.close();
        }
    }
}
