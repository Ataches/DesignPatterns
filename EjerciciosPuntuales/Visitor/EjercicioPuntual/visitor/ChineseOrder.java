package visitor;

import utils.CONSTANTS;

public class ChineseOrder extends VOrder {

  public ChineseOrder() {
  }
  public ChineseOrder(double inp_orderAmount,
                      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
    orderType = CONSTANTS.CHINESE.toString();
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public double accept(OrderVisitor v) {
    return v.visit(this);
  }

  @Override
  public String getOrderType() {
    return CONSTANTS.CHINESE.toString();
  }
}
