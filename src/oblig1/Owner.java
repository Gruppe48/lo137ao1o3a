
package oblig1;

public abstract class Owner {
  String name;
  String adress;
  Car car;
}

class Private extends Owner {
  int ssn; //Social Security number 
  
}

class Firm extends Owner {
  int cn; //Company number
}


