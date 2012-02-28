//Usikker på om denne trengs, eller om vi skal la alt være i CarRegistry. 

package oblig1;

public class CarOwnerList {
  
  private Owner fOwn;
  
  public CarOwnerList() {
    fOwn = null;
  }
  
  public void RegNewOwner(Owner owner) {
    
    if (fOwn == null) {
      fOwn = owner;
    }
    
    else {
      Owner rOwn = fOwn;
      while (rOwn.next != null) {
        rOwn = rOwn.next;
      }
      rOwn.next = owner;
    }
      
  }
  
  public void RegNewCar() {
    
  }
  
  public String PrintRegistry() {
    String res = "";
    Owner rOwn = fOwn;
    
    while (rOwn != null) {
      res += rOwn.toString() + "\n";
      rOwn = rOwn.next;
    }
    
    if (!res.equals("")) {
      return res;
    }
    
    else {
      return "Listen er tom";
    }
    
  }
  
  public boolean RemoveCar(String regNr) {
    if (fOwn == null)
      return false;
    
    Owner rOwn = fOwn;
    while(!rOwn.car.getRegNr().equals(regNr)) {
      if (rOwn.next == null)
        return false;
      rOwn = rOwn.next;
    }
    rOwn.car = null;
    return true;
  }
  
  public boolean RemoveOwner(int s) {
    if (fOwn == null)
      return false;
    
    Owner rOwn = fOwn;
    while(rOwn.next.getOwnerID() != s) {
      if (rOwn.next.next == null)
        return false;
      rOwn = rOwn.next;
    }
    if(rOwn.next.car == null) {
      rOwn.next = rOwn.next.next;
      return true;
    }
    return false;
  }
  
  public String FindOwner(String regNr) {
    if (fOwn == null)
      return "Ingen eier en bil med registreringsnummeret: " + regNr;
    
    Owner rOwn = fOwn;
    while(!rOwn.car.getRegNr().equals(regNr)) {
      if (rOwn.next == null)
        return "Ingen eier en bil med registreringsnummeret: " + regNr;
      rOwn = rOwn.next;
    }
    return rOwn.toString();
  }
  
}
