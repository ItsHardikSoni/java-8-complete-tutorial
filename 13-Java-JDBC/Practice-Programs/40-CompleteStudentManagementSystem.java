import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class CompleteStudentManagementSystem {
    private static Connection connect() throws Exception {
        return DriverManager.getConnection(
                System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb"),
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n1.Add 2.View 3.Search 4.Update 5.Delete 6.Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Marks: ");
                int marks = scanner.nextInt();
                try (Connection connection = connect();
                     PreparedStatement statement = connection.prepareStatement(
                             "INSERT INTO students(name, marks) VALUES (?, ?)")) {
                    statement.setString(1, name);
                    statement.setInt(2, marks);
                    statement.executeUpdate();
                }
            } else if (choice == 2) {
                try (Connection connection = connect();
                     PreparedStatement statement =
                             connection.prepareStatement("SELECT id, name, marks FROM students");
                     ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        System.out.println(result.getInt("id") + " "
                                + result.getString("name") + " "
                                + result.getInt("marks"));
                    }
                }
            } else if (choice == 3) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                try (Connection connection = connect();
                     PreparedStatement statement = connection.prepareStatement(
                             "SELECT id, name, marks FROM students WHERE name LIKE ?")) {
                    statement.setString(1, "%" + name + "%");
                    try (ResultSet result = statement.executeQuery()) {
                        while (result.next()) {
                            System.out.println(result.getInt("id") + " "
                                    + result.getString("name") + " "
                                    + result.getInt("marks"));
                        }
                    }
                }
            } else if (choice == 4) {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                System.out.print("Marks: ");
                int marks = scanner.nextInt();
                try (Connection connection = connect();
                     PreparedStatement statement = connection.prepareStatement(
                             "UPDATE students SET marks = ? WHERE id = ?")) {
                    statement.setInt(1, marks);
                    statement.setInt(2, id);
                    statement.executeUpdate();
                }
            } else if (choice == 5) {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                try (Connection connection = connect();
                     PreparedStatement statement = connection.prepareStatement(
                             "DELETE FROM students WHERE id = ?")) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            } else if (choice == 6) {
                running = false;
            } else {
                System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
