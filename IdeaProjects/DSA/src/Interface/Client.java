package Interface;

public class Client {
    public static void main(String[] args) {
       // Dog dog = new Dog();
        Animal dog = new Dog(); //upcasting
        dog.walk();
        dog.eat();
        dog.run();

        Cat cat = new Cat();
        cat.walk();
        cat.eat();
        cat.run();
    }
}
