package com.fawry.product;

import java.time.LocalDate;

import com.fawry.interfaces.Shippable;

class ExpiableShippableProduct extends ExpiableProduct implements Shippable {
  private final double weight; // in grams

  public ExpiableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight)
      throws Exception {
    super(name, price, quantity, expiryDate);

    if (weight <= 0)
      throw new Exception("Weight must be positive");

    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }
}
