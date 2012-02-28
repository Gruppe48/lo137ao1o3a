
package oblig1;

public abstract class AbstractOwner {
  protected String name;
  protected String address;
  protected Vehicle car;
  protected AbstractOwner next;
  protected AbstractOwner previous;
  
  public AbstractOwner(String n, String a, Vehicle c) {
    name = n;
    address = a;
    car = c;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Vehicle getCar() {
    return car;
  }

  public void setCar(Vehicle car) {
    this.car = car;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AbstractOwner getNext() {
    return next;
  }

  public void setNext(AbstractOwner next) {
    this.next = next;
  }
  
  public AbstractOwner getPrevious() {
    return previous;
  }

  public void setPrevious(AbstractOwner previousOwner) {
    this.previous = previousOwner;
  }
  
  abstract int getOwnerID();
  
  @Override
  public String toString() {
    return "Eier:\n " + "Navn: " + name + "\nAdresse: " + address + "\n" + car.toString();
  }
}






