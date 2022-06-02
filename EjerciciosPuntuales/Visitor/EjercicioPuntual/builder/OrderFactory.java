package builder;

import utils.CONSTANTS;

public class OrderFactory {
    private static final OrderFactory orderFactory = new OrderFactory();

    private OrderFactory() {
    }

    public static OrderFactory getInstance() {
        return orderFactory;
    }
    public UIOrder getOrder(String orderType) {
        if (orderType.equalsIgnoreCase(CONSTANTS.CALIFORNIA.toString())) {
            return new CaliforniaOrder();
        }
        if (orderType.equalsIgnoreCase(CONSTANTS.NON_CALIFORNIA.toString())) {
            return new NonCaliforniaOrder();
        }
        if (orderType.equalsIgnoreCase(CONSTANTS.OVERSEAS.toString())) {
            return new OverseasOrder();
        }
        if (orderType.equalsIgnoreCase(CONSTANTS.CHINESE.toString())) {
            return new ChineseOrder();
        }
        return null;
    }
} // End of class ButtonHandler