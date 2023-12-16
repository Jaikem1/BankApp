public class TransferTransaction extends Transaction {
    private long recipientAccountNumber;

    public TransferTransaction(String transactionID, double amount, long accountNumber, long recipientAccountNumber) {
        super(transactionID, amount, accountNumber);
        this.recipientAccountNumber = recipientAccountNumber;
    }

    @Override
    public void processTransaction() {
        System.out.println("Processing transfer transaction...");
        double sourceBalance = getAccountBalance(accountNumber);
        if (sourceBalance >= amount) {
            double newSourceBalance = sourceBalance - amount;
            updateAccountBalance(accountNumber, newSourceBalance);

            double recipientBalance = getAccountBalance(recipientAccountNumber);
            double newRecipientBalance = recipientBalance + amount;
            updateAccountBalance(recipientAccountNumber, newRecipientBalance);

            System.out.println("Transferred " + amount + " from account " + accountNumber + " to account " + recipientAccountNumber);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
}

