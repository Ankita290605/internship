

// 7. Find the element with maximum frequency

import java.util.*;

public class MaxFrequency{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n]; 
        for (int i=0;i<n-1;i++){
            arr[i] = sc.nextInt();
        }

        int freq = 0;
        int ele = 0;
        for(int i=0;i<n;i++){
            int c = 1;
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    c++;
                }
            }

            if(c>freq){
                freq = c;
                ele = arr[i];
            }
        }

        System.out.println("Maximum freq is: "+freq+" of element "+ele);

    }
}
