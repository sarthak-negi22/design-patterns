interface Pizza {
    String getDescription();
    float getCost();
}

class BasicPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public float getCost() {
        return 100.5f;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public float getCost() {
        return pizza.getCost();
    }
}

class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public float getCost() {
        return pizza.getCost() + 55.5f;
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public float getCost() {
        return pizza.getCost() + 75.5f;
    }
}

class Mushroom extends PizzaDecorator {
    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }

    @Override
    public float getCost() {
        return pizza.getCost() + 95.5f;
    }
}



public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        pizza = new Cheese(pizza);
        pizza = new Mushroom(pizza);
        pizza = new Olives(pizza);

        System.out.println(pizza.getDescription() + ", " + pizza.getCost());
    }
}
