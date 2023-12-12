import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public void run() {
        int response = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Logga in som:");
            System.out.println("1. Bank");
            System.out.println("2. Kund");
            System.out.print("Skriv ditt alternativ: ");

            response = scanner.nextInt();
        }
    }


    public static void main(String[] args) {

        Main run = new Main();
        run.run();
    }
}