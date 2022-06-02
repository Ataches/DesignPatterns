package IteratorExt;

import visitor.VOrder;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class OrderIterator implements Iterator {
  AllOrders ac;
  String orderType;
  VOrder nextOrder;
  Enumeration ec;


  public OrderIterator(AllOrders inp_ac,
                       String inpOrderType) {
    ac = inp_ac;
    orderType = inpOrderType;
    ec = inp_ac.getAllOrders();
  }
  public boolean hasNext() {
    boolean matchFound = false;
    while (ec.hasMoreElements()) {
      VOrder tempObj = (VOrder) ec.nextElement();
      if (tempObj.getOrderType().equals(
            orderType)) {
        matchFound = true;
        nextOrder = tempObj;
        break;
      }
    }
    if (matchFound == true) {
    } else {
      nextOrder = null;
    }
    return matchFound;
  }

  public Object next() {
    if (nextOrder == null) {
      throw new NoSuchElementException();
    } else {
      return nextOrder;
    }
  }
}
