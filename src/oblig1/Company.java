/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 * @studnr 180212

 * @author Even Augdal <even.augdal@gmail.com>
 * @studnr 181091
 * 
 * @author Tommy Nyrud <s180487@stud.hioa.no>
 * @studnr 180487
 * 
 * @date Feb 20, 2012
 */

package oblig1;


class Company extends AbstractOwner {
  protected int companyID; //Company number
  
  public Company (String n, String a, Vehicle c, int cn ) {
    super (n,a,c);
    companyID = cn;
  }
  
  @Override
  public int getOwnerID() {
    return companyID;
  }
  
  @Override
  public String toString() {
    String res = super.toString() + "Firma nummer: " + companyID + "\n";
    if (vehicle != null) {
      res += vehicle.toString();
    }
    return res;  
  }
}