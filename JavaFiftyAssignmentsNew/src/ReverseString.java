

// 12. Reverse a string without using built-in methods

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();

        int i = 0;
        int j = ch.length - 1;
        while(i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }

        System.out.print("Reversed string: ");
        for (char c : ch) {
            System.out.print(c);
        }
    }
}
