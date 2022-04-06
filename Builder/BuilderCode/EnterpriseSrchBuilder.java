import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

class EnterpriseSrchBuilder extends UIBuilder {

  private JTextField txtEnterpriseName = new JTextField(15);
  private JTextField txtTaxNumber = new JTextField(15);
  private JTextField txtCountry = new JTextField(15);
  private JTextField txtAddress = new JTextField(17);

  public void addUIControls() {
    searchUI = new JPanel();
    JLabel lblEnterpriseName = new JLabel("Enterprise name:");
    JLabel lblTaxNumber = new JLabel("Tax identification number:");
    JLabel lblCountry = new JLabel("Country:");
    JLabel lblAddress = new JLabel("Address:");

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblEnterpriseName);
    searchUI.add(txtEnterpriseName);
    searchUI.add(lblTaxNumber);
    searchUI.add(txtTaxNumber);
    searchUI.add(lblCountry);
    searchUI.add(txtCountry);
    searchUI.add(lblAddress);
    searchUI.add(txtAddress);

    gbc.anchor = GridBagConstraints.WEST;

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblEnterpriseName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblTaxNumber, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(lblCountry, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gridbag.setConstraints(lblAddress, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtEnterpriseName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtTaxNumber, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(txtCountry, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(txtAddress, gbc);
  }

  public void initialize() {
    txtEnterpriseName.setText("Enter EnterpriseName Here");
    txtTaxNumber.setText("Enter TaxNumber Here");
    txtCountry.setText("Colombia");
    txtAddress.setText("Enter Address Here");
  }

  public String getSQL() {
    return ("Select * from Enterprise where EnterpriseName='" +
            txtEnterpriseName.getText() + "'" + " and TaxNumber='" +
            txtTaxNumber.getText() + "' and Country='" +
            txtCountry.getText() + "' and Address='" + txtAddress.getText()+ "'");
  }

}
