import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class RetrieveAllStudents {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT id, name, marks FROM students")) {
            while (result.next()) {
                System.out.println(result.getInt("id") + " "
                        + result.getString("name") + " " + result.getInt("marks"));
            }
        }
    }
}
