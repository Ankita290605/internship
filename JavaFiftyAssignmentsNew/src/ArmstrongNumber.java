

// 27. Check for Armstrong number

import java.util.Scanner;
public class ArmstrongNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int m = n;
        while(n>0){
            int d = n%10;
            sum = sum+(d*d*d);
            n = n/10;
        }
       
        if(m==sum){
            System.out.println("It is Armstrong number");
        }
        else{
            System.out.println("It is not Armstrong number");
        }
    }
}
