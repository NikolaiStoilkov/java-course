package JavaBasics;

public class Order {
    public enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED,
    }

    int orderId;
    String customerName;
    OrderStatus orderStatus;

    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderStatus = OrderStatus.PENDING;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.orderStatus = newStatus;
    }

    public String getOrderInfo(int orderId, String customerName) {
        return "order ID: " + orderId + "Customer Name" + customerName + this.orderStatus;
    }
}
