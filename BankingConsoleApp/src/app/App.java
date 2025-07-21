package app;

import model.*;
import service.AccountGeneration;
import java.util.Scanner;

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
        Bank account = (choice == 1)
                ? new SavingAccount(name, age, email, contact, address, "Saving Account", accNum)
                : new CurrentAccount(name, age, email, contact, address, "Current Account", accNum);

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
                    } else {
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
                    } else {
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
