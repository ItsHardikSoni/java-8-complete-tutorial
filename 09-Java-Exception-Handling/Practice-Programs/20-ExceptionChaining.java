class ExceptionChaining {
    public static void main(String[] args) {
        try {
            loadConfiguration();
        } catch (RuntimeException exception) {
            System.out.println("High-level error: " + exception.getMessage());
            System.out.println("Cause: " + exception.getCause().getMessage());
        }
    }
    static void loadConfiguration() {
        try {
            throw new java.io.IOException("Configuration file is missing.");
        } catch (java.io.IOException exception) {
            throw new RuntimeException("Application configuration could not be loaded.", exception);
        }
    }
}
