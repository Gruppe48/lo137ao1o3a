
package oblig1;

public class Car {
  private String regNbr;  // registration number
  private String make; // Car make (Toyota, Ford, and so on)
  private String model; // Model, obviously.
  private int regyear; // First time registered.
  
  public Car (String rN, String m, String mo, int ry) {
    regNbr = rN;
    make = m;
    model = mo;
    regyear = ry;
  }
  
  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getRegyear() {
    return regyear;
  }
  
  public String getRegNr() {
    return regNbr;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setRegNbr(String regNbr) {
    this.regNbr = regNbr;
  }

  public void setRegyear(int regyear) {
    this.regyear = regyear;
  }
  
  
  @Override
  public String toString() {
    return "RegNr:" + regNbr + "\nModell:" + make + " " + model +  "\nÅr: " 
            + regyear + "\n";
  }
  
  
  
}
