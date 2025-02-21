
import java.util.Scanner;

public class bai1 {

   public static void main(String args[]) {
      String a, b;
      Scanner scanner = new Scanner(System.in);  
      System.out.println("Enter The value for variable a");
      a = scanner.nextLine();
      System.out.println("Enter The value for variable b");
      b = scanner.nextLine();

      System.out.println("The value you have entered for a is " + a);
      System.out.println("The value you have entered for b is " + b);
      scanner.close();
   }	   
}