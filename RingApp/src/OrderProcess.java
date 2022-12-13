public class OrderProcess {
    private Order order;
    private Jeweler jeweler;
    private StatusType statusType;

    public OrderProcess(Order order, Jeweler jeweler, StatusType statusType) {
        this.order = order;

        this.jeweler = jeweler;
        this.statusType = statusType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Jeweler getJeweler() {
        return jeweler;
    }

    public void setJeweler(Jeweler jeweler) {
        this.jeweler = jeweler;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }
}
