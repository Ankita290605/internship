package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public abstract class Bank {
    protected String name;
    protected int age;
    protected String email;
    protected long contact;
    protected String address;
    protected int balance;
    protected String accountType;
    protected long accountNumber;
    protected List<String> passbook;
    protected int overDraft;

    public Bank(String name, int age, String email, long contact, String address, String accountType, long accountNumber, int overDraft) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.passbook = new ArrayList<>();
        this.balance = 0;
        this.overDraft = overDraft;
    }

    public abstract void deposit(int amount);
    public abstract void withdraw(int amount);
    public abstract void transferTo(long toAccount, int amount);
    public abstract void editProfile(int choice, Scanner scanner);
    public abstract void printPassbook();

    public void addPassbookEntry(LocalDate date, String time, String deposit, String withdrawal, int bal, int overDraft) {
        String entry = String.format("%-13s | %-13s | %-15s | %-16s | %-13d | %-13d | %n", date, time, deposit, withdrawal, bal, overDraft);
        passbook.add(entry);
    }

    public String getAccountType() {
        return accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
    
    public int getBankBalance() {
    	return balance;
    }
    
    public int getOD() {
    	return overDraft;
    }
    
   
}
