import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class InventoryManagementJdbc {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS products "
                     + "(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), quantity INT)");
             PreparedStatement insert = connection.prepareStatement(
                     "INSERT INTO products(name, quantity) VALUES (?, ?)");
             PreparedStatement list = connection.prepareStatement(
                     "SELECT id, name, quantity FROM products")) {
            statement.executeUpdate();
            insert.setString(1, "Keyboard");
            insert.setInt(2, 20);
            insert.executeUpdate();
            try (ResultSet result = list.executeQuery()) {
                while (result.next()) {
                    System.out.println(result.getString("name") + " "
                            + result.getInt("quantity"));
                }
            }
        }
    }
}
