class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double side) {
        this(side, side);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Rectangle defaultRectangle = new Rectangle();
        Rectangle square = new Rectangle(5);
        Rectangle rectangle = new Rectangle(8, 4);

        System.out.println("Default rectangle area: " + defaultRectangle.calculateArea());
        System.out.println("Square area: " + square.calculateArea());
        System.out.println("Square perimeter: " + square.calculatePerimeter());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Rectangle perimeter: " + rectangle.calculatePerimeter());
    }
}
