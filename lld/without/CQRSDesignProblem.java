import java.util.HashMap;
import java.util.Map;

public class CQRSDesignProblem {
    private Map<Integer, String> orders = new HashMap<>();

    // Mixed method: writes and reads together
    public void placeOrder(int orderId, String orderDetails) {
        orders.put(orderId, orderDetails);
    }

    public String getOrder(int orderId) {
        return orders.get(orderId);
    }
}
