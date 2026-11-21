final class FinalKeyword {
    final int number = 100;

    final void display() {
        System.out.println("Final value: " + number);
    }

    public static void main(String[] args) {
        new FinalKeyword().display();
    }
}
