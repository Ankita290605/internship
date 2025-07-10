

// 32. Find all prime numbers in a range

import java.util.Scanner;

public class FindPrimeNumbers {

    public static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
}
