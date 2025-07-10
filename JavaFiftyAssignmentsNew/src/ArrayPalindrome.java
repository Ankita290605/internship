

// 8. Check if array is a palindrome

import java.util.*;

public class ArrayPalindrome{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n]; 
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        boolean flag = false;
        int i =0;
        int j = n-1;
        while(i<j){
            if(arr[i]!=arr[j]){
                flag = true;
                break;
            }
            i++;
            j--;
        }

        if(flag){
            System.out.println("It is not palindrome");
        }
        else{
            System.out.println("It is palindrome");
        }

    }
        
}
