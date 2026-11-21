import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class UpdateStudentMarks {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE students SET marks = ? WHERE id = ?")) {
            statement.setInt(1, 90);
            statement.setInt(2, 1);
            System.out.println("Updated rows: " + statement.executeUpdate());
        }
    }
}
