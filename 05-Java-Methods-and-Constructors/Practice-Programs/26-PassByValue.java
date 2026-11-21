class PassByValue {
    static class Counter {
        int value;

        Counter(int value) {
            this.value = value;
        }
    }

    public static void changePrimitive(int number) {
        number = 100;
        System.out.println("Inside primitive method: " + number);
    }

    public static void changeObject(Counter counter) {
        counter.value = 100;
        System.out.println("Inside object method: " + counter.value);
    }

    public static void replaceObject(Counter counter) {
        counter = new Counter(200);
        System.out.println("Inside replacement method: " + counter.value);
    }

    public static void main(String[] args) {
        int number = 10;
        changePrimitive(number);
        System.out.println("After primitive method: " + number);

        Counter counter = new Counter(10);
        changeObject(counter);
        System.out.println("After mutating object method: " + counter.value);

        replaceObject(counter);
        System.out.println("After object replacement method: " + counter.value);
    }
}
