import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

class DuplicateEmailHandling {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO students(name, marks, email) VALUES (?, ?, ?)")) {
            statement.setString(1, "Duplicate");
            statement.setInt(2, 70);
            statement.setString(3, "duplicate@example.com");
            try {
                statement.executeUpdate();
                System.out.println("Email inserted");
            } catch (SQLIntegrityConstraintViolationException exception) {
                System.out.println("Duplicate email is not allowed");
            }
        }
    }
}
