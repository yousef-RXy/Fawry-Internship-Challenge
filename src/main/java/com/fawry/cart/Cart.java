package com.fawry.cart;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.fawry.interfaces.Product;

public class Cart {
  private final Map<Product, CartItem> items = new LinkedHashMap<>();

  public void add(Product product, int quantity) throws Exception {
    if (product == null)
      throw new Exception("Product cannot be null");
    if (quantity <= 0)
      throw new Exception("Quantity must be positive");

    int totalQuantity = quantity;
    if (items.containsKey(product)) {
      totalQuantity += items.get(product).getQuantity();
    }

    if (!product.isValid(totalQuantity)) {
      throw new Exception("Product invalid: " + product.getName());
    }

    if (items.containsKey(product)) {
      items.get(product).increaseQuantity(quantity);
    } else {
      items.put(product, new CartItem(product, quantity));
    }
  }

  public void remove(Product product) throws Exception {
    if (!items.containsKey(product)) {
      throw new Exception("Product not in cart: " + product.getName());
    }
    items.remove(product);
  }

  public void reduce(Product product, int quantity) throws Exception {
    if (quantity <= 0) {
      throw new Exception("Reduction quantity must be positive");
    }

    if (!items.containsKey(product)) {
      throw new Exception("Product not in cart: " + product.getName());
    }

    CartItem cartItem = items.get(product);
    if (cartItem.getQuantity() < quantity) {
      throw new Exception("Not enough quantity in cart for product: " + product.getName());
    }

    if (cartItem.getQuantity() == quantity) {
      remove(product);
    } else {
      cartItem.reduceQuantity(quantity);
    }
  }

  public List<CartItem> getItems() {
    return List.copyOf(items.values());
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public void clear() {
    items.clear();
  }

  public double getSubtotal() {
    Stream<CartItem> cartItems = getItems().stream();
    DoubleStream totalPrices = cartItems.mapToDouble(CartItem::getTotalPrice);
    return totalPrices.sum();
  }
}
