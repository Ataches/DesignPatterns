package visitor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import IteratorExt.AllOrders;
import IteratorExt.Order;
import IteratorExt.SearchManager;
import builder.OrderDirector;
import builder.OrderFactory;
import builder.UIOrder;
import com.sun.java.swing.plaf.windows.*;
import utils.CONSTANTS;
import utils.FileUtil;

public class OrderManager extends JFrame {
    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String EXIT = "Exit";
    public static final String EDIT_ORDER = "Edit orders";
    public static final String RESULT_MSG_DEFAULT = "Click Create or GetTotal Button";

    private JComboBox cmbOrderType;
    private JLabel lblOrderType;
    private JLabel lblTotal, lblTotalValue;
    private JPanel panelOrderCriteria;

    private OrderVisitor objVisitor;

    public OrderManager() {
        super("Visitor Pattern - Example");

        //Create the visitor instance
        objVisitor = new OrderVisitor();

        cmbOrderType = new JComboBox();
        cmbOrderType.addItem(CONSTANTS.BLANK.toString());
        cmbOrderType.addItem(CONSTANTS.CALIFORNIA.toString());
        cmbOrderType.addItem(CONSTANTS.NON_CALIFORNIA.toString());
        cmbOrderType.addItem(CONSTANTS.OVERSEAS.toString());
        cmbOrderType.addItem(CONSTANTS.CHINESE.toString());

        panelOrderCriteria = new JPanel();

        lblOrderType = new JLabel("Order Type:");
        lblTotal = new JLabel("Result:");
        lblTotalValue =
                new JLabel(RESULT_MSG_DEFAULT);

        //Create the open button
        JButton getTotalButton =
                new JButton(OrderManager.GET_TOTAL);
        getTotalButton.setMnemonic(KeyEvent.VK_G);
        JButton createOrderButton =
                new JButton(OrderManager.CREATE_ORDER);
        getTotalButton.setMnemonic(KeyEvent.VK_C);
        JButton exitButton = new JButton(OrderManager.EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);
        JButton editButton = new JButton(OrderManager.EDIT_ORDER);
        editButton.setMnemonic(KeyEvent.VK_E);
        ButtonHandler objButtonHandler = new ButtonHandler(this);


        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        cmbOrderType.addActionListener(objButtonHandler);
        editButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(new ButtonHandler());

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();

        JPanel panel = new JPanel();
        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);
        GridBagConstraints gbc2 = new GridBagConstraints();
        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(editButton);
        panel.add(exitButton);
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        gridbag2.setConstraints(editButton, gbc2);
        gbc2.gridx = 3;
        gbc2.gridy = 0;
        gridbag2.setConstraints(exitButton, gbc2);

        //****************************************************
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);
        buttonPanel.add(panelOrderCriteria);
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(panelOrderCriteria, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(lblTotal, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gridbag.setConstraints(lblTotalValue, gbc);

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //****************************************************

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
                    OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void displayNewUI(JPanel panel) {
        panelOrderCriteria.removeAll();
        panelOrderCriteria.add(panel);
        panelOrderCriteria.validate();
        validate();
    }

    public static void main(String[] args) {
        JFrame frame = new OrderManager();

        frame.addWindowListener(new WindowAdapter() {
                                    public void windowClosing(WindowEvent e) {
                                        System.exit(0);
                                    }
                                }
        );

        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public JComboBox getOrderTypeCtrl() {
        return cmbOrderType;
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }

    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

} // End of class OrderManager

class ButtonHandler implements ActionListener {
    OrderManager objOrderManager;
    UIOrder order;
    FileUtil util;
    OrderDirector director;
    Order newOrder;

    public void actionPerformed(ActionEvent e) {
        String totalResult = null;

        if (e.getActionCommand().equals(OrderManager.EXIT)) {
            System.exit(1);
        }
        if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {

            objOrderManager.setTotalValue(
                    CONSTANTS.RESULT_MSG_DEFAULT.toString());
            String selection = objOrderManager.getOrderType();

            if (selection.equals("") == false) {
                OrderFactory factory = OrderFactory.getInstance();
                //create an appropriate builder instance
                order = factory.getOrder(selection);
                //configure the director with the builder
                director = new OrderDirector(order);
                //director invokes different builder
                // methods
                newOrder = new Order(selection,0.0,0.0,0.0);

                director.build(newOrder);
                //get the final build object
                JPanel UIObj = order.getSearchUI();
                objOrderManager.displayNewUI(UIObj);
            }
        }
        if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)
        ) {
            String selection = objOrderManager.getOrderType();
            VOrderFactory vOrderFactory = VOrderFactory.getInstance();
            newOrder = director.getOrderEdited();
            VOrder vOrder = vOrderFactory.createOrder(selection,newOrder.getOrderAmount(),newOrder.getAdditionalTax(),newOrder.getAdditionalSH());
            //Get the Visitor
            OrderVisitor visitor =
                    objOrderManager.getOrderVisitor();

            visitor.addOrderToVector(vOrder);

            AllOrders allOrders = AllOrders.getInstance();
            allOrders.setOrderVisitor(visitor);
            allOrders.createNewOrders(visitor.getOrderObjList());
            objOrderManager.setTotalValue(
                    "Order Created Successfully");
        }

        if (e.getActionCommand().equals(OrderManager.EDIT_ORDER)) {
            OrderVisitor visitor =
                    objOrderManager.getOrderVisitor();

            SearchManager sr = new SearchManager(visitor.getOrderObjList());
            sr.editOrders();
        }

        if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {

            //Get the Visitor
            OrderVisitor visitor =
                    objOrderManager.getOrderVisitor();

            AllOrders allOrders = AllOrders.getInstance();
            allOrders.setOrderVisitor(visitor);

            visitor.getOrderObjList();
            totalResult = ""+allOrders.getOrderTotal();
            totalResult = " Orders Total = " + totalResult;
            objOrderManager.setTotalValue(totalResult);
        }
    }

    public ButtonHandler() {
    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
    }
}
