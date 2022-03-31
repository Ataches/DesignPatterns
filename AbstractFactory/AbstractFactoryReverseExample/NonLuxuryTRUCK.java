public class NonLuxuryTRUCK implements NonLuxury {
  private String name;
  public NonLuxuryTRUCK(String sName) {
    name = sName;
  }
  public String getNLName() {
    return name;
  }
  public String getNLFeatures() {
    return "Non-Luxury TRUCK Features ";
  };

} // End of class


