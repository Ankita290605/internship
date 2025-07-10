

// 42. Demonstrate constructor overloading

import java.util.Scanner;
class Computor{
    String model;
    int speed;
    int price;
    int ramSize;
    Computor(){
        this("default", 0, 0, 0);
    }
    Computor(String model, int speed, int price, int ramSize){
        this.model = model;
        this.speed = speed;
        this.price = price;
        this.ramSize = ramSize;
    }
    void display(){
        System.out.println("Computor info: ");
        System.out.println("Model "+model);
        System.out.println("Speed "+speed);
        System.out.println("Price "+price);
        System.out.println("RamSize "+ramSize);
    }
}

public class ConstructorOverloading{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String model = sc.nextLine();
        int speed = sc.nextInt();
        int price = sc.nextInt();
        int ramsize = sc.nextInt();
        Computor c1 = new Computor();
        Computor c2 = new Computor(model, speed,price,ramsize);
        c1.display();
        c2.display();
    }
}
