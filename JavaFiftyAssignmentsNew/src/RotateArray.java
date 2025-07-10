

// 3. Rotate array by `k` steps

import java.util.*;
public class RotateArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int temp[] = new int[n];

        for(int i=0;i<n;i++){
            temp[(i+k)%n] = arr[i];
        }

        for(int i=0;i<n;i++){
            arr[i] = temp[i];
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
