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

public class FactoryDesignProblem {
    public static void main(String[] args) {
        Shape shape1 = new Circle();        // tightly coupled
        Shape shape2 = new Triangle();

        shape1.draw();
        shape2.draw();          
    }
}