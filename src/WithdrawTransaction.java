public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(String transactionID, double amount, long accountNumber) {
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
            System.out.println("Balance: " + newBalance);
        } else {
            System.out.println("Insufficient funds for withdrawal. Current balance: " + currentBalance);
        }
    }
}
