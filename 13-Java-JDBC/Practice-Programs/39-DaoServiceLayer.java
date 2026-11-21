import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class StudentRepository {
    private final Connection connection;

    StudentRepository(Connection connection) {
        this.connection = connection;
    }

    void save(String name, int marks) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO students(name, marks) VALUES (?, ?)")) {
            statement.setString(1, name);
            statement.setInt(2, marks);
            statement.executeUpdate();
        }
    }
}

class StudentService {
    private final StudentRepository repository;

    StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    void registerStudent(String name, int marks) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        repository.save(name, marks);
    }
}

class DaoServiceLayer {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""))) {
            StudentService service =
                    new StudentService(new StudentRepository(connection));
            service.registerStudent("Service Student", 92);
            System.out.println("Student registered through service layer");
        }
    }
}
