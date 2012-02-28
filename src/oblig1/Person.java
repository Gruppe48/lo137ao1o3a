/*
 */
package oblig1;


/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 * @studnr 180212
 * @date Feb 28, 2012
 */
class Person extends AbstractOwner {
  protected int ssn; //Social Security number 
  
  public Person (String n, String a, Vehicle c, int s) {
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