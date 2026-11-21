import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class MoneyTransferTransaction {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""))) {
            connection.setAutoCommit(false);
            try (PreparedStatement debit = connection.prepareStatement(
                    "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?");
                 PreparedStatement credit = connection.prepareStatement(
                         "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?")) {
                debit.setDouble(1, 500);
                debit.setInt(2, 1);
                credit.setDouble(1, 500);
                credit.setInt(2, 2);
                if (debit.executeUpdate() != 1 || credit.executeUpdate() != 1) {
                    throw new RuntimeException("Invalid account");
                }
                connection.commit();
                System.out.println("Transfer committed");
            } catch (Exception exception) {
                connection.rollback();
                throw exception;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}
