import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class DeleteLowMarks {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM students WHERE marks < ?")) {
            statement.setInt(1, 40);
            System.out.println("Deleted rows: " + statement.executeUpdate());
        }
    }
}
