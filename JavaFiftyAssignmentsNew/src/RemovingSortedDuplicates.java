
// 1. Remove duplicates from a sorted array

import java.util.*;
public class RemovingSortedDuplicates{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = 0;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[k]){
                k++;
                arr[k] = arr[i];
               
            }
        }

        for(int i=0;i<=k;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
}
