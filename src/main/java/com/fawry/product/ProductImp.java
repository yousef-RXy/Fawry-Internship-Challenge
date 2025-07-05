package com.fawry.product;

import com.fawry.interfaces.Product;

class ProductImp implements Product {
  private final String name;
  private final double price;
  private int quantity;

  public ProductImp(String name, double price, int quantity) throws Exception {
    if (price <= 0)
      throw new Exception("Price must be more than 0");
    if (quantity <= 0)
      throw new Exception("Quantity must be more than 0");

    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public void increaseQuantity(int increasedAmount) throws Exception {
    if (increasedAmount < 0)
      throw new Exception("Negative quantity not accepted");

    this.quantity += increasedAmount;
  }

  @Override
  public void reduceQuantity(int reducedAmount) throws Exception {
    if (reducedAmount < 0)
      throw new Exception("Negative quantity not accepted");
    if (reducedAmount > quantity)
      throw new Exception("Not enough stock");

    this.quantity -= reducedAmount;
  }

  @Override
  public boolean isValid(int amount) {
    return amount >= 0 && amount <= quantity;
  }
}
