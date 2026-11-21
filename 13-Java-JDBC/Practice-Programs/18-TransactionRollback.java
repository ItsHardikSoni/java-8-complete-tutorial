import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class TransactionRollback {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""))) {
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("UPDATE students SET marks = marks + 100");
                throw new RuntimeException("Simulated failure");
            } catch (RuntimeException exception) {
                connection.rollback();
                System.out.println("Transaction rolled back");
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}
