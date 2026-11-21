class StaticVsInstance {
    private int instanceValue;

    public StaticVsInstance(int instanceValue) {
        this.instanceValue = instanceValue;
    }

    public static int staticAdd(int a, int b) {
        return a + b;
    }

    public int getInstanceValue() {
        return instanceValue;
    }

    public static void main(String[] args) {
        System.out.println("Static method call: " + StaticVsInstance.staticAdd(10, 20));

        StaticVsInstance example = new StaticVsInstance(42);
        System.out.println("Instance method call: " + example.getInstanceValue());
    }
}
