
public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(String transactionID, double amount, int accountNumber) {
        super(transactionID, amount, accountNumber);
    }

    @Override
    public void processTransaction() {
        System.out.println("Processing withdrawal transaction...");
        double currentBalance = getAccountBalance(accountNumber);
        if (currentBalance >= amount) {
            double newBalance = currentBalance - amount;
            updateAccountBalance(accountNumber, newBalance);
            System.out.println("Withdrawn " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
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
