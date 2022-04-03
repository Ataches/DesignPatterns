import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

class EnterpriseSrchBuilder extends UIBuilder {

  private JTextField txtEnterpriseName = new JTextField(15);
  private JTextField txtTaxNumber = new JTextField(15);
  private JTextField txtCountry = new JTextField(40);
  private JTextField txtAddress = new JTextField(60);

  public void addUIControls() {
    searchUI = new JPanel();
    JLabel lblUserName = new JLabel("Name :");
    JLabel lblCity = new JLabel("City:");
    JLabel lblRenewal = new JLabel("Membership Renewal :");

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblUserName);
    searchUI.add(txtEnterpriseName);
    searchUI.add(lblCity);
    searchUI.add(txtTaxNumber);
    searchUI.add(lblRenewal);
    searchUI.add(txtCountry);

    gbc.anchor = GridBagConstraints.WEST;

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblUserName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblCity, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(lblRenewal, gbc);

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
  }

  public void initialize() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());

    txtEnterpriseName.setText("Enter UserName Here");
    txtCountry.setText((cal.get(Calendar.MONTH) + 1) + "/" +
                       cal.get(Calendar.DATE) + "/" +
                       cal.get(Calendar.YEAR));
  }

  public String getSQL() {
    return ("Select * from Employer where Username='" +
            txtEnterpriseName.getText() + "'" + " and City='" +
            txtTaxNumber.getText() + "' and DateRenewal='" +
            txtCountry.getText() + "'");

  }

}
