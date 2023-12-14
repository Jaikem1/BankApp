
public class TransferTransaction extends Transaction {
    private int recipientAccountNumber;

    public TransferTransaction(String transactionID, double amount, int accountNumber, int recipientAccountNumber) {
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


    private double getAccountBalance(int accountNumber) {
        // Logic to retrieve account balance from database
        return 0.0;
    }

    private void updateAccountBalance(int accountNumber, double newBalance) {
        // Logic to update account balance in the database
    }
}


