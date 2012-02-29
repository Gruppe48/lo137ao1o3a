//Usikker på om denne trengs, eller om vi skal la alt være i CarRegistry. 

package oblig1;


public class OwnerList {
  
  private AbstractOwner first;
  
  public OwnerList() {
    first = null;
  }
  
  // Double linked list. Not that we use it though, really.
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
  
  public boolean registerVehicle(int ownerID, Vehicle vehicle) {
    AbstractOwner owner = find(ownerID);
    if (owner != null && vehicle != null) {
      // Owner by that name exists and we have a non-null vehicle.
      if (owner.vehicle == null) {
        owner.vehicle = vehicle;
        return true;
      }
      else {
        // already owns a vehicle.
        return false;
      }
    }
    return false;
  }
  
  public String printRegistry() {
    String result = "";
    AbstractOwner current = first;
    
    while (current != null) {
      result += current.toString() + "\n";
      current = current.next;
    }
    
    if (!result.equals("")) {
      return result;
    }
    
    else {
      return "Listen er tom";
    }
    
  }
  
  public boolean removeVehicle(String regNr) {
    if (first == null)
      return false;
    
    AbstractOwner current = first;
    while(!current.vehicle.getRegNr().equals(regNr)) {
      if (current.next == null)
        return false;
      current = current.next;
    }
    current.vehicle = null;
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
    if(current.next.vehicle == null) {
      current.next = current.next.next;
      return true;
    }
    return false;
  }
  
  public String findOwner(String regNr) {
    if (first == null)
      return "Registeret er tomt.";
    
    AbstractOwner current = first;
    while(!current.vehicle.getRegNr().equals(regNr)) {
      if (current.next == null)
        return "Ingen eier en bil med registreringsnummeret: " + regNr;
      current = current.next;
    }
    return current.toString();
  }
  public AbstractOwner getOwner(String regNr) {
    if (first == null)
      return null;
    
    AbstractOwner current = first;
    while(!current.vehicle.getRegNr().equals(regNr)) {
      if (current.next == null)
        return null;
      current = current.next;
    }
    return current;
  }

  private AbstractOwner find(int ownerID) {
    if (first == null)
      return null;
    
    AbstractOwner current = first;
    while(current.getOwnerID() != ownerID) {
      if (current.next == null)
        return null;
      current = current.next;
    }
    return current;
  }
  
  public boolean changeOwner(String regNumber, int ownerID) {
    AbstractOwner owner = getOwner(regNumber);
    if (owner != null) {
      // The vehicle has a owner.
      AbstractOwner newOwner = find(ownerID);
      if (newOwner != null) {
        // The new owner also exists
        if (newOwner.vehicle == null) {
          newOwner.vehicle = owner.vehicle;
        }
        else {
          // He already owns a vehicle
          return false;
        }
      }
    }
    // The owner is null or the new owner is null.
    return false;
  }
  
}
