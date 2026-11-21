import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class BatchInsertThousands {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO students(name, marks, email) VALUES (?, ?, ?)")) {
            for (int i = 1; i <= 1000; i++) {
                statement.setString(1, "Student " + i);
                statement.setInt(2, i % 100);
                statement.setString(3, "student" + i + "@batch.example");
                statement.addBatch();
            }
            System.out.println("Batch size executed: " + statement.executeBatch().length);
        }
    }
}
