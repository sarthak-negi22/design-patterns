interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Circle is drawing");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Triangle is drawing");
    }
}

abstract class ShapeFactory {
    abstract Shape createShape();
}

class CircleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class TriangleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Triangle();
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();       
        ShapeFactory triangleFactory = new TriangleFactory();

        Shape circle = circleFactory.createShape();
        Shape triangle = triangleFactory.createShape();

        circle.draw();
        triangle.draw();
    }
}
