interface CarPrototpe {
    CarPrototpe clone();
}

class Car implements CarPrototpe {
    private String model;
    private String engine;
    private String color;

    public Car(String model, String engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    @Override
    public CarPrototpe clone() {
        return new Car(this.model, this.engine, this.color);
    }

    @Override
    public String toString() {
        return "Car = [ model = " + model + ", engine = "+ engine + ", color = " + color + " ]";
    }
}

class CarClient {
    private CarPrototpe carPrototpe;

    public CarClient(CarPrototpe carPrototpe) {
        this.carPrototpe = carPrototpe;
    }

    public CarPrototpe createCar() {
        return carPrototpe.clone();
    }
}

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        CarPrototpe carPrototpe = new Car("Tesla", "S8", "Black");
        CarClient client = new CarClient(carPrototpe);

        CarPrototpe car1 = client.createCar();      // cloning car without mentioning the configuration of the objects again and again
        CarPrototpe car2 = client.createCar();
        CarPrototpe car3 = client.createCar();
        
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());
    }
}
