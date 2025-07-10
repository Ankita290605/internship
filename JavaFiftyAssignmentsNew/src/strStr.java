

// 16. Implement `strStr()` (index of first occurrence)

import java.util.Scanner;
public class strStr {
    public static int findIndex(String str, String target){
        int n = str.length();
        int m = target.length();
        if(m==0) return -1;
        for(int i=0;i<=n-m;i++){
            if(str.substring(i, i+m).equals(target)){
                return i;
            }  
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = sc.nextLine();
        System.out.println(findIndex(str, s));
         
    }
}
