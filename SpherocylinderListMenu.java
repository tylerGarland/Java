import java.util.Scanner;
/**
 * A program to create a list menu to read and create a spherocylinder list, 
 *to print a 
 * spherocylinder list to Print summary info of a spheroyclinder list, to add a 
 *spherocylinder to list, to delete a spherocylinder from the list, to Find a 
 *spherocylinder in the list, to edit a spherocylidner in the list,
 * to quit out of the spherocylidner list.
 * @author: Tyler Garland
 * @version: 10/19/17
 */
public class SpherocylinderListMenu2 {
/**
*prints out our menu.
*@param args Standard arguments used.
*/

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Spherocylinder List System Menu");
      System.out.println("R - Read File and Create Spherocylinder List");
      System.out.println("P - Print Spherocylinder List");
      System.out.println("S - Print Summary");
      System.out.println("A - Add Spherocylinder");
      System.out.println("D - Delete Spherocylinder");
      System.out.println("F - Find Spherocylinder");
      System.out.println("E - Edit Spherocylinder");
      System.out.println("Q - Quit");
      System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
      boolean running = true;
      SpherocylinderList list = null;
      while (running) {
         String input = in.next().toUpperCase();
         switch(input) {
            case "R":
               System.out.print("\tFile name: ");
               String fileName = in.next();
               list = SpherocylinderList.readFile(fileName);
               if (list != null) {
                  System.out.println("File read in and" 
                     + " Spherocylinder list Created");
                  System.out.print("Enter Code [R, P, S, A, D, F, E or Q]: ");
               
               }
               else {
                  System.out.println("\t Could not read ");
               }
               break;
            case "P":
               if (list != null) {
                  System.out.println(list);
                  System.out.println("File read in and"
                     + " Spherocylinder list Created");
                  System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
               }
               break;
            case "S":
               if (list != null) {
                  System.out.println(list.summaryInfo());
                  System.out.print("Enter code [R, P, S, A, D, F, E, or Q]: ");
               }
               break;
            case "A":
               if (list != null) {
                  System.out.print("\tLabel: ");
                  String label = in.next();
                  System.out.print("\tRadius: ");
                  double radius = Double.parseDouble(in.next());
                  System.out.print("\tCyclinder Height: ");
                  double cylinderHeight = Double.parseDouble(in.next());
                  list.addSpherocylinder(label, radius, cylinderHeight);
                  System.out.print("\t *** Spherocylinder added ***\n");
                  System.out.println("\tFile read in and Spherocylinder"
                     + "list Created");
                  System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
               } else {
                  System.out.println("\tList not created yet.");
                  System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
               }
               break;
            case "D":
               if (list != null) {
                  System.out.print("\tLabel : ");
                  String label = in.next();
                  Spherocylinder deleted = list.deleteSpherocylinder(label);
                  if (deleted != null) {
                     System.out.println("\t\"" + label 
                        + "\" successfully deleted");
                     System.out.print("Enter Code [R, P, S, A,"
                        + " D, F, E, or Q]: ");
                  }
                  else {
                     System.out.println("\t\"label\" not found");
                     System.out.print("Enter Code [R, P, S, A, D,"
                        + " F, E, or Q]: ");
                  }
               }
            
               break;
            case "F":
               if (list != null) {
                  System.out.print("\tLabel : ");
                  String label = in.next();
                  Spherocylinder cylinder = list.findSpherocylinder(label);
                  if (cylinder != null) {
                     System.out.println(cylinder);
                  } else {
                     System.out.println("\t\" " + label + " \"" 
                        + "not found\n");
                  }
                  System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
                  break;
               }
            case "E":
               if (list != null) {
                  System.out.print("\tLabel: ");
                  String label = in.next();
                  System.out.print("\tRadius: ");
                  double radius = Double.parseDouble(in.next());
                  System.out.print("\tCyclinder Height: ");
                  double cylinderHeight = Double.parseDouble(in.next());
                  list.editSpherocylinder(label, radius, cylinderHeight);
                  System.out.println("\t" + label + " edited ");
                  System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
               }
               break;
            case "Q":
               running = false;
               break;
            default:
               System.out.println("\t*** invalid code***");
               break;
         }
      }
   }

}
