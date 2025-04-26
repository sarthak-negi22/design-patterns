class Logger {
    int value;

    public Logger() {
        
    }

    public void log(String message) {
        System.out.println("Log is: "+message);
    }
}

public class SingletonDesignProblem {
    public static void main(String[] args) {
        Logger log1 = new Logger();
        Logger log2 = new Logger();

        log1.log("test");
        log2.log("test");

        if(log1 == log2) {
            System.out.println("Same referneces");
        } else {
            System.out.println("Not same");
        }
    }
}