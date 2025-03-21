interface Button {
    void paint();
}

interface CheckBox {
    void check();
}

class WindowButton implements Button{
    public void paint() {
        System.out.println("Windows Button");
    }
}

class MacButton implements Button{
    public void paint() {
        System.out.println("Mac Button");
    }
}

class WindowCheckBox implements CheckBox{
    public void check() {
        System.out.println("Windows CheckBox");
    }
}

class MacCheckBox implements CheckBox{
    public void check() {
        System.out.println("Mac CheckBox");
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowButton();
    }

    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }
}
public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        // now client only calls one factory
        GUIFactory factory = new MacFactory();
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        button.paint();
        checkBox.check();
    }
}