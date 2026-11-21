import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class InsertStudentWithStatement {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(
                    "INSERT INTO students(name, marks, email) "
                    + "VALUES ('Aarav', 85, 'aarav@example.com')");
            System.out.println("Records inserted: " + count);
        }
    }
}
