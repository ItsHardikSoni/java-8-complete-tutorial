import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class SqlInjectionPreparedStatement {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        String unsafeName = "Aarav' OR '1'='1";
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             Statement unsafe = connection.createStatement()) {
            System.out.println("Unsafe query example:");
            try (ResultSet result = unsafe.executeQuery(
                    "SELECT * FROM students WHERE name = '" + unsafeName + "'")) {
                System.out.println("Unsafe query rows handled");
            }

            try (PreparedStatement safe = connection.prepareStatement(
                    "SELECT * FROM students WHERE name = ?")) {
                safe.setString(1, unsafeName);
                try (ResultSet result = safe.executeQuery()) {
                    System.out.println("PreparedStatement query executed safely");
                }
            }
        }
    }
}
