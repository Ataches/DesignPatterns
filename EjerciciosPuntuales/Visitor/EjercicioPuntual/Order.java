import javax.swing.*;

public abstract class Order {
  protected JPanel searchUI;

  public abstract void addUIControls();
  public abstract void accept(OrderVisitor v);

  public JPanel getSearchUI() {
    return searchUI;
  }
}

