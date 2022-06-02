package builder;

import IteratorExt.Order;

import javax.swing.*;
import java.awt.*;

public class NonCaliforniaOrder extends UIOrder {
  private JTextField txtOrderAmount;
  private JLabel lblOrderAmount;
  private Order order;

  public void addUIControls() {
    searchUI = new JPanel();

    txtOrderAmount = new JTextField(10);
    lblOrderAmount = new JLabel("Order Amount:");

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblOrderAmount);
    searchUI.add(txtOrderAmount);

    gbc.anchor = GridBagConstraints.WEST;

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderAmount, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtOrderAmount, gbc);
  }
  @Override
  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public void initialize() {
    txtOrderAmount.setText(""+order.getOrderAmount());
  }

  @Override
  public Order getOrderEdited() {
    Order orderEdited;
    orderEdited = (Order) order.clone();
    orderEdited.setOrderAmount(Double.parseDouble(txtOrderAmount.getText()));
    return orderEdited;
  }

  public NonCaliforniaOrder() {
  }
}
