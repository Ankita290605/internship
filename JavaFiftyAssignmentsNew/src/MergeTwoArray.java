

// 10. Merge two sorted arrays

import java.util.*;

public class MergeTwoArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }

        int[] merged = new int[n1 + n2];

        for(int i=0;i<n1;i++){
            merged[i]=arr1[i];
        }

        for(int i=0;i<n2;i++){
            merged[n1+i]=arr2[i];
        }

        System.out.print("Merged array: ");
        for(int val : merged) {
            System.out.print(val + " ");
        }
    }
}
