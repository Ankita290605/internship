import java.util.*;

abstract class Bank {
    protected String name;
    protected int age;
    protected String email;
    protected long contact;
    protected String address;
    protected int balance;
    protected String accountType;
    protected long accountNumber;
    protected List<String> passbook;

    public Bank(String name, int age, String email, long contact, String address, String accountType, long accountNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.passbook = new ArrayList<>();
        this.balance = 0;
    }

    public abstract void deposit(int amount);
    public abstract boolean withdraw(int amount);
    public abstract boolean transferTo(long toAccount, int amount);
    public abstract void editProfile(int choice, Scanner scanner);
    public abstract void printPassbook();

    protected void addPassbookEntry(String entry) {
        passbook.add(entry);
    }

    public String getAccountType() {
        return accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}

//====================== SAVING ACCOUNT ======================
class SavingAccount extends Bank {
    private static final int MAX_WITHDRAWALS = 5;
    private int withdrawals = 0;

    public SavingAccount(String name, int age, String email, long contact, String address, String accountType, long accountNumber) {
        super(name, age, email, contact, address, accountType, accountNumber);
    }

    public void deposit(int amount) {
        balance += amount;
        addPassbookEntry("Credited :" + amount + " | Balance: :" + balance);
        System.out.println("Amount deposited successfully.");
    }

    public boolean withdraw(int amount) {
        if (amount <= balance && withdrawals < MAX_WITHDRAWALS) {
            balance -= amount;
            withdrawals++;
            addPassbookEntry("Debited :" + amount + " | Balance: :" + balance);
            return true;
        }
        return false;
    }

    public boolean transferTo(long toAccount, int amount) {
        if (amount <= balance && withdrawals < MAX_WITHDRAWALS) {
            balance -= amount;
            withdrawals++;
            addPassbookEntry("Transferred :" + amount + " to A/C " + toAccount + " | Balance: " + balance);
            return true;
        }
        return false;
    }

    public void editProfile(int choice, Scanner scanner) {
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter new name: ");
                name = scanner.nextLine();
            }
            case 2 -> {
                System.out.print("Enter new age: ");
                age = scanner.nextInt();
            }
            case 3 -> {
                System.out.print("Enter new email: ");
                email = scanner.nextLine();
            }
            case 4 -> {
                System.out.print("Enter new contact: ");
                contact = scanner.nextLong();
            }
            case 5 -> {
                System.out.print("Enter new address: ");
                scanner.nextLine();
                address = scanner.nextLine();
            }
            default -> System.out.println("Invalid option.");
        }
        System.out.println("Profile updated.");
    }

    public void printPassbook() {
        System.out.println("----- Saving Account Passbook -----");
        System.out.println("Name: "+ name +" | A/C No: "+ accountNumber +" | Balance: "+ balance);
        for(String entry : passbook){
            System.out.println(entry);
        }
        System.out.println("-----------------------------------");
    }
}

//====================== CURRENT ACCOUNT ======================
class CurrentAccount extends Bank {
    private int overdraftLimit = 500000;

    public CurrentAccount(String name, int age, String email, long contact, String address, String accountType, long accountNumber) {
        super(name, age, email, contact, address, accountType, accountNumber);
    }

    public void deposit(int amount) {
        if (overdraftLimit < 500000) {
            int needed = 500000 - overdraftLimit;
            if(amount <= needed){
                overdraftLimit += amount;
                addPassbookEntry("Deposited in OD: "+ amount +" | OD Limit: "+ overdraftLimit);
            } 
            else{
                overdraftLimit = 500000;
                balance += (amount - needed);
                addPassbookEntry("OD filled: "+ needed +" | Credited: "+ (amount - needed) +" | Balance: "+ balance);
            }
        } 
        else {
            balance += amount;
            addPassbookEntry("Credited "+ amount +" | Balance: "+ balance);
        }
        System.out.println("Amount deposited.");
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            addPassbookEntry("Debited " + amount + " | Balance: " + balance);
            return true;
        } 
        else if (amount <= balance + overdraftLimit) {
            int fromOD = amount - balance;
            overdraftLimit -= fromOD;
            balance = 0;
            addPassbookEntry("Debited using OD " + amount + " | Remaining OD: " + overdraftLimit);
            return true;
        }
        return false;
    }

    public boolean transferTo(long toAccount, int amount) {
        return withdraw(amount) && logTransfer(toAccount, amount);
    }

    private boolean logTransfer(long toAccount, int amount) {
        addPassbookEntry("Transferred "+ amount +" to A/C "+ toAccount);
        return true;
    }

    public void editProfile(int choice, Scanner scanner) {
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter new name: ");
                name = scanner.nextLine();
            }
            case 2 -> {
                System.out.print("Enter new age: ");
                age = scanner.nextInt();
            }
            case 3 -> {
                System.out.print("Enter new email: ");
                email = scanner.nextLine();
            }
            case 4 -> {
                System.out.print("Enter new contact: ");
                contact = scanner.nextLong();
            }
            case 5 -> {
                System.out.print("Enter new address: ");
                scanner.nextLine();
                address = scanner.nextLine();
            }
            default -> System.out.println("Invalid option.");
        }
        System.out.println("Profile updated.");
    }

    public void printPassbook(){
        System.out.println("----- Current Account Passbook -----");
        System.out.println("Name: "+ name +" | A/C No: "+ accountNumber +" | Balance: "+ balance +" | OD: "+ overdraftLimit);
        for (String entry : passbook) {
            System.out.println(entry);
        }
        System.out.println("------------------------------------");
    }
}

//====================== ACCOUNT NUMBER GENERATOR ======================
class AccountGeneration {
    public static long generateAccountNumber() {
        Random random = new Random();
        return 1_000_000_000L + random.nextInt(900_000_000);
    }
}

//====================== MAIN APPLICATION ======================
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Welcome to Genesis Bank System ===");

        int choice;
        while (true) {
            System.out.print("Choose Account Type (1 - Saving, 2 - Current): ");
            choice = sc.nextInt();
            if (choice == 1 || choice == 2) break;
            System.out.println("Invalid input. Please try again.");
        }

        sc.nextLine();
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        if (age < 18) {
            System.out.println("You must be 18+ to open an account.");
            return;
        }

        sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Enter your contact number: ");
        long contact = sc.nextLong();
        if (String.valueOf(contact).length() != 10) {
            System.out.println("Invalid contact number.");
            return;
        }

        sc.nextLine();
        System.out.print("Enter your address: ");
        String address = sc.nextLine();

        long accNum = AccountGeneration.generateAccountNumber();
        Bank account = (choice == 1) ? new SavingAccount(name, age, email, contact, address, "Saving Account", accNum) : new CurrentAccount(name, age, email, contact, address, "Current Account", accNum);

        System.out.print("Deposit initial amount: ");
        int initial = sc.nextInt();
        account.deposit(initial);

        while (true) {
            System.out.println("\nMenu: 1-Deposit  2-Withdraw  3-Transfer  4-Passbook  5-EditProfile  6-AccountType  7-Exit");
            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    int amt = sc.nextInt();
                    account.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    int amt = sc.nextInt();
                    if (account.withdraw(amt)) {
                        System.out.println("Withdrawal successful.");
                    } 
                    else {
                        System.out.println("Withdrawal failed.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter receiver A/C number: ");
                    long toAcc = sc.nextLong();
                    System.out.print("Enter amount to transfer: ");
                    int amt = sc.nextInt();
                    if (account.transferTo(toAcc, amt)) {
                        System.out.println("Transfer successful.");
                    } 
                    else {
                        System.out.println("Transfer failed.");
                    }
                }
                case 4 -> account.printPassbook();
                case 5 -> {
                    System.out.println("Edit: 1-Name 2-Age 3-Email 4-Contact 5-Address");
                    int editOpt = sc.nextInt();
                    account.editProfile(editOpt, sc);
                }
                case 6 -> System.out.println("Account Type: " + account.getAccountType());
                case 7 -> {
                    System.out.println("Thanks for using our banking system!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}