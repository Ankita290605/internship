

// 45. Create an abstract class `Shape` and subclass `Circle` with area method

abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }
    abstract double area();

    void displayColor() {
        System.out.println("Shape color: " + color);
    }
}
class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    double area() {
        return Math.PI * radius * radius;
    }
}
public class AbstractExample{
    public static void main(String[] args) {
        Circle c = new Circle("Red", 5.0);
        c.displayColor();
        System.out.println("Area of circle: " + c.area());
    }
}
