

// 26. Find GCD and LCM

import java.util.Scanner;
public class GCDandLCM{

    public static int findGcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int gcd = findGcd(n, m);
        int lcm = (n*m)/gcd;

        System.out.println("GCD: "+gcd);
        System.out.println("LCM: "+lcm);

        
    }
}
