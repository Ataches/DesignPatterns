package builder;

import IteratorExt.Order;

public class OrderDirector {
  private UIOrder builder;

  public OrderDirector(UIOrder bldr) {
    builder = bldr;
  }
  public void build(Order order) {
    builder.addUIControls();
    builder.setOrder(order);
    builder.initialize();
  }
  public Order getOrderEdited(){
    return builder.getOrderEdited();
  }
}

