
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
  
}
