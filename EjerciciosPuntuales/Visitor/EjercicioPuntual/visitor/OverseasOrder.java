package visitor;

import utils.CONSTANTS;

import javax.swing.*;

public class OverseasOrder extends VOrder {

  public OverseasOrder() {
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
    orderType = CONSTANTS.OVERSEAS.toString();
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
    return CONSTANTS.OVERSEAS.toString();
  }
}
