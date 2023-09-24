import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayOptions();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!!!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again. :(");
            }
        }
    }

    private void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your balance is: rs" + balance);
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: rs");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: rs");
        double amount = scanner.nextDouble();
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
