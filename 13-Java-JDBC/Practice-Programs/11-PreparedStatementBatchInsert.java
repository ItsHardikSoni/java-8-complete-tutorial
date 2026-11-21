import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class PreparedStatementBatchInsert {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO students(name, marks, email) VALUES (?, ?, ?)")) {
            String[] names = {"Diya", "Kabir", "Meera"};
            for (int i = 0; i < names.length; i++) {
                statement.setString(1, names[i]);
                statement.setInt(2, 75 + i);
                statement.setString(3, names[i].toLowerCase() + "@example.com");
                statement.addBatch();
            }
            System.out.println("Inserted rows: " + statement.executeBatch().length);
        }
    }
}
