import javax.swing.*;
import java.awt.*;

public class ChineseOrder extends Order {
  private double orderAmount;
  private double additionalSH;

  private JTextField txtOrderAmount, txtAdditionalSH;
  private JLabel lblOrderAmount, lblAdditionalSH;

  public void addUIControls() {
    searchUI = new JPanel();

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
  public ChineseOrder() {
  }
  public ChineseOrder(double inp_orderAmount,
                      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
}
