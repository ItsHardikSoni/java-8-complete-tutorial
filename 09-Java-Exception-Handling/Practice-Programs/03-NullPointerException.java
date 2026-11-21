class NullPointerException {
    public static void main(String[] args) {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (java.lang.NullPointerException exception) {
            System.out.println("Cannot use methods on a null String.");
        }
    }
}
