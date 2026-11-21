import java.sql.Connection;
import java.sql.DriverManager;

class DatabaseConnection {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL",
                "jdbc:mysql://localhost:3306/studentdb");
        String user = System.getenv().getOrDefault("MYSQL_USER", "root");
        String password = System.getenv().getOrDefault("MYSQL_PASSWORD", "");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected: " + !connection.isClosed());
        }
    }
}
