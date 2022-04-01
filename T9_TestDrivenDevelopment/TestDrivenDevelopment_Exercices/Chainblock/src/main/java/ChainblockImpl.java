import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private List<Transaction> transactionsList;

    public ChainblockImpl() {
        this.transactionsList = new ArrayList<>();
    }

    public int getCount() {
        return this.transactionsList.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            transactionsList.add(transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        if (transactionsList.contains(transaction)) {
            return true;
        }
        return false;
    }

    public boolean contains(int id) {
        List<Transaction> searchById = transactionsList.stream().filter(t -> t.id() == id).collect(Collectors.toList());
        if (!searchById.isEmpty()) {
            return true;
        }
        return false;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        List<Transaction> transactionSearch = transactionsList.stream().filter(t -> t.id() == id).limit(1).collect(Collectors.toList());
        if (transactionSearch.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Transaction transaction = transactionSearch.get(0);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        List<Transaction> transactions = transactionsList.stream().filter(t -> t.id() == id).limit(1).collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        transactionsList.remove(transactions.get(0));
    }

    public Transaction getById(int id) {
        List<Transaction> transactions = transactionsList.stream().filter(t -> t.id() == id).limit(1).collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions.get(0);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = transactionsList
                .stream()
                .filter(t -> t.status().equals(status))
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = transactionsList
                .stream()
                .filter(t -> t.status().equals(status))
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<String> senders = new ArrayList<>();
        for (Transaction tran :transactions) {
            senders.add(tran.from());
        }
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receivers = new ArrayList<>();
        for (Transaction tran :transactionsList) {
            if (tran.status().equals(status)) {
                receivers.add(tran.to());
            }
        }
        if (receivers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactionsList = transactionsList
                .stream()
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .sorted(Comparator.comparingInt(Transaction::id).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = transactionsList
                .stream()
                .filter(t -> t.to().equals(sender))
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = transactionsList
                .stream()
                .filter(t -> t.to().equals(receiver))
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .sorted(Comparator.comparingInt(Transaction::id))
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions;
        transactions = transactionsList
                .stream()
                .filter(t -> t.status().equals(status) && t.amount() <= amount)
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .collect(Collectors.toList());

        return transactions;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = transactionsList
                .stream()
                .filter(t -> t.from().equals(sender) && t.amount() > amount)
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = transactionsList
                .stream()
                .filter(t -> t.to().equals(receiver) && t.amount() <= lo || t.amount() >= hi)
                .sorted(Comparator.comparingDouble(Transaction::amount).reversed())
                .sorted(Comparator.comparingInt(Transaction::id).reversed())
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = transactionsList
                .stream()
                .filter(t -> t.amount() <= lo && t.amount() >= hi)
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            transactions = new ArrayList<>();
            return transactions;
        }

        return transactions;
    }

    public Iterator<Transaction> iterator() {
        return transactionsList.iterator();
    }
}
