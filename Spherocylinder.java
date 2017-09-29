import java.text.DecimalFormat;
public class Spherocylinder {
/**
*Program to create a spherocylinder 
*/
   private String label = "";
   private double radius = 0;
   private double cylinderHeight = 0;
   
   public Spherocylinder(String label, double radius,
   double ch){
      setLabel(label);
      setRadius(radius);
      setCylinderHeight(ch);
   }
   
   void setLabel(String labelIn) {
      label = labelIn;
   }
   void setRadius(double radiusIn) {
      radius = radiusIn;
   }
   void setCylinderHeight(double chIn) {
      cylinderHeight = chIn;
   }
   String getLabel() {
      return label;
   }
   double getRadius() {
      return radius;}
      
   double getcylinderHeight() {
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
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      String string = "Spherocylinder \"" + getLabel() + "\" with radius " + fmt.format(radius)
         + " and cylinder height " + fmt.format(cylinderHeight) + " has:\n\t"
         + "circumference = " + fmt.format(circumference()) + " units\n"
         + "\tsurface area = " + fmt.format(surfaceArea()) + " square units\n"
         + "\tvolume = " + fmt.format(volume()) + " units";
   
      return string;
   }
}