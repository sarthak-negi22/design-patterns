public class CircuitBreakerDesignProblem {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                String response = processPayment();
                System.out.println("Payment processed: " + response);
            } catch (Exception e) {
                System.out.println("Payment failed: " + e.getMessage());
            }
        }
    }

    static String processPayment() throws Exception {
        // Simulating external payment gateway instability
        if (Math.random() < 0.8) { // 80% chance to fail
            throw new Exception("Payment gateway is down");
        }
        return "Payment successful!";
    }
}
