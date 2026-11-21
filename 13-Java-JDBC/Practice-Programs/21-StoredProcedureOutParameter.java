import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

class StoredProcedureOutParameter {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             CallableStatement statement =
                     connection.prepareCall("{ call getStudentCount(?) }")) {
            statement.registerOutParameter(1, Types.INTEGER);
            statement.execute();
            System.out.println("Student count: " + statement.getInt(1));
        }
    }
}
