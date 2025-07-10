

// 23. Check if a number is a palindrome

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rev = 0;
        int original = n;
        while(n>0){
            int d = n%10;
            rev = rev*10+d;
            n = n/10;
        }

        if(original==rev){
            System.out.println("It is palindrome");

        }
        else{
            System.out.println("It is not palindrome");
        }
    }
}
