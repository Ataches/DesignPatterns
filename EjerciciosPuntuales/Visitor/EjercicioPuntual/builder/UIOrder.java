package builder;

import IteratorExt.Order;

import javax.swing.*;

public abstract class UIOrder {
  protected JPanel searchUI;

  public abstract void addUIControls();
  public abstract void setOrder(Order order);
  public abstract void initialize();
  public abstract Order getOrderEdited();

  public JPanel getSearchUI() {
    return searchUI;
  }
}

