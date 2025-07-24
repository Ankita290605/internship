package app;

import model.*;
import service.*;
import java.util.regex.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidationCheck v = new ValidationCheck();
        System.out.println("=== Welcome to Genesis Bank System ===");

        int choice;
        while (true) {
            System.out.print("Choose Account Type (1 - Saving, 2 - Current, 3 - Details): ");
            choice = sc.nextInt();
            
            if (choice == 1 || choice == 2) break;
            else if(choice == 3) {
            	System.out.println("-----------Saving Account Details-----------");
            	System.out.println("In this account type you always get 3 transaction/month");
            	System.out.println("This account type do not provide any Overdraft");
            	System.out.println();
            	System.out.println("-----------Saving Account Details-----------");
            	System.out.println("In this account type you get unlimited transaction");
            	System.out.println("This account type do provide Overdraft of 2Lakh");
            	
            }
            else System.out.println("Invalid input. Please try again.");
        }

        sc.nextLine();
        String name = "";
        while(true) {
            System.out.print("Enter your name: ");
            name = sc.nextLine();          
            boolean valid = v.validName(name);    

            if(!valid) {
                System.out.println("Invalid name. Please try again.");
            } 
            else{
                break;                                                                              
            }
        }
       
        int age = -1;
        while(true) {
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        if (age < 18 && age >= 0) {
            System.out.println("You must be 18+ to open an account.");
            return;
        }
        else if(age > 100 || age<0) {
        	System.out.println("Invalid Age. Please enter valid age");
        }
        else {
        	break;
        }
        }
        

        sc.nextLine();
        String email = "";
        while(true) {
        System.out.print("Enter your email: ");
        email = sc.nextLine();
        boolean valid = v.validEmail(email);
        if(!valid) {
        	System.out.println("Invalid email! Please enter valid email");
        }
        else {
        	break;
        }
        }
        
        long contact = -1;
        while(true) {
        System.out.print("Enter your contact number: ");
        contact = sc.nextLong();
        if (String.valueOf(contact).length() != 10 || contact < 1000000000 && contact > 9999999999L) {
            System.out.println("Invalid contact number. Please enter valid contact number");
        }
        else {
        	break;
        }
        }
        
        
        sc.nextLine();
        String address = "";
        while(true) {
        System.out.print("Enter your address: ");
        address = sc.nextLine();
        boolean valid = v.validAddress(address);
        if(!valid) {
            System.out.println("Invalid address. Please try again.");
        } 
        else{
            break;                          
        }
        }

        long accNum = AccountGeneration.generateAccountNumber();
        Bank account = (choice == 1)
                ? new SavingAccount(name, age, email, contact, address, "Saving Account", accNum, 0)
                : new CurrentAccount(name, age, email, contact, address, "Current Account", accNum, 200000);

        System.out.print("Deposit initial amount: ");
        int initial = sc.nextInt();
        account.deposit(initial);

        while (true) {
            System.out.println("\nMenu: 1-Deposit  2-Withdraw  3-Transfer  4-Passbook  5-EditProfile  6-AccountType  7-CheckBankBalance  8-CheckOverDraft  9-Exit");
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
                    account.withdraw(amt);
                }
                case 3 -> {
                	long toAcc = -1;
                	while(true) {
                    System.out.print("Enter receiver A/C number: ");
                    toAcc = sc.nextLong();
                    if (String.valueOf(toAcc).length() != 10 || toAcc < 1000000000 && toAcc > 9999999999L || toAcc==contact) {
                        System.out.println("Invalid Account number. Please enter valid account number");
                    } 
                    else {
                    	break;
                    }
                	}
                    System.out.print("Enter amount to transfer: ");
                    int amt = sc.nextInt();
                    account.transferTo(toAcc, amt);
                    
                }
                case 4 -> account.printPassbook();
                case 5 -> {
                    System.out.println("Edit: 1-Name 2-Age 3-Email 4-Contact 5-Address");
                    int editOpt = sc.nextInt();
                    account.editProfile(editOpt, sc);
                }
                case 6 -> System.out.println("Account Type: " + account.getAccountType());
                case 7 -> System.out.println("Your Current Balance is: "+ account.getBankBalance());
                case 8 -> System.out.println("Your Remaining OverDraft is: "+ account.getOD());
                case 9 -> {
                    System.out.println("Thanks for using our banking system!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}

