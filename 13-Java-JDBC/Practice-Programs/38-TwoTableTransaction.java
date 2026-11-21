import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class TwoTableTransaction {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""))) {
            connection.setAutoCommit(false);
            try (PreparedStatement order = connection.prepareStatement(
                    "INSERT INTO orders(customer, amount) VALUES (?, ?)");
                 PreparedStatement payment = connection.prepareStatement(
                         "INSERT INTO payments(order_id, amount) VALUES (?, ?)")) {
                order.setString(1, "Diya");
                order.setDouble(2, 200);
                order.executeUpdate();
                payment.setInt(1, 1);
                payment.setDouble(2, 200);
                payment.executeUpdate();
                connection.commit();
                System.out.println("Order and payment committed together");
            } catch (Exception exception) {
                connection.rollback();
                throw exception;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}
