package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Scanner;

public class SavingAccount extends Bank {
    private static final int MAX_WITHDRAWALS = 3;
    private int withdrawals = 0;
    int overDraft = 0;

    public SavingAccount(String name, int age, String email, long contact, String address, String accountType, long accountNumber, int overDraft) {
        super(name, age, email, contact, address, accountType, accountNumber, overDraft);
    }
    
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    String formattedTime = currentTime.format(formatter);

    public void deposit(int amount) {
        balance += amount;
        addPassbookEntry(currentDate, formattedTime, String.valueOf(amount), "----" , balance, overDraft );
        System.out.println("Amount deposited successfully. Your Current balance is: "+ balance);
    }

    public void withdraw(int amount) {
        if (amount <= balance && withdrawals < MAX_WITHDRAWALS) {
            balance -= amount;
            withdrawals++;
            addPassbookEntry(currentDate, formattedTime, "----", String.valueOf(amount), balance, overDraft);
            System.out.println("Amount withdrawal successfully. Remaining balance is: "+balance);
        }
        else if(amount <= balance && withdrawals >= MAX_WITHDRAWALS){
        	System.out.println("Your transaction limit is over!");
        }
        else {
        	System.out.println("Insufficient Amount");
        }
        
    }

    public void transferTo(long toAccount, int amount) {
    	
        if (amount <= balance && withdrawals < MAX_WITHDRAWALS) {
            balance -= amount;
            withdrawals++;
            addPassbookEntry(currentDate, formattedTime, "----", (amount+"(Transfered)"), balance, overDraft);
            System.out.println("Money transfered successfully! Remaining Balance is: "+balance);
        }
        else if(amount <= balance && withdrawals > MAX_WITHDRAWALS) {
        	System.out.println("Transaction Limit is Over");
        }
        else {
        	System.out.println("Insufficient Amount");
        }
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
    	System.out.printf("----------------------------------------------------------------------------------------------------%n");
    	System.out.printf("                            Passbook Details      %n");
    	System.out.println("Account owner: "+name+" Account number: "+accountNumber+" Account Type: "+accountType);
    	System.out.printf("----------------------------------------------------------------------------------------------------%n");
    	System.out.printf("%-13s | %-13s | %-15s | %-16s | %-13s | %-13s | %n", "DATE", "TIME", "DEPOSITE", "WITHDRAWAL", "BALANCE", "OVERDRAFT");
    	System.out.printf("----------------------------------------------------------------------------------------------------%n");
    	for (String entry : passbook) {
            System.out.println(entry);
        }
    	System.out.printf("----------------------------------------------------------------------------------------------------%n");
    }
}
