

// 17. Remove all duplicate characters from a string

import java.util.*;
public class RemoveDuplicates{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s = sc.nextLine();
        int n = s.length();
        char arr[] = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        sb.append(arr[0]);
        
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
                sb.append(arr[i]);
            }
        }

        System.out.println(sb.toString());
        
    }
}
