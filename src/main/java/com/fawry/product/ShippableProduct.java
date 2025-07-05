package com.fawry.product;

import com.fawry.interfaces.Shippable;

class ShippableProduct extends ProductImp implements Shippable {
  private final double weight; // in grams

  public ShippableProduct(String name, double price, int quantity, double weight)
      throws Exception {
    super(name, price, quantity);

    if (weight <= 0)
      throw new Exception("Weight must be positive");

    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }
}
