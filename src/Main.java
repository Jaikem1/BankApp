
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    Scanner scanner = new Scanner(System.in);
    int response;
    String transactionID;
    double amount;
    int accountNumber;
    Account account = new Account();

    public void runProgram() {


        while (true) {
            System.out.println("Logga in som:");
            System.out.println("1. Bank");
            System.out.println("2. Kund");
            System.out.println("3. Avsluta");
            System.out.print("Skriv ditt alternativ: ");
            response = scanner.nextInt();

            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            switch (response){
                case 1:
                    runBankMenu();
                    break;
                case 2:
                    runCustomerMenu();
                    break;
                default:
                    break;
            }
        }
    }

    private void runBankMenu() {
        while (true) {
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Skapa en kund");
            System.out.println("2. Se konotuppgifter");
            System.out.println("3. Avsluta");
            System.out.print("Skriv ditt alternativ: ");

            response = scanner.nextInt();

            switch (response) {
                case 1:
                    runBankMenu();
                    break;
                case 2:
                    runCustomerMenu();
                    break;
            }
        }
    }

    private void runCustomerMenu() {

        while (true) {
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Gör ett uttag");
            System.out.println("2. Gör en insättning");
            System.out.println("3. Gör en Överföring");
            System.out.println("4. Starta ett konto");
            System.out.println("5. Se kontoinfo");
            System.out.print("Skriv ditt alternativ: ");

            response = scanner.nextInt();

            switch (response) {
                case 1:
                case 2:
                case 3:
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