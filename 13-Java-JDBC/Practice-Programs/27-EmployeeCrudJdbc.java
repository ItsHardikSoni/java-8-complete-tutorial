import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class EmployeeCrudJdbc {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement create = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS employees "
                     + "(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), salary DOUBLE)");
             PreparedStatement insert = connection.prepareStatement(
                     "INSERT INTO employees(name, salary) VALUES (?, ?)")) {
            create.executeUpdate();
            insert.setString(1, "Aarav");
            insert.setDouble(2, 50000);
            insert.executeUpdate();

            try (PreparedStatement read =
                         connection.prepareStatement("SELECT id, name, salary FROM employees");
                 ResultSet result = read.executeQuery()) {
                while (result.next()) {
                    System.out.println(result.getInt("id") + " "
                            + result.getString("name") + " "
                            + result.getDouble("salary"));
                }
            }
        }
    }
}
