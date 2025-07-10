

// 47. Demonstrate `this` keyword in constructor

class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name; 
        this.age = age;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class  ThisWithConstructor{
    public static void main(String[] args) {
        Student s1 = new Student("Ankita", 20);
        s1.display();
    }
}
