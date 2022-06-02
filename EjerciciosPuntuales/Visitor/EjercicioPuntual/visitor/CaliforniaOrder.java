package visitor;

import utils.CONSTANTS;

public class CaliforniaOrder extends VOrder {
  public CaliforniaOrder() {
  }
  public CaliforniaOrder(double inp_orderAmount,
      double inp_additionalTax) {
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
    orderType = CONSTANTS.CALIFORNIA.toString();
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalTax() {
    return additionalTax;
  }
  public double accept(OrderVisitor v) {
    return v.visit(this);
  }

  @Override
  public String getOrderType() {
    return CONSTANTS.CALIFORNIA.toString();
  }
}

