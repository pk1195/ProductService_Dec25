package Abstracts_class;

public class Client {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            public void walk() {
                System.out.println("Anonymous Animal walks");
            }
        };
        a.walk();
        a.noOflegs();
    }

}
