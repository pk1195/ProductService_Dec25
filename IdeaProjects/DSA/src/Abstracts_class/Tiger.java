package Abstracts_class;

public class Tiger extends Animal{

//whn a class is extending an abstract class, it is mandatory to override all the abstract methods of the abstract class
    @Override
    public void walk() {
        System.out.println("Tiger walks");
    }

    @Override
    public void noOflegs() {
        System.out.println("Tiger has 4 legs");
    }
}
