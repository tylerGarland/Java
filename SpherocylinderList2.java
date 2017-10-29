import java.io.File;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
*Project 5.
*@author: Tyler Garalnd
*@version:  10/11/17
* Program to make a list of spherocylinders.
*/
public class SpherocylinderList2 {
   private String listName;
   private Spherocylinder[] Sphero = new Spherocylinder[...]
   private int elements;
   
/**
* Constructor for the SpherocylinderList
*makes listName and aList equal to listNameIn and aListin.
@param listNameIn equals listName.
@param aListIn equals aList.
*/
   public SpherocylinderList2(String listNameIn,
      ArrayList<Spherocylinder> aListIn, int elementsIn) {
      listName = listNameIn;
      aList = aListIn;
   }
   /**
   *@return listName.
   */
   public String getName() {
      return listName;
   }
   /**
   *Sets an if else statment so that if the array list size is zero
   * it will @return 0.
   *or it will return the size of the array list.
   */
   public int numberOfSpherocylinders() {
      if (aList.size() == 0) { 
         return 0; }
      else {
         return aList.size();
      }
   }

   /**
    * Returns 0 if the arraylist size is zero.
    * Takes the total surface area of all spherocylinderes and totals them.
    * @return the total of all the spherocylinders.
    */
   public double totalSurfaceArea() {
      int i = 0;
      double total = 0;
      if (aList.size() == 0) {
         return 0;
      } 
      while (i < aList.size()) { 
         double temp = aList.get(i).surfaceArea();
         total = total + temp;    //total += temp;
         i++;
      
         
      }
      return total;
   }

   /**
    * Takes the volume of all the spherocylinders and add them together.
    * returns 0 if there are no spherocylinders.
    * @return the total volume of all the spheroclyinders.
    */
   public double totalVolume() {
      int i = 0;
      double total = 0;
      if (aList.size() == 0) {
         return 0;
      }
      while (i < aList.size()) {
         double temp = aList.get(i).volume();
         total = total + temp;
         i++;
      }
      return total;
   }

   /**
    * Gets the average surface area of all the spherocylionders.
    * Returns 0 if there are no spherocylinders.
    * @return the average surface area of all the spheroclyinders.
    */
   public double averageSurfaceArea() {
      double avgSa;
      if (aList.size() == 0) {
         return 0;
      }
      avgSa = totalSurfaceArea() / aList.size();
      return avgSa;  
      
   }

   /**
    * Returns 0 if there are no spherocylinders.
    * @return the average volume for all the spherocylinders.
    */
   public double averageVolume() {
      double avgVolume;
      if (aList.size() == 0) {
         return 0;
      }
      avgVolume = totalVolume() / aList.size();
      return avgVolume;
   }

   /**
    *
    * @return the output of the toString method.
    */
   public String toString() {
      int i = 0;
      String output = "";
      output += listName;
      while (i < aList.size()) {
         output += "\n" 
                + aList.get(i).toString();
         i++;
      }
      return output;
   }

   /**
    * Returns all of the summary info for the inputed spherocylinders.
    * @return summaryInfo
    */
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return "----- Summary for " + listName + " -----"
              + "\nNumber of Spherocylinders: " 
              + fmt.format(numberOfSpherocylinders())
              + "\nTotal Surface Area: " + fmt.format(totalSurfaceArea())
              + "\nTotal Volume: " + fmt.format(totalVolume())
              + "\nAverage Surface Area: " + fmt.format(averageSurfaceArea())
              + "\nAverage Volume: " + fmt.format(averageVolume());
   }
/**
*@return aList.
*/
   public ArrayList<Spherocylinder> getList() {
      return aList;
   }

   /**
    *
    * @param file reads in a string tht is a file.
    * @return a list called sList.
    */
   public static SpherocylinderList readFile(String file) {
      SpherocylinderList sList = null;
      ArrayList<Spherocylinder> list = new ArrayList<Spherocylinder>();
      try {
         Scanner v = new Scanner(new File(file));
         String listName = v.nextLine();
         while (v.hasNext()) {
            String name = v.nextLine();
            double radius = Double.parseDouble(v.nextLine());
            double cylinder = Double.parseDouble(v.nextLine());
            Spherocylinder sc = new Spherocylinder(name, radius, cylinder);
            list.add(sc);
         }
         sList = new SpherocylinderList(listName, list);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return sList;
   }

   /**
    * method to add a spherocylinder.
    * @param label reads in a string called label when you add a Spherocylinder.
    * @param radius reads in a double called radius when you add a
    * Spherocylinder.
    * @param height reads in a double for the cylinderheight.
    */
   public void addSpherocylinder(String label, double radius, double height) {
      this.aList.add(new Spherocylinder(label, radius, height));
   }

   /**
    * method to find a spherocylinder.
    * @param label takes in a label for the name of the spherocylinder.
    * @return 1 or null
    */
   public Spherocylinder findSpherocylinder(String label) {
      for (Spherocylinder l : aList) {
         if (l.getLabel().equalsIgnoreCase(label)) {
            return l; 
         }
      }
      return null;
   }

   /**
    * method to to delete Spherocylinder.
    * @param label returns a String called label.
    * @return found returns Spherocylinder that we found.
    */
   public Spherocylinder deleteSpherocylinder(String label) {
      Spherocylinder found = findSpherocylinder(label);
      aList.remove(found);
      return found;
   }
/**
*@param label string that takes in label value
*@param radius takes in a double value for radius
*@param height takes in a cylinder height value.
@return boolean value.
*/
   public boolean editSpherocylinder(String label, 
      double radius, double height) {
      Spherocylinder found = findSpherocylinder(label);
      if (found != null) {
         found.setLabel(label);
         found.setRadius(radius);
         found.setCylinderHeight(height);
         return true;
      }
      return false;
   }

}