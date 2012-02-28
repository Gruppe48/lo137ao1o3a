//Usikker på om denne trengs, eller om vi skal la alt være i CarRegistry. 

package oblig1;

public class CarOwnerList {
  
  private AbstractOwner fOwn;
  
  public CarOwnerList() {
    fOwn = null;
  }
  
  public void RegNewOwner(AbstractOwner owner) {
    
    if (fOwn == null) {
      fOwn = owner;
    }
    
    else {
      AbstractOwner rOwn = fOwn;
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
    AbstractOwner rOwn = fOwn;
    
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
    
    AbstractOwner rOwn = fOwn;
    while(!rOwn.car.getRegNr().equals(regNr)) {
      if (rOwn.next == null)
        return false;
      rOwn = rOwn.next;
    }
    rOwn.car = null;
    return true;
  }
  
  public boolean RemoveOwner(int ownerID) {
    if (fOwn == null)
      return false;
    
    AbstractOwner rOwn = fOwn;
    while(rOwn.next.getOwnerID() != ownerID) {
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
    
    AbstractOwner rOwn = fOwn;
    while(!rOwn.car.getRegNr().equals(regNr)) {
      if (rOwn.next == null)
        return "Ingen eier en bil med registreringsnummeret: " + regNr;
      rOwn = rOwn.next;
    }
    return rOwn.toString();
  }
  
}
