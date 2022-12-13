import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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


    public Order(Double ringSize, Double weight, LocalDateTime orderDate, MaterialType materialType) {
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
    public void doTransaction(Customer customer, Double money){
        if(!takenOrders.containsKey(customer.getFirstName())){
            throw new NullPointerException("Don't have order to pay");
        }
        OrderProcess process = takenOrders.get(customer.getFirstName());
        if(money==calculatedTotalSum()){
            process.setStatusType(StatusType.PAID);
        } else if (money<calculatedTotalSum() && money>0) {
            process.setStatusType(StatusType.PARTLY_PAID);
        }

    }


// This is 2 step, taken order by jeweler
    public void takenOrder(){
        if(createdOrders.isEmpty()){
            throw new NullPointerException("Don't have new order");
        }
        Map.Entry<String,Order> entry = createdOrders.entrySet().iterator().next();
        String name = entry.getKey();
        Order o = entry.getValue();
        createdOrders.remove(name);
        OrderProcess process = new OrderProcess(o,getJeweler(), StatusType.NOT_PAID);
        takenOrders.put(name, process);
    }
// In this step to calculate total summ;
    public Double calculatedTotalSum(){
        if(getJeweler()==null || getWeight()<=0 || getMaterialType()==null){
            throw new NullPointerException("transaction failed");
        }
        Double sum = getWeight()*getMaterialType().getPriceForOneGram() + getJeweler().getPriceService();
        setNeedToPay(sum);
        return sum;
    }

//  This is 1 step, where created just order by customer
    public void createOrder(){
        Order o = new Order(getRingSize(), getWeight(), LocalDateTime.now(), getMaterialType());
        createdOrders.put(getCustomer().getFirstName(), o);
    }

    public void DeleteOrder(Customer customer){
        if(!createdOrders.containsKey(customer.getFirstName())){
            throw new NullPointerException("order is empty");
        }
        createdOrders.remove(customer.getFirstName());
    }
}
