// traditional rigid subclassing via inheritance requires multiple child classes for every combinations

class Pizza {
    public String getDescription() {
        return "Basic Pizza";
    }

    public float getCost() {
        return 100.0f;
    }
}

class CheesePizza extends Pizza {
    
    @Override
    public String getDescription() {
        return "Cheese Pizza";
    }

    public float getCost() {
        return 150.5f;
    }
}

class CheesePizzaWithOlives extends Pizza {
    
    @Override
    public String getDescription() {
        return "Cheese and olives Pizza";
    }

    public float getCost() {
        return 190.5f;
    }
}

class CheesePizzaWithOlivesAndMushrooms extends Pizza {
    
    @Override
    public String getDescription() {
        return "Cheese, olives, mushroom Pizza";
    }

    public float getCost() {
        return 200.5f;
    }
}

public class DecoratorDesignPRoblem {
    public static void main(String[] args) {
        Pizza pizza = new CheesePizzaWithOlivesAndMushrooms();
        System.out.println(pizza.getDescription() + " " + pizza.getCost());
    }
}
