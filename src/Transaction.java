import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Transaction {
    protected String transactionID;
    protected double amount;
    protected long accountNumber;
    protected final String filePath = "src/AccountList.txt";

    public Transaction(String transactionID, double amount, long accountNumber) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public abstract void processTransaction();

    protected double getAccountBalance(long accountNumber) {
        String stringAccountNumber = String.valueOf(accountNumber);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                String[] data = readLine.split(",");

                if (data.length > 1 && data[1].equals(stringAccountNumber)) {
                    return Double.parseDouble(data[data.length - 1].trim());
                }
            }
            System.out.println("Kontonummer " + accountNumber + " kunde inte hittas");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Fel! Kunde inte läsa från fil. " + e.getMessage());
        }
        return 0.0;
    }

    protected void updateAccountBalance(long accountNumber, double newBalance) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                String[] data = readLine.split(",");

                if (data.length > 1 && data[1].equals(String.valueOf(accountNumber))) {
                    data[data.length - 1] = String.valueOf(newBalance);
                }

                lines.add(String.join(",", data));
            }
        } catch (IOException e) {
            System.err.println("Fel! Kunde inte läsa från fil. " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Fel! Kunde inte skriva till fil. " + e.getMessage());
        }
    }
}