import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class StudentDao {
    private final Connection connection;

    StudentDao(Connection connection) {
        this.connection = connection;
    }

    void add(String name, int marks) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO students(name, marks) VALUES (?, ?)")) {
            statement.setString(1, name);
            statement.setInt(2, marks);
            statement.executeUpdate();
        }
    }

    void findAll() throws Exception {
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT id, name, marks FROM students");
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                System.out.println(result.getInt("id") + " "
                        + result.getString("name") + " "
                        + result.getInt("marks"));
            }
        }
    }
}

class StudentDaoPattern {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""))) {
            StudentDao dao = new StudentDao(connection);
            dao.add("DAO Student", 88);
            dao.findAll();
        }
    }
}
