import java.util.*;

abstract class Bank {
    String name;
    int age;
    String email;
    Long contact;
    String address;
    int totalMoney = 0;
    String accountType;
    Long accountNumber;
    List<String> ans = new ArrayList<>();

    Bank(String name, int age, String email, Long contact, String address, String accountType, Long accountNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    abstract void deposite(int amount);
    abstract boolean withdrawal(int amount);
    abstract boolean transferTo(Long to, int amount);
    abstract void editProfile(int n, Scanner sc);     
    abstract void printPassBook();
    abstract String getAccountType();                
}

// ====================== SAVING ACCOUNT CLASS ======================
class SavingAccount extends Bank {
    int OD_limit = 0;
    int limit = 0;

    SavingAccount(String name, int age, String email, Long contact, String address, String accountType, Long accountNumber) {
        super(name, age, email, contact, address, accountType, accountNumber);
    }

    void deposite(int amount) {
        totalMoney += amount;
        passBook("Credit amount: " + amount + " | Total Balance: " + totalMoney);
        System.out.println("Successfully deposited.");
    }

    boolean withdrawal(int amount) {
        if (totalMoney >= amount && limit < 5) {
            limit++;
            totalMoney -= amount;
            passBook("Debit amount: " + amount + " | Remaining Balance: " + totalMoney);
            return true;
        }
        return false;
    }

    boolean transferTo(Long to, int amount) {
        if (amount > totalMoney) {
           // limit++;
            return false;
        } 
        else {
            if(limit<=5){
            limit++;
            totalMoney -= amount;
            passBook("Transferred amount: " + amount + " to Acc No: " + to + " | Remaining Balance: " + totalMoney);
            
            }
            return true;
        }
    }

    void editProfile(int n, Scanner sc) {
        sc.nextLine();
            switch (n) {
            case 1:
                System.out.print("Enter new name: ");
                name = sc.nextLine();
                break;
            case 2:
                System.out.print("Enter new age: ");
                age = sc.nextInt();
                break;
            case 3:
                System.out.print("Enter new email: ");
                email = sc.nextLine();
                break;
            case 4:
                System.out.print("Enter new contact: ");
                contact = sc.nextLong();
                break;
            case 5:
                System.out.print("Enter new address: ");
                sc.nextLine(); 
                address = sc.nextLine();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
            System.out.println("Profile updated successfully.");
            return;
    }
    

    void passBook(String s) {
        ans.add(s);
    }

    void printPassBook() {
        System.out.println("----- Passbook -----");
        System.out.println("----- Passbook -----");
        System.out.println("===Saving Account===");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Contact No. "+contact);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Transaction Details Given Below: ");
        for (String entry : ans) {
            System.out.println(entry);
        }
        System.out.println("--------------------");
    }

    String getAccountType() {
        return accountType;
    }
}

// ====================== CURRENT ACCOUNT CLASS ======================
class CurrentAccount extends Bank {
    int OD_limit = 500000;

    CurrentAccount(String name, int age, String email, Long contact, String address, String accountType, Long accountNumber) {
        super(name, age, email, contact, address, accountType, accountNumber);
    }

    void deposite(int amount) {
        if(OD_limit==500000){
        totalMoney += amount;
        passBook("Credit amount: " + amount + " | Total Balance: " + totalMoney);
        }
        else{
            int n = 500000 - OD_limit;
            if(n>amount){
                OD_limit += amount;
                passBook("Credit in Overdraft: "+ amount+" Total Balance: "+totalMoney);
            }
            else if(n<amount){
                int q = amount-n;
                OD_limit += n;
                totalMoney += q;
                passBook("Credit in Overdraft: "+n+" Total Balance: "+totalMoney);
            }
        }
        System.out.println("Successfully deposited.");
        
    }

    boolean withdrawal(int amount){
        if (totalMoney >= amount) {
            totalMoney -= amount;
            passBook("Debit amount: " + amount + " | Remaining Balance: " + totalMoney);
            return true;
        }
        else{
            if(OD_limit==500000 || OD_limit>amount){
                int n = amount - totalMoney;
                OD_limit -= n;
                passBook("Debit from Overdraft, Remaining Overdraft: "+OD_limit);
                return true;
            }
            else{
                System.out.println("Overdraft limit exceeded! Transaction Block");
                return false;
            }

        }
    }

    boolean transferTo(Long to, int amount) {
        if (amount > totalMoney && OD_limit<amount) {
            return false;
        } 
        else {
            if(totalMoney>amount){
            totalMoney -= amount;
            passBook("Transferred amount: " + amount + " to Acc No: " + to + " | Remaining Balance: " + totalMoney);
            return true;
            }
            else{
                int q = amount - totalMoney;
                OD_limit -= q;
                passBook("Transferred amount using Overdraft: "+amount+" to Acc No: "+to+" | Remaining Overdraft: "+ OD_limit);
                return true;
            }
            
            }
            
    }
    
    void editProfile(int n, Scanner sc) {
        sc.nextLine();
        switch (n) {
            case 1:
                System.out.print("Enter new name: ");
                name = sc.nextLine();
                break;
            case 2:
                System.out.print("Enter new age: ");
                age = sc.nextInt();
                break;
            case 3:
                System.out.print("Enter new email: ");
                email = sc.nextLine();
                break;
            case 4:
                System.out.print("Enter new contact: ");
                contact = sc.nextLong();
                break;
            case 5:
                System.out.print("Enter new address: ");
                sc.nextLine(); 
                address = sc.nextLine();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
        System.out.println("Profile updated successfully.");
    }
    

    void passBook(String s) {
        ans.add(s);
    }

    void printPassBook() {
        System.out.println("----- Passbook -----");
        System.out.println("===Saving Account===");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Contact No. "+contact);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Transaction Details Given Below: ");
        for (String entry : ans) {
            System.out.println(entry);
        }
        System.out.println("--------------------");
    }

    String getAccountType() {
        return accountType;
    }
}

// ====================== ACCOUNT NUMBER CLASS ======================

class GetAccountNumber{
    public long generateAccoutNum(){
        Random random = new Random();
        long min = 1000000000;
        return  min + random.nextLong(999999999);
    }
}

// =========================== MAIN APP =============================
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Welcome to My Bank! ---");
        System.out.println("Press 1 for Saving Account generation\nPress 2 for Current Account generation");

        int ch;
        while (true) {
            ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("\nYou're proceeding with Saving Account creation.");
                System.out.println("Note: Max 5 withdrawals/month. No Overdraft.");
                break;
            } else if (ch == 2) {
                System.out.println("You're proceeding with Current Account creation.");
                System.out.println("Note: Overdraft limit is upto 5 lakh");
                break;
            } else {
                System.out.println("Invalid input. Please choose 1 or 2.");
            }
        }

        sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        if (age < 18) {
            System.out.println("You're a minor. Cannot open account.");
            return;
        }

        sc.nextLine(); 
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Enter your contact number: ");
        long contact = sc.nextLong();
        if (contact < 1000000000 || contact > 9999999999L) {
            System.out.println("Invalid contact number.");
            return;
        }

        sc.nextLine(); 
        System.out.print("Enter your address: ");
        String address = sc.nextLine();

        GetAccountNumber g = new GetAccountNumber();
        long accNum = g.generateAccoutNum();
        System.out.println("\n==== Congratulations! Your Account is Created ====");
        System.out.println("Your Account Number: " + accNum);


//=======================Saving Account Instance======================
    if(ch==1){
        SavingAccount s1 = new SavingAccount(name, age, email, contact, address, "Saving Account", accNum);

        System.out.print("Kindly deposit initial amount: ");
        int money = sc.nextInt();
        s1.deposite(money);

        System.out.println("Press 1 for Deposite Money\nPress 2 for Withdrawal Money\nPress 3 to transfer money\nPress 4 to print PassBook\nPress 5 to Edit Profile Details\nPress 6 to know your account type\nPress 7 to exit");
        while(true){
            int p = sc.nextInt();
            if(p==1){
                System.out.println("Enter the amount you want to deposite: ");
                int n = sc.nextInt();
                s1.deposite(n);
            }
            else if(p==2){
                System.out.println("Enter the money you want to withdrawal: ");
                int n = sc.nextInt();
                boolean flag = s1.withdrawal(n);
                if(flag==true){
                    System.out.println("Successfully Withdrawal");
                }
                else{
                    System.out.println("You have less amount in account or limit is over");
                }
            }
            else if(p==3){
                System.out.println("Enter the account no. of recieving account and the amount have to transfer: ");
                Long n = sc.nextLong();
                int m = sc.nextInt();
                boolean flag = s1.transferTo(n, m);
                if(flag==true){
                    System.out.println("Successfully send");
                }
                else{
                    System.out.println("Your Bank balance is less than the sending amount or limit is over");
                }
                
            }
            else if(p==4){
                s1.printPassBook();
            }
            else if(p==5){
                System.out.println("Enter 1 for name, 2 for age, 3 for email, 4 for contact, 5 for address 6 for exit");
                while(true){
                    int n = sc.nextInt();
                    if(n==6){
                        System.out.println("--EXIT--");
                        break;
                    }
                    s1.editProfile(n, sc);
                }
            }
        
            else if(p==7){
                System.out.println("Thank you see you next time....");
                break;
            }
            else{
                System.out.println("Invalid output");
                break;
            }
        }
    }

 //================Current account instance===========

    if(ch==2){
            CurrentAccount c1 = new CurrentAccount(name, age, email, contact, address, "Current Account", accNum);

        System.out.print("Kindly deposit initial amount: ");
        int money = sc.nextInt();
        c1.deposite(money);
        System.out.println("---------Choose an Option----------");
        System.out.println("Press 1 for Deposite Money\nPress 2 for Withdrawal Money\nPress 3 to transfer money\nPress 4 to print PassBook\nPress 5 to Edit Profile Details\nPress 6 to know your account type\nPress 7 to exit");
        while(true){
            int p = sc.nextInt();
            if(p==1){
                System.out.println("Enter the amount you want to deposite: ");
                int n = sc.nextInt();
                c1.deposite(n);
            }
            else if(p==2){
                System.out.println("Enter the money you want to withdrawal: ");
                int n = sc.nextInt();
                boolean flag = c1.withdrawal(n);
                if(flag==true){
                    System.out.println("Successfully Withdrawal");
                }
                else{
                    System.out.println("You have less amount in account or limit is over");
                }
            }
            else if(p==3){
                System.out.println("Enter the account no. of recieving account and the amount have to transfer: ");
                Long n = sc.nextLong();
                int m = sc.nextInt();
                boolean flag = c1.transferTo(n, m);
                if(flag==true){
                    System.out.println("Successfully send");
                }
                else{
                    System.out.println("Your Bank balance is less than the sending amount or limit is over");
                }
                
            }
            else if(p==4){
                c1.printPassBook();
            }
            else if(p==5){
                System.out.println("Enter 1 for name, 2 for age, 3 for email, 4 for contact, 5 for address 6 for exit");
                while(true){
                    int n = sc.nextInt();
                     if(n==6){
                        System.out.println("---EXIT---");
                        break;
                    }
                    c1.editProfile(n, sc);
                   
                }
            }

            else if(p==6){
                System.out.println(c1.getAccountType());
            }
            else if(p==7){
                System.out.println("Thank you see you next time....");
                break;
            }
            else{
                System.out.println("Invalid output");
            }
        }
        }

    }
}
