package Recursion;

public class printName {
    public void printMyName(int n,String name,int count){
        //base case
        if(count==n)
            return;
        System.out.println(name);
        printMyName(n,name,count+1);
    }

    public static void main(String[] args) {
        printName pn = new printName();
      //  int n = 3;
        pn.printMyName(5,"Pooja",0);
    }
}
