import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

class ResultSetMetaDataDemo {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement =
                     connection.prepareStatement("SELECT id, name, marks FROM students");
             ResultSet result = statement.executeQuery()) {
            ResultSetMetaData metadata = result.getMetaData();
            for (int i = 1; i <= metadata.getColumnCount(); i++) {
                System.out.println(metadata.getColumnName(i) + ": "
                        + metadata.getColumnTypeName(i));
            }
        }
    }
}
