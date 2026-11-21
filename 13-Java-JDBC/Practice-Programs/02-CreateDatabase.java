import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class CreateDatabase {
    public static void main(String[] args) throws Exception {
        String baseUrl = System.getenv().getOrDefault("MYSQL_ADMIN_URL",
                "jdbc:mysql://localhost:3306/");
        String user = System.getenv().getOrDefault("MYSQL_USER", "root");
        String password = System.getenv().getOrDefault("MYSQL_PASSWORD", "");
        try (Connection connection = DriverManager.getConnection(baseUrl, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS studentdb");
            System.out.println("Database created");
        }
    }
}
