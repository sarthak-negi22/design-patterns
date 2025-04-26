// Command side (Writing)

import java.util.HashMap;
import java.util.Map;

class OrderCommandService {
    private Map<Integer, String> ordersDatabase = new HashMap<>();

    public void placeOrder(int orderId, String orderDetails) {
        System.out.println("Placing order: " + orderId);
        ordersDatabase.put(orderId, orderDetails);
    }

    // Providing access to "writes" so that Query side can read
    public Map<Integer, String> getDatabase() {
        return ordersDatabase;
    }
}

// Query side (Reading)
class OrderQueryService {
    private final OrderCommandService orderCommandService;

    public OrderQueryService(OrderCommandService commandService) {
        this.orderCommandService = commandService;
    }

    public String getOrderStatus(int orderId) {
        System.out.println("Fetching order status for: " + orderId);
        return orderCommandService.getDatabase().get(orderId);
    }
}

// Main Application
public class CQRSDesignPattern {
    public static void main(String[] args) {
        OrderCommandService commandService = new OrderCommandService();
        OrderQueryService queryService = new OrderQueryService(commandService);

        commandService.placeOrder(1, "Malai Chaap");
        commandService.placeOrder(2, "Chilli Potato");

        System.out.println(queryService.getOrderStatus(1));
        System.out.println(queryService.getOrderStatus(2));
    }
}
