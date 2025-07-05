package com.fawry.product;

import java.time.LocalDate;

import com.fawry.interfaces.Product;

public class ProductFactory {
  public static Product CreateProduct(String name, double price, int quantity) throws Exception {
    return new ProductImp(name, price, quantity);
  }

  public static Product CreateShippableProduct(String name, double price, int quantity, double weight)
      throws Exception {
    return new ShippableProduct(name, price, quantity, weight);
  }

  public static Product CreateExpiableProduct(String name, double price, int quantity, LocalDate expiryDate)
      throws Exception {
    return new ExpiableProduct(name, price, quantity, expiryDate);
  }

  public static Product CreateExpiableShippableProduct(String name, double price, int quantity, LocalDate expiryDate,
      double weight)
      throws Exception {
    return new ExpiableShippableProduct(name, price, quantity, expiryDate, weight);
  }

}
