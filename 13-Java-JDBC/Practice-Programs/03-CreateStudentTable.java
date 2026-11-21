import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class CreateStudentTable {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS students "
                    + "(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), "
                    + "marks INT, email VARCHAR(150) UNIQUE)");
            System.out.println("Table created");
        }
    }
}
