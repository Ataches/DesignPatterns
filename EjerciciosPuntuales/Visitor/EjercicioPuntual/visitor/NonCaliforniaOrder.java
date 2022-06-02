package visitor;

import utils.CONSTANTS;

public class NonCaliforniaOrder extends VOrder {

  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
    orderType = CONSTANTS.NON_CALIFORNIA.toString();
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double accept(OrderVisitor v) {
    return v.visit(this);
  }

  @Override
  public String getOrderType() {
    return CONSTANTS.NON_CALIFORNIA.toString();
  }
}
