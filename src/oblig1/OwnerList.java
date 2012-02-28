//Usikker på om denne trengs, eller om vi skal la alt være i CarRegistry. 

package oblig1;


public class OwnerList {
  
  private AbstractOwner first;
  
  public OwnerList() {
    first = null;
  }
  
  public void addOwner(AbstractOwner owner) {
    
    if (first == null) {
      first = owner;
    }
    
    else {
      AbstractOwner current = first;
      while (current.next != null) {
        current = current.next;
      }
      current.next = owner;
      current.next.previous = current;     
    }
      
  }
  
  public void registerVehicle(String ownerName, Vehicle vehicle) {
    AbstractOwner owner = find(ownerName);
    if (owner != null) {
      
    }
  }
  
  public String printRegistry() {
    String res = "";
    AbstractOwner rOwn = first;
    
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
  
  public boolean removeVehicle(String regNr) {
    if (first == null)
      return false;
    
    AbstractOwner current = first;
    while(!current.car.getRegNr().equals(regNr)) {
      if (current.next == null)
        return false;
      current = current.next;
    }
    current.car = null;
    return true;
  }
  
  public boolean removeOwner(int ownerID) {
    if (first == null)
      return false;
    
    AbstractOwner current = first;
    while(current.next.getOwnerID() != ownerID) {
      if (current.next.next == null)
        return false;
      current = current.next;
    }
    if(current.next.car == null) {
      current.next = current.next.next;
      return true;
    }
    return false;
  }
  
  public String findOwner(String regNr) {
    if (first == null)
      return "Registeret er tomt.";
    
    AbstractOwner current = first;
    while(!current.car.getRegNr().equals(regNr)) {
      if (current.next == null)
        return "Ingen eier en bil med registreringsnummeret: " + regNr;
      current = current.next;
    }
    return current.toString();
  }

  private AbstractOwner find(String ownerName) {
    if (first == null)
      return null;
    
    AbstractOwner current = first;
    while(!current.getName().equals(ownerName)) {
      if (current.next == null)
        return null;
      current = current.next;
    }
    return current;
  }
  
}
