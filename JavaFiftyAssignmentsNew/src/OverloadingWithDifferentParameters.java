

// 43. Demonstrate method overloading with different parameters

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class OverloadingWithDifferentParameters {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Sum of 10 + 20 = " + calc.add(10, 20));
        System.out.println("Sum of 1 + 2 + 3 = " + calc.add(1, 2, 3));
        System.out.println("Sum of 5.5 + 2.3 = " + calc.add(5.5, 2.3));
    }
}
