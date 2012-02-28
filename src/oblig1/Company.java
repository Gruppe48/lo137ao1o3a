/*
 */
package oblig1;

/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 * @studnr 180212
 * @date Feb 28, 2012
 */
class Company extends AbstractOwner {
  protected int cnbr; //Company number
  
  public Company (String n, String a, Vehicle c, int cn ) {
    super (n,a,c);
    cnbr = cn;
  }
  
  @Override
  public int getOwnerID() {
    return cnbr;
  }
  
  @Override
  public String toString() {
    return super.toString() + "CompanyID: " + cnbr + car.toString();
    
  }
}