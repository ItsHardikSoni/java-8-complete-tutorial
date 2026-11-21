class ThrowsKeyword {
    public static void main(String[] args) {
        try {
            printFileName("data.txt");
        } catch (java.io.IOException exception) {
            System.out.println("I/O error: " + exception.getMessage());
        }
    }
    static void printFileName(String fileName) throws java.io.IOException {
        if (fileName.length() == 0) {
            throw new java.io.IOException("File name cannot be empty.");
        }
        System.out.println("File name: " + fileName);
    }
}
