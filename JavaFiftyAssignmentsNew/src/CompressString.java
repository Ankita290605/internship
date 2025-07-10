

// 18. Compress a string

import java.util.*;
public class CompressString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        System.out.println(n);
        char arr[] = s.toCharArray();
        int i=0;
        while(i<n){
            int r = 1;
            while((i<n-1) && arr[i]==arr[i+1]){
                r++;
                i++;
            }

            System.out.print(arr[i]+""+r);
            i++;
        }

    }
}

