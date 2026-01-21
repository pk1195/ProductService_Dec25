package Prefixsum;

public class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }

    public static class Dog extends Animal
    {
        void bark() {
            System.out.println("Dog barks");
        }
    }

    public static class Cat extends Animal
    {
        void meow() {
            System.out.println("Cat meows");
        }
    }

    static void main() {
        Dog anm = new Dog();
        anm.bark();
        anm.speak();
        Cat cat = new Cat();
        cat.meow();
        cat.speak();




    }
}
