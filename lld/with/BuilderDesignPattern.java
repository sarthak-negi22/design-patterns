class Car {
    private String model;
    private String color;
    private int wheels;
    private boolean sunroof;

    private Car(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
    }

    public static class Builder {
        private String model;
        private String color;
        private int wheels = 4;
        private boolean sunroof = false;
        
        public Builder(String model, String color) {
            this.model = model;
            this.color = color;
        }

        public Builder wheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder sunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car [model = "+ model + ", color = "+ color + ", wheels = " + wheels + ", sunroof = "+sunroof + "]"; 
    }


}

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Car car1 = new Car.Builder("Tesla", "Red")
                .wheels(6)
                .sunroof(true)
                .build();

        System.out.println(car1.toString());
    }
}

    