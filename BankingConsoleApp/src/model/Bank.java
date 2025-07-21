package model;

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
