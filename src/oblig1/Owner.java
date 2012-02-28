
package oblig1;

public abstract class Owner {
  protected String name;
  protected String adress;
  protected Car car;
  protected Owner next;
  
  public Owner(String n, String a, Car c) {
    name = n;
    adress = a;
    car = c;
  }
  
  abstract int getOwnerID();
  
  @Override
  public String toString() {
    return "Eier:\n " + "Navn: " + name + "\nAdresse: " + adress + "\n" + car.toString();
  }
}

class Private extends Owner {
  protected int ssn; //Social Security number 
  
  public Private (String n, String a, Car c, int s) {
    super (n,a,c);
    ssn = s;
  }
  
  @Override
  public int getOwnerID() {
    return ssn;
  }
  
  @Override
  public String toString() {
    return super.toString() + "Personnr: " + ssn + car.toString();
  }
  
}

class Firm extends Owner {
  protected int cnbr; //Company number
  
  public Firm (String n, String a, Car c, int cn ) {
    super (n,a,c);
    cnbr = cn;
  }
  
  public int getOwnerID() {
    return cnbr;
  }
  
  @Override
  public String toString() {
    return super.toString() + "Personnr: " + cnbr + car.toString();
    
  }
}




