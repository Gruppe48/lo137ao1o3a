
package oblig1;

public class Car {
  int regNbr; 
  String make;
  int regyear;
  Owner owner;
  Car next;
  
  public Car (int rN, String m, int ry) {
    regNbr = rN;
    make = m;
    regyear = ry;
  }

  @Override
  public String toString() {
    return "RegNr:" + regNbr + "\nModell:" + make + "\nÅr: " 
            + regyear + "\nEier: " + owner + "\n";
  }
  
  
  
}
