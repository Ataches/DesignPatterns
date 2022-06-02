package builder;

import IteratorExt.Order;

import javax.swing.*;
import java.awt.*;

public class ChineseOrder extends UIOrder {
  private JTextField txtOrderAmount, txtAdditionalSH;
  private JLabel lblOrderAmount, lblAdditionalSH;
  private Order order;

  public void addUIControls() {
    searchUI = new JPanel();

    txtOrderAmount = new JTextField(10);
    txtAdditionalSH = new JTextField(10);
    lblOrderAmount = new JLabel("Order Amount:");
    lblAdditionalSH =
            new JLabel("Additional S & H:");

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblOrderAmount);
    searchUI.add(txtOrderAmount);
    searchUI.add(lblAdditionalSH);
    searchUI.add(txtAdditionalSH);

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
    gridbag.setConstraints(lblAdditionalSH, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtOrderAmount, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtAdditionalSH, gbc);
  }
  @Override
  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public void initialize() {
    txtOrderAmount.setText(""+order.getOrderAmount());
    txtAdditionalSH.setText(""+order.getAdditionalSH());
  }

  @Override
  public Order getOrderEdited() {

    Order orderEdited;
    orderEdited = (Order) order.clone();
    orderEdited.setOrderAmount(Double.parseDouble(txtOrderAmount.getText()));
    orderEdited.setAdditionalSH(Double.parseDouble(txtAdditionalSH.getText()));
    return orderEdited;
  }

  public ChineseOrder() {
  }
}
