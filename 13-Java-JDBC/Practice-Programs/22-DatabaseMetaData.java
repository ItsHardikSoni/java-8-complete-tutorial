import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

class DatabaseMetaDataDemo {
    public static void main(String[] args) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        try (Connection connection = DriverManager.getConnection(url,
                System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""))) {
            DatabaseMetaData metadata = connection.getMetaData();
            System.out.println("Database: " + metadata.getDatabaseProductName());
            System.out.println("Version: " + metadata.getDatabaseProductVersion());
            System.out.println("Driver: " + metadata.getDriverName());
        }
    }
}
