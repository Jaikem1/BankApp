package src;
public class DepositTransaction extends Transaction {
    public DepositTransaction(String transactionID, double amount, int accountNumber) {
        super(transactionID, amount, accountNumber);
    }

    @Override
    public void processTransaction() {
        System.out.println("Processing deposit transaction...");
        // Assuming a method getAccountBalance and updateAccountBalance exist
        double currentBalance = getAccountBalance(accountNumber);
        double newBalance = currentBalance + amount;
        updateAccountBalance(accountNumber, newBalance);
        System.out.println("Deposited " + amount + " into account " + accountNumber);
    }

    private double getAccountBalance(int accountNumber) {
        // Logic to retrieve account balance from database
        return 0.0;
    }

    private void updateAccountBalance(int accountNumber, double newBalance) {
        // Logic to update account balance in the database
    }
}
