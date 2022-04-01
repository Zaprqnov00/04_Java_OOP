public interface Transaction {

    int id();
    TransactionStatus status();
    void setStatus(TransactionStatus status);
    String from();
    String to();
    double amount();
}
