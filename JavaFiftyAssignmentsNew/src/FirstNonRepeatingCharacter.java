

// 15. Find the first non-repeating character

import java.util.*;
public class FirstNonRepeatingCharacter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] freq = new int[256];

        for(int i=0;i<str.length();i++) {
            freq[str.charAt(i)]++;
        }

        boolean found = false;
        for (int i=0;i<str.length();i++) {
            if(freq[str.charAt(i)]==1){
                System.out.println("First non-repeating character: "+str.charAt(i));
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("No non-repeating character found.");
        }
    }
}
