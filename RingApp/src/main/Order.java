package main;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private Double ringSize;
    private Double weight;
    private LocalDateTime orderDate;
    private Double needToPay;
    private MaterialType materialType;
    private Transaction transaction;
    private Customer customer;
    private Jeweler jeweler;

    private List<Order> createdOrdersList = new ArrayList<>();
    private Hashtable<String, Order> createdOrders = new Hashtable<String, Order>();
    private Hashtable<String, OrderProcess> takenOrders = new Hashtable<String, OrderProcess>();
    private Hashtable<String, Transaction> transactionList = new Hashtable<String, Transaction>();


    public Order(Customer customer, Jeweler jeweler, Double ringSize, Double weight, LocalDateTime orderDate, MaterialType materialType) {
        this.customer = customer;
        this.jeweler = jeweler;
        this.ringSize = ringSize;
        this.weight = weight;
        this.orderDate = orderDate;
        this.materialType = materialType;
    }

    public Double getRingSize() {
        return ringSize;
    }

    public void setRingSize(Double ringSize) {
        this.ringSize = ringSize;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getNeedToPay() {
        return needToPay;
    }

    public void setNeedToPay(Double needToPay) {
        this.needToPay = needToPay;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Jeweler getJeweler() {
        return jeweler;
    }

    public void setJeweler(Jeweler jeweler) {
        this.jeweler = jeweler;
    }

// This is step, customer should pay for order
    public void doTransaction(Double money) throws OrderException {
        calculatedTotalSum();
        Double transactionSum = money;
        if(!takenOrders.containsKey(getCustomer().getFirstName())){
            throw new NullPointerException("Don't have order to pay");
        }

        OrderProcess process = takenOrders.get(getCustomer().getFirstName());
        //we will check whether the customer has paid before or not
        if(transactionList.containsKey(getCustomer().getFirstName())){
            transactionSum += transactionList.get(getCustomer().getFirstName()).getSum();
            transactionList.remove(getCustomer().getFirstName());
        }
        // we change status of transaction;
        if(Objects.equals(transactionSum, getNeedToPay())){
            process.setStatusType(StatusType.PAID);
        } else if (transactionSum<getNeedToPay() && transactionSum>0) {
            process.setStatusType(StatusType.PARTLY_PAID);
        }
        setTransaction(new Transaction(LocalDateTime.now(), transactionSum));
        transactionList.put(getCustomer().getFirstName(), getTransaction());
    }

    // This method for change status of order, after jeweler has started do the order.
    public void startDoOrder() throws OrderException {
        if(getStatusOfOrder()==StatusType.IN_PROGRESS){
            throw new OrderException("This order has been started");
        }
        OrderProcess or = takenOrders.get(getCustomer().getFirstName());
        or.setStatusType(StatusType.IN_PROGRESS);
        takenOrders.put(getCustomer().getFirstName(),or);
    }
// This method for change status of order, after jeweler has finished the order.
    public void finishedOrder() throws OrderException {
        if(getStatusOfOrder()==StatusType.FINISHED){
            throw new OrderException("This order has fiinshed");
        }
        OrderProcess or = takenOrders.get(getCustomer().getFirstName());
        or.setStatusType(StatusType.FINISHED);
        takenOrders.put(getCustomer().getFirstName(),or);
    }

// Check order status
    public StatusType getStatusOfOrder() throws OrderException {
        if(takenOrders.isEmpty() || !takenOrders.containsKey(getCustomer().getFirstName())){
            throw new OrderException("Don't have taken Order");
        }
        return takenOrders.get(getCustomer().getFirstName()).getStatusType();
    }

// This is 2 step, taken order by jeweler
    public void takenOrder() throws OrderException {
        Order order = getNextOrder();
        OrderProcess orderProcess = new OrderProcess(order,getJeweler(), StatusType.NOT_PAID);
        takenOrders.put(order.getCustomer().getFirstName(), orderProcess);
    }
// In this step to calculate total summ;
    public void calculatedTotalSum() throws OrderException {
        if(getJeweler()==null || getWeight()<=0 || getMaterialType()==null){
            throw new OrderException("Cal");
        }
        Double sum = getWeight()*getMaterialType().getPriceForOneGram() + getJeweler().getPriceService();
        setNeedToPay(sum);

    }

//  This is 1 step, where created just order by customer
    public void createOrder(){
        createdOrders.put(getCustomer().getFirstName(), this);
    }

    // This method to get next order by jeweler, then has finished the current order.
    public Order getNextOrder() throws OrderException{
        if(createdOrders.isEmpty()){
            throw new OrderException("Don't have new order");
        }
        Map.Entry<String,Order> entry = createdOrders.entrySet().iterator().next();
        String name = entry.getKey();
        Order o = entry.getValue();
        createdOrders.remove(name);
        return o;
    }
    public void DeleteOrder(Customer customer){
        if(!createdOrders.containsKey(customer.getFirstName())){
            throw new NullPointerException("order is empty");
        }
        createdOrders.remove(customer.getFirstName());
    }
}
