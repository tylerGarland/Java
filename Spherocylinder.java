import java.text.DecimalFormat;
/** To set up a constructor.
*To set up a
 */
public class Spherocylinder {
/**
*Program to create a spherocylinder constructor.
*/
   private String label = "";
   private double radius = 0;
   private double cylinderHeight = 0;
   /**
   *Calls on label, radius, ch.
   @param labelin label of the spherocylinder.
   @param radiusin radius for spherocylinder.
   @param ch cylinderheight for spherocylinder.
   */
   public Spherocylinder(String labelin, double radiusin,
      double ch) {
      setLabel(labelin);
      setRadius(radiusin);
      setCylinderHeight(ch);
   }
   /**
   *Gives value to label.
   */
   boolean setLabel(String labelIn) {
      if (labelIn != labelIn.trim()) {
         return false;
      }
   
      label = labelIn;
      
      return true;
   }
   /**
   *Makes it where radius has a value and if its less
   *than 0 it returns false.
   */
   boolean setRadius(double radiusIn) {
      if (radiusIn < 0) {
         return false;
      }
      radius = radiusIn;
      return true;
   }
   /**
   *Makes it where ch has a value and if it less than 0
   *then it returns false.
   */
   boolean setCylinderHeight(double chIn) {
      if (chIn < 0) {
         return false;
      }
      cylinderHeight = chIn;
      return true;
   }
   /**
   *Gives label a return value.
   */
   String getLabel() {
      return label;
   }
   double getRadius() {
      return radius; }
      
   double getCylinderHeight() {
      return cylinderHeight;
    
   }
   double circumference() {
      return 2 * Math.PI * radius;
   }
   double surfaceArea() { 
      return circumference() * (2 * radius + cylinderHeight);
   
   }
   double volume() {
      return Math.PI * radius * radius * (4.0 / 3.0 * radius + cylinderHeight);
   }
   /**
   *Setups the string to be used in the app.
   *@return string that is setup.
   */
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      String string = "Spherocylinder \"" + getLabel() + "\" with radius " 
         + fmt.format(radius)
         + " and cylinder height " + fmt.format(cylinderHeight) + " has:\n\t"
         + "circumference = " + fmt.format(circumference()) + " units\n"
         + "\tsurface area = " + fmt.format(surfaceArea()) + " square units\n"
         + "\tvolume = " + fmt.format(volume()) + " units";
   
      return string;
   }
}