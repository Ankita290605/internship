

// 20. Convert lowercase string to uppercase manually

import java.util.Scanner;

public class LowerToUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        char arr[] = str.toCharArray();
        for(int i=0;i<n;i++){
            char c = arr[i];
            arr[i] = (char) (c - 32); 
            System.out.print(arr[i]);
        }
    }
}
