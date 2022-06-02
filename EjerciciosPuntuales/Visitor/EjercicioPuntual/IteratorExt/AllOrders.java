package IteratorExt;

import utils.FileUtil;
import visitor.OrderVisitor;
import visitor.VOrder;
import visitor.VOrderFactory;

import java.util.*;

public class AllOrders {
  private Vector data;
  private OrderVisitor orderVisitor;
  private static final FileUtil util = new FileUtil();
  private static final AllOrders allOrders = new AllOrders();

  public void createNewOrders(Vector orderObjList) {
    data.addAll(orderObjList);
    saveOrders();
  }
  public void setOrderVisitor(OrderVisitor orderVisitor) {
    this.orderVisitor = orderVisitor;
  }
  private AllOrders() {
    initialize();
  }

  public static AllOrders getInstance() {
    return allOrders;
  }

  private void initialize() {
    /*
      Get data from db.
     */
    data = new Vector();

    Vector dataLines = util.fileToVector("Orders.txt");
    for (int i = 0; i < dataLines.size(); i++) {
      String str = (String) dataLines.elementAt(i);
      StringTokenizer st = new StringTokenizer(str, ",");
      VOrderFactory vOrderFactory = VOrderFactory.getInstance();
      data.add(
              vOrderFactory.createOrder(st.nextToken(), Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
    }
  }

  public Enumeration getAllOrders() {
    return data.elements();
  }
  public void deleteOrder(VOrder order) {
    data.removeIf(o -> (Objects.equals(o.toString(), order.toString())));
  }
  public void editOrder(VOrder order, VOrder editedOrder) {
    data.removeIf(o -> (Objects.equals(o.toString(), order.toString())));
    data.addElement(editedOrder);
  }
  public Iterator getOrders(String type) {
    return new OrderIterator(this, type);
  }
  public void saveOrders(){
    util.deleteFile("Orders.txt");
    util.vectorToFile(data, "Orders.txt");
  }
  public double getOrderTotal(){
    return data.stream()
            .mapToDouble(order -> {
              VOrder vOrder = (VOrder) order;
              return vOrder.accept(orderVisitor);
            }).sum();
  }
}


