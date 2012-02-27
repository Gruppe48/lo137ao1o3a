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
  
  public void RemoveCar() {
    
  }
  
  public void RemoveOwner() {
    
  }
  
  public void FindOwner() {
    
  }
  
}
