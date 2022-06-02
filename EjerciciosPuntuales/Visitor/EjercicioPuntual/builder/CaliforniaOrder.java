package builder;

import IteratorExt.Order;

import javax.swing.*;
import java.awt.*;

public class CaliforniaOrder extends UIOrder {

  private Order order;
  private JTextField txtOrderAmount, txtAdditionalTax;
  private JLabel lblOrderAmount, lblAdditionalTax;

  public void addUIControls() {
    searchUI = new JPanel();

    txtOrderAmount = new JTextField(10);
    txtAdditionalTax = new JTextField(10);
    lblOrderAmount = new JLabel("Order Amount:");
    lblAdditionalTax =
            new JLabel("Additional Tax:");

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblOrderAmount);
    searchUI.add(txtOrderAmount);
    searchUI.add(lblAdditionalTax);
    searchUI.add(txtAdditionalTax);

    gbc.anchor = GridBagConstraints.WEST;

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderAmount, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblAdditionalTax, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtOrderAmount, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtAdditionalTax, gbc);
  }

  @Override
  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public void initialize() {
    txtOrderAmount.setText(""+order.getOrderAmount());
    txtAdditionalTax.setText(""+order.getAdditionalTax());
  }

  @Override
  public Order getOrderEdited() {
    Order orderEdited;
    orderEdited = (Order) order.clone();
    orderEdited.setOrderAmount(Double.parseDouble(txtOrderAmount.getText()));
    orderEdited.setAdditionalTax(Double.parseDouble(txtAdditionalTax.getText()));
    return orderEdited;
  }

  public CaliforniaOrder() {
  }
}

