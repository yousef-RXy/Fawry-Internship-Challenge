package com.fawry.interfaces;

import com.fawry.cart.Cart;
import com.fawry.customer.Customer;

public interface ReceiptPrinter {
  public void printReceipt(Cart cart, double subtotal, double shippingFees, double totalAmount,
      Customer customer);
}
