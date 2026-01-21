package Threads;

public class Client {
    public static void main(String[] args) {

        //4. create an object
        //5. create a thread and assign the object of the class
        for(int i=0;i<100;i++)
        {
            PrintNumber pn = new PrintNumber(i);
            Thread t = new Thread(pn);
            t.start();
        }
    }
}
