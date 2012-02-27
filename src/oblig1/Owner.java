
package oblig1;

public abstract class Owner {
  String name;
  String adress;
  Car car;
  Owner next;
  
  public Owner(String n, String a, Car c) {
    name = n;
    adress = a;
    car = c;
  }
}

class Private extends Owner {
  int ssn; //Social Security number 
  
  public Private (String n, String a, Car c, int s) {
    super (n,a,c);
    ssn = s;
  }
  
}

class Firm extends Owner {
  int cnbr; //Company number
  
  public Firm (String n, String a, Car c, int cn ) {
    super (n,a,c);
    cnbr = cn;
  }
}




