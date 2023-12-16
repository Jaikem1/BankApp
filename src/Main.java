
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    Scanner scanner = new Scanner(System.in);
    int response;
    String transactionID;
    Account account = new Account();

    public void runProgram() {
        while (true) {
            System.out.println("Logga in som:");
            System.out.println("1. Bank");
            System.out.println("2. Kund");
            System.out.println("3. Avsluta");
            System.out.print("Skriv ditt alternativ: ");
            response = scanner.nextInt();

            switch (response){
                case 1:
                    runBankMenu();
                    break;
                case 2:
                    runCustomerMenu();
                    break;
                case 3:
                    System.out.println("Programmet avslutas");
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
    private void runBankMenu() {
        while (true) {
            System.out.println();
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Skapa en kund");
            System.out.println("2. Se kontouppgifter");
            System.out.println("3. Avsluta");
            System.out.print("Skriv ditt alternativ: ");

            response = scanner.nextInt();

            switch (response) {
                case 1:
                    System.out.println("Skriv kundens namn: ");
                    String custumerName = scanner.next();
                    account.createAccount(custumerName);
                    System.out.println("Kund skapad med kontonummer: " + account.getAccountDetails());
                    break;
                case 2:
                    System.out.println("Skriv kundens kontonummer: ");
                    Long customerAccountNumber = scanner.nextLong();
                    account.searchAccount(customerAccountNumber);
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    private void runCustomerMenu() {

        while (true) {
            System.out.println();
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Gör ett uttag");
            System.out.println("2. Gör en insättning");
            System.out.println("3. Gör en överföring");
            System.out.println("4. Starta ett konto");
            System.out.println("5. Se kontoinfo");
            System.out.println("6. Avsluta");
            System.out.print("Skriv ditt alternativ: ");

            response = scanner.nextInt();

            switch (response) {
                case 1:
                    System.out.println("Skriv beloppet att ta ut: ");
                    double withdrawalAmount = scanner.nextDouble();
                    System.out.println("Skriv ditt kontonummer: ");
                    long withdrawalAccountNumber = scanner.nextLong();
                    WithdrawTransaction withdrawal = new WithdrawTransaction(transactionID, withdrawalAmount, withdrawalAccountNumber);
                    withdrawal.processTransaction();
                    break;
                case 2:
                    System.out.println("Skriv beloppet att sätta in: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println("Skriv ditt kontonummer: ");
                    long depositAccountNumber = scanner.nextLong();
                    DepositTransaction deposit = new DepositTransaction(transactionID, depositAmount, depositAccountNumber);
                    deposit.processTransaction();
                    break;
                case 3:
                    System.out.println("Skriv beloppet att överföra: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.println("Skriv ditt kontonummer: ");
                    long sourceAccountNumber = scanner.nextLong();
                    System.out.println("Skriv mottagarens kontonummer: ");
                    long recipientAccountNumber = scanner.nextLong();
                    TransferTransaction transfer = new TransferTransaction(transactionID, transferAmount, sourceAccountNumber, recipientAccountNumber);
                    transfer.processTransaction();
                    break;
                case 4:
                    System.out.println("Skriv ditt namn: ");
                    String nameResp = scanner.next();
                    account.createAccount(nameResp);
                    System.out.println("Ditt kontonummer är: " + account.getAccountDetails());
                    break;
                case 5:
                    System.out.println("Skriv ditt kontonummer: ");
                    Long responseLong = scanner.nextLong();
                    account.searchAccount(responseLong);
                    break;
                case 6:
                    System.out.println("Programmet avslutas");
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Main run = new Main();
        run.runProgram();
    }
}