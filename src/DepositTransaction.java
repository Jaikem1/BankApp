public class DepositTransaction extends Transaction {
    public DepositTransaction(String transactionID, double amount, long accountNumber) {
        super(transactionID, amount, accountNumber);
    }

    @Override
    public void processTransaction() {
        System.out.println("Processing deposit transaction...");
        double currentBalance = getAccountBalance(accountNumber);
        double newBalance = currentBalance + amount;
        updateAccountBalance(accountNumber, newBalance);
        System.out.println("Deposited " + amount + " into account " + accountNumber);
        System.out.println("New balance: " + newBalance);
    }
}