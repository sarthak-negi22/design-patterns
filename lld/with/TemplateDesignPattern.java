abstract class Beverage {
    // common steps
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void brew();         // to be modified by subclasses
    protected abstract void addCondiments();

    public final void makeBeverage() {      // marked final so that subclasses arent able to modify the overall structure of making any beverage
        boilWater();
        brew();
        addCondiments();
        pourInCup();
    }
}

// concrete classes 
class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Steeping tea leaves");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Added lemon and ginger");
    }
}

class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Mixing coffee beans");
    }

    @Override
    protected void addCondiments() {
        System.out.println("added sugar and steamed milk");
    }
}

public class TemplateDesignPattern {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.makeBeverage();

        Coffee coffee = new Coffee();
        coffee.makeBeverage();      // more readablle and maintainable with no violation of open-closed principle
    }
}
