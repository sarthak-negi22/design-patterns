class Car {
    private String model;
    private String engine;
    private String color;

    public Car(String model, String engine, String color) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car= [model = "+ model + ", engine = " + engine + ", color = " + color + " ]";
    }
}

public class PrototypeDesignProblem {
    public static void main(String[] args) {

        // redudancy, less flexible and prone to error
        Car car1 = new Car("Tesla", "R8", "Red");
        Car car2 = new Car("Tesla", "R8", "Red");
        Car car3 = new Car("Tesla", "R8", "Red");

        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());
    }
}
