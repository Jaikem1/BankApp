package src;

public class TransactionFactory {
    public static Transaction createTransaction(String type, String transactionID, double amount, int accountNumber, Integer recipientAccountNumber) {
        switch (type) {
            case "WITHDRAW":
                return new WithdrawTransaction(transactionID, amount, accountNumber);
            case "DEPOSIT":
                return new DepositTransaction(transactionID, amount, accountNumber);
            case "TRANSFER":
                if (recipientAccountNumber == null) {
                    throw new IllegalArgumentException("Recipient account number required for transfer transactions.");
                }
                return new TransferTransaction(transactionID, amount, accountNumber, recipientAccountNumber);
            default:
                throw new IllegalArgumentException("Unknown transaction type: " + type);
        }
    }
}
