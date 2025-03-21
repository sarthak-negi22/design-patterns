class Car {
    private String model;
    private String color;
    private int wheels;
    private boolean sunroof;

    // mandatory fields
    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // optional wheels
    public Car(String model, String color, int wheels) {
        this(model, color);
        this.wheels = wheels;
    }

    // optional sunroof
    public Car(String model, String color, boolean sunroof) {
        this(model, color);
        this.sunroof = sunroof;
    }

    @Override
    public String toString() {
        return "Car [model = "+ model + ", color = "+ color + ", wheels = " + wheels + ", sunroof = "+sunroof + "]"; 
    }
}

public class BuilderDesignProblem {
    public static void main(String[] args) {

        // telescopic constructors problem
        Car car1 = new Car("Tiago", "Red");
        Car car2 = new Car("XUV", "Black", 4);
        Car car3 = new Car("SUV", "Blue", 
     true);

     System.out.println(car1.toString());
     System.out.println(car2.toString());
     System.out.println(car3.toString());
    }
}