

// 5. Two sum in sorted array (return indices)

import java.util.*;
public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        int left = 0;
        int right = n-1;

        while(left<right){
            int sum = arr[left] + arr[right];
            if(sum==t){
                System.out.println("Indices: "+(left+1)+" "+(right+1));
                return;
            }
            else if(sum<t){
                left++;
            }
            else{
                right--;
            }
        }

        System.out.println("No two numbers found.");
    }
}
 
    
