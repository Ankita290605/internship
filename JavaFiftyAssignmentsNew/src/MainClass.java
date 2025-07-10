

// 41. Create a class `Car` with fields, constructor, and method to display details

class Car {
    String brand;
    String model;
    double price;

    Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Car Model: " + model);
        System.out.println("Car Price: ₹" + price);
    }
}

public class MainClass{
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Innova", 2500000);
        myCar.displayDetails();
    }
}
