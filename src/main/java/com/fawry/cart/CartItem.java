package com.fawry.cart;

import com.fawry.interfaces.Product;

public class CartItem {
  private final Product product;
  private int quantity;

  public CartItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void increaseQuantity(int amount) throws Exception {
    if (amount <= 0)
      throw new Exception("Increase amount must be positive");
    this.quantity += amount;
  }

  public void reduceQuantity(int amount) throws Exception {
    if (amount <= 0)
      throw new Exception("Reduce amount must be positive");
    if (amount > quantity)
      throw new Exception("Not enough quantity to reduce");
    this.quantity -= amount;
  }

  public double getTotalPrice() {
    return product.getPrice() * quantity;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CartItem cartItem) {
      return cartItem.product.getName().equals(this.product.getName());
    }

    return false;
  }

  @Override
  public int hashCode() {
    return product.hashCode();
  }
}
