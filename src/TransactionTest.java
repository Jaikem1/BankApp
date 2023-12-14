
import java.util.Scanner;

public class TransactionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome To Our Fake Bank - Transaction Testing");

        while (true) {
            System.out.println("Please choose a transaction type:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Exit");

            System.out.print("Enter choice (1-4): ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting the test.");
                break;
            }

            System.out.print("Enter transaction ID: ");
            String transactionID = scanner.next();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();

            Integer recipientAccountNumber = null;
            if (choice == 3) {
                System.out.print("Enter recipient account number: ");
                recipientAccountNumber = scanner.nextInt();
            }

            try {
                Transaction transaction = null;
                switch (choice) {
                    case 1:
                        transaction = TransactionFactory.createTransaction("WITHDRAW", transactionID, amount, accountNumber, null);
                        break;
                    case 2:
                        transaction = TransactionFactory.createTransaction("DEPOSIT", transactionID, amount, accountNumber, null);
                        break;
                    case 3:
                        transaction = TransactionFactory.createTransaction("TRANSFER", transactionID, amount, accountNumber, recipientAccountNumber);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }

                if (transaction != null) {
                    transaction.processTransaction();
                    System.out.println("Transaction processed successfully.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred during the transaction: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

