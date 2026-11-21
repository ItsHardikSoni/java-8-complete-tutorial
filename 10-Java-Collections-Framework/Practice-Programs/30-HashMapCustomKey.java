import java.util.HashMap;
import java.util.Objects;

class StudentKey {
    private final int id;
    private final String name;

    StudentKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof StudentKey)) {
            return false;
        }
        StudentKey other = (StudentKey) object;
        return id == other.id && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }
}

class HashMapCustomKey {
    public static void main(String[] args) {
        HashMap<StudentKey, String> students = new HashMap<>();
        StudentKey key = new StudentKey(101, "Aarav");
        students.put(key, "First Year");

        StudentKey equalKey = new StudentKey(101, "Aarav");
        System.out.println("Found: " + students.get(equalKey));
    }
}
