import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class BankAccountTransaction {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""))) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?")) {
                statement.setDouble(1, 100);
                statement.setInt(2, 1);
                statement.executeUpdate();
                connection.commit();
                System.out.println("Withdrawal committed");
            } catch (Exception exception) {
                connection.rollback();
                throw exception;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}
