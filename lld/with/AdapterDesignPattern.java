class OldLoggingSystem {
    public void logMessage(String message) {
        System.out.println("Old Logging System: "+message);
    }
}

interface NewLoggingSystem {
    void log(String message);
}

class NewLoggingSystemAdapter implements NewLoggingSystem {
    private OldLoggingSystem oldLoggingSystem;

    public NewLoggingSystemAdapter(OldLoggingSystem oldLoggingSystem) {
        this.oldLoggingSystem = oldLoggingSystem;
    }

    @Override
    public void log(String message) {
        oldLoggingSystem.logMessage(message);
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        OldLoggingSystem log1 = new OldLoggingSystem();
        NewLoggingSystem log2 = new NewLoggingSystemAdapter(log1);      // using adapter

        log2.log("Logging");        // internally calls logMessage()
    
    }
}
