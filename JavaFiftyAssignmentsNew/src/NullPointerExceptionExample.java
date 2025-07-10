
// 50. Handle `NullPointerException`

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null; 

        try {
            System.out.println(str.length());
        } 
        catch (NullPointerException e) {
            System.out.println("Error: Null reference, cannot call methods on null");
        }
        System.out.println("Program continues...");
    }
}