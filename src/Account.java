import java.io.*;

public class Account {
    private long accountNumber;
    private double balance;
    private final String filePath = "src/AccountList.txt";
    private String name;

    public void createAccount(String name){
        this.name = name;
        this.accountNumber = generateRandomAccountNumber();
        this.balance = 5000;

        String content = name + "," + accountNumber + "," + balance;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long generateRandomAccountNumber() {
        long minAccountNumber = 1000000000L;
        long maxAccountNumber = 9999999999L;

        return minAccountNumber + (long) (Math.random() * (maxAccountNumber - minAccountNumber + 1));
    }

    public String searchAccount(Long accountNumber) {
        this.accountNumber = accountNumber;
        String stringAccountNumber = String.valueOf(accountNumber);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                String[] data = readLine.split(",");

                if (data.length > 1 && data[1].trim().equals(stringAccountNumber)) {
                    String name = data[0];
                    String balanceOnAccount = data[data.length - 1];
                    System.out.println("Namn: " + name + "\nKontonummer: " + accountNumber + "\nSaldo: " + balanceOnAccount);
                    return stringAccountNumber;
                }
            }
            System.out.println("Kontonummer " + accountNumber + " kunde inte hittas");
        } catch (IOException e) {
            System.err.println("Fel! Kunde inte läsa från fil. " + e.getMessage());
        }
        return stringAccountNumber;
    }

    public long getAccountDetails(){
        return accountNumber;
    }
}