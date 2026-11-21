import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class OrderManagementJdbc {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement create = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS orders "
                     + "(id INT PRIMARY KEY AUTO_INCREMENT, customer VARCHAR(100), amount DOUBLE)");
             PreparedStatement insert = connection.prepareStatement(
                     "INSERT INTO orders(customer, amount) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            create.executeUpdate();
            insert.setString(1, "Aarav");
            insert.setDouble(2, 1250);
            insert.executeUpdate();
            try (ResultSet keys = insert.getGeneratedKeys()) {
                if (keys.next()) {
                    System.out.println("Created order ID: " + keys.getInt(1));
                }
            }
        }
    }
}
