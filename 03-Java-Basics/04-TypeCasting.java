class TypeCasting {

    public static void main(String[] args) {

        // Widening Casting
        int number = 100;

        double decimalNumber = number;

        System.out.println("Widening Casting:");
        System.out.println("Integer: " + number);
        System.out.println("Double: " + decimalNumber);

        // Narrowing Casting
        double price = 99.99;

        int convertedPrice = (int) price;

        System.out.println("\nNarrowing Casting:");
        System.out.println("Double: " + price);
        System.out.println("Integer: " + convertedPrice);

        // String to Integer
        String value = "500";

        int result = Integer.parseInt(value);

        System.out.println("\nString to Integer: " + result);

        // Integer to String
        int age = 22;

        String text = String.valueOf(age);

        System.out.println("Integer to String: " + text);
    }
}