class Beverage {
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void steepingTea() {
        System.out.println("Steeping the tea leaves");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void brewCoffee() {
        System.out.println("Brewing the coffee grinds");
    }

    public void makeBeverage(String choice) {
        boilWater();
        if(choice.equalsIgnoreCase("tea")) {
            steepingTea();
        } else {
            brewCoffee();
        }
        pourInCup();
    }
}

public class TemplateDesignProblem {
    public static void main(String[] args) {
        Beverage tea = new Beverage();
        tea.makeBeverage("Tea");

        Beverage coffee = new Beverage();       // not respect open-closed principle, as if more beverages are added, we need to modify the class as well
        coffee.makeBeverage("coffee");
    }
}
