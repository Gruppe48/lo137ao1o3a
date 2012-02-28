
package oblig1;

public class Car {
  private String regNbr; 
  private String make;
  private String model;
  private int regyear;
  
  public Car (String rN, String m, String mo, int ry) {
    regNbr = rN;
    make = m;
    model = mo;
    regyear = ry;
  }
  
  public String getRegNr() {
    return regNbr;
  }
  
  @Override
  public String toString() {
    return "RegNr:" + regNbr + "\nModell:" + make + " " + model +  "\nÅr: " 
            + regyear + "\n";
  }
  
  
  
}
