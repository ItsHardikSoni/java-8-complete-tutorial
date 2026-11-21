class OverloadedParameters {
    public static void display(int number) {
        System.out.println("int: " + number);
    }

    public static void display(double number) {
        System.out.println("double: " + number);
    }

    public static void display(String text) {
        System.out.println("String: " + text);
    }

    public static void display(int number, double decimal) {
        System.out.println("int + double: " + number + ", " + decimal);
    }

    public static void display(String text, int number) {
        System.out.println("String + int: " + text + ", " + number);
    }

    public static void display(double decimal, String text) {
        System.out.println("double + String: " + decimal + ", " + text);
    }

    public static void main(String[] args) {
        display(10);
        display(3.14);
        display("Java");
        display(20, 7.5);
        display("Value", 30);
        display(8.25, "Eight");
    }
}
