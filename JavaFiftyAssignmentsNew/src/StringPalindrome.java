

// 13. Check if a string is a palindrome

import java.util.*;

public class StringPalindrome{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase(); 

        boolean isPalindrome = true;
        int i = 0;
        int j = str.length() - 1;

        while(i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        if(isPalindrome){
            System.out.println("It is a palindrome");
        } 
        else{
            System.out.println("It is not a palindrome");
        }
    }
}
