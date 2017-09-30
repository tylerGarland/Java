import java.util.Scanner;
/**
*Program to use the construcor we made for spherocylinder.
*@tylerGarland
*@version: 9/28/2017
*/

public class SpherocylinderApp {
   /**
   *@param args not used.
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      
      System.out.println("Enter label, radius, and cylinder height for a "
            + "spherocylinder.");
      System.out.print("\tlabel: ");
      String label = userInput.nextLine().trim();
      System.out.print("\tradius: ");
      double radius = userInput.nextDouble();
      if (radius < 0) {
         System.out.println("Error: radius must be non-negative.");
         return;
      }
      System.out.print("\tcylinder height: ");
      double cylinderheight = userInput.nextDouble();
      if (cylinderheight < 0) {
         System.out.println("Error: cylinder height must be non-negative.");
         return;
      }
      Spherocylinder sc = new Spherocylinder(label, radius, cylinderheight);
      System.out.println(sc.toString());
      
   
     
      
   }
 
}