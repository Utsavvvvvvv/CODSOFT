import java.util.Scanner;

class BankAccount {
    private String accHolder;
    private double balance;

    public BankAccount(String accHolder, double balance) {
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Invalid amount. Please enter an amount greater than 0.";
        }
        balance += amount;
        return "Deposit successful. New balance: $" + balance;
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Invalid amount. Please enter an amount greater than 0 .";
        }
        if (amount > balance) {
            return "Insufficient funds for this withdrawal.";
        }
        balance -= amount;
        return "Withdrawal successful. New balance: $" + balance;
    }

    public String checkBalance() {
        return "Current balance: $" + balance;
    }
}

class ATMMachine {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATMMachine(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processSelection(int selection) {
        switch (selection) {
            case 1:
                System.out.println(bankAccount.checkBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                System.out.println(bankAccount.deposit(depositAmount));
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                System.out.println(bankAccount.withdraw(withdrawAmount));
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
                break;
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option (1-4): ");
            int selection = scanner.nextInt();
            if (selection == 4) {
                processSelection(selection);
                break;
            }
            processSelection(selection);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Utsav Verma", 500.00);
        ATMMachine atm = new ATMMachine(bankAccount);
        atm.run();
    }
}
