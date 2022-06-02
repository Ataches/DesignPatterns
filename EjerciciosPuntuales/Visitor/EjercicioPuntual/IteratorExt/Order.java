package IteratorExt;

public class Order implements Cloneable {
  private String orderType;
  private double orderAmount;
  private double additionalTax;
  private double additionalSH;

  public Order(String inp_orderType, double inp_orderAmount,
               double inp_additionalTax, double inp_additionalSH) {
    orderType = inp_orderType;
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
    additionalSH = inp_additionalSH;
  }
  public String getOrderType() {
    return orderType;
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

  public void setOrderAmount(double orderAmount) {
    this.orderAmount = orderAmount;
  }

  public void setAdditionalTax(double additionalTax) {
    this.additionalTax = additionalTax;
  }

  public void setAdditionalSH(double additionalSH) {
    this.additionalSH = additionalSH;
  }

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
}
