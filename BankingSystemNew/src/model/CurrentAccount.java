package model;

import java.util.Scanner;

public class CurrentAccount extends Bank {
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

    public void printPassbook(){
        System.out.println("----- Current Account Passbook -----");
        System.out.println("Name: "+ name +" | A/C No: "+ accountNumber +" | Balance: "+ balance +" | OD: "+ overdraftLimit);
        for (String entry : passbook) {
            System.out.println(entry);
        }
        System.out.println("------------------------------------");
    }
}
