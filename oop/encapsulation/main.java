class Order {
    // Private fields
    private int orderId;
    private String product;
    private int quantity;

    // Constructor
    public Order(int orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    // Getter for orderId (no setter, as orderId should not change)
    public int getOrderId() {
        return orderId;
    }

    // Getter and Setter for product
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        if (product != null && !product.isEmpty()) {
            this.product = product;
        } else {
            System.out.println("Invalid product name.");
        }
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity must be greater than zero.");
        }
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an Order object
        Order order = new Order(101, "Laptop", 2);

        // Displaying initial order details
        order.displayOrderDetails();

        // Updating the order
        order.setProduct("Smartphone");
        order.setQuantity(3);

        // Displaying updated order details
        order.displayOrderDetails();
    }
}