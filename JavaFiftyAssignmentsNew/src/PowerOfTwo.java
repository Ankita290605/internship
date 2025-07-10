

// 24. Check if a number is a power of 2

import java.util.Scanner;
public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        if(n>0 && ((n & n-1)==0)){
            flag = true;
        }

        if(flag){
            System.out.println("Ys it is a number power of 2");
        }
        else{
            System.out.println("No it is not a number power of 2");
        }
    }
}
