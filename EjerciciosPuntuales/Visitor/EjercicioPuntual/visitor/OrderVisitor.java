package visitor;

import java.util.*;

public class OrderVisitor implements VisitorInterface {
  private Vector orderObjList;

  public OrderVisitor() {
    orderObjList = new Vector();
  }
  public double visit(NonCaliforniaOrder inp_order) {
    return inp_order.getOrderAmount();
  }
  public double visit(CaliforniaOrder inp_order) {
    return inp_order.getOrderAmount() + inp_order.getAdditionalTax();
  }
  public double visit(OverseasOrder inp_order) {
    return inp_order.getOrderAmount() + inp_order.getAdditionalSH();
  }

  public double visit(ChineseOrder inp_order) {
    return inp_order.getOrderAmount() + inp_order.getAdditionalSH();
  }

  public void addOrderToVector(VOrder order){
    orderObjList.addElement(order);
  }

  public Vector getOrderObjList() {
    return orderObjList;
  }
}
