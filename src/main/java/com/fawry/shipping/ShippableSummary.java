package com.fawry.shipping;

public class ShippableSummary {
  private final String name;
  private final double weight;
  private int quantity;

  public ShippableSummary(String name, double weight, int quantity) {
    this.name = name;
    this.weight = weight;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public double getWeight() {
    return weight;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return this.quantity + "x " + this.name + " " + this.weight * 1000;
  }

}
