
package oblig1;

public abstract class AbstractOwner {
  protected String name;
  protected String address;
  protected Vehicle car;
  protected AbstractOwner next; // TODO: WTF IS THIS FOR?
  
  public AbstractOwner(String n, String a, Vehicle c) {
    name = n;
    address = a;
    car = c;
  }
  
  abstract int getOwnerID();
  
  @Override
  public String toString() {
    return "Eier:\n " + "Navn: " + name + "\nAdresse: " + address + "\n" + car.toString();
  }
}






