import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class LibraryManagementJdbc {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement create = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS books "
                     + "(id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(150), issued BOOLEAN)");
             PreparedStatement insert = connection.prepareStatement(
                     "INSERT INTO books(title, issued) VALUES (?, false)");
             PreparedStatement list = connection.prepareStatement(
                     "SELECT id, title, issued FROM books");
             ) {
            create.executeUpdate();
            insert.setString(1, "Java Programming");
            insert.executeUpdate();
            try (ResultSet result = list.executeQuery()) {
                while (result.next()) {
                    System.out.println(result.getInt("id") + " "
                            + result.getString("title") + " "
                            + result.getBoolean("issued"));
                }
            }
        }
    }
}
