package IteratorExt;

import builder.OrderDirector;
import builder.OrderFactory;
import builder.UIOrder;
import utils.CONSTANTS;
import visitor.VOrder;
import visitor.VOrderFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Vector;
//import com.sun.java.swing.plaf.windows.*;

public class SearchManager extends JFrame {
  public static final String GET_ORDERS = "Show orders";
  public static final String EDIT_ORDER = "Edit order";
  public static final String DELETE_ORDER = "Delete order";
  public static final String EXIT = "Exit";

  public static final String SELECT_ORDER = "Select order";
  private Vector orderObjList;

  private JComboBox cmbOrderType;
  private JComboBox cmbOrders;
  private JPanel panelOrderCriteria;

  public SearchManager() {
    super("Iterator Pattern - Example");

    // Create controls
    cmbOrderType = new JComboBox();
    cmbOrders = new JComboBox();
    cmbOrders.setActionCommand(SearchManager.SELECT_ORDER);
    cmbOrders.setVisible(false);

    cmbOrderType.addItem(CONSTANTS.OVERSEAS.toString());
    cmbOrderType.addItem(CONSTANTS.CALIFORNIA.toString());
    cmbOrderType.addItem(CONSTANTS.CHINESE.toString());
    cmbOrderType.addItem(CONSTANTS.NON_CALIFORNIA.toString());

    panelOrderCriteria = new JPanel();

    //Create Labels
    JLabel lblOrderType =
            new JLabel("Certification Type:");
    JLabel lblSelectedCandidates = new JLabel("Results:");

    //Create the open button
    JButton btnGetOrders =
            new JButton(SearchManager.GET_ORDERS);
    btnGetOrders.setMnemonic(KeyEvent.VK_R);
    JButton btnEditOrder =
            new JButton(SearchManager.EDIT_ORDER);
    btnEditOrder.setMnemonic(KeyEvent.VK_E);
    JButton btnDeleteOrder =
            new JButton(SearchManager.DELETE_ORDER);
    btnDeleteOrder.setMnemonic(KeyEvent.VK_E);
    JButton btnExit = new JButton(SearchManager.EXIT);
    btnExit.setMnemonic(KeyEvent.VK_X);

    buttonHandler vf = new buttonHandler(this);

    btnGetOrders.addActionListener(vf);
    btnEditOrder.addActionListener(vf);
    btnDeleteOrder.addActionListener(vf);
    cmbOrders.addActionListener(vf);
    btnExit.addActionListener(vf);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    JPanel panel = new JPanel();

    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    panel.add(btnGetOrders);
    panel.add(btnEditOrder);
    panel.add(btnDeleteOrder);
    panel.add(btnExit);

    GridBagConstraints gbc2 = new GridBagConstraints();
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(btnGetOrders, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(btnEditOrder, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(btnDeleteOrder, gbc2);
    gbc2.gridx = 3;
    gbc2.gridy = 0;
    gridbag2.setConstraints(btnExit, gbc2);

    //****************************************************

    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(lblSelectedCandidates);
    buttonPanel.add(cmbOrders);
    buttonPanel.add(panel);
    buttonPanel.add(panelOrderCriteria);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblSelectedCandidates, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(cmbOrders, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(panelOrderCriteria, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;
    gbc.gridx = 1;
    gbc.gridy = 6;
    gridbag.setConstraints(panel, gbc);


    //****************************************************
    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();
    contentPane.add(buttonPanel, BorderLayout.CENTER);
    try {
      //    UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
              SearchManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
  public SearchManager(Vector orderObjList){
    this.orderObjList = orderObjList;
  }
  public void editOrders() {

    JFrame frame = new SearchManager();
    //frame.pack();
    frame.setSize(600, 500);
    frame.setVisible(true);
  }

  public void displayNewUI(JPanel panel) {
    panelOrderCriteria.removeAll();
    panelOrderCriteria.add(panel);
    panelOrderCriteria.validate();
    validate();
  }

  public VOrder getOrderSelected() {
    return (VOrder) cmbOrders.getSelectedItem();
  }
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }
  public void addOrder(VOrder order) {
    cmbOrders.addItem(order);
  }
  public void removeAllOrders(){
    cmbOrders.removeAllItems();
  }

  public boolean cmbOrderVisible() {
    return cmbOrders.isVisible();
  }
  public void cmbOrderVisibility(boolean visible) {
    cmbOrders.setVisible(visible);
  }
}


class buttonHandler implements ActionListener {
  public buttonHandler() {
  }
  public buttonHandler(SearchManager inObjOrderManager) {
    objOrderManager = inObjOrderManager;
  }

  SearchManager objOrderManager;
  UIOrder order;
  VOrder orderSelected;
  AllOrders ac;
  OrderDirector director;
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals(SearchManager.EXIT)) {
      objOrderManager.dispose();
    }
    if (e.getActionCommand().equals(
          SearchManager.GET_ORDERS)) {
      String selection = objOrderManager.getOrderType();

      ac = AllOrders.getInstance();

      Iterator certCandidates =
              ac.getOrders(selection);

      objOrderManager.removeAllOrders();
      while (certCandidates.hasNext()) {
        VOrder c = (VOrder) certCandidates.next();
        objOrderManager.addOrder(c);
      }
      objOrderManager.cmbOrderVisibility(true);
    }
    if (e.getActionCommand().equals(
          SearchManager.DELETE_ORDER)) {

      ac = AllOrders.getInstance();

      ac.deleteOrder(orderSelected);
      ac.saveOrders();
      objOrderManager.dispose();
    }
    if (e.getActionCommand().equals(
          SearchManager.EDIT_ORDER)) {

      ac = AllOrders.getInstance();

      Order orderEdited = director.getOrderEdited();
      VOrderFactory vOrderFactory = VOrderFactory.getInstance();
      VOrder vOrderEdited = vOrderFactory.createOrder(orderEdited.getOrderType(), orderEdited.getOrderAmount(), orderEdited.getAdditionalTax(), orderEdited.getAdditionalSH());
      ac.editOrder(orderSelected, vOrderEdited);
      ac.saveOrders();
      objOrderManager.dispose();
    }
    if (e.getActionCommand().equals(SearchManager.SELECT_ORDER)) {

      if (objOrderManager.cmbOrderVisible()) {
        objOrderManager.cmbOrderVisibility(false);
        OrderFactory factory = OrderFactory.getInstance();
        //create an appropriate builder instance
        String orderType = objOrderManager.getOrderType();
        order = factory.getOrder(orderType);
        //configure the director with the builder
        director = new OrderDirector(order);
        //director invokes different builder
        // methods
        orderSelected = objOrderManager.getOrderSelected();

        Order selectedOrder = new Order(orderSelected.getOrderType(), orderSelected.getOrderAmount(),
                orderSelected.getAdditionalTax(), orderSelected.getAdditionalSH());
        director.build(selectedOrder);
        //get the final build object
        JPanel UIObj = order.getSearchUI();
        objOrderManager.displayNewUI(UIObj);
      }
    }
  }
}

