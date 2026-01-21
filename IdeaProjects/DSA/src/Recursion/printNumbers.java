package Recursion;

public class printNumbers {
    public void printNum(int n,int current) {

        //base case
        if (current == n)
            return;
        System.out.println(n);

        //recursive call
        printNum(n, current + 1);
    }
        public static void main(String[] args) {
            printNumbers pn = new printNumbers();
            pn.printNum(5,0);
        }
    }

