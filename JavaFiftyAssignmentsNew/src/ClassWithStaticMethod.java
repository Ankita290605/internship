

// 48. Create a class that uses a static method and variable

class Counter {
    static int count = 0;

    static void increment() {
        count++;
        System.out.println("Count: " + count);
    }
}
public class ClassWithStaticMethod {
    public static void main(String[] args) {
        Counter.increment();
        Counter.increment();
        System.out.println("Final Count: " + Counter.count);
    }
}
