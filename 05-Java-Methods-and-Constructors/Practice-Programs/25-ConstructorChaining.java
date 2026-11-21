class ConstructorChaining {
    private int a;
    private int b;
    private int c;

    public ConstructorChaining() {
        this(0);
    }

    public ConstructorChaining(int a) {
        this(a, 0);
    }

    public ConstructorChaining(int a, int b) {
        this(a, b, 0);
    }

    public ConstructorChaining(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void display() {
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
    }

    public static void main(String[] args) {
        new ConstructorChaining().display();
        new ConstructorChaining(10).display();
        new ConstructorChaining(10, 20).display();
        new ConstructorChaining(10, 20, 30).display();
    }
}
