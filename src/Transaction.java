
public abstract class Transaction {
    protected String transactionID;
    protected double amount;
    protected int accountNumber;

    public Transaction(String transactionID, double amount, int accountNumber) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public abstract void processTransaction();
}
