package model;

import java.util.Scanner;

public class SavingAccount extends Bank {
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

    public void editProfile(int choice, Scanner sc) {
        sc.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter new name: ");
                name = sc.nextLine();
            }
            case 2 -> {
                System.out.print("Enter new age: ");
                age = sc.nextInt();
            }
            case 3 -> {
                System.out.print("Enter new email: ");
                email = sc.nextLine();
            }
            case 4 -> {
                System.out.print("Enter new contact: ");
                contact = sc.nextLong();
            }
            case 5 -> {
                System.out.print("Enter new address: ");
                sc.nextLine();
                address = sc.nextLine();
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
