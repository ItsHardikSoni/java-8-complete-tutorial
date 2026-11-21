import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class RetrieveGeneratedKeys {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO students(name, marks, email) VALUES (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "New Student");
            statement.setInt(2, 70);
            statement.setString(3, "new.student@example.com");
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    System.out.println("Generated ID: " + keys.getLong(1));
                }
            }
        }
    }
}
