

// 28. Generate Fibonacci series up to N terms

import java.util.Scanner;
public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = 0;
        int second = 1;
        if(n>=1){
            System.out.print(first+" ");
        }
        if(n>=2){
            System.out.print(second+" ");
        }
        for(int i=2;i<n;i++){
            int next = first+second;
            System.out.print(next+" ");

            first = second;
            second = next;
        }
    }
}
