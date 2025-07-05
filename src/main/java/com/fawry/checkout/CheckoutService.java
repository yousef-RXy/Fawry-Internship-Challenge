package com.fawry.checkout;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fawry.cart.Cart;
import com.fawry.cart.CartItem;
import com.fawry.customer.Customer;
import com.fawry.interfaces.Product;
import com.fawry.interfaces.ReceiptPrinter;
import com.fawry.interfaces.Shippable;
import com.fawry.interfaces.ShippingCalculator;
import com.fawry.shipping.ShippableSummary;

public class CheckoutService {
  public static void checkout(Customer customer, Cart cart, ShippingCalculator shippingCalculator,
      ReceiptPrinter receiptPrinter) throws Exception {
    validateCartNotEmpty(cart);
    validateItems(cart);

    double subtotal = cart.getSubtotal();
    Map<String, ShippableSummary> shippableSummary = collectShippableSummary(cart);

    double shippingFees = shippingCalculator.calculateShipmentPrice(shippableSummary);
    double totalAmount = subtotal + shippingFees;

    ensureCustomerHasBalance(customer, totalAmount);

    reduceStock(cart);
    chargeCustomer(customer, totalAmount);

    receiptPrinter.printReceipt(cart, subtotal, shippingFees, totalAmount, customer);

    cart.clear();
  }

  private static void validateCartNotEmpty(Cart cart) throws Exception {
    if (cart.isEmpty()) {
      throw new Exception("Cart is empty");
    }
  }

  private static void validateItems(Cart cart) throws Exception {
    for (CartItem item : cart.getItems()) {
      if (!item.getProduct().isValid(item.getQuantity())) {
        throw new Exception("Product invalid: " + item.getProduct().getName());
      }
    }
  }

  private static Map<String, ShippableSummary> collectShippableSummary(Cart cart) {
    Map<String, ShippableSummary> summaryMap = new LinkedHashMap<>();

    for (CartItem item : cart.getItems()) {
      Product product = item.getProduct();

      if (product instanceof Shippable shippable) {
        String key = shippable.getName() + " " + shippable.getWeight();

        if (!summaryMap.containsKey(key)) {
          summaryMap.put(key, new ShippableSummary(shippable.getName(), shippable.getWeight() / 1000, 0));
        }
        ShippableSummary shippableSummary = summaryMap.get(key);
        shippableSummary.setQuantity(shippableSummary.getQuantity() + item.getQuantity());
      }
    }

    return summaryMap;
  }

  private static void ensureCustomerHasBalance(Customer customer, double totalAmount) throws Exception {
    if (!customer.isSufficientBalance(totalAmount)) {
      throw new Exception("Insufficient customer balance");
    }
  }

  private static void reduceStock(Cart cart) throws Exception {
    for (CartItem item : cart.getItems()) {
      item.getProduct().reduceQuantity(item.getQuantity());
    }
  }

  private static void chargeCustomer(Customer customer, double totalAmount) throws Exception {
    customer.reduceBalance(totalAmount);
  }
}
