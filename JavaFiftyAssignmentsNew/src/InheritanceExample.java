

// 44. Create a class hierarchy: `Animal -> Dog`, show inheritance

class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating...");
    }

    void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println(name + " is barking...");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.name = "Bruno";
        d.eat();    
        d.sleep(); 
        d.bark();   // from Dog
    }
}
