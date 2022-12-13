import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime dateTransaction;
    private Double sum;


    public Transaction(LocalDateTime dateTransaction, Double sum) {
        this.dateTransaction = dateTransaction;
        this.sum = sum;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        if (sum == null || sum==0.0) throw new NullPointerException("sum cannot be null or equals to 0");
        this.sum = sum;

    }
}
