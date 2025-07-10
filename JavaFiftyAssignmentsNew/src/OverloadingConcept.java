

// 33. Impliment overloading concept

import java.util.Arrays;
import java.util.Scanner;
class Sorter{
    public void sort(int arr[]){
        Arrays.sort(arr);
    }
     public void sort(double arr[]){
        Arrays.sort(arr);
    }
    
}

public class OverloadingConcept{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,2,6,4,3};
        double brr[] = {1.1,2.2,3.3,4.4};
        Sorter ob = new Sorter();
        ob.sort(arr);
        ob.sort(brr);
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(double i:brr){
            System.out.print(i+" ");
        }
    }
}
