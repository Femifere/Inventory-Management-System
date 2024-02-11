package OrderManagement;

public enum OrderStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    FULFILLED("Fulfilled"),
    CANCELLED("Cancelled");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

