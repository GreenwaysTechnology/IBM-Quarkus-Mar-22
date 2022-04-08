package  com.ibm.reactive;

public class Order {
    private int orderId;
    private String productName;
    private boolean inStock;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", inStock=" + inStock +
                '}';
    }

    public Order(int orderId, String productName, boolean inStock) {
        this.orderId = orderId;
        this.productName = productName;
        this.inStock = inStock;
    }
}
