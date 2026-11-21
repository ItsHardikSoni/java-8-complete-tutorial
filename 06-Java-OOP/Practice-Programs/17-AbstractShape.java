abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class ShapeRectangle extends Shape {
    double length;
    double width;

    ShapeRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    double perimeter() {
        return 2 * (length + width);
    }
}

class AbstractShape {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new ShapeRectangle(4, 6);
        System.out.println("Circle: " + circle.area() + ", " + circle.perimeter());
        System.out.println("Rectangle: " + rectangle.area() + ", " + rectangle.perimeter());
    }
}
