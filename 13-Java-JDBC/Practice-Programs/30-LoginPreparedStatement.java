import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class LoginPreparedStatement {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT 1 FROM users WHERE username = ? AND password_hash = ?")) {
            statement.setString(1, "admin");
            statement.setString(2, "hash-of-password");
            try (ResultSet result = statement.executeQuery()) {
                System.out.println(result.next() ? "Login successful" : "Invalid login");
            }
        }
    }
}
