class PaymentProcessor {
    public void pay(String method, double amount) {
        if(method.equalsIgnoreCase("credit")) System.out.println("Paying using credit card");
        else if(method.equalsIgnoreCase("paypal")) System.out.println("Paying using paypal");
        else if(method.equalsIgnoreCase("upi")) System.out.println("Paying using UPI");
        else System.out.println("Invalid payment method");      
    }
}

public class StrategyDesignProblem {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.pay("credit", 45000);
        paymentProcessor.pay("paypal", 25000);      // tighlty coupled 
        paymentProcessor.pay("upi", 15000);
    }
}
