package com.fawry.interfaces;

public interface Product {
  public String getName();

  public double getPrice();

  public void increaseQuantity(int amount) throws Exception;

  public void reduceQuantity(int amount) throws Exception;

  public boolean isValid(int amount);
}
