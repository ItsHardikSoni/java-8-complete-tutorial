class ConstructorMethodPropagation {
    static class Resource {
        Resource(String name) {
            if (name == null) throw new IllegalArgumentException("Resource name is required.");
            load(name);
        }
        void load(String name) {
            if (name.isEmpty()) throw new IllegalStateException("Resource name cannot be empty.");
            System.out.println("Loaded: " + name);
        }
    }
    public static void main(String[] args) {
        try {
            new Resource("Database");
        } catch (RuntimeException exception) {
            System.out.println("Propagation handled in main: " + exception.getMessage());
        }
    }
}
