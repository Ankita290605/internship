

// 4. Find the majority element (> n/2 times)

import java.util.*;
public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int freq = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(ans==0){
                ans = arr[i];
            }
            if(arr[i]==ans){
                freq++;
            }
            else{
                freq--;
            }
        }

        System.out.println(ans);
    }
}
