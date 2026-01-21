package staticc_keyword;

public class Animal {
    
   public int notStatic = 10;
   public static int variable = 20;

   public static String printSomething()
   {
       System.out.println("Static method called");
       System.out.println(variable);
     //  System.out.println(notStatic);
       return "Hello from static method";
   }
}
