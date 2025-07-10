

// 21. Count number of words in a sentence

import java.util.Scanner;
public class CountWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = str.split("\\s").length;
        System.out.println(count);
    }
}
