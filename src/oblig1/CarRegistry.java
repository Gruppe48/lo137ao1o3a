
package oblig1;

public class CarRegistry {
  Car fCar; //First Car
  
  CarRegistry() {
    fCar = null;
  }
  
  public void RegCar (Car c) {
    if (fCar == null) {    
      fCar = c;
    }  
    else {
      Car rCar = fCar; //Runner
      while (rCar.next != null) {
        rCar = rCar.next;
      }
      rCar.next = c;
    }
      
    }
    
  
  public String PrintReg() {
    String res = "";
    Car rCar = fCar;
    
    while (rCar != null) {
      res += rCar.toString();
      rCar = rCar.next;
    }
    
    if (!res.equals("")) {
      return res;
    }
    else {
      return "Ingen biler registert";
    }
  }
  
  
  public String RemoveCar(int regNbr) {
    Car rCar = fCar;
    
    while (rCar.next != null) {
      if (rCar.next.regNbr == regNbr) {
        rCar = null;
        return "Bilen med regNr " + regNbr + " ble fjernet\n";
      }
      rCar = rCar.next;
    }
    return "Fant ikke bilen med regNr " + regNbr + " i registeret\n"; 
  }
  
  public void FindOwner(Owner owner) {
  }
  
  public void ChangeOwner() {
    
  }
  
  public void RegOwner() {
    
  }
}
