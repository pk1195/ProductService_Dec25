package Threads;

//sop -
// 1. Think what tasks can be done in parallel
//2. create a class for task
//3. implement Runnable interface
public class PrintNumber implements Runnable{

        private int number;

    public PrintNumber(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println("We are printing " +this.number+ " the number");
    }
}
