

// 22. Reverse digits of an integer

import java.util.Scanner;
public class ReverseDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int reverse = 0;
        while(n>0){
            int d = n%10;
            reverse = reverse*10+d;
            n = n/10;
        }

        System.out.println(reverse);
    }
}
