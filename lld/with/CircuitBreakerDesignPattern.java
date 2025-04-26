public class CircuitBreakerDesignPattern {

    enum State { CLOSED, OPEN, HALF_OPEN }

    static State state = State.CLOSED;
    static int failureCount = 0;
    static final int FAILURE_THRESHOLD = 3;
    static final long RETRY_TIMEOUT = 5000; // 5 seconds
    static long lastFailureTime = 0;

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            try {
                System.out.println("Attempt #" + i);
                String result = processPaymentWithCircuitBreaker();
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Payment failed: " + e.getMessage());
            }

            try {
                Thread.sleep(1000); // simulate delay between attempts
            } catch (InterruptedException ignored) {}
        }
    }

    static String processPaymentWithCircuitBreaker() throws Exception {
        long now = System.currentTimeMillis();

        if (state == State.OPEN) {
            if (now - lastFailureTime > RETRY_TIMEOUT) {
                System.out.println("Trying in HALF-OPEN state...");
                state = State.HALF_OPEN;
            } else {
                throw new Exception("Circuit is OPEN. Skipping payment.");
            }
        }

        try {
            String result = processPayment();

            if (state == State.HALF_OPEN) {
                System.out.println("Payment succeeded in HALF-OPEN. Closing circuit.");
                state = State.CLOSED;
                failureCount = 0;
            }

            return result;

        } catch (Exception e) {
            failureCount++;
            lastFailureTime = now;

            if (failureCount >= FAILURE_THRESHOLD) {
                state = State.OPEN;
                System.out.println("Too many failures. Opening circuit.");
            }

            throw e;
        }
    }

    static String processPayment() throws Exception {
        if (Math.random() < 0.8) { // Simulate 80% failure rate
            throw new Exception("Payment gateway is down");
        }
        return "Payment processed successfully!";
    }
}
