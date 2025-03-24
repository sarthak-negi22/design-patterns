abstract class Beverage {
    // common steps
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void brew(); 
    protected abstract void addCondiments();

    public void makeBeverage() {
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
        coffee.makeBeverage();
    }
}
