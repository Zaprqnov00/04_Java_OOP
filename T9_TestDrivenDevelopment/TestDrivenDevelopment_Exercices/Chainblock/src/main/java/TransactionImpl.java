public class TransactionImpl implements Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public TransactionStatus status() {
        return this.status;
    }

    @Override
    public String from() {
        return this.from;
    }

    @Override
    public String to() {
        return this.to;
    }

    @Override
    public double amount() {
        return this.amount;
    }

    @Override
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
