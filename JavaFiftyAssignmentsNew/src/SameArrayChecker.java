

// 29. Check if two arrays are equal

import java.util.*;

public class SameArrayChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0;i<m;i++){
            brr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(brr);
        boolean flag = true;
        if(m!=n){
            flag = false;
        }
        else{
            for(int i=0;i<n;i++){
                if(arr[i]!=brr[i]){
                    flag = false;
                    break;
                }
            }
        }
        if(flag==true){
            System.out.println("Same Arrays");
        }
        else{
            System.out.println("Different Arrays");
        }
    }
}

