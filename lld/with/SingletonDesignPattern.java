// multiple initilization styles exist for Singleton design pattern

// 1) Lazy initialzation 

class SingletonImpplementation1 {
    private static SingletonImpplementation1 instance; // Private static instance

    private SingletonImpplementation1() {} // Private constructor

    public static SingletonImpplementation1 getInstance() {
        if (instance == null) {  // Check if instance is null
            instance = new SingletonImpplementation1();
        }
        return instance;
    }
}

// 2) Synchronized method - ensures thread-safety with a cost of extra overhead because of synchronized
class SingletonImpplementation2 {
    private static SingletonImpplementation2 instance;

    private SingletonImpplementation2() {}

    public static synchronized SingletonImpplementation2 getInstance() {
        if (instance == null) {
            instance = new SingletonImpplementation2();
        }
        return instance;
    }

}

// 3) Double checked locking - best practice
class SingletonImpplementation3 {
    private static volatile SingletonImpplementation3 instance;

    private SingletonImpplementation3() {}

    public static SingletonImpplementation3 getInstance() {
        if (instance == null) {  // First check
            synchronized (SingletonImpplementation3.class) {
                if (instance == null) {  // Second check
                    instance = new SingletonImpplementation3();
                }
            }
        }
        return instance;
    }
}

// 4) Eager initilization - wastes memory if object isnt required even once
class SingletonImpplementation4 {
    private static final SingletonImpplementation4 instance = new SingletonImpplementation4();

    private SingletonImpplementation4() {}

    public static SingletonImpplementation4 getInstance() {
        return instance;
    }

}

// 5) Using enum - inherently thread-safe
enum SingletonImpplementation5 {
    INSTANCE;

    public void show() {
        System.out.println("Singleton using Enum");
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        SingletonImpplementation4 thread1 = SingletonImpplementation4.getInstance();
        SingletonImpplementation4 thread2 = SingletonImpplementation4.getInstance();

        if(thread1 == thread2) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
