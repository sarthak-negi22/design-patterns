class OldLoggingSystem {
    public void logMessage(String message) {
        System.out.println("Old logging: "+message);
    }
}

// incompatible interface, as old logging system expects logMessage()
interface NewLoggingSystem {
    void log(String message);
}

class Logging implements NewLoggingSystem {
    public void log(String message) {
        System.out.println("New Logging System: "+message);
    }
}

public class AdapterDesignProblem {
    public static void main(String[] args) {

        // tightly coupled
        Logging log1 = new Logging();
        OldLoggingSystem log2 = new OldLoggingSystem();

        log2.logMessage("Hello");
        log1.log("Test");
    }
}
