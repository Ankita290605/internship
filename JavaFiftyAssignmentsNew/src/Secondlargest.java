

// 9. Find second largest element

import java.util.*;

public class Secondlargest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i=0;i<n;i++){
            if (arr[i]>max){
                second=max;
                max=arr[i];
            } 
            else if(arr[i]>second && arr[i]!=max){
                second=arr[i];
            }
        }

        if(second==Integer.MIN_VALUE){
            System.out.println("No second largest element");
        }
        else{
            System.out.println("Second largest element is: " + second);
        }
    }
}
