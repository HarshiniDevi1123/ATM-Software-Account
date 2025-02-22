import java.util.Scanner;
class BankAccount {
    private String accountHolder;
    private double balance;
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
}
public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account1 = new BankAccount("Harshini");
        BankAccount account2 = new BankAccount("Mariya");
        while (true) {
            System.out.println("Select an account: ");
            System.out.println("1. Harshini's Account");
            System.out.println("2. Mariya's Account");
            System.out.println("3. Exit");
            int accountChoice = scanner.nextInt();
            if (accountChoice == 3) {
                System.out.println("Exiting...");
                scanner.close();
                return;
            }
            BankAccount selectedAccount = (accountChoice == 1) ? account1 : account2;
            while (true) {
                System.out.println("Select an option: ");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. View Balance");
                System.out.println("4. Switch Account");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        selectedAccount.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        selectedAccount.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println(selectedAccount.getAccountHolder() + "'s Balance: " + selectedAccount.getBalance());
                        break;
                    case 4:
                        break; 
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return; 
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
                if (choice == 4) {
                    break;
                }
            }
        }
    }
}