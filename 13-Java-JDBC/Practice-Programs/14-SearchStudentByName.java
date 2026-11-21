import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class SearchStudentByName {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name or partial name: ");
        String name = scanner.nextLine();
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id, name, marks FROM students WHERE name LIKE ?")) {
            statement.setString(1, "%" + name + "%");
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    System.out.println(result.getInt("id") + " "
                            + result.getString("name"));
                }
            }
        }
        scanner.close();
    }
}
