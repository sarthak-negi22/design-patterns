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

class ButtonFactory {
    public static Button createButton(String osType) {
        if(osType.equalsIgnoreCase("mac")) return new MacButton();
        else if (osType.equalsIgnoreCase("windows")) return new WindowButton();
        else return null;
    }
}

class CheckBoxFactory {
    public static CheckBox createCheckBox(String osType) {
        if(osType.equalsIgnoreCase("mac")) return new MacCheckBox();
        else if (osType.equalsIgnoreCase("windows")) return new WindowCheckBox();
        else return null;
    }
}

public class AbstractFactoryDesignProblem {
    public static void main(String[] args) {
        // client must seperately called ButtonFactory and CheckBoxFactory and must know which one to call
        Button button = ButtonFactory.createButton("mac");
        CheckBox checkbox = CheckBoxFactory.createCheckBox("mac");

        button.paint();
        checkbox.check();
        
    }
}