import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayDeque;
import java.util.Queue;

class SimpleJdbcConnectionPool implements AutoCloseable {
    private final Queue<Connection> connections = new ArrayDeque<>();

    SimpleJdbcConnectionPool(int size) throws Exception {
        String url = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/studentdb");
        String user = System.getenv().getOrDefault("MYSQL_USER", "root");
        String password = System.getenv().getOrDefault("MYSQL_PASSWORD", "");
        for (int i = 0; i < size; i++) {
            connections.add(DriverManager.getConnection(url, user, password));
        }
    }

    synchronized Connection borrow() throws InterruptedException {
        while (connections.isEmpty()) {
            wait();
        }
        return connections.remove();
    }

    synchronized void release(Connection connection) {
        connections.add(connection);
        notifyAll();
    }

    @Override
    public synchronized void close() throws Exception {
        for (Connection connection : connections) {
            connection.close();
        }
        connections.clear();
    }
}

class SimpleJdbcConnectionPoolDemo {
    public static void main(String[] args) throws Exception {
        try (SimpleJdbcConnectionPool pool = new SimpleJdbcConnectionPool(2)) {
            Connection connection = pool.borrow();
            System.out.println("Borrowed connection: " + !connection.isClosed());
            pool.release(connection);
        }
    }
}
