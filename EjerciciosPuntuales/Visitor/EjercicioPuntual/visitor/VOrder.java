package visitor;

public abstract class VOrder implements Cloneable{
  String orderType;
  double orderAmount;
  double additionalTax;
  double additionalSH;

  public abstract double accept(OrderVisitor v);
  public abstract String getOrderType();

  public String toString()
  {
    return orderType+","+orderAmount+","+additionalTax+","+additionalSH;
  }

  public Object clone() {
    //shallow copy
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public double getAdditionalTax() {
    return additionalTax;
  }

  public double getAdditionalSH() {
    return additionalSH;
  }
}

