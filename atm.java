import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double iBalance) {
        this.balance = iBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful, New balance: " + balance);
    }
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds, Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println(amount+" Withdrawed successfully, New balance: " + balance);
            return true;
        }
    }
}
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial account balance: ");
        double initialBalance = sc.nextDouble();
        BankAccount userAccount = new BankAccount(initialBalance);
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    if (withdrawalAmount > 0) {
                        userAccount.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount > 0) {
                        userAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;
                case 3:
                    System.out.println("Current Balance is " + userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
            }
        }
    }
}