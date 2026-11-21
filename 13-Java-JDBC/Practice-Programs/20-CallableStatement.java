import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

class CallableStatementDemo {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             CallableStatement statement =
                     connection.prepareCall("{ call getStudentById(?) }")) {
            statement.setInt(1, 1);
            statement.execute();
            System.out.println("Stored procedure executed");
        }
    }
}
