import java.io.IOException;

class ExceptionHandlingOverriding {
    static class Parent {
        void read() throws IOException {
            System.out.println("Parent read.");
        }
    }
    static class Child extends Parent {
        @Override
        void read() throws java.io.FileNotFoundException {
            throw new java.io.FileNotFoundException("File not found.");
        }
    }
    public static void main(String[] args) {
        try {
            new Child().read();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
