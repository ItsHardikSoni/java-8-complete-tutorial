abstract class ManagementShape {
    abstract double area();
}

class ManagementCircle extends ManagementShape {
    private double radius;

    ManagementCircle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class ManagementRectangle extends ManagementShape {
    private double length;
    private double width;

    ManagementRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class ManagementTriangle extends ManagementShape {
    private double base;
    private double height;

    ManagementTriangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

class ShapeManagement {
    public static void main(String[] args) {
        ManagementShape[] shapes = {
            new ManagementCircle(3),
            new ManagementRectangle(4, 5),
            new ManagementTriangle(6, 4)
        };

        for (ManagementShape shape : shapes) {
            System.out.println("Area: " + shape.area());
        }
    }
}
