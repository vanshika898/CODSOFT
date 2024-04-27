
// Create a class to represent the ATM machine.
// 2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
// checking the balance.
// 3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
// checkBalance().
// 4. Create a class to represent the user's bank account, which stores the account balance.
// 5. Connect the ATM class with the user's bank account class to access and modify the account
// balance.
// 6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
// 7. Display appropriate messages to the user based on their chosen options and the success or failure
// of their transactions.

/*Considering that intially the account has a balance of 500 rupees. */
import java.util.*;

class bankAccount {
    private int balance;

    public bankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amt) {
        balance += amt;
        System.out.println("After depositing, Your total balance is: " + balance);
        System.out.println("Your transaction is successful!!");
        System.out.println("***************************************************************************");

    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.println("After Withdrawing, Your total balance is: " + balance);
        System.out.println("Your transaction is successful!!");
        System.out.println("***************************************************************************");

    }

    public boolean isTruePin(int pin) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the PIN: ");
            int enteredPin = sc.nextInt();
            return enteredPin == pin;
        } catch (InputMismatchException e) {
            System.out.println("Exception:Enter valid PIN  in number");
            sc.next();
            return false;
        }
    }
}

class ATM {
    private bankAccount acc;
    Scanner sc = new Scanner(System.in);

    public ATM(bankAccount acc) {
        this.acc = acc;
    }

    public void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        try {
            int amt = sc.nextInt();
            acc.deposit(amt);

        } catch (Throwable y) {
            System.out.println("Exception:Enter valid amount  in number");
            sc.nextInt();
        }

    }

    public void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        try {
            int amt = sc.nextInt();
            if (amt <= 0) {
                System.out.println("Exception: Enter a valid positive amount.");
            } else if (amt > acc.getBalance()) {
                System.out.println("Exception: Insufficient balance.");
            } else {
                acc.withdraw(amt);
            }
        } catch (Throwable k) {
            System.out.println("Exception:Enter valid amount  in number");

        }
    }

    public void checkBalance() {
        System.out.println("Your balance in ATM is: " + acc.getBalance());
    }
}

public class task3 {
    public static void main(String[] args) {
        bankAccount b = new bankAccount(500); // Initial balance of 500 rupees
        ATM atm = new ATM(b);

        Random r = new Random();
        int pin = r.nextInt(9000) + 1000;
        System.out.println(
                "*************************************************************************************");
        System.out.println("                            Welcome to the ATM.");
        System.out.println("***************************************************************************");
        System.out.println("Your  PIN is: " + pin);

        while (true) {
            System.out.println("***************************************************************************");

            System.out.println("Choose an option:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit from the ATM");
            System.out.println("***************************************************************************");

            System.out.print("Enter your choice:");
            int choice = atm.sc.nextInt();

            switch (choice) {
                case 1:
                    if (b.isTruePin(pin)) {
                        atm.depositMoney();
                    } else {
                        System.out.println("Invalid PIN. Transaction failed.");
                    }
                    break;
                case 2:
                    if (b.isTruePin(pin)) {
                        atm.withdrawMoney();
                    } else {
                        System.out.println("Invalid PIN. Transaction failed.");
                    }
                    break;
                case 3:
                    if (b.isTruePin(pin)) {
                        atm.checkBalance();
                    } else {
                        System.out.println("Invalid PIN. Transaction failed.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for visting.");
                    System.out
                            .println("***************************************************************************");
                    System.out.println("                               Program Ends");
                    System.out
                            .println("***************************************************************************");

                    return;
                default:
                    System.out.println("Enter valid option.");
            }

        }

    }

}
