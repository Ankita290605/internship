

// 6. Find missing number from 1 to N

import java.util.*;

public class MissingNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n - 1]; 
        for (int i=0;i<n-1;i++){
            arr[i] = sc.nextInt();
        }

        int totalSum = n*(n+1)/2;

        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        int missing = totalSum - actualSum;
        System.out.println("Missing number is: " + missing);
    }
}