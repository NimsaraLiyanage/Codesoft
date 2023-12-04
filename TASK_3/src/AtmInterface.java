import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("You can collect your money!");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You have successfully deposited your money!");
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }
}

public class AtmInterface {
    private final BankAccount userAccount;
    private final Scanner scanner;

    public AtmInterface(BankAccount account, Scanner scanner) {
        this.userAccount = account;
        this.scanner = scanner;
    }

    public void showOptions() {
        System.out.println("\n1 - Withdraw");
        System.out.println("2 - Deposit");
        System.out.println("3 - Check Balance");
        System.out.println("4 - Exit");
    }

    public void start() {
        int choice = 0;

        while (choice != 4) {
            showOptions();
            System.out.println("\nChoose 1 to 4 from above:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userAccount.withdraw(getTransactionAmount("withdraw"));
                    break;
                case 2:
                    userAccount.deposit(getTransactionAmount("deposit"));
                    break;
                case 3:
                    System.out.println("Your account balance is Rs " + userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for choosing us. Have a nice day!");
                    break;
                default:
                    System.out.println("Wrong choice! Please select 1 to 4.");
            }
        }
    }

    private int getTransactionAmount(String transactionType) {
        System.out.println("Enter the " + transactionType + " amount Rs:");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);
        AtmInterface atmInterface = new AtmInterface(account, scanner);

        System.out.println("\n---------------Welcome to the ATM--------------");
        atmInterface.start();

        scanner.close();
    }
}
