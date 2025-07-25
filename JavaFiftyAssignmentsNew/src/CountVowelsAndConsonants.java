

// 14. Count vowels and consonants

import java.util.*;

public class CountVowelsAndConsonants{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        int vowels = 0;
        int consonants = 0;

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch>='a' && ch<='z') {
                if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    vowels++;
                } 
                else{
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
