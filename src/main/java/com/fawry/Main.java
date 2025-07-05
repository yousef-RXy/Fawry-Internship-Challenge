package com.fawry;

import java.time.LocalDate;

import com.fawry.cart.Cart;
import com.fawry.checkout.CheckoutService;
import com.fawry.checkout.ReceiptPrinterImp;
import com.fawry.customer.Customer;
import com.fawry.interfaces.Product;
import com.fawry.interfaces.ReceiptPrinter;
import com.fawry.interfaces.ShippingCalculator;
import com.fawry.product.ProductFactory;
import com.fawry.shipping.ShippingCalculatorImp;

public class Main {
  public static void main(String[] args) {
    try {
      Product tv = ProductFactory.CreateShippableProduct(
          "TV", 5000, 10, 2000.0);

      Product cheese = ProductFactory.CreateExpiableShippableProduct(
          "Cheese", 100, 20, LocalDate.now().plusDays(5), 400);

      Product scratchCard = ProductFactory.CreateProduct(
          "Mobile Scratch Card", 50, 100);

      Customer customer = new Customer(100000);

      Cart cart = new Cart();
      cart.add(tv, 2);
      cart.add(cheese, 2);
      cart.add(scratchCard, 5);

      ShippingCalculator shippingCalculator = new ShippingCalculatorImp(30);
      ReceiptPrinter receiptPrinter = new ReceiptPrinterImp();
      CheckoutService.checkout(customer, cart, shippingCalculator, receiptPrinter);
    } catch (Exception e) {
      System.out.println();
      System.out.println(e.getMessage());
    }
  }
}