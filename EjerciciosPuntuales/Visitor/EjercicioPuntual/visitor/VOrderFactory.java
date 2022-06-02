package visitor;

import utils.CONSTANTS;

public class VOrderFactory {
    private static final VOrderFactory vOrderFactory = new VOrderFactory();

    private VOrderFactory() {
    }

    public static VOrderFactory getInstance() {
        return vOrderFactory;
    }

    public VOrder createOrder(String orderType,
                              double orderAmount, double tax, double SH) {
        if (orderType.equalsIgnoreCase(CONSTANTS.CALIFORNIA.toString())) {
            return new CaliforniaOrder(orderAmount, tax);
        }
        if (orderType.equalsIgnoreCase(CONSTANTS.NON_CALIFORNIA.toString())) {
            return new NonCaliforniaOrder(orderAmount);
        }
        if (orderType.equalsIgnoreCase(CONSTANTS.OVERSEAS.toString())) {
            return new OverseasOrder(orderAmount, SH);
        }
        if (orderType.equalsIgnoreCase(CONSTANTS.CHINESE.toString())) {
            return new ChineseOrder(orderAmount, SH);
        }
        return null;
    }

} // End of class