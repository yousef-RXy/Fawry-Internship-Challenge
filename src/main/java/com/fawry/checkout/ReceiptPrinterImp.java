package com.fawry.checkout;

import com.fawry.cart.Cart;
import com.fawry.cart.CartItem;
import com.fawry.customer.Customer;
import com.fawry.interfaces.ReceiptPrinter;

public class ReceiptPrinterImp implements ReceiptPrinter {
  @Override
  public void printReceipt(Cart cart, double subtotal, double shippingFees, double totalAmount,
      Customer customer) {
    System.out.println("\n** Checkout receipt **");
    for (CartItem item : cart.getItems()) {
      System.out.printf("%dx %s %.2f%n",
          item.getQuantity(),
          item.getProduct().getName(),
          item.getProduct().getPrice());
    }
    System.out.println("----------------------");
    System.out.printf("Subtotal %.2f%n", subtotal);
    System.out.printf("Shipping %.2f%n", shippingFees);
    System.out.printf("Amount %.2f%n", totalAmount);
    System.out.printf("Customer balance after payment %.2f%n", customer.getBalance());
  }
}
