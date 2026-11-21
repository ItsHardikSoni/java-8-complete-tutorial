import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class StudentsAbove80 {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT name, marks FROM students WHERE marks > ?");
             ) {
            statement.setInt(1, 80);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    System.out.println(result.getString("name") + " "
                            + result.getInt("marks"));
                }
            }
        }
    }
}
